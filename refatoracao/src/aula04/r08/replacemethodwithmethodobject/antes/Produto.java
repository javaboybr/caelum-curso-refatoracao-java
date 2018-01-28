package aula04.r08.replacemethodwithmethodobject.antes;

public class Produto {
	
	private final String descricao;
	private boolean promocional;
	private final double precoBase;
	private final double acrescimo;
	private final double desconto;
	
	public Produto(String descricao, double precoBase, double acrescimo, double desconto) {
		this.descricao = descricao;
		this.precoBase = precoBase;
		this.acrescimo = acrescimo;
		this.desconto = desconto;
		
		double preco = calcularPreco(precoBase, acrescimo, desconto);
		
		System.out.printf("O preço é %.2f", preco);
	}

	private double calcularPreco(double precoBase, double acrescimo, double desconto) {
		if(promocional && desconto > 0) throw new RuntimeException("Produto já é promocional e não pode ter desconto!");
		if(desconto > 20) desconto = 20;
		if(acrescimo > 15) acrescimo = 15;
		return precoBase + precoBase * (acrescimo - desconto);
	}
	
	public void habilitarPromocao() {
		if(desconto == 0) this.promocional = true;
		else throw new RuntimeException("Produto com desconto não pode ser transformado em produto promocional");
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean isPromocional() {
		return promocional;
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
