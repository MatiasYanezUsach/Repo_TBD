package cl.tbd.control1.repository;
import cl.tbd.control1.models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM voluntario";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(int.class);
            return id+1;
        }
    }
    
    @Override
    public List<Voluntario> findAllVoluntario() {
        
        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM voluntario").executeAndFetch(Voluntario.class);
        }
    }

    @Override
    public Voluntario getVoluntario(int id) {

        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM voluntario WHERE id = :id").addParameter("id",id).executeAndFetchFirst(Voluntario.class);
        }    
    }

    @Override
    public Voluntario createVoluntario(Voluntario voluntario){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO voluntario(id, nombre, correo, contrasenia)" + 
                            "VALUES(:id, :nombre, :correo, :contrasenia)";

        try{
            conn.createQuery(SQL_INSERT, true)
                    .addParameter("id", newId())
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("correo", voluntario.getCorreo())
                    .addParameter("contrasenia", voluntario.getContrasenia())
                    .executeUpdate();
            return voluntario;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear el voluntario\n");
            return null;
        }
    }


    @Override
    public void updateVoluntario(Voluntario voluntario,int id){

        String SQL_UPDATE = "UPDATE voluntario SET nombre = :nombre, correo= :correo, contrasenia= :contrasenia, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("correo", voluntario.getCorreo())
                    .addParameter("contrasenia", voluntario.getContrasenia())
                    .addParameter("id", id)
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el voluntario\n");
        }
    }


    @Override
    public void deleteVoluntario(int id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM voluntario WHERE voluntario.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el voluntario\n");
        }
    }
}