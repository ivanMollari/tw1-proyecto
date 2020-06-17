package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;

import java.util.List;
import java.util.Map;

public interface ServicioRestaurant {

        Restaurant consultarRestaurant(Long id);
        Map<String, List<ItemMenu>> consultarMenuCompleto(Long menuId);
}
