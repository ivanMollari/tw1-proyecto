package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.*;

import java.io.Serializable;
import java.util.List;

public interface RepositorioRestaurant {

	Restaurant consultarRestaurant(Long id);

	void crearPedido(Pedido pedido);

	List<Restaurant> consultarListaRestos();

	List<Restaurant> buscarRestaurants(String searchText);

}
