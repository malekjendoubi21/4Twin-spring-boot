package tn.esprit.exam.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.exam.entity.Equipe;
import tn.esprit.exam.repository.EquipeRepository;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class EquipeService implements IEquipeService{
EquipeRepository equipeRepository;
    @Override
    public List<Equipe> retrieveAllEquipes() {
        List<Equipe> listC = equipeRepository.findAll();
        log.info("nombre total des chambres : " + listC.size());
        for (Equipe c: listC) {
            log.info("Equipe : " + c);
        }
        return listC;
    }

    @Override
    public Equipe retrieveEquipe(Long idEquipe) {


        Equipe equipe = equipeRepository.findById(idEquipe).get();
        return equipe;
    }

    @Override
    public Equipe addEquipe(Equipe equipe) {

        Equipe e = equipeRepository.save(equipe);
        return e;
    }

    @Override
    public void removeEquipe(Long idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }

    @Override
    public Equipe modifyEquipe(Equipe idEquipe) {

        Equipe e = equipeRepository.save(idEquipe);
        return e;
    }
}
