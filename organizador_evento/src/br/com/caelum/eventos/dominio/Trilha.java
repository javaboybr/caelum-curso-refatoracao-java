package br.com.caelum.eventos.dominio;

import static br.com.caelum.eventos.dominio.Palestra.ALMOCO;
import static br.com.caelum.eventos.dominio.Palestra.NETWORKING;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Trilha {
	
	private final int numero;
	private final List<Palestra> palestrasAgendadas;
	
	public Trilha(SessaoDaManha sessaoDaManha, SessaoDaTarde sessaoDaTarde, int numero){
		this.numero = numero;
		palestrasAgendadas = new ArrayList<>();
		agendarPalestrasDa(sessaoDaManha);
		agendarAlmoco();
		agendarPalestrasDa(sessaoDaTarde);
		agendarNetworking();
	}
	
	private void agendarNetworking() {
		Palestra networking = new Palestra("Networking Event", new TempoDeDuracao(60));
		networking.agendarPara(LocalTime.of(17, 0));
		palestrasAgendadas.add(NETWORKING);
	}

	private void agendarAlmoco(){
		palestrasAgendadas.add(ALMOCO);
	}
	
	private void agendarPalestrasDa(Sessao sessao) {
		LocalTime inicioDaSessao = sessao.comecaAs();
		LocalTime horarioCalculado = null;
		for(Palestra palestra : sessao){
			LocalTime horario = horarioCalculado == null ? inicioDaSessao : horarioCalculado;
			palestra.agendarPara(horario);
			palestrasAgendadas.add(palestra);
			horarioCalculado = horario.plusMinutes(palestra.lerTempoDeDuracao().toInt());
		}
	}

	public String nome(){
		return "Trilha " + numero;
	}

	public List<Palestra> lerPalestrasAgendadasEmOrdem() {
		return palestrasAgendadas;
	}
}
