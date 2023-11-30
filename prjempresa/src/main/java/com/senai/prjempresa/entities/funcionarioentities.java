package com.senai.prjempresa.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_funcionario")
public class funcionarioentities {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcodigo;
    
    private String funnome;
    
    private LocalDate funnascimento;
    
    private double funsalario;
    
    @ManyToOne
	private departamentoentities departamentoentities;

//inserir os metodos get e o set
public departamentoentities getDepartamento() {
		return departamentoentities;
	}

	public void setDepartamento(departamentoentities departamentoentities) {
		this.departamentoentities = departamentoentities;
	}
    public funcionarioentities(Long funcodigo, String funnome ) {
        super();
        this.funcodigo = funcodigo;
        this.funnome = funnome;
    }
    
    public Long Getfuncodigo() {
        return funcodigo;
    }
    
    public void setfuncodigo(Long funcodigo) {
        this.funcodigo = funcodigo;
    }

    public String getfunnome() {
        return funnome;
    }

    public void setfunnome(String funnome) {
        this.funnome = funnome;
    }
    
    public LocalDate getnascimento() {
        return funnascimento;
    }

    public void setfunnascimento(LocalDate funnascimento) {
        this.funnascimento = funnascimento;
    }
    public Double getsalario() {
        return funsalario;
    }

    public void setfunsalario(Double funsalario) {
        this.funsalario = funsalario;
    }
    }
	
	

