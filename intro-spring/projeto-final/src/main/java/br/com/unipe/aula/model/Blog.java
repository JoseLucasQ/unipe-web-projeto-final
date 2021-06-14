package br.com.unipe.aula.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog implements Serializable{
	
	@Id
	private Long id;
	
	private String texto;
	
	public Blog(Long id, String texto ) {
		super();
		this.id = id;
		this.texto = texto;
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
