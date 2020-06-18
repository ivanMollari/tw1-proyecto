package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;

import java.util.List;

public interface ServicioRestaurant {

        Restaurant consultarRestaurant(Long id);
}
