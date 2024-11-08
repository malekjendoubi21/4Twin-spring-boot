package tn.esprit.tpfoyer.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Reservation;
import tn.esprit.tpfoyer.Repository.ReservationRepository;

import java.util.List;
@Data
@AllArgsConstructor
@Service
public class ReservationService implements IReservationService{
    private ReservationRepository reservationRepository;
    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.saveAndFlush(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> retrieReservationAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation retrieReservationById(Long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public void DeleteReservation(Long idReservation) {
       reservationRepository.deleteById(idReservation);
    }
}
