package aula05.r11.movefield.antes;

public class ContaDeLuz {
	
	private TipoDeConta tipoDeConta;
	private double jurosAoMes;
	
	public ContaDeLuz(TipoDeConta tipo) {
		this.tipoDeConta = tipo;
		if(tipoDeConta instanceof ContaResidencial) this.jurosAoMes = 0.03;
		else this.jurosAoMes = 0.06;
	}
	
	public double calcularValorDosJuros(double principal, int diasDeAtraso) {
		double jurosAoDia = jurosAoMes / 30;
		double juros = jurosAoDia * diasDeAtraso;
		return juros * principal;
	}
}
 
abstract class TipoDeConta {
	
}

class ContaResidencial extends TipoDeConta{
	
}

class ContaComercial extends TipoDeConta {
	
}