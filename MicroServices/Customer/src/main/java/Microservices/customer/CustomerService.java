package Microservices.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

	private final RestTemplate restTemplate;
	private final CustomerRepository customerRepository;
	public void registerCustomer(CustomerRegistrationRequest request) {
		// TODO Auto-generated method stub
		
		Customer customer=Customer.builder()
				.firstname(request.firstname())
				.lastname(request.lastname())
				.email(request.email()).build();
		
		customerRepository.saveAndFlush(customer);
		FraudCheckResponse fraudCheckResponse=restTemplate.
		getForObject("http://FRAUD/api/v1/fraud-check/{customerId}", 
				FraudCheckResponse.class,customer.getId());
	
		if(fraudCheckResponse.isFraudster()) {
			
			throw new IllegalStateException("Fraudster");
		}
		
	}

}
