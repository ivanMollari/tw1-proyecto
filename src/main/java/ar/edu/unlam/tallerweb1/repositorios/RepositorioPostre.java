package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Postre;

import java.util.List;

public interface RepositorioPostre {
    List<ItemMenu> getPostresByMenuId(Long menuId);

	Postre consultarPostre(Long id);
}
