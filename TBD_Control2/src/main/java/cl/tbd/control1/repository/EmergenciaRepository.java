package cl.tbd.control1.repository;

import java.util.List;
import cl.tbd.control1.models.Emergencia;

public interface EmergenciaRepository{
    
    public List<Emergencia> findAllEmergencia();
    public Emergencia getEmergencia(int id);
    public Emergencia createEmergencia(Emergencia emergencia);
    public void updateEmergencia(Emergencia emergencia,int id);
    public void deleteEmergencia(int id);
    public int newId();
}
