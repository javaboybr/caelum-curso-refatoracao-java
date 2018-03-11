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
		LocalTime horarioCalculado = sessaoDaManha.comecaAs();
		for(Palestra palestra : sessaoDaManha){
			palestra.agendarPara(horarioCalculado);
			atividadesAgendadas.add(palestra);
			horarioCalculado = horarioCalculado.plusMinutes(palestra.lerTempoDeDuracao().toInt());
		}
		agendarAlmoco();
		horarioCalculado = sessaoDaTarde.comecaAs();
		for(Palestra palestra : sessaoDaTarde){
			palestra.agendarPara(horarioCalculado);
			atividadesAgendadas.add(palestra);
			horarioCalculado = horarioCalculado.plusMinutes(palestra.lerTempoDeDuracao().toInt());
		}
		agendarNetworking();
	}
	
	private void agendarNetworking() {
		atividadesAgendadas.add(NETWORKING);
	}

	private void agendarAlmoco(){
		atividadesAgendadas.add(ALMOCO);
	}
	
	public String nome(){
		return "Trilha " + nome;
	}

	public List<Atividade> lerAtividadesAgendadasEmOrdem() {
		return atividadesAgendadas;
	}
}
