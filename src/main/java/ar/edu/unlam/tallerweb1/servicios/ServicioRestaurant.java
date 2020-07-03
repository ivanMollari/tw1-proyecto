package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.modelo.dto.RequestPedido;


import java.util.List;
import java.util.Map;

public interface ServicioRestaurant {
        Restaurant consultarRestaurant(Long id);

        void crearPedido (Pedido pedido);

        Comida consultarComida(Long id);

        Map<String, List<ItemMenu>> consultarMenuCompleto(Long menuId);
        

        List<Restaurant> buscarRestaurants(String searchText);

		Postre consultarPostre(Long id);

        Entrada consultarEntrada(Long id);

        Bebida consultarBebida(Long id);
        Pedido armarPedido(RequestPedido requestPedido,Restaurant restaurant);

		

		

}
