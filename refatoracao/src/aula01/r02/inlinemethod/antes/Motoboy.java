package aula01.r02.inlinemethod.antes;

public class Motoboy {
	
	private int qtdeEntregasNoturnas;
	
	public Motoboy(int qtdeEntregasNoturnas) {
		this.qtdeEntregasNoturnas = qtdeEntregasNoturnas;
	}
	
	int lerAvaliacao() {
		return temMaisDeCincoEntregasNoturnas() ? 2 : 1;
	}
	
	private boolean temMaisDeCincoEntregasNoturnas() {
		return qtdeEntregasNoturnas > 5;
	}
}
