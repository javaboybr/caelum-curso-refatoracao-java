package aula01.r02.inlinemethod.depois;

public class Motoboy {
	
	private int qtdeEntregasNoturnas;
	
	public Motoboy(int qtdeEntregasNoturnas) {
		this.qtdeEntregasNoturnas = qtdeEntregasNoturnas;
	}
	
	int lerAvaliacao() {
		return qtdeEntregasNoturnas > 5 ? 2 : 1;
	}
}
