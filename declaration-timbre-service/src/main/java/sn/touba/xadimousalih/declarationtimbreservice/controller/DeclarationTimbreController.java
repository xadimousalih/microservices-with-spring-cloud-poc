package sn.touba.xadimousalih.declarationtimbreservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sn.touba.xadimousalih.declarationtimbreservice.exception.DeclarationNotFoundException;
import sn.touba.xadimousalih.declarationtimbreservice.model.DeclarationTimbreInfo;
import sn.touba.xadimousalih.declarationtimbreservice.repository.DeclarationTimbreRepository;

@RestController
public class DeclarationTimbreController {

	@Autowired
	private Environment environment;
	@Autowired
	private DeclarationTimbreRepository declarationTimbreRepository;

	@GetMapping("/declaration-timbre/ninea/{ninea}/montant/{montant}")
	public DeclarationTimbreInfo retrieveDeclarationInfo(@PathVariable String ninea, @PathVariable String montant) {
		// DeclarationTimbreInfo declarationInfo = new DeclarationTimbreInfo(10000L,
		// "NIN001", 500000);
		DeclarationTimbreInfo declarationInfo = declarationTimbreRepository.findByNineaAndMontant(ninea,
				Double.parseDouble(montant));
		if (declarationInfo == null)
			throw new DeclarationNotFoundException("NINEA ==> " + ninea);

		declarationInfo.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return declarationInfo;

	}

}
