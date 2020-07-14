package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Bebida;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;

import java.util.List;

public interface ServicioBebida {
    List<ItemMenu> getBebidasByMenuId(Long menuId);


	Bebida consultarBebida(Long id);
}
