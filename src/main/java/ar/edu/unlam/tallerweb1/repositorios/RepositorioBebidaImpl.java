package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioBebida")
public class RepositorioBebidaImpl implements RepositorioBebida{
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioBebidaImpl(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    @Override
    public List<ItemMenu> getBebidaByMenuId(Long menuId){
        final Session session = sessionFactory.getCurrentSession();

        return (List<ItemMenu>) session.createCriteria(Comida.class)
                .add(Restrictions.eq("id", menuId))
                .list();
    };
}
