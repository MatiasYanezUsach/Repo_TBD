package cl.tbd.control1.repository;
import cl.tbd.control1.models.Institucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class InstitucionRepositoryImp implements InstitucionRepository{
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM institucion";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(int.class);
            return id+1;
        }
    }
    
    @Override
    public List<Institucion> findAllInstitucion() {
        
        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM institucion").executeAndFetch(Institucion.class);
        }
    }

    @Override
    public Institucion getInstitucion(int id) {

        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM institucion WHERE id = :id").addParameter("id",id).executeAndFetchFirst(Institucion.class);
        }    
    }

    @Override
    public Institucion createInstitucion(Institucion institucion){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO institucion(id, nombre, direccion)" + 
                            "VALUES(:id, :nombre, :direccion)";

        try{
            conn.createQuery(SQL_INSERT, true)
                    .addParameter("id", newId())
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("direccion", institucion.getDireccion())
                    .executeUpdate();
            return institucion;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la institucion\n");
            return null;
        }
    }


    @Override
    public void updateInstitucion(Institucion institucion,int id){

        String SQL_UPDATE = "UPDATE institucion SET nombre = :nombre, direccion=:direccion, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("direccion", institucion.getDireccion())
                    .addParameter("id", id)
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la institucion\n");
        }
    }


    @Override
    public void deleteInstitucion(int id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM institucion WHERE institucion.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la institucion\n");
        }
    }
}