package rohit.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rohit.vehicle.domain.Rental;
import rohit.vehicle.repository.AdminRepository;
import rohit.vehicle.repository.RentalRepository;
import rohit.vehicle.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private AdminRepository adminRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RentalRepository rentRepo;
	
    //view all rental vehicles availible to rent
	public List<Rental> listAll() {
        //filter all 
        return rentRepo.findAll();
    }

    //view all rental vehicle in use by this user
    public List<Rental> listAllInUse() {
        List<Rental> rentList = rentRepo.findAll();
        //filter all 
        return rentList;
    }

    //edit rental details(Rental Status)
    public void saveRental(Rental rent) {
        rentRepo.save(rent);
    }

    //
}