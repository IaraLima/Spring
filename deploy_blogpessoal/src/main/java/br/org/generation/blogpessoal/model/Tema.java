package br.org.generation.blogpessoal.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity //create table no my sql
@Table (name="tb_temas") //colocando o nome da tabela mysql




public class Tema {

	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private Long id;
	
	
	
	@NotBlank(message = "O atributo descrição é obrigatório!")
	@Size(min = 5, max =100, message = "O atributo de texto deve ter no ,ínimo 5 e no máximo 100 caracteres!")
	private String descricao;

	@OneToMany(mappedBy="tema",cascade=CascadeType.ALL)
	@JsonIgnoreProperties("tema") // DÚVIDA !!! o que é esse tema? classe? atributo?
	private List<Postagem> postagens;
	
	

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String texto) {
		this.descricao = texto;
	}
	
	
	
	
	
}
