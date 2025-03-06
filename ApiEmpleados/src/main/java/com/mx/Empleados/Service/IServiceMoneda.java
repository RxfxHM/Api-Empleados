package com.mx.Empleados.Service;

import com.mx.Empleados.Entity.Moneda;

public interface IServiceMoneda {
	
	public Moneda alta(Moneda moneda);
	
	public Moneda consulta(int numCia, String claveMoneda);
	
	public Moneda eliminacion(int numCia, String claveMoneda);
	
	public Moneda actualizacion(Moneda Moneda);

}
