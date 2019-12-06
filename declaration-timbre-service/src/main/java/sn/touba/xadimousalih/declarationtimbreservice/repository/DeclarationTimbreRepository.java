package sn.touba.xadimousalih.declarationtimbreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.touba.xadimousalih.declarationtimbreservice.model.DeclarationTimbreInfo;

public interface DeclarationTimbreRepository extends JpaRepository<DeclarationTimbreInfo, Long> {
	
	DeclarationTimbreInfo findByNineaAndMontant(String ninea, double montant);

}
