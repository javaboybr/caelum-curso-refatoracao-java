package aula03.r07.removeassignmentstoparameters.depois;

public class CalculadoraDePrecos {
	
	double getDescontoFinal(double descontoInicial, int quantidade, int clienteHaQuantosAnos) {
		double resultado = descontoInicial;
		if(resultado > 50) resultado = 50;
		if(quantidade > 100) resultado += 15;
		if(clienteHaQuantosAnos > 4) resultado += 10;
		return resultado;
	}
}
