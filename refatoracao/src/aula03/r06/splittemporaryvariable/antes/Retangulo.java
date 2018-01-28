package aula03.r06.splittemporaryvariable.antes;

public class Retangulo {
	
	public Retangulo(double altura, double largura) {
		double temp = 2 * (altura + largura);
		System.out.printf("Perímetro: %f", temp);
		
		temp = altura * largura;
		System.out.printf("Área: %f", temp);
	}
}
