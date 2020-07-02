package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

public interface RepositorioPedido {

	List<ItemMenu> getPedidosPorIdUsuario(Long usuarioId);

	void agregaPedido(Pedido pedido);
	
	

}
