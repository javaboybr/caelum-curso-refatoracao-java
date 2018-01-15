package br.com.caelum.stella.inwords;

public abstract class Digito {

	public final long numero;
	protected final double posicao;
	protected final Digito digitoFilho;

	public Digito(long numero, double posicao, Digito digitoFilho) {
		this.numero = numero;
		this.posicao = posicao;
		this.digitoFilho = digitoFilho;
	}

	public String extenso() {
		return "";
		/*return ResourceManagerHelper
            .Instance
            .ResourceManager
            .GetString(string.Format("Extenso{0:000}", valorSomenteDoDigito()));*/
	}

	protected double valorSomenteDoDigito() {
		return numero * (int)Math.pow(10, posicao - 1);
	}

	protected double ValorDosFilhos() {
		if (digitoFilho == null) {
			return 0;
		}
		else {
			return digitoFilho.valorTotal();
		}
	}

	public double valorTotal() {
		double result = valorSomenteDoDigito();
		if (digitoFilho != null)
			result += digitoFilho.valorTotal();
		return result;
	}

	protected String extenso(double numero) {
		return "";
		/*        return ResourceManagerHelper
            .Instance
            .ResourceManager
            .GetString(string.Format("Extenso{0:000}", numero));*/
	}

	public boolean getPlural() {
		boolean numeroMaiorQueUm = numero > 1;
		return numeroMaiorQueUm;
	}
}
