package cl.tbd.control1.repository;
import cl.tbd.control1.models.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class RankingRepositoryImp implements RankingRepository{
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM ranking";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(int.class);
            return id+1;
        }
    }
    
    @Override
    public List<Ranking> findAllRanking() {
        
        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM ranking").executeAndFetch(Ranking.class);
        }
    }

    @Override
    public Ranking getRanking(int id) {

        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM ranking WHERE id = :id").addParameter("id",id).executeAndFetchFirst(Ranking.class);
        }    
    }

    @Override
    public Ranking createRanking(Ranking ranking){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO ranking(id, id_voluntario, id_tarea, puntaje)" + 
                            "VALUES(:id, :id_voluntario, :id_tarea, :puntaje)";

        try{
            conn.createQuery(SQL_INSERT, true)
                    .addParameter("id", newId())
                    .addParameter("id_voluntario", ranking.getId_voluntario())
                    .addParameter("id_tarea", ranking.getId_tarea())
                    .addParameter("puntaje", ranking.getPuntaje())
                    .executeUpdate();
            return ranking;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear el ranking\n");
            return null;
        }
    }


    @Override
    public void updateRanking(Ranking ranking,int id){

        String SQL_UPDATE = "UPDATE ranking SET id_voluntario = :id_voluntario, id_tarea = :id_tarea, puntaje = :puntaje, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                    .addParameter("id_voluntario", ranking.getId_voluntario())
                    .addParameter("id_tarea", ranking.getId_tarea())
                    .addParameter("puntaje", ranking.getPuntaje())
                    .addParameter("id", id)
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el ranking\n");
        }
    }


    @Override
    public void deleteRanking(int id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM ranking WHERE ranking.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el ranking\n");
        }
    }
}