package br.com.caelum.livraria.dominio;

import static java.time.LocalDate.now;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.javamoney.moneta.Money;

//12 - Extrair classe: Essa classe será o resultado da refatoração.
public class CarrinhoDeComprasFactory implements Iterable<CarrinhoDeCompras> {

	private final Set<CarrinhoDeCompras> carrinhos;
	
	public CarrinhoDeComprasFactory() {
		this.carrinhos = new HashSet<>();
	}
	
	@Override
	public Iterator<CarrinhoDeCompras> iterator() {
		return carrinhos.iterator();
	}
 
	public CarrinhoDeCompras obterCarrinho(final Cliente idCliente, Livro livro, Money valorFrete) {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(idCliente, livro, valorFrete, now());
		if(carrinhos.contains(carrinho)) {
			carrinho = carrinhos.stream()
					.filter(umCarrinho -> umCarrinho.doCliente(idCliente))
					.findFirst().orElse(null);
			//14 - Ocultar delegação. Nesse ponto, quando o código for bagunçado, será usado um
			// getLivros().adicionar(livro)
			if(carrinho != null)carrinho.adicionar(livro);
		}
		else carrinhos.add(carrinho);
		return carrinho;
	}

}
