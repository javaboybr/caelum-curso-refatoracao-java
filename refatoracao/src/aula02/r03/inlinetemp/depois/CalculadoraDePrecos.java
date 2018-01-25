package aula02.r03.inlinetemp.depois;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class CalculadoraDePrecos {
	
	boolean temDesconto(Pedido pedido) {
		double valorProdutos = pedido.valorProdutos();
		return valorProdutos > 1000;
	}
}

class Pedido {
	
	private final LocalDateTime clienteDesde;
	private final double valorProdutos;
	
	public Pedido(LocalDateTime clienteDesde, double valorProdutos) {
		this.clienteDesde = clienteDesde;
		this.valorProdutos = valorProdutos;
	}
	
	public double valorProdutos() {
		return valorProdutos;
	}
	
	public boolean temDesconto() {
		// aqui NÃO É um bom exemplo para inline method!
		boolean clienteHaMaisDe5Anos = Period.between(clienteDesde.toLocalDate(), LocalDate.now()).getYears() >= 5;
		boolean compraEspecial = valorProdutos > 1000;
		return clienteHaMaisDe5Anos && compraEspecial;
	}
}
