package rohit.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import rohit.vehicle.domain.Rental;
 
 
@Repository
public interface RentalRepository extends JpaRepository<Rental,Integer> {
 
}