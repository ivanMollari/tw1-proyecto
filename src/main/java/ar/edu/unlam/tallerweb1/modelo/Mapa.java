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

	

	/*public Double sacarDistancia(Restaurant resto, Usuario usuario) {
		
		Double distancia= 0.0;
		
		if(this.resto.contains(resto) && usuario != null) {
		
		Double	radianes= (Math.PI/180);
		Double radioTierra= 6372.795477598;
		
		Double diferenciaLatitud= ((resto.getLatitudResto())-(usuario.getLatitud()));
		Double diferenciaLongitud= 	((resto.getLongitudResto()) - (usuario.getLongitud()));
		Double calculoDentroDeLaRaiz= Math.pow((Math.sin(radianes*diferenciaLatitud/2)), 2) + Math.cos(radianes*usuario.getLatitud())* Math.cos(radianes*resto.getLatitudResto())* Math.pow((Math.sin(radianes*diferenciaLongitud/2)), 2);
		distancia= 2*radioTierra*Math.asin(Math.sqrt(calculoDentroDeLaRaiz));	
		
		
		}
		else {
			distancia= -1.0;
		}
		return distancia;				
		
	}
	
	public List<Restaurant> mostrarRestosMasCercanos(Usuario usuario,List<Restaurant> listaRestos ) {
		
		List<Restaurant> listaRestaurantCercano = new ArrayList();
		
		for (Restaurant restaurant : listaRestos) {
			if(this.sacarDistancia(restaurant, usuario) >-1.0 && this.sacarDistancia(restaurant, usuario)<=1.0) {
				listaRestaurantCercano.add(restaurant);
			}
			
		}
		
		
		
		return listaRestaurantCercano;
	}*/
	
	
	
}
