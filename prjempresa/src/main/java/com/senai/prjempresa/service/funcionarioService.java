package com.senai.prjempresa.service;

	import java.util.List;
	import java.util.Optional;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import com.senai.prjempresa.entities.*;
	import com.senai.prjempresa.repository.*;

	@Service
	public class funcionarioService {
	    
	@Autowired
	private funcionarioRepository funcionarioRepository;

	public List<funcionarioentities> getAllfuncionarioentities() {
		return funcionarioRepository.findAll();
	}

	public funcionarioentities getfuncionarioentitiesById(long funcodigo) {
		return funcionarioRepository.findById(funcodigo).orElse(null);
	}

	public funcionarioentities savefuncionarioentities(funcionarioentities funcionarioentities) {
		return funcionarioRepository.save(funcionarioentities);
	}

	public List<funcionarioentities> getfuncionarioentitiesByFunnomeAproximado(String funnome) {
        return funcionarioRepository.findByNomeContaining(funnome);
    }

	public boolean deletefuncionarioentities(Long id) {
		Optional<funcionarioentities> funcionarioExistente = funcionarioRepository.findById(id);
		if (funcionarioExistente.isPresent()) {
			funcionarioRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public funcionarioentities updatefuncionarioentities(Long funcodigo, funcionarioentities novoFuncionario) {
		Optional<funcionarioentities> funcionarioOptional = funcionarioRepository.findById(funcodigo);
		if (funcionarioOptional.isPresent()) {
			funcionarioentities funcionarioExistente = funcionarioOptional.get();
			funcionarioExistente.setfunnome(novoFuncionario.getfunnome());
			funcionarioExistente.setfunnascimento(novoFuncionario.getnascimento());
			funcionarioExistente.setfunsalario(novoFuncionario.getsalario());

			if (novoFuncionario.getDepartamento() != null) {
				funcionarioExistente.setDepartamento(novoFuncionario.getDepartamento());
			}		
			return funcionarioRepository.save(funcionarioExistente);
		} else {
			return null; // Ou lançar uma exceção indicando que o funcionário não foi encontrado
		}
	}}