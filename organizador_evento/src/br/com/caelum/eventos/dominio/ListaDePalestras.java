package br.com.caelum.eventos.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListaDePalestras {
	
	private final List<Palestra> palestras;
	
	public ListaDePalestras(Set<Palestra> palestras){
		this.palestras = new ArrayList<>(palestras);
	}
	
	public Palestra obterProxima(){
		Palestra ret = null;
		Iterator<Palestra> cursorPalestras = palestras.iterator();
		while(cursorPalestras.hasNext()){
			ret = cursorPalestras.next();
		}
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
	
	public void devolver(List<Palestra> devolvidas){
		for(Palestra devolvida : devolvidas){
			devolverSePossivel(devolvida);
		}
	}

	public void embaralhar() {
		Collections.shuffle(palestras);
	}
}
