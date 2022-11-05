package com.GS.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
@Table(name= "TB_CARRO_GS")
public class Carro {

	@Id
	@NotNull
	@Column (name="placa")
	private String placa;
	
	@NotNull
	@Column (name="nome_pessoa")
	private String nomePessoa;

	@NotNull
	@Column (name="modelo_carro")
	private String modeloCarro;


	@NotNull
	@Column (name="data_estacionamento")
	private String dataEstacionamento;
	
	@ManyToOne
	@JoinColumn(name="ESTACIONAMENTO_CODIGO")
	private Estacionamento estacionamento;



	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public String getDataEstacionamento() {
		return dataEstacionamento;
	}

	public void setDataEstacionamento(String dataEstacionamento) {
		this.dataEstacionamento = dataEstacionamento;
	}
	
	public Estacionamento getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

}
