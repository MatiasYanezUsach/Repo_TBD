package cl.tbd.control1.repository;
import cl.tbd.control1.models.Vol_habilidad;
import java.util.List;

public interface Vol_habilidadRepository{
    public List<Vol_habilidad> findAllVol_habilidad();
    public Vol_habilidad getVol_habilidad(int id);
    public Vol_habilidad createVol_habilidad(Vol_habilidad vol_habilidad);
    public void updateVol_habilidad(Vol_habilidad vol_habilidad,int id);
    public void deleteVol_habilidad(int id);
    public int newId();
}
