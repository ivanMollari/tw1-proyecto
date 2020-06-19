package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@Repository("repositorioRestaurant")
public class RepositorioRestaurantImpl implements RepositorioRestaurant{

    private SessionFactory sessionFactory;


    @Autowired
    public RepositorioRestaurantImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Restaurant consultarRestaurant(Long id){
        final Session session = sessionFactory.getCurrentSession();


        return session.get(Restaurant.class, id);
    }

    @Override
   public Integer crearPedido(Pedido pedido){
        final Session session = sessionFactory.getCurrentSession();
         Serializable id=session.save(pedido);
         if (id!=null){
             return 201;
         }
         return 500;


    }
    @Override
    public Comida consultarComida(Long id){
        final Session session = sessionFactory.getCurrentSession();
        return session.get(Comida.class,id);
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
