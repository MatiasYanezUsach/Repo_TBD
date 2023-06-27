package cl.tbd.control1.repository;

import java.util.List;



import cl.tbd.control1.models.Emergencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository{

    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM emergencia";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id+1;
        }
    }
    @Override
    public List<Emergencia> findAllEmergencia() {
        
        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM emergencia").executeAndFetch(Emergencia.class);
        }
    }

    @Override
    public Emergencia getEmergencia(int id) {

        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM emergencia WHERE id = :id").addParameter("id",id).executeAndFetchFirst(Emergencia.class);
        }    
    }

    @Override
    public Emergencia createEmergencia(Emergencia emergencia){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO emergencia(id, nombre, descripcion, ubicacion)" + 
                            "VALUES(:id, :nombre, :descripcion, :ubicacion)";

        try{
            conn.createQuery(SQL_INSERT, true)
                    .addParameter("id", newId())
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("descripcion", emergencia.getDescripcion())
                    .addParameter("ubicacion", emergencia.getUbicacion())
            
                    .executeUpdate();

            emergencia.setId(newId());
            return emergencia;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la emergencia\n");
            return null;
        }
    }


    @Override
    public void updateEmergencia(Emergencia emergencia,int id){

        String SQL_UPDATE = "UPDATE emergencia SET nombre = :nombre, descripcion = :descripcion, ubicacion=:ubicacion, id = :id WHERE id = :id";

        System.out.println("llega acá");
        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("descripcion", emergencia.getDescripcion())
                    .addParameter("ubicacion", emergencia.getUbicacion())
                    .addParameter("id", id)
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la emergencia\n");
        }
    }


    @Override
    public void deleteEmergencia(int id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM emergencia WHERE emergencia.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la emergencia\n");
        }
    }
    
}
