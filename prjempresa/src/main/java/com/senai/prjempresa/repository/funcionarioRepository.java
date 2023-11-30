package com.senai.prjempresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.senai.prjempresa.entities.funcionarioentities;

public interface funcionarioRepository extends JpaRepository<funcionarioentities, Long> {

	@Query("SELECT f FROM Funcionario f WHERE LOWER(f.funnome) LIKE LOWER(CONCAT('%', :funnome, '%'))")
	List<funcionarioentities> findByNomeContaining(@Param("funnome") String funnome);
}
