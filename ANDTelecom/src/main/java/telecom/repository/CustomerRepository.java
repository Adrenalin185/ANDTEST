package telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import telecom.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
