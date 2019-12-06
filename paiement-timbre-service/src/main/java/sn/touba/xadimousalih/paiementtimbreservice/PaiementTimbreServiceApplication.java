package sn.touba.xadimousalih.paiementtimbreservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@SpringBootApplication
//Activation de feign en lui passant le package à scanner
@EnableFeignClients("sn.touba.xadimousalih.paiementtimbreservice")
//Enregistrer les instance de ce microservices dans Eureka
@EnableDiscoveryClient
public class PaiementTimbreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaiementTimbreServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public Sampler defaultSampler() {	
		return Sampler.ALWAYS_SAMPLE;
	}


}
