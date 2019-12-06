package sn.touba.xadimousalih.declarationtimbreservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
//Enregistrer les instance de ce microservices dans Eureka
@EnableDiscoveryClient
public class DeclarationTimbreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeclarationTimbreServiceApplication.class, args);
	}
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
