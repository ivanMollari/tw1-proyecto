package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;

import java.util.List;

public interface ServicioComida {
    List<ItemMenu> getComidasByMenuId(Long menuId);


	Comida consultarComida(Long id);
}
