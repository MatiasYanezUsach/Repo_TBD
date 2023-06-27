package cl.tbd.control1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tbd.control1.models.Ranking;
import cl.tbd.control1.repository.RankingRepositoryImp;

@Service

public class RankingService {
    @Autowired
    private RankingRepositoryImp rankingRepository  = new RankingRepositoryImp();

    public List <Ranking> getAll(){
    return rankingRepository.findAllRanking();  
    }
    public Ranking select(int id){
        return rankingRepository.getRanking(id);
    }
    public Ranking crearRanking(Ranking ranking){
        return  rankingRepository.createRanking(ranking);
    }
    public void actualizarRanking(Ranking ranking,int id) {

        rankingRepository.updateRanking(ranking, id);
    }
    public void deleteRanking(int id){
        rankingRepository.deleteRanking(id);
    }
}