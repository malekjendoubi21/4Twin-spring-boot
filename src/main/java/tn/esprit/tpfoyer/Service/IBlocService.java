package tn.esprit.tpfoyer.Service;

import tn.esprit.tpfoyer.Entity.Bloc;

import java.util.List;

public interface IBlocService {
    public Bloc addBloc(Bloc bloc);

    public Bloc updateBloc(Bloc bloc);

    public List<Bloc> retrieBlocAllBloc();

    public Bloc retrieBlocById(Long idBloc );

    public void DeleteBloc(Long idBloc);
}
