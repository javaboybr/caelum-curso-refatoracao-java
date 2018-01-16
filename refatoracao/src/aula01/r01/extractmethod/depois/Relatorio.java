package aula01.r01.extractmethod.depois;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Relatorio {
	
	void imprimir() {
		Pedido pedido = criarPedido();
		double total = imprimirItens(pedido);
		imprimirDetalhes(pedido, total);
	}
	
	private Pedido criarPedido() {
		Pedido pedido = new Pedido("José da Silva");
		pedido.addItem("Dentozap", 2, 10, 0d, 3d);
        pedido.addItem("Voldax", 3, 10, 0d, 3d);
        pedido.addItem("Tranlab", 7, 10, 0d, 3d);
		return pedido;
	}
	
	private void imprimirDetalhes(Pedido pedido, double total) {
        System.out.println("*****************************");
        System.out.println("********** Resumo ***********");
        System.out.println("*****************************");
        System.out.println("nome: " + pedido.getCliente());
        System.out.println("valor: " + total);
	}
	
	private double imprimirItens(Pedido pedido) {
		System.out.println("*****************************");
		System.out.println("********** Itens ************");
		System.out.println("*****************************");
		double total = 0d;
		for(Item item : pedido.getItens()) {
			double valorItem = getValorItem(item);
			System.out.printf("%.0f: %d unidades, R$ %.0f", item.getDesconto(), item.getQuantidade(), valorItem);
			total = total + valorItem;
		}
		return total;
	}

	private double getValorItem(Item item) {
		return item.getQuantidade() * item.getPrecoBase();
	}
}

class Pedido {
	
	private String cliente;
	
	private final List<Item> itens = new ArrayList<>();
	
	public Pedido(String cliente) {
		this.cliente = cliente;
	}
	
	public void addItem(String descricao, int quantidade, double precoBase, double acrescimo, double desconto) {
		itens.add(new Item(descricao, quantidade, precoBase, acrescimo, desconto));
	}

	public String getCliente() {
		return cliente;
	}

	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}
}

class Item{
	
	private final String descricao;
	private final int quantidade;
	private final double precoBase;
	private final double acrescimo;
	private final double desconto;
	
	public Item(String descricao, int quantidade, double precoBase, double acrescimo, double desconto) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoBase = precoBase;
		this.acrescimo = acrescimo;
		this.desconto = desconto;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getPrecoBase() {
		return precoBase;
	}

	public double getAcrescimo() {
		return acrescimo;
	}

	public double getDesconto() {
		return desconto;
	}
}
