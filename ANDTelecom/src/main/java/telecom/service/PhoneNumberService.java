package telecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import telecom.entity.Customer;
import telecom.entity.PhoneNumber;
import telecom.repository.CustomerRepository;
import telecom.repository.PhoneNumberRepository;

import java.util.Optional;

@Service
public class PhoneNumberService {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity findAll(){
        return ResponseEntity.ok().body(phoneNumberRepository.findAll());
    }

    public ResponseEntity findAllCustomerNumbers(Long customerId){
        Optional<Customer> optionalCustomer = (customerRepository.findById(customerId));
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            return ResponseEntity.ok().body(customer.getPhoneNumbers());
        }
        return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity activateNumber(Long numberId){
        Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(numberId);
        if(phoneNumber.isPresent()){
            PhoneNumber number = phoneNumber.get();
            number.setActivated(true);
            phoneNumberRepository.saveAndFlush(number);
            return ResponseEntity.ok().body(HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
    }
}
