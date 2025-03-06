package com.mx.Empleados.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "HU_CAT_MONEDA")
public class Moneda {

	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numCia;
	@Id
	@Column(name = "CLAVE_MONEDA")
	private String claveMoneda;
	private String descripcion;
	private String simbolo;
	private String status;

	@OneToMany(mappedBy = "moneda", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Empleados> empleados = new ArrayList<>();

	public Moneda() {

	}

	public Moneda(int numCia, String claveMoneda, String descripcion, String simbolo, String status,
			List<Empleados> empleados) {
		this.numCia = numCia;
		this.claveMoneda = claveMoneda;
		this.descripcion = descripcion;
		this.simbolo = simbolo;
		this.status = status;
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Moneda [numCia=" + numCia + ", claveMoneda=" + claveMoneda + ", descripcion=" + descripcion
				+ ", simbolo=" + simbolo + ", status=" + status + ", empleados=" + empleados + "]";
	}

	public int getNumCia() {
		return numCia;
	}

	public void setNumCia(int numCia) {
		this.numCia = numCia;
	}

	public String getClaveMoneda() {
		return claveMoneda;
	}

	public void setClaveMoneda(String claveMoneda) {
		this.claveMoneda = claveMoneda;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
