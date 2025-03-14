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

import com.mx.Empleados.Entity.Empleados;
import com.mx.Empleados.Service.ServiceEmpleadosImp;

@RestController
@RequestMapping("/empleados")
@CrossOrigin
public class EmpleadosController {
	
	@Autowired
	private ServiceEmpleadosImp service;
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@RequestBody Empleados empleado){
		Empleados aux = service.alta(empleado);
		if(aux == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(aux);
		}
	}
	
	@GetMapping("/consultar")
	public ResponseEntity<?> consultar(@RequestParam int numCia, int numEmp){
		Empleados consulta = service.consulta(numCia, numEmp);
		if(consulta == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(consulta);
		}
	}

	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar(@RequestParam int numCia, int numEmp){
		Empleados eliminaremp = service.eliminacion(numCia, numEmp);
		if(eliminaremp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(eliminaremp);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody Empleados empleado){
		Empleados actuEmp = service.actualizacion(empleado);
		if(actuEmp == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(actuEmp);
		}
	}
}













