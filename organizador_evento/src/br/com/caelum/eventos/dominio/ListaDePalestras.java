package br.com.caelum.eventos.dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListaDePalestras implements Iterable<Palestra>{
	
	private final List<Palestra> palestras;
	
	public ListaDePalestras(Collection<Palestra> palestras){
		this.palestras = new ArrayList<>(palestras);
	}
	
	public ListaDePalestras() {
		this(new ArrayList<>());
	}

	public Palestra obterProxima(){
		Palestra ret = palestras.stream().reduce((first, second) -> second).orElse(null);
		palestras.remove(ret);
		return ret;
	}

	public boolean estaVazia() {
		return palestras.isEmpty();
	}

	public void devolver(Palestra devolvida) {
		devolverSePossivel(devolvida);
	}

	private void devolverSePossivel(Palestra devolvida) {
		if(!palestras.contains(devolvida)){
			palestras.add(devolvida);
		}
	}
	
	public void devolver(ListaDePalestras devolvidas){
		for(Palestra devolvida : devolvidas){
			devolverSePossivel(devolvida);
		}
	}

	public void embaralhar() {
		Collections.shuffle(palestras);
	}

	@Override
	public Iterator<Palestra> iterator() {
		return palestras.iterator();
	}

	public boolean adicionar(Palestra novaPalestra) {
		return palestras.add(novaPalestra);
	}

	public ListaDePalestras removerTodas() {
		ListaDePalestras ret = new ListaDePalestras(palestras);
		palestras.clear();
		return ret;
	}
}
