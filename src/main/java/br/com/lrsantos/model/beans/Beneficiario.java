package br.com.lrsantos.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema="rendimento" , name="beneficiario")
@SequenceGenerator(name="SEQ_ID_BENEFICIARIO", allocationSize=1, initialValue=1, 
	sequenceName="rendimento.seq_id_beneficiario")
public class Beneficiario {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_BENEFICIARIO")
	private Integer id;
	
	@NotNull
	private String matricula;
	
	@NotNull
	private String cpf;
	
	private String nome;
	
	@Column
	private byte[] comprovante;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getComprovante() {
		return comprovante;
	}

	public void setComprovante(byte[] comprovante) {
		this.comprovante = comprovante;
	}
	
	
	
	
}
