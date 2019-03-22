package telecom.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import telecom.service.PhoneNumberService;

@RestController
public class PhoneNumberController {

    @Autowired
    private PhoneNumberService phoneNumberService;

    private static Logger log = LogManager.getLogger(PhoneNumberController.class);

    @GetMapping("/numbers")
    public ResponseEntity getAllNumbers() {
        log.info("Returning all phone numbers: ");
        return phoneNumberService.findAll();
    }

    @GetMapping("/numbers/{customerId}")
    public ResponseEntity getNumbersForCustomer(@PathVariable Long customerId) {
        log.info("Returing all numbers for customer with id: {}", customerId);
        return phoneNumberService.findAllCustomerNumbers(customerId);
    }

    @PostMapping("/activate-number/{numberId}")
    public ResponseEntity activateNumber(@PathVariable Long numberId) {
        log.info("Activating number: {}", numberId);
        return phoneNumberService.activateNumber(numberId);
    }
}
