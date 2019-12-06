package sn.touba.xadimousalih.paiementtimbreservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import sn.touba.xadimousalih.paiementtimbreservice.DeclarationTimbreServiceProxy;
import sn.touba.xadimousalih.paiementtimbreservice.model.PaiementTimbreInfo;

@RestController
public class PaiementTimbreController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DeclarationTimbreServiceProxy declarationTimbreServiceProxy;

	/**
	 * Version RestTemplate
	 * @param ninea
	 * @param montant
	 * @return
	 */
	@GetMapping("/paiement-timbre/ninea/{ninea}/montant/{montant}")
	public PaiementTimbreInfo payTimbreDeclaration(@PathVariable String ninea, @PathVariable String montant) {
		Map<String, String> payTimbreParameters = new HashMap<>();
		payTimbreParameters.put("ninea", ninea);
		payTimbreParameters.put("montant", montant);

		ResponseEntity<PaiementTimbreInfo> responseEntity = restTemplate.getForEntity(
				"http://localhost:8000/declaration-timbre/ninea/{ninea}/montant/{montant}", PaiementTimbreInfo.class,
				payTimbreParameters);
		PaiementTimbreInfo response = responseEntity.getBody();
		response.setStatusPaiement(true);
		return response;

	}

	/**
	 * Version Feign
	 * @param ninea
	 * @param montant
	 * @return
	 */
	@GetMapping("/paiement-timbre-feign/ninea/{ninea}/montant/{montant}")
	public PaiementTimbreInfo payTimbreDeclarationFeign(@PathVariable String ninea, @PathVariable String montant) {
		PaiementTimbreInfo response = declarationTimbreServiceProxy.retrieveDeclarationInfo(ninea, montant);
		response.setStatusPaiement(true);
		return response;

	}

}
