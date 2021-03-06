package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.modelo.dto.RequestPedido;

import java.util.List;
import java.util.Map;

public interface ServicioRestaurant {
	Restaurant consultarRestaurant(Long id);

	void crearPedido(Pedido pedido);

	Map<String, List<ItemMenu>> consultarMenuCompleto(Long menuId);

	List<Restaurant> buscarRestaurants(String searchText);

	Pedido armarPedido(RequestPedido requestPedido, Restaurant restaurant);

	List<ItemMenu> mostrarPedido(Pedido pedido);

}
