package cl.tbd.control1.repository;
import cl.tbd.control1.models.TareaHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class TareaHabilidadRepositoryImp implements TareaHabilidadRepository{
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM tarea_habilidad";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(int.class);
            return id+1;
        }
    }
    
    @Override
    public List<TareaHabilidad> findAllTarea_Habilidad() {
        
        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tarea_habilidad").executeAndFetch(TareaHabilidad.class);
        }
    }

    @Override
    public TareaHabilidad getTarea_Habilidad(int id) {

        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tarea_habilidad WHERE id = :id").addParameter("id",id).executeAndFetchFirst(TareaHabilidad.class);
        }    
    }

    @Override
    public TareaHabilidad createTarea_Habilidad(TareaHabilidad tarea_Habilidad){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO tarea_habilidad(id, id_tarea, id_habilidad)" + 
                            "VALUES(:id, :id_tarea,:id_habilidad)";

        try{
            conn.createQuery(SQL_INSERT, true)
                    .addParameter("id", newId())
                    .addParameter("id_tarea", tarea_Habilidad.getId_tarea())
                    .addParameter("id_habilidad", tarea_Habilidad.getId_habilidad())
                    .executeUpdate();
            return tarea_Habilidad;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la Tarea_Habilidad\n");
            return null;
        }
    }


    @Override
    public void updateTarea_Habilidad(TareaHabilidad tarea_Habilidad,int id){

        String SQL_UPDATE = "UPDATE tarea_habilidad SET id_tarea = :id_tarea,id_habilidad= :id_habilidad, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                    .addParameter("id_tarea", tarea_Habilidad.getId_tarea())
                    .addParameter("id_habilidad", tarea_Habilidad.getId_habilidad())
                    .addParameter("id", id)
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la tarea_Habilidad\n");
        }
    }


    @Override
    public void deleteTarea_Habilidad(int id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM tarea_habilidad WHERE tarea_habilidad.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la tarea_habilidad\n");
        }
    }
}