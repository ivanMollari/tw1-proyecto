package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Postre;

import java.util.List;

public interface ServicioPostre {
    List<ItemMenu> getPostresByMenuId(Long menuId);


	Postre consultarPostre(Long id);
}
