package br.org.generation.blogpessoal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

@Entity //create table no my sql
@Table (name="tb_postagens") //colocando o nome da tabela mysql




public class Postagem {

	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private Long id;
	
	@NotBlank(message = "O atributo título é obrigatório!")
	@Size(min = 5, max =100, message = "O atributo titulo deve ter no ,ínimo 5 e no máximo 100 caracteres!")
	private String titulo;
	
	@UpdateTimestamp // a data atualiza sozinha com o sistema
	private LocalDate data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return titulo;
	}

	public void setTexto(String texto) {
		this.titulo = texto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
	
	
}
