package aula05.r11.movefield.depois;

public class ContaDeLuz {
	
	private TipoDeConta tipoDeConta;
	
	public ContaDeLuz(TipoDeConta tipo) {
		this.tipoDeConta = tipo;
	}
	
	public double calcularValorDosJuros(double principal, int diasDeAtraso) {
		double jurosAoDia = tipoDeConta.jurosAoMes / 30;
		double juros = jurosAoDia * diasDeAtraso;
		return juros * principal;
	}
}
 
abstract class TipoDeConta {
	
	protected double jurosAoMes;
}

class ContaResidencial extends TipoDeConta{
	
	public ContaResidencial() {
		this.jurosAoMes = 0.03;
	}
}

class ContaComercial extends TipoDeConta {
	
	public ContaComercial() {
		this.jurosAoMes = 0.06;
	}
}