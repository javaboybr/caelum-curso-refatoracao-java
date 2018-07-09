package br.com.caelum.livraria.dominio;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.util.Arrays.asList;

import java.time.LocalDate;
import java.util.Iterator;

import org.javamoney.moneta.Money;

public class CarrinhoDeCompras implements Iterable<Livro> {
	
	private final Cliente cliente;
	private final Money valorFrete;
	private final Livros livros;
	private Desconto desconto;
	private final LocalDate dataDaCompra;
	private final CalculadoraDeCompra calculadora;
	
	private static final int DIAS_PARA_ENTREGA = 5;
	
	public CarrinhoDeCompras(Cliente cliente, Livro livro, Money valorFrete, LocalDate dataDaCompra) {
		this.cliente = cliente;
		this.livros = new Livros(livro);
		this.valorFrete = valorFrete;
		this.desconto = Desconto.NENHUM;
		this.dataDaCompra = dataDaCompra;
		this.calculadora = new CalculadoraDeCompra();
	}

	public Money getValorTotal() {
		return calculadora.calcularValorTotal(livros.getSubtotal(), valorFrete, desconto);
	}
	
	public LocalDate getDataDeEntrega() {
		return calcularDiaDeEntrega(DIAS_PARA_ENTREGA);
	}
	
	private LocalDate calcularDiaDeEntrega(int diasParaEntrega) {
		LocalDate dataCalculada = dataDaCompra.plusDays(diasParaEntrega);
		//16 - Introduzir método externo - será criado um método que verifique se a data de entrega calculada
		// é um fim de semana
		if(asList(SATURDAY, SUNDAY).contains(dataCalculada.getDayOfWeek())) return calcularDiaDeEntrega(diasParaEntrega + 1);
		return dataCalculada;
	}

	public void incluirDesconto(Desconto desconto) {
		this.desconto = desconto;
	}

	public boolean doCliente(Cliente idCliente) {
		return this.cliente.equals(idCliente);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean iguais = false;
		if(obj instanceof CarrinhoDeCompras) {
			CarrinhoDeCompras outro = (CarrinhoDeCompras)obj;
			iguais = cliente.equals(outro.cliente);
		}
		return iguais;
	}
	
	@Override
	public int hashCode() {
		return cliente.hashCode();
	}

	@Override
	public Iterator<Livro> iterator() {
		return livros.iterator();
	}

	public Livros getLivros() {
		return livros;
	}
}
