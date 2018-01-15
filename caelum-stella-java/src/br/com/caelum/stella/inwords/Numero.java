package br.com.caelum.stella.inwords;

/**
 * Responsável por transformar um número em sua representação por extenso, em português.
 * @author caelum
 *
 */
public class Numero {
	
	protected double numeroOrigem;
	
	public Numero(double numeroOrigem) {
		this.numeroOrigem = preparaNumeroOrigem(numeroOrigem);
	}
	
	protected double preparaNumeroOrigem(double numeroOrigem) {
        numeroOrigem = Math.round(numeroOrigem);
        return numeroOrigem;
    }
	
	public String extenso() {
		GrupoDe3Digitos grupo = getGrupoPrincipal(numeroOrigem);
		return grupo.extenso();
	}
	
    GrupoDe3Digitos getGrupoPrincipal(double numeroOrigem) {
        double numero = numeroOrigem;

        double posicao = 1;
        GrupoDe3Digitos grupo = null;

        do {
            grupo = new GrupoDe3Digitos((long)(numero % (double)1000), posicao, grupo);
            posicao++;
            numero /= 1000;
        }
        while (numero > 0);

        return grupo;
    }
}
