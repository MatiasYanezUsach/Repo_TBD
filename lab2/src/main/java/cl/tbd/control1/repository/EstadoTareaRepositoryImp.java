package cl.tbd.control1.repository;
import cl.tbd.control1.models.EstadoTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class EstadoTareaRepositoryImp implements EstadoTareaRepository{
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM estado_tarea";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(int.class);
            return id+1;
        }
    }
    
    @Override
    public List<EstadoTarea> findAllEstadoTarea() {
        
        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM estado_tarea").executeAndFetch(EstadoTarea.class);
        }
    }

    @Override
    public EstadoTarea getEstadoTarea(int id) {

        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM estado_tarea WHERE id = :id").addParameter("id",id).executeAndFetchFirst(EstadoTarea.class);
        }    
    }

    @Override
    public EstadoTarea createEstadoTarea(EstadoTarea estadoTarea){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO estado_tarea(id, estado)" + 
                            "VALUES(:id, :estado)";

        try{
            conn.createQuery(SQL_INSERT, true)
                    .addParameter("id", newId())
                    .addParameter("estado", estadoTarea.getEstado())
                    .executeUpdate();
            return estadoTarea;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear el estado_tarea\n");
            return null;
        }
    }


    @Override
    public void updateEstadoTarea(EstadoTarea estadoTarea,int id){

        String SQL_UPDATE = "UPDATE estado_tarea SET estado = :estado, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                    .addParameter("estado", estadoTarea.getEstado())
                    .addParameter("id", id)
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el estado_tarea\n");
        }
    }


    @Override
    public void deleteEstadoTarea(int id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM estado_tarea WHERE estado_tarea.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el estado_tarea\n");
        }
    }
}