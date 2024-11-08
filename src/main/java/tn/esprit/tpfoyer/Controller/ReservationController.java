package tn.esprit.tpfoyer.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Reservation;
import tn.esprit.tpfoyer.Service.IReservationService;

import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin("*")

@RequestMapping("/api/v5")
public class ReservationController {
    private IReservationService ireservationService;

    @GetMapping("/reservation")
    public List<Reservation> getreservation(){
        return ireservationService.retrieReservationAllReservation();
    }



    @PostMapping("/addreservation")
    public Reservation addReservation(@RequestBody Reservation reservation )
    {
        return  ireservationService.addReservation(reservation);

    }

    @PutMapping("/UpdateReservation")

    public Reservation UpdateReservation ( @RequestBody Reservation reservation) {
        return ireservationService.updateReservation(reservation);
    }

    @GetMapping("/retiReservationById/{IdReservation}")
    public Reservation retriRervationById(@PathVariable Long IdReservation) {
        return ireservationService.retrieReservationById(IdReservation);
    }
    @DeleteMapping("/deleteReservation/{IdReservation}")

    public void  DeleteFoyer( @PathVariable Long IdReservation) {
        ireservationService.DeleteReservation(IdReservation); }

}
