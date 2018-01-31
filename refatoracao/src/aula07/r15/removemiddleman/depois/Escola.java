package aula07.r15.removemiddleman.depois;

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
	private double salario;
	
	public Funcionario getDiretor() {
		return departamento.getEscola().getDiretor();
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}

class Teste {
	public Teste() {
		Funcionario maria = new Funcionario();
		Funcionario diretorDaMaria = maria.getDiretor();
	}
}