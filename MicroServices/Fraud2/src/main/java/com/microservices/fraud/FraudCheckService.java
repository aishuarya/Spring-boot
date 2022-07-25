package com.microservices.fraud;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class FraudCheckService {
	
	private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
	
	
	
	
	public boolean isFraudulentCustomer(Integer customerID) {
		
		fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
				.customerId(customerID)
				.isFraudster(false)
				.createAt(LocalDateTime.now())
				.build());
		return false;
	}

}
