package br.com.caelum.stella.inwords;

public class DigitoDezena extends Digito {

	public DigitoDezena(long numero, double posicao, Digito digitoFilho) {
		super(numero, posicao, digitoFilho);
	}

	@Override
	public String extenso()
	{
		if (entreZeroeNove()) {
			return digitoFilho.extenso();
		}
		else if (entreDezEDezenove()) {
			return extenso(valorSomenteDoDigito() + digitoFilho.numero);
		}
		else {
			if (multiploDeDez())
				return extenso(valorSomenteDoDigito());
			else
				return String.format("%s e %s", extenso(), digitoFilho.extenso());
		}
	}
	
	private boolean entreZeroeNove() {
		return this.numero == 0;
	}
	
	private boolean entreDezEDezenove() {
		return this.numero == 1;
	}
	
	private boolean multiploDeDez() {
		return this.digitoFilho.numero == 0;
	}
}

