package ar.edu.unlam.tallerweb1.modelo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity

public class Mapa{
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	@OneToMany(targetEntity = Restaurant.class)
	private List<Restaurant> resto;
	@OneToOne(targetEntity = Usuario.class)
	@JoinColumn(name= "id_usuario", referencedColumnName= "id")
	private Usuario usuario;

	
	public Boolean agregarResto(Restaurant nuevoResto) {
		if (!resto.contains(nuevoResto))
			return resto.add(nuevoResto);
			else return false;
	}
	
	public List<Restaurant> getResto() {
		return resto;
	}



	public void setResto(List<Restaurant> resto) {
		this.resto = resto;
	}



	
	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	
	
	
}
