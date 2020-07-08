package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Entrada;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

import java.util.List;

public interface RepositorioEntrada {
    List<ItemMenu> getEntradasByMenuId(Long menuId);

	Entrada consultarEntrada(Long id);

	


}
