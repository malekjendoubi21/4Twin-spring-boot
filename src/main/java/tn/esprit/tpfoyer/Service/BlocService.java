package tn.esprit.tpfoyer.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Bloc;
import tn.esprit.tpfoyer.Repository.BlocRepository;

import java.util.List;
@Data
@AllArgsConstructor
@Service
public class BlocService implements IBlocService{
    private BlocRepository blocRepository;
    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.saveAndFlush(bloc);
    }
    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> retrieBlocAllBloc() {
        return blocRepository.findAll();}

    @Override
    public Bloc retrieBlocById(Long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void DeleteBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }
}
