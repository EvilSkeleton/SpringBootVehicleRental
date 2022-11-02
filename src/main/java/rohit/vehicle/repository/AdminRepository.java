package rohit.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import rohit.vehicle.domain.Admin;
 
 
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {}