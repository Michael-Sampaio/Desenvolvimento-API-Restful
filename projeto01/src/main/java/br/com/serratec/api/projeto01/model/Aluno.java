package br.com.serratec.api.projeto01.model;

public class Aluno {
	private Long matricula;
	private String nome;
	private String telefone;
	private String email;
	
	public Aluno(Long matricula, String nome, String telefone, String email) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public Long getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}
}
