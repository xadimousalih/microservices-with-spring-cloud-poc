package sn.touba.xadimousalih.paiementtimbreservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sn.touba.xadimousalih.paiementtimbreservice.model.PaiementTimbreInfo;

//name =nom du service à appeler dans mon cas je lui passe le nom de figurant dans le fichier application.properties du service à invoquer : spring.application.name=declaration-timbre-service
//@FeignClient(name="declaration-timbre-service", url="localhost:8000")
//Pas besoin de mettre l'url en cas de multi instance  parce que le naming serveur s'en chargera ou au pire des cas utiliser la propriéte suivante dans le fichier application.properties declaration-timbre-service.ribbon.listOfServers=http://localhost:8000,http://localhost:8001

//V1 sans Zuul
//@FeignClient(name="declaration-timbre-service")

//V2
//Pour intégrer zuul dans la communication entre les micro services internes (paiement et déclaration)
@FeignClient(name="zuul-api-gateway-server")


//Activation de Ribbon pour les besoins de load balancing entre plusieurs instances microservices
@RibbonClient(name="declaration-timbre-service")
public interface DeclarationTimbreServiceProxy {
	//V1 sans zuul
	//@GetMapping("/declaration-timbre/ninea/{ninea}/montant/{montant}")
	
	//V2 avec Zuul
	@GetMapping("/declaration-timbre-service/declaration-timbre/ninea/{ninea}/montant/{montant}")
	public PaiementTimbreInfo retrieveDeclarationInfo(@PathVariable String ninea, @PathVariable String montant);

}
