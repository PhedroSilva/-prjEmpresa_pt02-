package com.senai.prjempresa.service;

	import java.util.List;
	import java.util.Optional;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import com.senai.prjempresa.entities.departamentoentities;
	import com.senai.prjempresa.repository.departamentoRepository;

	@Service
	public class departamentoService {
	private final departamentoRepository departamentoRepository;
	    
	    @Autowired
	    public departamentoService( departamentoRepository departamentoRepository) {
	        this.departamentoRepository = departamentoRepository;
	    }
	    
	    public departamentoentities saveDepartamentos(departamentoentities departamentoentities) {
	        return departamentoRepository.save(departamentoentities);
	    }
	    
	    public departamentoentities getdepartamentoById(Long depcodigo) {
	        return departamentoRepository.findById(depcodigo).orElse(null);
	    }
	    
	    public List<departamentoentities> getAllDepartamentos(){
	        return departamentoRepository.findAll();
	    }
	    
	    public void deleteDepartamento (Long depcodigo) {
	        departamentoRepository.deleteById(depcodigo);
	    }
	        
	        public departamentoentities updateDepartamento(Long depcodigo, departamentoentities novodepartamento) {
	            Optional<departamentoentities> departamentoOptional = departamentoRepository.findById(depcodigo);
	            if (departamentoOptional.isPresent()) {
	            	departamentoentities departamentoExistente = departamentoOptional.get();
	                    departamentoExistente.setdepnome(novodepartamento.getdepnome());
	                    return departamentoRepository.save(departamentoExistente);
	            }else{
	                return null;
	            }
	    }

	}

