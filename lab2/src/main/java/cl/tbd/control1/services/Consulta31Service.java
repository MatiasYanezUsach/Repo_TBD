package cl.tbd.control1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.tbd.control1.models.Habilidad;
import cl.tbd.control1.models.Vol_habilidad;
import cl.tbd.control1.models.Emergencia;
import cl.tbd.control1.models.Tarea;
import cl.tbd.control1.models.TareaHabilidad;
import cl.tbd.control1.models.TareaEstructura;
import cl.tbd.control1.models.EmergenciaEstructura;

@Service
public class Consulta31Service {

    @Autowired
    HabilidadService habilidadService;

    @Autowired
    Vol_habilidadService vol_habilidadService;

    @Autowired
    TareaHabilidadService tareaHabilidadService;

    @Autowired
    EmergenciaHabilidadService emergenciaHabilidadService;

    @Autowired
    EmergenciaService emergenciaService;

    @Autowired
    TareaService tareaService;    

    //El método retorna las habilidades que cumple el voluntario. Para efectos de 
    //este laboratorio se entiende lo mismo por habilidad o requisito.
    public List<Habilidad> obtenerHabilidades(int id){
        List<Vol_habilidad> vol_habilidades=vol_habilidadService.getAllByVoluntario(id);
        List<Habilidad> habilidadesVoluntario=new ArrayList<>();
        Vol_habilidad iterador;
        for (int i=0; i<vol_habilidades.size();i++){
            iterador=vol_habilidades.get(i);
            habilidadesVoluntario.add(habilidadService.select(iterador.getId_Habilidad()));
        }
        vol_habilidades.clear();
        return habilidadesVoluntario;
    }

    //El método retorna todas las habilidades requeridas por una tarea.
    public List<Habilidad> revisarRequisitos(int id){
        List<TareaHabilidad> tareaHabilidades=tareaHabilidadService.getAllByTarea(id);
        List<Habilidad> HabilidadesTarea=new ArrayList<>();
        TareaHabilidad iterador;
        for (int i=0; i<tareaHabilidades.size();i++){
            iterador=tareaHabilidades.get(i);
            //Hay que pasar por la tabla intermedia emergenciaHabilidad.
            HabilidadesTarea.add(habilidadService.select((emergenciaHabilidadService.select(iterador.getId_eme_habilidad())).getId_habilidad()));
        }
        tareaHabilidades.clear();
        return HabilidadesTarea;
    }

    //El método verifica si alguna de las habilidades del voluntario corresponde a algún requisito de la tarea.
    public boolean requisitosCumplidos(List<Habilidad> habilidadesVoluntario, List<Habilidad> habilidadesTarea){
        for (int i=0;i<habilidadesTarea.size();i++){
            for (int j=0;j<habilidadesVoluntario.size();j++){
                if (habilidadesTarea.get(i).getId()==habilidadesVoluntario.get(j).getId()){
                    return true;
                }
            }
        }
        return false;
    }

    //El método retorna los datos de las emergencias y su lista de tareas, para un voluntario.
    public List<Object> getRequisitos(int idVoluntario) {
        List<Habilidad> requisitosVoluntario=this.obtenerHabilidades(idVoluntario);
        List<Emergencia> emergencias=emergenciaService.getAll();
        List<Tarea> tareas=new ArrayList<>();
        List<Habilidad> habilidadesTarea=new ArrayList<>();
        EmergenciaEstructura emeEs;
        List<EmergenciaEstructura> emergenciaEstructuras=new ArrayList<>();
        for (int i=0;i<emergencias.size();i++){
            emeEs=new EmergenciaEstructura();
            emeEs.Nombre=emergencias.get(i).getNombre();
            emeEs.id=emergencias.get(i).getId();
            emeEs.tareas=new ArrayList<>();
            tareas=tareaService.findAllByEmergencia(emergencias.get(i).getId());
            for (int j=0;j<tareas.size();j++){
                habilidadesTarea=this.revisarRequisitos(tareas.get(j).getId());
                if (this.requisitosCumplidos(requisitosVoluntario, habilidadesTarea)){
                        TareaEstructura tEs=new TareaEstructura();
                        tEs.Nombre=tareas.get(j).getNombre();
                        tEs.id=tareas.get(j).getId();
                        tEs.habilidades=habilidadesTarea;
                        emeEs.tareas.add(tEs);
                }
            }
            emergenciaEstructuras.add(emeEs);
        }
        List<Object> resultado=new ArrayList<Object>();
        resultado.add(requisitosVoluntario);
        resultado.add(emergenciaEstructuras);
        return resultado;
    }

}
