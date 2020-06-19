package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.ItemMenu;

import java.util.List;

public interface ServicioPostre {
    List<ItemMenu> getPostresByMenuId(Long menuId);
}
