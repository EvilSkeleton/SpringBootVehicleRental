package rohit.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rohit.vehicle.domain.Rental;
import rohit.vehicle.exception.ResourceNotFoundException;
import rohit.vehicle.repository.RentalRepository;

@Service
public class UserService {

    @Autowired
    private RentalRepository rentRepo;
	
    //view all rental vehicles
	public List<Rental> listAll() {
        return rentRepo.findAll();
    }

    //edit rental details(Rental Status)
    public void saveRental(Rental rent) {
        rentRepo.save(rent);
    }

    //locate by id from vehicles
    public Rental get(Integer id) {
        Rental rental = rentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found rental with id = " + id));
        // rental.setV_id(rental.getV_id());
        rental.setV_name(rental.getV_name());
        rental.setV_status(rental.getV_status());
        rental.setV_model(rental.getV_model());
        rental.setV_cust(rental.getV_cust());
        // return new ResponseEntity<>(rentRepo.save(rental), HttpStatus.OK);
        return rental;
    }

    //finish rental
    public void finishRental(Integer id) {
        Rental rent = rentRepo.findById(id).get();
        rent.setV_status("Idle");
        rent.setV_cust(null);
        rentRepo.save(rent);
    }
}