package cl.tbd.control1.repository;

import java.util.List;
import cl.tbd.control1.models.EmergenciaHabilidad;

public interface EmergenciaHabilidadRepository{
    
    public List<EmergenciaHabilidad> findAllEmergenciaHabilidad();
    public EmergenciaHabilidad getEmergenciaHabilidad(int id);
    public EmergenciaHabilidad createEmergenciaHabilidad(EmergenciaHabilidad emergenciaHabilidad);
    public void updateEmergenciaHabilidad(EmergenciaHabilidad emergenciaHabilidad,int id);
    public void deleteEmergenciaHabilidad(int id);
    public int newId();
}