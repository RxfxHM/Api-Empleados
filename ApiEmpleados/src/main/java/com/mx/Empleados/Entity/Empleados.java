package com.mx.Empleados.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "HU_EMPLS")
@Data
public class Empleados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numCia;
	private Integer numEmp;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLAVE_MONEDA")
	@JsonBackReference
	private Moneda moneda;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String puesto;
	
}
