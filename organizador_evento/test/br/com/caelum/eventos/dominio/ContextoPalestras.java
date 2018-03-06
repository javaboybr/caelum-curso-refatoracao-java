package br.com.caelum.eventos.dominio;

import java.util.HashSet;
import java.util.Set;

import br.com.caelum.eventos.dominio.ListaDePalestras;
import br.com.caelum.eventos.dominio.Palestra;
import br.com.caelum.eventos.dominio.TempoDeDuracao;

public class ContextoPalestras {
	
	public static final ListaDePalestras palestras(){
		return new ListaDePalestras(setPalestras());
	}
	
	public static final Set<Palestra> setPalestras(){
		Set<Palestra> ret = new HashSet<Palestra>(){
			private static final long serialVersionUID = 2996699278229107554L;
		{
			add(new Palestra("Escrevendo testes rapidamente em sistemas JavaEE", new TempoDeDuracao(60)));
			add(new Palestra("Hibernate x Eclipse TopLink", new TempoDeDuracao(45)));
			add(new Palestra("Programação funcional em Java", new TempoDeDuracao(30)));
			add(new Palestra("Domain Driven Design sem complicações", new TempoDeDuracao(45)));
			add(new Palestra("Donald Knuth não escreve testes. Você não é Donald Knuth! Por que você deve sempre testar seu código?", new TempoDeDuracao(45)));
			add(new Palestra("Orientação a objetos para programadores experientes", TempoDeDuracao.LIGHTING));
			add(new Palestra("Collections como você nunca viu", new TempoDeDuracao(60)));
			add(new Palestra("Ter razão (escrever muita documentação) ou ser feliz (agradar o cliente)?", new TempoDeDuracao(45)));
			add(new Palestra("Substituindo de vez EJB por Spring", new TempoDeDuracao(30)));
			add(new Palestra("TDD x BDD: quem ganha é o sistema!", new TempoDeDuracao(30)));
			add(new Palestra("Novidades do JUnit", new TempoDeDuracao(45)));
			add(new Palestra("Padrões de criação de microserviços", new TempoDeDuracao(60)));
			add(new Palestra("Por que REST é melhor que SOAP?", new TempoDeDuracao(60)));
			add(new Palestra("Automatização de builds com Jenkins: do local até a produção", new TempoDeDuracao(45)));
			add(new Palestra("Batalha de evangelistas", new TempoDeDuracao(30)));
			add(new Palestra("Java x Javascript no frontend", new TempoDeDuracao(30)));
			add(new Palestra("Programação funcional para desenvolvedores Java", new TempoDeDuracao(60)));
			add(new Palestra("O problema do uso de singletons", new TempoDeDuracao(30)));
			add(new Palestra("Computação distribuida em Java: do RMI até as tecnologias atuais", new TempoDeDuracao(30)));
		}};
		return ret;
	}

	public static int totalDePalestras() {
		return 19;
	}
}
