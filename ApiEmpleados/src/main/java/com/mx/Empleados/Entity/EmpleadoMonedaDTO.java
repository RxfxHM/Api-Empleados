package com.mx.Empleados.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoMonedaDTO {
	
	private int numCiaEmp;
	private int numEmp;
	private Moneda moneda;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String puesto;
	private int numCiaMoneda;
	private String claveMoneda;
	private String descripcion;
	private String simbolo;
	private String status;

}
