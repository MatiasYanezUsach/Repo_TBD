package cl.tbd.control1.repository;
import cl.tbd.control1.models.Vol_habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class Vol_habilidadRepositoryImp implements Vol_habilidadRepository{
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM vol_habilidad";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(int.class);
            return id+1;
        }
    }
    
    @Override
    public List<Vol_habilidad> findAllVol_habilidad() {
        
        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM vol_habilidad").executeAndFetch(Vol_habilidad.class);
        }
    }

    @Override
    public Vol_habilidad getVol_habilidad(int id) {

        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM vol_habilidad WHERE id = :id").addParameter("id",id).executeAndFetchFirst(Vol_habilidad.class);
        }    
    }

    @Override
    public Vol_habilidad createVol_habilidad(Vol_habilidad vol_habilidad){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO vol_habilidad(id, id_voluntario, id_habilidad)" + 
                            "VALUES(:id, :id_voluntario, :id_habilidad)";

        try{
            conn.createQuery(SQL_INSERT, true)
                    .addParameter("id", newId())
                    .addParameter("id_voluntario", vol_habilidad.getId_voluntario())
                    .addParameter("id_habilidad", vol_habilidad.getId_Habilidad())
                    .executeUpdate();
            return vol_habilidad;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la vol_habilidad\n");
            return null;
        }
    }


    @Override
    public void updateVol_habilidad(Vol_habilidad vol_habilidad,int id){

        String SQL_UPDATE = "UPDATE vol_habilidad SET id_voluntario = :id_voluntario, id_habilidad= :id_habilidad, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                    .addParameter("id_voluntario", vol_habilidad.getId_voluntario())
                    .addParameter("id_habilidad", vol_habilidad.getId_Habilidad())
                    .addParameter("id", id)
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la Vol_habilidad\n");
        }
    }


    @Override
    public void deleteVol_habilidad(int id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM vol_habilidad WHERE vol_habilidad.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la vol_habilidad\n");
        }
    }
}