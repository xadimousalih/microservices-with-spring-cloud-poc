package sn.touba.xadimousalih.paiementtimbreservice.model;


public class PaiementTimbreInfo {

	private long numero;
	private String ninea;
	private double montant;
	private int port;
	private boolean statusPaiement;
	
	
	public PaiementTimbreInfo() {
	}



	public PaiementTimbreInfo(long numero, String ninea, double montant) {
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



	public boolean isStatusPaiement() {
		return statusPaiement;
	}



	public void setStatusPaiement(boolean statusPaiement) {
		this.statusPaiement = statusPaiement;
	}



	@Override
	public String toString() {
		return "DeclarationInfo [numero=" + numero + ", ninea=" + ninea + ", montant=" + montant + "]";
	}



	
	
	
	
	
}
