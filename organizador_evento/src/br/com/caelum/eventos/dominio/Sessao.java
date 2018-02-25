package br.com.caelum.eventos.dominio;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class Sessao implements Iterable<Palestra>{
	
	private final Set<Palestra> palestras;
	private TempoDeDuracao tempoDeDuracaoDasPalestras;
	
	protected Sessao(){
		this.palestras = new HashSet<>();
		this.tempoDeDuracaoDasPalestras = new TempoDeDuracao(0);
	}
	
	public boolean adicionar(Palestra novaPalestra) {
		boolean ret = false;
		if(podeAdicionar(novaPalestra)){
			ret = palestras.add(novaPalestra);
			tempoDeDuracaoDasPalestras = tempoDeDuracaoDasPalestras.mais(novaPalestra.lerTempoDeDuracao());
		}
		return ret;
	}
	
	public List<Palestra> cancelar() {
		List<Palestra> ret = new ArrayList<>();
		ret.addAll(palestras);
		palestras.clear();
		tempoDeDuracaoDasPalestras = new TempoDeDuracao(0);
		return ret;
	}
	
	private boolean podeAdicionar(Palestra novaPalestra){
		TempoDeDuracao tempoAcumulado = tempoTotalDasPalestras().mais(novaPalestra.lerTempoDeDuracao());
		boolean tempoFuturoOk = tempoAcumulado.menorQue(lerTempoDeDuracao())|| tempoAcumulado.equals(lerTempoDeDuracao());
		boolean palestraMenorQueUmaSessao = novaPalestra.comDuracaoMenorQue(lerTempoDeDuracao());
		return tempoFuturoOk && palestraMenorQueUmaSessao;
	}
	
	protected TempoDeDuracao tempoTotalDasPalestras() {
		return tempoDeDuracaoDasPalestras;
	}
	
	@Override
	public Iterator<Palestra> iterator(){
		return palestras.iterator();
		
	}

	public abstract TempoDeDuracao lerTempoDeDuracao();
	public abstract boolean estaDevidamentePreenchida();
	public abstract LocalTime comecaAs();
	public abstract LocalTime terminaAs();
	
}
