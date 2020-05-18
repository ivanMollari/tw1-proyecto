package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Menu;

@Repository("repositorioRestaurant")
public class RepositorioRestaurantImpl implements RepositorioRestaurant{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioRestaurantImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Menu consultarMenu(Long menuId){
        final Session session = sessionFactory.getCurrentSession();
        return (Menu) session.createCriteria(Menu.class)
                .add(Restrictions.eq("menuId", menuId))
                .uniqueResult();
    }

}
