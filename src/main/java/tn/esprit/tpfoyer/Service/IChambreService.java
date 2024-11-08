package tn.esprit.tpfoyer.Service;



import tn.esprit.tpfoyer.Entity.Chambre;

import java.util.List;

public interface IChambreService {

        public Chambre addChambre(Chambre chambre);

        public Chambre updateChambre(Chambre chambre);

        public List<Chambre> retrieChambreAllchambre();

        public Chambre retriechambreById(Long idChambre );

        public void Deletechambre(Long idChambre);
    }

