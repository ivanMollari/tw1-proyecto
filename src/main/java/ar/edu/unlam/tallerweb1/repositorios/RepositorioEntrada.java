package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ItemMenu;

import java.util.List;

public interface RepositorioEntrada {
    List<ItemMenu> getEntradasByMenuId(Long menuId);
}
