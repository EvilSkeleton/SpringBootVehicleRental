package rohit.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rohit.vehicle.domain.Rental;
import rohit.vehicle.domain.User;
import rohit.vehicle.repository.RentalRepository;
import rohit.vehicle.repository.UserRepository;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RentalRepository rentRepo;
	
    //view all vehicles
	public List<Rental> listAll() {
        return rentRepo.findAll();
    }
     
    //save vehicle details(CREATE AND EDIT)
    public void saveRental(Rental rent) {
        rentRepo.save(rent);
    }
    
    //delete by id from vehicles
    public void deleteRental(Integer id) {
        rentRepo.deleteById(id);
    }

    //locate by id from vehicles
    public Rental get(Integer id) {
        return rentRepo.findById(id).get();
    }

    //view all Users
    public List<User> listAllUsers() {
        return userRepo.findAll();
    }
    //save User details(EDIT)
    public void save(User usr) {
        userRepo.save(usr);
    }
    
    //delete User
    public void deleteusr(Integer id) {
        userRepo.deleteById(id);
    }
    
    //locate by id from user
    public User getUser(Integer id) {
        return userRepo.findById(id).get();
    }
    
    //accept rental request
}    
