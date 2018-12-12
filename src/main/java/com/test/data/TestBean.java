package com.test.data;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.wordnik.swagger.annotations.ApiModel;

/**
 * Test data bean
 */
@Entity
@Cache
@ApiModel("Test object")
public class TestBean {

    @Id
    private Long id;

    private String nombre;

    private String autor;
    
    private Integer anyo_publicacion;
    
    private String genero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getAnyo_publicacion() {
		return anyo_publicacion;
	}

	public void setAnyo_publicacion(Integer anyo_publicacion) {
		this.anyo_publicacion = anyo_publicacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "TestBean [id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", anyo_publicacion="
				+ anyo_publicacion + ", genero=" + genero + "]";
	}
    
}
