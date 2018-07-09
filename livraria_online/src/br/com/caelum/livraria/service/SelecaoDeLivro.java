package br.com.caelum.livraria.service;

import static java.time.LocalDate.now;

import java.util.HashSet;
import java.util.Set;

import org.javamoney.moneta.Money;

import br.com.caelum.livraria.dominio.CalculadoraFrete;
import br.com.caelum.livraria.dominio.CarrinhoDeCompras;
import br.com.caelum.livraria.dominio.Cliente;
import br.com.caelum.livraria.dominio.ISBN;
import br.com.caelum.livraria.dominio.Livro;
import br.com.caelum.livraria.dominio.TodosLivros;

public class SelecaoDeLivro {
	
	private final TodosLivros todosLivros;
	private final CalculadoraFrete calculadoraFrete;
	private final Set<CarrinhoDeCompras> carrinhos;
	
	
	public SelecaoDeLivro(TodosLivros todosLivros, CalculadoraFrete calculadoraFrete) {
		this.todosLivros = todosLivros;
		this.calculadoraFrete = calculadoraFrete;
		this.carrinhos = new HashSet<>();
	}

	public CarrinhoDeCompras adicionarLivroNoCarrinhoDoCliente(ISBN isbn, Cliente cliente, String cep) {
		Livro livro = todosLivros.por(isbn);
		Money valorFrete = calculadoraFrete.baseadoEm(cep);
		
		//12 - extrair classe: criar o CarrinhoDeComprasFactory, que terá a lógica abaixo, bem
		// como a collection de carrinhos de compras.
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(cliente, livro, valorFrete, now());
		if(carrinhos.contains(carrinho)) {
			carrinho = carrinhos.stream()
					.filter(umCarrinho -> umCarrinho.doCliente(cliente))
					.findFirst().orElse(null);
			//14 - Ocultar delegação. Nesse ponto, quando o código for refatorado, será acrescentado um
			//adicionar(livro) à classe Carrinho, e removido o método getLivros() dessa mesma classe.
			if(carrinho != null)carrinho.getLivros().adicionar(livro);
		}
		else carrinhos.add(carrinho);
		return carrinho;
	}
}
