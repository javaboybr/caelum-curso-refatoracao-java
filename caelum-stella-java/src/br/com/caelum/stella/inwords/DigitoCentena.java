package br.com.caelum.stella.inwords;

public class DigitoCentena extends Digito {

    public DigitoCentena(long numero, double posicao, Digito digitoFilho) { 
    		super(numero, posicao, digitoFilho);
    }

    @Override
    public String extenso() {
        if (multiplodeCem())
            return extenso(valorSomenteDoDigito());
        else
        {
            String esteDigitoExtenso = "";
            if (numero == 1)
                esteDigitoExtenso = "";//ResourceManagerHelper.Instance.ResourceManager.GetString("Extenso100mais");
            else
                esteDigitoExtenso = super.extenso();

            return String.format("%s e %s", esteDigitoExtenso, digitoFilho.extenso());
        }
    }
    
    private boolean multiplodeCem() {
    		return ValorDosFilhos() == 0;
    }
}
