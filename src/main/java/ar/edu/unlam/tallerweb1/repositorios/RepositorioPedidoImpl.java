package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("repositorioPedido")
public class RepositorioPedidoImpl implements RepositorioPedido{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPedidoImpl(SessionFactory sessionFactory) { 
    	this.sessionFactory = sessionFactory; 
    }

    @Override
    public List<ItemMenu> getPedidosPorIdUsuario(Long usuarioId){
        final Session session = sessionFactory.getCurrentSession();

        return (List<ItemMenu>) session.createCriteria(Pedido.class)
                .add(Restrictions.eq("usuario.id", usuarioId))
                .setFetchMode("usuario", FetchMode.EAGER)
                .list();
    }
    
    @Override
    public List<Pedido> buscarPedidosUsuario(Usuario usuario) {
    	final Session session = sessionFactory.getCurrentSession();
    	return (List<Pedido>) session.createCriteria(Pedido.class)
    			.add(Restrictions.eq("usuario.id",usuario.getId()))
                .list();
    }
    
	
}
