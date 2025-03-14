package com.mx.Empleados.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.Empleados.Entity.Empleados;

import jakarta.transaction.Transactional;

public interface IEmpleadosDao extends JpaRepository<Empleados, Integer>{
	
	//Metodo para buscar con los dos parametros
	@Query(nativeQuery = true, 
			value = "SELECT * FROM HU_EMPLS WHERE NUM_CIA = (:numCia) AND NUM_EMP = (:numEmp)")
	public Empleados findByDosParametros(int numCia, int numEmp);

	@Transactional
	@Modifying
	@Query(nativeQuery = true,
			value = "DELETE FROM HU_EMPLS WHERE NUM_EMP = (:numEmp)")
	public void eliminarNumEmp(@Param("numEmp") int numEmp);
}
