package br.com.lrsantos.model.resource;

import javax.validation.constraints.NotNull;

public class ConsultaVO {
	
	@NotNull
	private String cpf;
	
	@NotNull
	private String matricula;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	@Override
	public String toString() {
		return "ConsultaVO [cpf=" + cpf + ", matricula=" + matricula + "]";
	}
	
}
