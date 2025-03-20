package com.mx.Empleados.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.Empleados.Entity.EmpleadoMonedaDTO;
import com.mx.Empleados.Entity.Empleados;

import jakarta.transaction.Transactional;

public interface IEmpleadosDao extends JpaRepository<Empleados, Integer>{
	
	
	/*
	@Query("SELECT E.*, M.* "
	 		+ "FROM HU_EMPLS E "
	 		+ "INNER JOIN HU_CAT_MONEDA M "
	 		+ "ON E.CLAVE_MONEDA = M.CLAVE_MONEDA "
	 		+ "WHERE E.NUM_CIA = :numCia AND E.NUM_EMP = :claveMoneda")
	public Moneda findByDosParametros(@Param("numCia") int numCia, 
			@Param("claveMoneda") String claveMoneda);
	 */
	
	@Query(nativeQuery = true, 
			value = "SELECT * FROM HU_EMPLS WHERE NUM_CIA = (:numCia) AND NUM_EMP = (:numEmp)")
	public Empleados encontrar(int numCia, int numEmp);
	
	//JPQL
	/*@Query("SELECT new com.mx.Empleados.Entity.EmpleadoMonedaDTO("
			+ " e.numCia, e.numEmp, e.nombre, e.apellidoPaterno, e.apellidoMaterno, e.apellidoMaterno, e.puesto,"
			+ " m.numCia, m.claveMoneda, m.descripcion, m.simbolo, m.status) "
			+ "FROM Empleados e JOIN e.Moneda m "
			+ "WHERE e.numCia = :numCiaEmp AND e.numEmp = :numEmple")
	public List<EmpleadoMonedaDTO> findByDosParametrosEmpleados(@Param("numCia") int numCiaEmp, @Param("numEmp") int numEmple);
		*/

	@Transactional
	@Modifying
	@Query(nativeQuery = true,
			value = "DELETE FROM HU_EMPLS WHERE NUM_EMP = (:numEmp)")
	public void eliminarNumEmp(@Param("numEmp") int numEmp);
}
