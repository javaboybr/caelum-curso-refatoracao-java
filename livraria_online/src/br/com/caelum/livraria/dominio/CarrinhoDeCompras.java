package br.com.caelum.livraria.dominio;

import java.util.Iterator;

import org.javamoney.moneta.Money;

public class CarrinhoDeCompras implements Iterable<Livro> {
	
	private final Cliente cliente;
	private final Money valorFrete;
	private final Livros livros;
	private Desconto desconto;
	
	public CarrinhoDeCompras(Cliente cliente, Livro livro, Money valorFrete) {
		this.cliente = cliente;
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
		return this.cliente.equals(idCliente);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		if(obj instanceof CarrinhoDeCompras) {
			CarrinhoDeCompras outro = (CarrinhoDeCompras)obj;
			ret = cliente.equals(outro.cliente);
		}
		return ret;
	}
	
	@Override
	public int hashCode() {
		return cliente.hashCode();
	}

	@Override
	public Iterator<Livro> iterator() {
		return livros.iterator();
	}

	public void adicionar(Livro livro) {
		livros.adicionar(livro);
	}
}
