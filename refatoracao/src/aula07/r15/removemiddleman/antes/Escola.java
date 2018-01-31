package aula07.r15.removemiddleman.antes;

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

class Empregado {
	
	private final Funcionario funcionario;
	
	public Empregado(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public Funcionario getDiretor() {
		return this.funcionario.getDiretor();
	}
	
	public double getSalario() {
		return funcionario.getSalario();
	}
}

class Teste {
	public Teste() {
		Empregado maria = new Empregado(new Funcionario());
		Funcionario diretorDaMaria = maria.getDiretor();
	}
}