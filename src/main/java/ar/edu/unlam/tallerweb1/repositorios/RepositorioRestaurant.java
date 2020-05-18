package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Menu;

public interface RepositorioRestaurant {
        Menu consultarMenu(Long id);
}
