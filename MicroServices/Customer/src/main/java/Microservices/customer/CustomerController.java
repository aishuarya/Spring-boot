package Microservices.customer;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


//RestController is used for making restful web services
//slf4j for logging

@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
@Slf4j
public class CustomerController {
	
	
private final CustomerService  customerService;
	@PostMapping
	public void registerCustomer( @RequestBody CustomerRegistrationRequest customerRegistrationRequest ) {
		
	//Logger log = null ;
	
	log.info("New customer registartion{}",customerRegistrationRequest);
		
	customerService.registerCustomer(customerRegistrationRequest);
		
	}
}
