package com.inforcol.clase.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inforcol.clase.entidades.Usuario;
import com.inforcol.clase.servicios.UsuarioServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Usuario", description = "Metodos de usuario")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioServices services;
	
	
	
	@GetMapping("/saludar/{nombre}")
	public String saludar(@PathVariable String nombre) {
		return "Hola mundo " + nombre;
	}

	@Operation(
      summary = "Inserta un usuario",
      description = "Metodo POST que inserta un usuario en base de datos.")
	@ApiResponses({
      @ApiResponse(responseCode = "200", description = "El usuario se insertó correctamente"),
      @ApiResponse(responseCode = "404", description = "No se encontró el metodo"),
      @ApiResponse(responseCode = "500", description = "Otro mensaje")})
	@PostMapping("/insertar")
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
		Usuario nuevoUsuario = services.guardar(usuario);
		return ResponseEntity.ok(nuevoUsuario);
	}
	
	@Operation(
      summary = "Retorna todos los usuarios",
      description = "Metodo GET que retorna todos los usuarios almacenados en la base de datos.")
	@ApiResponses({
      @ApiResponse(responseCode = "200", description = "Funcionó correctamente"),
      @ApiResponse(responseCode = "404", description = "No se encontró el metodo"),
      @ApiResponse(responseCode = "500", description = "Otro mensaje")})
	@GetMapping("/getall")
	public ResponseEntity<List<Usuario>> getAll(){
		List<Usuario> list = services.getAll();
		return ResponseEntity.ok(list);
	}
	
	@Operation(
      summary = "Retorna un usuario por ID",
      description = "Metodo GET que retorna un usuario por ID almacenado en la base de datos.")
	@ApiResponses({
      @ApiResponse(responseCode = "200", description = "Funcionó correctamente"),
      @ApiResponse(responseCode = "404", description = "No se encontró el metodo"),
      @ApiResponse(responseCode = "500", description = "Otro mensaje")})
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUser(@PathVariable int id){
		Usuario nuevoUsuario = services.buscarUsuario(id);
		return ResponseEntity.ok(nuevoUsuario);
	}
}
