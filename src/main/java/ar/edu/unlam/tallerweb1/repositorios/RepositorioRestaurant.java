package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;

import java.io.Serializable;
import java.util.List;


public interface RepositorioRestaurant {


       Restaurant consultarRestaurant(Long id);

       Integer crearPedido(Pedido pedido);

       Comida consultarComida(Long id);

	    List<Restaurant> consultarListaRestos();

        List<Restaurant> buscarRestaurants(String searchText);

}
