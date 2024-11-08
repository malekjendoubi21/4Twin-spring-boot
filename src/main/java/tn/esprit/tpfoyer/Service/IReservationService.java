package tn.esprit.tpfoyer.Service;


import tn.esprit.tpfoyer.Entity.Reservation;

import java.util.List;

public interface IReservationService {
        public Reservation addReservation(Reservation reservation);
        public Reservation updateReservation(Reservation reservation);
        public List<Reservation> retrieReservationAllReservation();
        public Reservation retrieReservationById(Long idReservation);
        public void DeleteReservation(Long idReservation);
    }

