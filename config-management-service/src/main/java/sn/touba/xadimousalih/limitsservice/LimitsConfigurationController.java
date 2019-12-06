package sn.touba.xadimousalih.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.touba.xadimousalih.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		
//		return new LimitConfiguration(1000, 1);
		
		LimitConfiguration limitConfiguration = new LimitConfiguration(configuration.getMaximum(), 
				configuration.getMinimum());
		return limitConfiguration;
	}
	
//	@GetMapping("/fault-tolerance-example")
//	@HystrixCommand(fallbackMethod="fallbackRetrieveConfiguration")
//	public LimitConfiguration retrieveConfiguration() {
//		throw new RuntimeException("Not available");
//	}
//
//	public LimitConfiguration fallbackRetrieveConfiguration() {
//		return new LimitConfiguration(999, 9);
//	}	

}
