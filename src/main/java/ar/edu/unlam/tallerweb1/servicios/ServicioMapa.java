package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioMapa {

	Restaurant consultarRestaurant(Long id);

	Usuario consultarUsuario(Long id);
	
	Integer sacarDistancia(Restaurant resto, Usuario usuario)throws ResultadoNegativoException;

	List<Restaurant> traerLista();
	
	List<Restaurant> mostrarRestosMasCercanos(Usuario usuario,Integer radioEnKm)throws ResultadoNegativoException;

}
