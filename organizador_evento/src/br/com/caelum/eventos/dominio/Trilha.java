package br.com.caelum.eventos.dominio;


import static br.com.caelum.eventos.dominio.Atividade.ALMOCO;
import static br.com.caelum.eventos.dominio.Atividade.NETWORKING;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Trilha {
	
	private final int numero;
	private final List<Atividade> atividadesAgendadas;
	
	public Trilha(SessaoDaManha sessaoDaManha, SessaoDaTarde sessaoDaTarde, int numero){
		this.numero = numero;
		atividadesAgendadas = new ArrayList<>();
		agendarPalestrasDa(sessaoDaManha);
		agendarAlmoco();
		agendarPalestrasDa(sessaoDaTarde);
		agendarNetworking();
	}
	
	private void agendarNetworking() {
		atividadesAgendadas.add(NETWORKING);
	}

	private void agendarAlmoco(){
		atividadesAgendadas.add(ALMOCO);
	}
	
	private void agendarPalestrasDa(Sessao sessao) {
		LocalTime inicioDaSessao = sessao.comecaAs();
		LocalTime horarioCalculado = null;
		for(Palestra palestra : sessao){
			LocalTime horario = horarioCalculado == null ? inicioDaSessao : horarioCalculado;
			palestra.agendarPara(horario);
			atividadesAgendadas.add(palestra);
			horarioCalculado = horario.plusMinutes(palestra.lerTempoDeDuracao().toInt());
		}
	}

	public String nome(){
		return "Trilha " + numero;
	}

	public List<Atividade> lerAtividadesAgendadasEmOrdem() {
		return atividadesAgendadas;
	}
}
