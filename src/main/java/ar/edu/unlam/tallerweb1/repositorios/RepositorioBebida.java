package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Bebida;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;

import java.util.List;

public interface RepositorioBebida {
    List<ItemMenu> getBebidasByMenuId(Long menuId);

	Bebida consultarBebida(Long id);
}
