package br.com.caelum.stella.inwords;

public abstract class Moeda extends Numero
{
	protected Moeda(double numeroOrigem) {
		super(numeroOrigem);
	}

	@Override
	protected double preparaNumeroOrigem(double numeroOrigem) {
		return numeroOrigem;
	}

	@Override
	public String extenso() {
		StringBuilder builder = new StringBuilder();
		MontarInteiros(builder);
		MontarCentavos(builder);
		return builder.toString();
	}

	private void MontarCentavos(StringBuilder builder) {
		double centavos = Math.round((numeroOrigem - truncarNumeroOrigem()) * 100);
		if (centavos > 0)
		{
			if (numeroOrigem >= 1.0)
				builder.append(""/*ResourceManagerHelper.Instance.ResourceManager.GetString("Extensosep")*/);

			BuildNumeroCentavos(centavos, builder);
			builder.append(" ");
			BuildPalavraCentavos(centavos, builder);
		}
	}

	private int truncarNumeroOrigem() {
		return (int)numeroOrigem;
	}

	private void MontarInteiros(StringBuilder builder) {
		if (numeroOrigem < 0) {
			throw new IllegalArgumentException();
		}
		else if (numeroOrigem >= 1.0 || numeroOrigem == 0) {
			BuildNumeroMoeda(numeroOrigem, builder);
			BuildPreposicaoMilhoes(numeroOrigem, builder);
			BuildPalavraMoeda(numeroOrigem, builder);
		}
	}

	protected void BuildPreposicaoMilhoes(double numeroOrigem, StringBuilder builder)
	{
		if (numeroOrigem >= 1000000
				&& truncarNumeroOrigem() % 1000000 == 0)
			builder.append(" de ");
		else
			builder.append(" ");
	}

	private void BuildNumeroMoeda(double numeroOrigem, StringBuilder builder)
	{
		builder.append(new Numero(truncarNumeroOrigem()).extenso());
	}

	private void BuildPalavraMoeda(double numeroOrigem, StringBuilder builder)
	{
		if (truncarNumeroOrigem() > 1)
			builder.append(moedaNoPlural());
		else
			builder.append(moedaNoSingular());
	}


	private void BuildNumeroCentavos(double centavos, StringBuilder builder)
	{
		builder.append(new Numero(centavos).extenso());
	}

	private void BuildPalavraCentavos(double centavos, StringBuilder builder) {
		if (((int)centavos) > 1)
			builder.append(centavoPlural());
		else
			builder.append(centavosNoSingular());
	}

	private String centavosNoSingular() {
		return "";//ResourceManagerHelper.Instance.ResourceManager.GetString("MoedaCentavo");
	}

	private String centavoPlural() {
		return ""; //ResourceManagerHelper.Instance.ResourceManager.GetString("MoedaCentavos");
	}

	protected abstract String moedaNoPlural();

	protected abstract String moedaNoSingular();
}
