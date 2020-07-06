package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioPedido {

	List<ItemMenu> getPedidosPorIdUsuario(Long usuarioId);


	List<Pedido> buscarPedidosUsuario(Usuario usuario);
	
	

}
