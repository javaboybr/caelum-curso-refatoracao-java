package aula07.r14.hidedelegate.antes;

public class Escola {
	
	private String nome;
	private Funcionario diretor;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Funcionario getDiretor() {
		return diretor;
	}
	public void setDiretor(Funcionario diretor) {
		this.diretor = diretor;
	}
}

class Departamento {
	
	private Escola escola;

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	
}

class Funcionario {
	
	private Departamento departamento;

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}

class Teste {
	
	public Teste() {
		Funcionario maria = new Funcionario();
		Funcionario diretorDaMaria = maria.getDepartamento().getEscola().getDiretor();
	}
}