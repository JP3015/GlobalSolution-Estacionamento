package com.GS.models;


import javax.persistence.*;

import net.bytebuddy.utility.nullability.NeverNull;




@Entity
@Table(name= "TB_CARRO_GS")
@SequenceGenerator(name="carro", sequenceName = "TB_CARRO", allocationSize = 1)
public class Carro {

	@Id
	@GeneratedValue(generator = "carro", strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;

	@NeverNull
	@Column (name="placa")
	private String placa;
	
	@NeverNull
	@Column (name="nome_pessoa")
	private String nomePessoa;

	@NeverNull
	@Column (name="modelo_carro")
	private String modeloCarro;


	@NeverNull
	@Column (name="data_estacionamento")
	private String dataEstacionamento;
	
	@Column(name="ESTACIONAMENTO_CODIGO")
	private Long estacionamento;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	public Long getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(Long estacionamento) {
		this.estacionamento = estacionamento;
	}

}
