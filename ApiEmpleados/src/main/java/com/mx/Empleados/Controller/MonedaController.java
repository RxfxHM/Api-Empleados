package com.mx.Empleados.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Empleados.Entity.Moneda;
import com.mx.Empleados.Service.ServiceMonedaImp;

@RestController
@RequestMapping("/moneda")
@CrossOrigin
public class MonedaController {

	@Autowired
	private ServiceMonedaImp service;
	
	@PostMapping("/guardarmoneda")
	public ResponseEntity<?> guardarMoneda(@RequestBody Moneda moneda){
		Moneda guardar = service.alta(moneda);
		if(guardar == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(guardar);
		}
	}
	
	@GetMapping("/consultarmoneda")
	public ResponseEntity<?> consultarMoneda(@RequestParam int numCia, String claveMoneda){
		Moneda consultar = service.consulta(numCia, claveMoneda);
		if(consultar == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(consultar);
		}
	}
	
	
	@DeleteMapping("/eliminarmoneda")
	public ResponseEntity<?> eliminarMoneda(@RequestParam int numCia, String claveMoneda){
		Moneda eliminar = service.eliminacion(numCia, claveMoneda);
		if(eliminar == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(eliminar);
		}
	}
	
	@PutMapping("/actualizarmoneda")
	public ResponseEntity<?> actualizarMoneda(@RequestBody Moneda moneda){
		Moneda actualizar = service.actualizacion(moneda);
		if(actualizar == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(actualizar);
		}
	}
}









