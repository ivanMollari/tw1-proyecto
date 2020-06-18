package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;

import java.util.List;

public interface ServicioRestaurant {

        Restaurant consultarRestaurant(Long id);
         Integer crearPedido (Pedido pedido);

        Comida consultarComida(Long id);
}
