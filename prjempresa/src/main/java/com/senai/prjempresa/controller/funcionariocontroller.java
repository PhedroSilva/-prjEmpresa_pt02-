package com.senai.prjempresa.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.senai.prjempresa.entities.funcionarioentities;
	import com.senai.prjempresa.service.funcionarioService;

	@RestController
	@RequestMapping("/departamento")
	public class funcionariocontroller {
	    
		private final funcionarioService funcionarioService;
		
		@Autowired
		public funcionariocontroller(funcionarioService funcionarioService) {
			this.funcionarioService = funcionarioService;
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<funcionarioentities> getAllfuncionarioentities(@PathVariable Long id) {
			funcionarioentities funcionarioentities = funcionarioService.getfuncionarioentitiesById(id);
			if (funcionarioentities != null) {
				return ResponseEntity.ok(funcionarioentities);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		@GetMapping("/nome/{funnome}")
		public ResponseEntity<List<funcionarioentities>> findFuncionariosByNomeAproximado(@PathVariable String funnome) {
		    List<funcionarioentities> funcionarioentities = funcionarioService.getfuncionarioentitiesByFunnomeAproximado(funnome);
		    if (!funcionarioentities.isEmpty()) {
		        return ResponseEntity.ok(funcionarioentities);
		    } else {
		        return ResponseEntity.notFound().build();
		    }
		}
		

		@GetMapping("/")
		public ResponseEntity<List<funcionarioentities>> findAllUsuarioscontrol() {
			List<funcionarioentities> funcionarioentities = funcionarioService.getAllfuncionarioentities();
			return ResponseEntity.ok(funcionarioentities);
		}

		@PostMapping("/")
		public ResponseEntity<funcionarioentities> insertUsuariosControl(@RequestBody funcionarioentities funcionarioentities) {
			funcionarioentities novofuncionario = funcionarioService.savefuncionarioentities(funcionarioentities);
			return ResponseEntity.status(HttpStatus.CREATED).body(novofuncionario);
		}

		@PutMapping("/{id}")
	    public ResponseEntity<funcionarioentities> updateFuncionario(@PathVariable Long funcodigo, @RequestBody funcionarioentities funcionario) {
	    	funcionarioentities funcionarioAtualizado = funcionarioService.updatefuncionarioentities(funcodigo, funcionario);
	        if (funcionarioAtualizado != null) {
	            return ResponseEntity.ok(funcionarioAtualizado);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

		@DeleteMapping("/id")
		public ResponseEntity<String> deleteUsuarioControl(@PathVariable Long funcodigo) {
			boolean remover = funcionarioService.deletefuncionarioentities(funcodigo);
			if (remover) {
				return ResponseEntity.ok().body("usuario Excluido com sucesso");
			} else {
				return ResponseEntity.notFound().build();
			}
		}}