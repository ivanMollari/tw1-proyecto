package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Comida;

import ar.edu.unlam.tallerweb1.modelo.ItemMenu;


import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;

import java.util.List;
import java.util.Map;

public interface ServicioRestaurant {
        Restaurant consultarRestaurant(Long id);

         Integer crearPedido (Pedido pedido);

        Comida consultarComida(Long id);

        Map<String, List<ItemMenu>> consultarMenuCompleto(Long menuId);

        List<Restaurant> buscarRestaurants(String searchText);

}
