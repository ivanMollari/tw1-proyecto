package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Menu;

import java.util.List;

@Repository("repositorioRestaurant")
public class RepositorioRestaurantImpl implements RepositorioRestaurant{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioRestaurantImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Menu consultarMenu(Long id){
        final Session session = sessionFactory.getCurrentSession();
        Query q= session.createSQLQuery("SELECT m.id,m.descripcion,m.nombre,m.precioDeLista FROM Menu m JOIN Restaurant r on m.id=r.menu_id Where rm.Restaurant_id=?");
        Menu result=(Menu) q.setParameter(1,id).uniqueResult();
        return result;

    }

}
