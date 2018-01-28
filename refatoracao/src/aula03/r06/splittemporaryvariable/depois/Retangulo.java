package aula03.r06.splittemporaryvariable.depois;

public class Retangulo {
	
	public Retangulo(double altura, double largura) {
		double perimetro = 2 * (altura + largura);
		System.out.printf("Perímetro: %f", perimetro);
		
		double area = altura * largura;
		System.out.printf("Área: %f", area);
	}
}
