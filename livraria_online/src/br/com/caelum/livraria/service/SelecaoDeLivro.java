package br.com.caelum.livraria.service;

import org.javamoney.moneta.Money;

import br.com.caelum.livraria.dominio.CalculadoraFrete;
import br.com.caelum.livraria.dominio.CarrinhoDeCompras;
import br.com.caelum.livraria.dominio.CarrinhoDeComprasFactory;
import br.com.caelum.livraria.dominio.Cliente;
import br.com.caelum.livraria.dominio.ISBN;
import br.com.caelum.livraria.dominio.Livro;
import br.com.caelum.livraria.dominio.TodosLivros;

public class SelecaoDeLivro {
	
	private final TodosLivros todosLivros;
	private final CarrinhoDeComprasFactory factory;
	private final CalculadoraFrete calculadoraFrete;
	
	public SelecaoDeLivro(TodosLivros todosLivros, CalculadoraFrete calculadoraFrete, CarrinhoDeComprasFactory factory) {
		this.todosLivros = todosLivros;
		this.calculadoraFrete = calculadoraFrete;
		this.factory = factory;
	}

	public CarrinhoDeCompras adicionarLivro(ISBN isbn, Cliente cliente) {
		Livro livro = todosLivros.por(isbn);
		Money valorFrete = calculadoraFrete.baseadoEm(cliente.lerCep());
		return factory.obterCarrinho(cliente, livro, valorFrete);
	}
}
