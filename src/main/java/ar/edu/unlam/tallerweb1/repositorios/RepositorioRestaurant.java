package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Menu;

import java.util.List;

public interface RepositorioRestaurant {
       Menu consultarMenu(Long id);
}
