package com.mx.Empleados.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.Empleados.Entity.Moneda;

import jakarta.transaction.Transactional;

public interface IMonedaDao extends JpaRepository<Moneda, String>{
	
	@Query("SELECT m FROM Moneda m JOIN FETCH m.empleados e "
			+ "WHERE m.numCia = :numCia AND m.claveMoneda = :claveMoneda")
	public Moneda findByDosParametros(@Param("numCia") int numCia, 
			@Param("claveMoneda") String claveMoneda);
	
	/*@Query(nativeQuery = true, 
			value = "SELECT M.NUM_CIA, M.CLAVE_MONEDA, M.DESCRIPCION, M.SIMBOLO, M.STATUS, "
					+ "E.NUM_EMP, E.NOMBRE, E.APELLIDO_MATERNO, E.PUESTO "
					+ "FROM HU_CAT_MONEDA M "
					+ "INNER JOIN HU_EMPLS E "
					+ "ON M.CLAVE_MONEDA = E.CLAVE_MONEDA "
					+ "WHERE M.NUM_CIA = :numCia AND M.CLAVE_MONEDA = :claveMoneda")
	public Moneda findByDosParametros(@Param("numCia") int numCia,@Param("claveMoneda") String claveMoneda);
*/
	@Transactional
	@Modifying
	@Query(nativeQuery = true,
			value = "DELETE FROM HU_CAT_MONEDA WHERE CLAVE_MONEDA = (:claveMoneda)")
	public void eliminarClaveMoneda(@Param("claveMoneda") String claveMoneda);
}
