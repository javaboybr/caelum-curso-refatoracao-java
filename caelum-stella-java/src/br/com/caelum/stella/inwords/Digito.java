package br.com.caelum.stella.inwords;

public abstract class Digito {
    
	public final long Numero;
    protected final double posicao;
    protected final Digito digitoFilho;

    public Digito(long numero, double posicao, Digito digitoFilho)
    {
        this.Numero = numero;
        this.posicao = posicao;
        this.digitoFilho = digitoFilho;
    }

    public String Extenso()
    {
        return ResourceManagerHelper
            .Instance
            .ResourceManager
            .GetString(string.Format("Extenso{0:000}", ValorSomenteDoDigito()));
    }

    protected double ValorSomenteDoDigito() {
        return Numero * (int)Math.pow(10, posicao - 1);
    }

    protected double ValorDosFilhos() {
        if (digitoFilho == null)
        {
            return 0;
        }
        else
        {
            return digitoFilho.ValorTotal();
        }
    }

    public double ValorTotal() {
        double result = ValorSomenteDoDigito();
        if (digitoFilho != null)
            result += digitoFilho.ValorTotal();
        return result;
    }

    protected String Extenso(double numero)
    {
        return ResourceManagerHelper
            .Instance
            .ResourceManager
            .GetString(string.Format("Extenso{0:000}", numero));
    }
    
    public boolean getPlural() {
    		boolean numeroMaiorQueUm = Numero > 1;
    		return numeroMaiorQueUm;
    }
}
