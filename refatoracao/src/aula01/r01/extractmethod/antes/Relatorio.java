package aula01.r01.extractmethod.antes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Relatorio {
	void imprimir() {
		double total = 0.0d;
		Pedido pedido = new Pedido("José da Silva");
        pedido.addItem("Dentozap", 2, 10d, 0d, 3d);
        pedido.addItem("Voldax", 3, 10d, 0d, 3d);
        pedido.addItem("Tranlab", 7, 10d, 0d, 3d);
        
        // imprimir itens
        System.out.println("*****************************");
        System.out.println("********** Itens ************");
        System.out.println("*****************************");
        for (Item item : pedido.getItens())
        {
            double valorItem = item.getQuantidade() * item.getPrecoBase();
            System.out.printf("%.0f: %d unidades, R$ %.0f", item.getDesconto(), item.getQuantidade(), valorItem);
            total = total + valorItem;
        }

        // imprimir detalhes
        System.out.println("*****************************");
        System.out.println("********** Resumo************");
        System.out.println("*****************************");
        System.out.println("nome: " + pedido.getCliente());
        System.out.println("valor: " + total);


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
