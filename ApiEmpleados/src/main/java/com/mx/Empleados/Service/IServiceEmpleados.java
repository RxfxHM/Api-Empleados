package com.mx.Empleados.Service;

import com.mx.Empleados.Entity.Empleados;

public interface IServiceEmpleados {

	public Empleados alta(Empleados empleado);
	
	public Empleados consulta(int numCia, int numEmp);
	
	public Empleados eliminacion(int numCia,int numEmp);
	
	public Empleados actualizacion(Empleados empleado); 
}
