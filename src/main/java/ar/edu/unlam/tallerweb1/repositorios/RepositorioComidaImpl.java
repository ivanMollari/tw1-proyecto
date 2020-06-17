package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioComida")
public class RepositorioComidaImpl implements RepositorioComida{
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioComidaImpl(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    @Override
    public List<ItemMenu> getComidaByMenuId(Long menuId){
        final Session session = sessionFactory.getCurrentSession();

        return (List<ItemMenu>) session.createCriteria(Comida.class)
                .createAlias("menu_id", "menuId")
                .add(Restrictions.eq("menuId", menuId))
                .list();
    };
}
