package telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import telecom.entity.PhoneNumber;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {

}
