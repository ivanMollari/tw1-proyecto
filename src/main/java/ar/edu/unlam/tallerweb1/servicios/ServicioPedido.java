package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioPedido {

	List<Pedido> mostrarPedidosUsuario(Usuario usuario);

}
