package br.com.caelum.stella.inwords;

public class DigitoCentena extends Digito
{
    private boolean MultiploDe100 => ValorDosFilhos() == 0;

    public DigitoCentena(long numero, double posicao, Digito digitoFilho) : base(numero, posicao, digitoFilho) { }

    @Override
    public String Extenso() {
        if (MultiploDe100)
            return base.Extenso(ValorSomenteDoDigito());
        else
        {
            String esteDigitoExtenso = "";
            if (Numero == 1)
                esteDigitoExtenso = ResourceManagerHelper.Instance.ResourceManager.GetString("Extenso100mais");
            else
                esteDigitoExtenso = base.Extenso();

            return
                String.Format("{0} e {1}"
                , esteDigitoExtenso
                , digitoFilho.Extenso());
        }
    }
}
