package cl.tbd.control1.repository;
import cl.tbd.control1.models.Ranking;
import java.util.List;
public interface RankingRepository{
    public List<Ranking> findAllRanking();
    public Ranking getRanking(int id);
    public Ranking createRanking(Ranking ranking);
    public void updateRanking(Ranking ranking,int id);
    public void deleteRanking(int id);
    public int newId();
}