package br.com.caelum.eventos.dominio;


import static br.com.caelum.eventos.dominio.Atividade.ALMOCO;
import static br.com.caelum.eventos.dominio.Atividade.NETWORKING;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Trilha {
	
	private final String nome;
	private final List<Atividade> atividadesAgendadas;
	
	public Trilha(String nome, SessaoDaManha sessaoDaManha, SessaoDaTarde sessaoDaTarde){
		this.nome = nome;
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
		LocalTime horarioCalculado = sessao.comecaAs();
		for(Palestra palestra : sessao){
			palestra.agendarPara(horarioCalculado);
			atividadesAgendadas.add(palestra);
			horarioCalculado = horarioCalculado.plusMinutes(palestra.lerTempoDeDuracao().toInt());
		}
	}

	public String nome(){
		return "Trilha " + nome;
	}

	public List<Atividade> lerAtividadesAgendadasEmOrdem() {
		return atividadesAgendadas;
	}
}
