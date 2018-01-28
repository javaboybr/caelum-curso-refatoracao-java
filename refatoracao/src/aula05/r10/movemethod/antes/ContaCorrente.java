package aula05.r10.movemethod.antes;

public class ContaCorrente {
	
	private final TipoConta tipoConta;
	private final int diasEmDescoberto;
	
	public ContaCorrente(TipoConta tipoConta, int diasEmDescoberto) {
		this.tipoConta = tipoConta;
		this.diasEmDescoberto = diasEmDescoberto;
	}
	
	public double getTaxaChequeEspecial() {
		if(tipoConta.ehPremium()) {
			double result = 10;
			if(diasEmDescoberto > 7) result += (diasEmDescoberto - 7) * 0.01;
			return result;
		}
		return diasEmDescoberto * 1.75;
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
}
