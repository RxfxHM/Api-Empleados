package com.mx.Empleados.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Empleados.Entity.Empleados;
import com.mx.Empleados.Repository.IEmpleadosDao;

@Service
public class ServiceEmpleadosImp implements IServiceEmpleados{

	
	//Inyeccion de dependencias
	@Autowired
	private IEmpleadosDao dao;
	
	@Override
	public Empleados alta(Empleados empleado) {
		// TODO Auto-generated method stub
		return dao.save(empleado);
	}

	@Override
	public Empleados consulta(int numCia, int numEmp) {
		// TODO Auto-generated method stub
		return dao.findByDosParametros(numCia, numEmp);
	}

	@Override
	public Empleados eliminacion(int numCia, int numEmp) {
		// TODO Auto-generated method stub
		Empleados empleado = dao.findByDosParametros(numCia, numEmp);
		if(empleado != null) {
			dao.eliminarNumEmp(empleado.getNumEmp());
		}
		return empleado;
	}

	@Override
	public Empleados actualizacion(Empleados empleado) {
		// TODO Auto-generated method stub
		return dao.save(empleado);
	}

}
