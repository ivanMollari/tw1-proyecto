package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("repositorioComida")
public class RepositorioComidaImpl implements RepositorioComida {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioComidaImpl(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    @Override
    public List<ItemMenu> getComidasByMenuId(Long menuId){
        final Session session = sessionFactory.getCurrentSession();

        return (List<ItemMenu>) session.createCriteria(Comida.class)
                .add(Restrictions.eq("menu.id", menuId))
                .setFetchMode("menu", FetchMode.EAGER)
                .list();
    }
    
    @Override
    public Comida consultarComida(Long id){
        final Session session = sessionFactory.getCurrentSession();
        return session.get(Comida.class,id);
    }
    

    

}
