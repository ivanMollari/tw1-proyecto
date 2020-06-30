package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.ItemMenu;

import java.util.List;

public interface ServicioEntrada {
    List<ItemMenu> getEntradasByMenuId(Long menuId);

	List<ItemMenu> getEntradasDeUnPedidoPorUsuarioId(Long usuarioId);
}
