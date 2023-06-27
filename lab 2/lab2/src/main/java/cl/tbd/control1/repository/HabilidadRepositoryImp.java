package cl.tbd.control1.repository;
import cl.tbd.control1.models.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM habilidad";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(int.class);
            return id+1;
        }
    }
    
    @Override
    public List<Habilidad> findAllHabilidad() {
        
        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM habilidad").executeAndFetch(Habilidad.class);
        }
    }

    @Override
    public Habilidad getHabilidad(int id) {

        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM habilidad WHERE id = :id").addParameter("id",id).executeAndFetchFirst(Habilidad.class);
        }    
    }

    @Override
    public Habilidad createHabilidad(Habilidad habilidad){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO habilidad(id, nombre, descripcion)" + 
                            "VALUES(:id, :nombre, :descripcion)";

        try{
            conn.createQuery(SQL_INSERT, true)
                    .addParameter("id", newId())
                    .addParameter("nombre", habilidad.getNombre())
                    .addParameter("descripcion", habilidad.getDescripcion())
                    .executeUpdate();
            return habilidad;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la habilidad\n");
            return null;
        }
    }


    @Override
    public void updateHabilidad(Habilidad habilidad,int id){

        String SQL_UPDATE = "UPDATE habilidad SET nombre = :nombre, descripcion= :descripcion, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                    .addParameter("nombre", habilidad.getNombre())
                    .addParameter("descripcion", habilidad.getDescripcion())
                    .addParameter("id", id)
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la habilidad\n");
        }
    }


    @Override
    public void deleteHabilidad(int id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM habilidad WHERE habilidad.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la habilidad\n");
        }
    }
}