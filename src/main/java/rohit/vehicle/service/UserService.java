package rohit.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rohit.vehicle.domain.Rental;
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
        return rentRepo.findById(id).get();
    }

    //finish rental
    public void finishRental(Integer id) {
        Rental rent = rentRepo.findById(id).get();
        rent.setV_status("Idle");
        rent.setV_cust(null);
        rentRepo.save(rent);
    }
}