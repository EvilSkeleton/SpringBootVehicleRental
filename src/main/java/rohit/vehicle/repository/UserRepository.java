package rohit.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import rohit.vehicle.domain.User;
 
 
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {}