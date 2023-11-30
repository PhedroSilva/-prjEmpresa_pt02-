package com.senai.prjempresa.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.RequestEntity;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.senai.prjempresa.entities.*;
	import com.senai.prjempresa.service.departamentoService;

	@RestController
	@RequestMapping("/departamento")
	public class departamentocontroller {
	    
	    private final departamentoService departamentoService;

	    @Autowired
	    public departamentocontroller(departamentoService departamentoService) {
	        this.departamentoService = departamentoService;
	    }

	    @GetMapping("/home")
	    public String paginaInicial() {
	        return "index"; 
	    }

	    @GetMapping("/(id)")
	    public ResponseEntity<departamentoentities> getepartamento(@PathVariable Long depcodigo) {
	    	departamentoentities departamentoentities = departamentoService.getdepartamentoById(depcodigo);
	        if (departamentoentities != null) {
	            return ResponseEntity.ok(departamentoentities);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping
	    public departamentoentities createDepartamento(@RequestBody departamentoentities departamentoentities) {
	        return departamentoService.saveDepartamentos(departamentoentities);

	    }
	    public List<departamentoentities> getAllDepartamento() {
	        return departamentoService.getAllDepartamentos();
	    }

	    @DeleteMapping("/{id}")
	    public void deleteDepartamento(@PathVariable Long depnome) {
	    	departamentoService.deleteDepartamento(depnome);
	    }

	        @GetMapping
	        public ResponseEntity<List<departamentoentities>> getAllDepartamento(RequestEntity<Void> requestEntity) {
	            String method = requestEntity.getMethod().name();
	            String contentType = requestEntity.getHeaders().getContentType().toString();
	            List<departamentoentities> departamento = departamentoService.getAllDepartamentos();
	            return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
	                    .body(departamento);
	        }
	        
	        @PutMapping("/{id}")
	        public departamentoentities updateDepartamento(@PathVariable Long depcodigo, @RequestBody departamentoentities departamento) {
	            return departamentoService.updateDepartamento(depcodigo, departamento);
	        }
	}
	
	
