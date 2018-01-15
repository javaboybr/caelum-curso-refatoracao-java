package br.com.caelum.stella.inwords;

public abstract class Moeda extends Numero
{
    protected abstract string MoedaSingular { get; }
    protected abstract string MoedaPlural { get; }
    string CentavoSingular { get => ResourceManagerHelper.Instance.ResourceManager.GetString("MoedaCentavo"); }
    string CentavoPlural { get => ResourceManagerHelper.Instance.ResourceManager.GetString("MoedaCentavos"); }

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
        double centavos = Math.Round((numeroOrigem - Math.Truncate(numeroOrigem)) * 100);
        if (centavos > 0)
        {
            if (numeroOrigem >= 1.0)
                builder.Append(ResourceManagerHelper.Instance.ResourceManager.GetString("Extensosep"));

            BuildNumeroCentavos(centavos, builder);
            builder.Append(" ");
            BuildPalavraCentavos(centavos, builder);
        }
    }

    private void MontarInteiros(StringBuilder builder)
    {
        if (numeroOrigem < 0)
        {
            throw new ArgumentOutOfRangeException();
        }
        else if (numeroOrigem >= 1.0 || numeroOrigem == 0)
        {
            BuildNumeroMoeda(numeroOrigem, builder);
            BuildPreposicaoMilhoes(numeroOrigem, builder);
            BuildPalavraMoeda(numeroOrigem, builder);
        }
    }

    protected virtual void BuildPreposicaoMilhoes(double numeroOrigem, StringBuilder builder)
    {
        if (numeroOrigem >= 1000000
            && Math.Truncate(numeroOrigem) % 1000000 == 0)
            builder.Append(" de ");
        else
            builder.Append(" ");
    }

    private void BuildNumeroMoeda(double numeroOrigem, StringBuilder builder)
    {
        builder.Append(new Numero(Math.Truncate(numeroOrigem)).Extenso());
    }

    private void BuildPalavraMoeda(double numeroOrigem, StringBuilder builder)
    {
        if (Math.Truncate(numeroOrigem) > 1)
            builder.Append(MoedaPlural);
        else
            builder.Append(MoedaSingular);
    }


    private void BuildNumeroCentavos(double centavos, StringBuilder builder)
    {
        builder.Append(new Numero(centavos).Extenso());
    }

    private void BuildPalavraCentavos(double centavos, StringBuilder builder)
    {
        if (Math.Truncate(centavos) > 1)
            builder.Append(CentavoPlural);
        else
            builder.Append(CentavoSingular);
    }
}
