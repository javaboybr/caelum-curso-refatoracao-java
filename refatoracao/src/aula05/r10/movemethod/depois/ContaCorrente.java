package aula05.r10.movemethod.depois;

public class ContaCorrente {
	
	private final TipoConta tipoConta;
	private final int diasEmDescoberto;
	
	public ContaCorrente(TipoConta tipoConta, int diasEmDescoberto) {
		this.tipoConta = tipoConta;
		this.diasEmDescoberto = diasEmDescoberto;
	}
	
	public double getTaxaChequeEspecial() {
		return tipoConta.getTaxaChequeEspecial(this);
	}

	public int getDiasEmDescoberto() {
		return diasEmDescoberto;
	}
}

class TipoConta {
	
	private boolean ehPremium;
	
	public TipoConta(boolean ehPremium) {
		this.ehPremium = ehPremium;
	}

	public boolean ehPremium() {
		return ehPremium;
	}

	public double getTaxaChequeEspecial(ContaCorrente contaCorrente) {
		if(ehPremium()) {
			double result = 10;
			if(contaCorrente.getDiasEmDescoberto() > 7) result += (contaCorrente.getDiasEmDescoberto() - 7) * 0.01;
			return result;
		}
		return contaCorrente.getDiasEmDescoberto() * 1.75;
	}
}
