package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;

import java.util.List;

public interface RepositorioRestaurant {

       Restaurant consultarRestaurant(Long id);
}
