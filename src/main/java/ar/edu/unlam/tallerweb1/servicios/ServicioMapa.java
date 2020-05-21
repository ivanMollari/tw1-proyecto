package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioMapa {

	Restaurant consultarRestaurant(Long id);

	Usuario consultarUsuario(Long id);
	
	Double sacarDistancia(Restaurant resto, Usuario usuario);

	List<Restaurant> traerLista();
	
	List<Restaurant> mostrarRestosMasCercanos(Usuario usuario);

}
