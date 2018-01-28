package aula03.r07.removeassignmentstoparameters.antes;

public class CalculadoraDePrecos {
	
	double getDescontoFinal(double descontoInicial, int quantidade, int clienteHaQuantosAnos) {
		if(descontoInicial > 50) descontoInicial = 50;
		if(quantidade > 100) descontoInicial += 15;
		if(clienteHaQuantosAnos > 4) descontoInicial += 10;
		return descontoInicial;
	}
}
