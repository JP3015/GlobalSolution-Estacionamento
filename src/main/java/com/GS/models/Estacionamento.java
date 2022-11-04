package com.GS.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name= "TB_ESTACIONAMENTO_GS")
public class Estacionamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column (name="cd")
	private long codigo;

	@NotNull
	@Column (name="local")
	private String local;

	@OneToMany
	@JoinColumn(name="carros")
	private List<Carro> carros;


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
}
