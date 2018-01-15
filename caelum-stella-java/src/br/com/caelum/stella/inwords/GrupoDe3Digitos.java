package br.com.caelum.stella.inwords;

public class GrupoDe3Digitos
{
    private static final String NUMERO_NEGATIVO = "Número não pode ser negativo";
    private final long numero;
    private final double posicao;
    private final Digito digito;
    private final GrupoDe3Digitos grupoFilho;

    //public double Posicao => posicao;

    public GrupoDe3Digitos(long numero, double posicao, GrupoDe3Digitos grupoFilho) {
        if (numero < 0) {
            throw new IllegalArgumentException(NUMERO_NEGATIVO);
        }
        else {
            this.numero = numero;
            this.posicao = posicao;
            this.grupoFilho = grupoFilho;
            double posicaoDigito = 1;
            Digito digito = null;
            do {
                switch ((int)(posicaoDigito - 1) % 3) {
                    case 0:
                        digito = new DigitoUnidade(numero % 10, posicaoDigito, digito);
                        break;
                    case 1:
                        digito = new DigitoDezena(numero % 10, posicaoDigito, digito);
                        break;
                    case 2:
                        digito = new DigitoCentena(numero % 10, posicaoDigito, digito);
                        break;
                }
                posicaoDigito++;
                numero /= 10;
            } while (numero > 0);

            this.digito = digito;
        }
    }

    protected double valorSomenteDoGrupo() {
        return digito.ValorTotal();
    }

    protected double ValorDosFilhos() {
        if (grupoFilho == null) {
            return 0;
        }
        else {
            return grupoFilho.ValorTotal();
        }
    }

    public double ValorTotal() {
        double result = valorSomenteDoGrupo();
        if (grupoFilho != null)
            result += grupoFilho.ValorTotal();
        return result;
    }

    public GrupoDe3Digitos PrimeiroGrupoComValor() {
        GrupoDe3Digitos result = null;

        if (valorSomenteDoGrupo() > 0)
            result = this;
        else if (grupoFilho != null)
            result = grupoFilho.PrimeiroGrupoComValor();
        return result;
    }

    public String extenso() {
        if (grupoFilho == null)
            return digito.Extenso();
        else if (valorSomenteDoGrupo() == 0) {
            return grupoFilho.extenso();
        }
        else {
            double valorGrupo = digito.ValorTotal();
            String singularPlural = valorGrupo < 2 ? "singular" : "plural";
            String nomeGrupo =
                ResourceManagerHelper
                    .Instance
                    .ResourceManager
                    .GetString(String.Format("Extenso1e{0}{1}", (posicao - 1) * 3, singularPlural));

            double valorGrupoFilho = grupoFilho.ValorTotal();

            if (valorGrupoFilho == 0)
            {
                return String.Format("{0} {1}",
                digito.Extenso(),
                nomeGrupo);
            }
            else
            {
                GrupoDe3Digitos proximoGrupoComValor = grupoFilho.PrimeiroGrupoComValor();
                String separador = "";

                if (proximoGrupoComValor.posicao == 1)
                {
                    if (posicao == 2
                        && proximoGrupoComValor.numero >= 100 && proximoGrupoComValor.numero >= 10)
                        separador = "";
                    else
                        separador = " e";
                }
                else
                {
                    separador = ",";
                }

                return String.Format("{0} {1}{2} {3}",
                digito.Extenso(),
                nomeGrupo,
                separador,
                grupoFilho.extenso());
            }
        }
    }
}