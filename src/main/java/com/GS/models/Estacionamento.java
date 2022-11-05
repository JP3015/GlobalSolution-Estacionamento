package com.GS.models;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name= "TB_ESTACIONAMENTO_GS")
@SequenceGenerator(name="estacionamento", sequenceName = "TB_ESTACIONAMENTO", allocationSize = 1)
public class Estacionamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "estacionamento", strategy=GenerationType.IDENTITY)
	@Column (name="cd")
	private long codigo;

	@NotNull
	@Column (name="local")
	private String local;


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

	
}
