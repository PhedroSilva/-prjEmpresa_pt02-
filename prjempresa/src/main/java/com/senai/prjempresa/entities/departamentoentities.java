package com.senai.prjempresa.entities;

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	@Entity
	@Table(name = "tb_empresa")
	public class departamentoentities {
		
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY )
			private Long depcodigo;

			private String depnome;

			
			

			public Long getdepcodigo() {
				return depcodigo;
			}

			public void setId(Long depcodigo) {
				this.depcodigo= depcodigo;
			}

			public String getdepnome() {
				return depnome;
			}

			public void setdepnome(String depnome) {
				this.depnome = depnome;
			}


		
	}
