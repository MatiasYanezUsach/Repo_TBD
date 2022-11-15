package cl.tbd.control1.repository;
import java.util.List;
import cl.tbd.control1.models.EmergenciaHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository

public class EmergenciaHabilidadRepositoryImp implements EmergenciaHabilidadRepository{

    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM eme_habilidad";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(int.class);
            return id+1;
        }
    }

    @Override
    public List<EmergenciaHabilidad> findAllEmergenciaHabilidad() {
        
        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM eme_habilidad").executeAndFetch(EmergenciaHabilidad.class);
        }
    }

    @Override
    public EmergenciaHabilidad getEmergenciaHabilidad(int id) {

        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM eme_habilidad WHERE id = :id").addParameter("id",id).executeAndFetchFirst(EmergenciaHabilidad.class);
        }    
    }

    @Override
    public EmergenciaHabilidad createEmergenciaHabilidad(EmergenciaHabilidad emergenciaHabilidad){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO eme_habilidad(id, id_emergencia, id_habilidad)" + 
                            "VALUES(:id, :id_emergencia, :id_habilidad)";

        try{
            conn.createQuery(SQL_INSERT, true)
                    .addParameter("id", newId())
                    .addParameter("id_emergencia", emergenciaHabilidad.getId_emergencia())
                    .addParameter("id_habilidad", emergenciaHabilidad.getId_habilidad())
                    .executeUpdate();
            return emergenciaHabilidad;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la emergencia\n");
            return null;
        }
    }


    @Override
    public void updateEmergenciaHabilidad(EmergenciaHabilidad emergenciaHabilidad,int id){

        String SQL_UPDATE = "UPDATE eme_habilidad SET id_emergencia = :id_emergencia, id_habilidad = :id_habilidad, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                    .addParameter("id_emergencia", emergenciaHabilidad.getId_emergencia())
                    .addParameter("id_habilidad", emergenciaHabilidad.getId_habilidad())
                    .addParameter("id", id)
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la emergencia\n");
        }
    }


    @Override
    public void deleteEmergenciaHabilidad(int id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM eme_habilidad WHERE eme_habilidad.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la EmergenciaHabilidad\n");
        }
    }
    
}
