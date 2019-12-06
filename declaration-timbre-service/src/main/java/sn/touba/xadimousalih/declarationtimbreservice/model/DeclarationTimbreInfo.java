package sn.touba.xadimousalih.declarationtimbreservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "declaration_info")
public class DeclarationTimbreInfo extends AbstractAuditingEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long numero;
	private String ninea;
	private double montant;
	private int port;
	
	
	public DeclarationTimbreInfo() {
	}



	public DeclarationTimbreInfo(long numero, String ninea, double montant) {
		super();
		
		this.numero = numero;
		this.ninea = ninea;
		this.montant = montant;
	}



	public long getNumero() {
		return numero;
	}



	public void setNumero(long numero) {
		this.numero = numero;
	}



	public String getNinea() {
		return ninea;
	}



	public void setNinea(String ninea) {
		this.ninea = ninea;
	}



	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	public int getPort() {
		return port;
	}



	public void setPort(int port) {
		this.port = port;
	}



	@Override
	public String toString() {
		return "DeclarationInfo [numero=" + numero + ", ninea=" + ninea + ", montant=" + montant + "]";
	}



	
	
	
	
	
}
