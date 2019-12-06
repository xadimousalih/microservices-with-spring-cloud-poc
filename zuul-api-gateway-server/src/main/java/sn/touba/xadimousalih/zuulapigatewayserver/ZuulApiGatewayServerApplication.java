package sn.touba.xadimousalih.zuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;


//Activation de Zuul 
@EnableZuulProxy
//Activer la découverte au niveau du naming server eureka
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewayServerApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		
		return Sampler.ALWAYS_SAMPLE;
	}

}
