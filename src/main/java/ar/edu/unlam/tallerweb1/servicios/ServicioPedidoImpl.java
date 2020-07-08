package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;

@Service("servicioPedido")
@Transactional
public class ServicioPedidoImpl implements ServicioPedido {
	
	private RepositorioPedido servicioPedidoDao;
	
	@Autowired
	public ServicioPedidoImpl(RepositorioPedido servicioPedidoDao) {
		this.servicioPedidoDao = servicioPedidoDao;
	}
	
	@Override 
	public List<Pedido> mostrarPedidosUsuario(Usuario usuario){
		return servicioPedidoDao.buscarPedidosUsuario(usuario);
	}
	
	
}
