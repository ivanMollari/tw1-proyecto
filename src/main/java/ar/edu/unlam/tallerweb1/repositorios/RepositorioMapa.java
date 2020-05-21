package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioMapa {
		Restaurant consultarRestaurant(Long id);

		Usuario consultarUsuario(Long id);

		List<Restaurant> consultarListaRestos();
}
