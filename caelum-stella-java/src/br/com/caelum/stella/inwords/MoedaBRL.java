package br.com.caelum.stella.inwords;

public class MoedaBRL extends Moeda {

	public MoedaBRL(double numero) {
		super(numero);
	}

	@Override
	protected String moedaNoPlural() {
		return ""; //ResourceManagerHelper.Instance.ResourceManager.GetString("MoedaBRLPlural");
	}

	@Override
	protected String moedaNoSingular() {
		return ""; //ResourceManagerHelper.Instance.ResourceManager.GetString("MoedaBRLSingular");
	}
}
