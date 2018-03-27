package br.com.caelum.livraria.dominio;

import java.util.Iterator;

import org.javamoney.moneta.Money;

public class CarrinhoDeCompras implements Iterable<Livro> {
	
	private final Cliente idCliente;
	private final Money valorFrete;
	private final Livros livros;
	private Desconto desconto;
	
	public CarrinhoDeCompras(Cliente idCliente, Livro livro, Money valorFrete) {
		this.idCliente = idCliente;
		this.livros = new Livros(livro);
		this.valorFrete = valorFrete;
		this.desconto = Desconto.NENHUM;
	}

	public Money lerValorTotal() {
		return CalculadoraDeCompra.calcularValorTotal(livros.lerSubtotal(), valorFrete, desconto);
	}

	public void incluirDesconto(Desconto desconto) {
		this.desconto = desconto;
	}

	public boolean doCliente(Cliente idCliente) {
		return this.idCliente.equals(idCliente);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		if(obj instanceof CarrinhoDeCompras) {
			CarrinhoDeCompras outro = (CarrinhoDeCompras)obj;
			ret = idCliente.equals(outro.idCliente);
		}
		return ret;
	}
	
	@Override
	public int hashCode() {
		return idCliente.hashCode();
	}

	@Override
	public Iterator<Livro> iterator() {
		return livros.iterator();
	}

	public void adicionar(Livro livro) {
		livros.adicionar(livro);
	}
}
