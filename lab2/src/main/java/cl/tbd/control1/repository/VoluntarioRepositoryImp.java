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
            return conn.createQuery("SELECT id,nombre,correo,contrasenia,st_x(st_astext(geom)) AS longitude, st_y(st_astext(geom)) AS latitude FROM voluntario").executeAndFetch(Voluntario.class);
        }
    }

    @Override
    public Voluntario getVoluntario(int id) {

        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT id,nombre,correo,contrasenia,st_x(st_astext(geom)) AS longitude, st_y(st_astext(geom)) AS latitude FROM voluntario WHERE id = :id").addParameter("id",id).executeAndFetchFirst(Voluntario.class);
        }    
    }

    @Override
    public Voluntario createVoluntario(Voluntario voluntario){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO voluntario(id, nombre, correo, contrasenia, geom)" + 
                            "VALUES(:id, :nombre, :correo, :contrasenia, ST_GeomFromText(:point, 4326))";
        String point = "POINT("+voluntario.getLongitude()+" "+voluntario.getLatitude()+")";

        try{
            conn.createQuery(SQL_INSERT, true)
                    .addParameter("id", newId())
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("correo", voluntario.getCorreo())
                    .addParameter("contrasenia", voluntario.getContrasenia())
                    .addParameter("point",point)
                    .executeUpdate();
            return voluntario;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear el voluntario\n");
            return null;
        }
    }


    @Override
    public void updateVoluntario(Voluntario voluntario,int id){

        String SQL_UPDATE = "UPDATE voluntario SET nombre = :nombre, correo= :correo, contrasenia= :contrasenia, geom=ST_GeomFromText(:point, 4326), id = :id WHERE id = :id";
        String point = "POINT("+voluntario.getLongitude()+" "+voluntario.getLatitude()+")";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("correo", voluntario.getCorreo())
                    .addParameter("contrasenia", voluntario.getContrasenia())
                    .addParameter("id", id)
                    .addParameter("point",point)
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

    //FUNCIONALIDAD 22//
    //FUNCIONALIDAD 22//
    @Override
    public List<Voluntario> getCercanos(String punto, int numero) {
        
        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT id,nombre,correo,contrasenia,st_x(st_astext(geom)) AS longitude, st_y(st_astext(geom)) AS latitude "+
            " FROM voluntario ORDER BY st_distance(geom, ST_GeomFromText(:point, 4326)) ASC Limit :N")
            .addParameter("point", punto)
            .addParameter("N",numero)
            .executeAndFetch(Voluntario.class);
        }
    }
    //FUNCIONALIDAD 22//
    //FUNCIONALIDAD 22//

}