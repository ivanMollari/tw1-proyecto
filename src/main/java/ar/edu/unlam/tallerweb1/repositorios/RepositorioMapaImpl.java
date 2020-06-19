package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("repositorioMapa")
public class RepositorioMapaImpl implements RepositorioMapa{


	private SessionFactory sessionFactory;


	@Autowired
	public RepositorioMapaImpl(SessionFactory sessionFactory){
	    this.sessionFactory = sessionFactory;
	}



	@Override
	public Restaurant consultarRestaurant(Long restoId){
	    final Session session = sessionFactory.getCurrentSession();
	    return (Restaurant) session.createCriteria(Restaurant.class)
	            .add(Restrictions.eq("id", restoId))
	            .uniqueResult();
	}

	@Override
	public Usuario consultarUsuario(Long usuarioId){
	    final Session session = sessionFactory.getCurrentSession();
	    return (Usuario) session.createCriteria(Usuario.class)
	            .add(Restrictions.eq("id", usuarioId))
	            .uniqueResult();
	}

	@Override
	public List<Restaurant> consultarListaRestos(){
	    final Session session = sessionFactory.getCurrentSession();

	    Criteria criteria = session.createCriteria(Restaurant.class);
	           criteria.add(Restrictions.isNotNull("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

	    List<Restaurant> listaRestaurantes = criteria.list();
	    return listaRestaurantes;
	}




}
