package com.mx.Empleados.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Empleados.Entity.Moneda;
import com.mx.Empleados.Repository.IMonedaDao;

@Service
public class ServiceMonedaImp implements IServiceMoneda{

	@Autowired
	private IMonedaDao dao;
	
	@Override
	public Moneda alta(Moneda moneda) {
		// TODO Auto-generated method stub
		return dao.save(moneda);
	}

	@Override
	public Moneda consulta(int numCia, String claveMoneda) {
		// TODO Auto-generated method stub
		return dao.findByDosParametros(numCia, claveMoneda);
	}

	
	@Override
	public Moneda eliminacion(int numCia, String claveMoneda) {
		// TODO Auto-generated method stub
		Moneda moneda = dao.findByDosParametros(numCia, claveMoneda);
		if(moneda != null) {
			dao.eliminarClaveMoneda(moneda.getClaveMoneda());
		}
		return moneda;
	}

	@Override
	public Moneda actualizacion(Moneda moneda) {
		// TODO Auto-generated method stub
		return dao.save(moneda);
	}

}
