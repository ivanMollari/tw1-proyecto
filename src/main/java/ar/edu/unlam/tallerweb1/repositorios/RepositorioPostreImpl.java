package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Postre;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioPostre")
public class RepositorioPostreImpl implements RepositorioPostre{
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPostreImpl(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    @Override
    public List<ItemMenu> getPostresByMenuId(Long menuId){
        final Session session = sessionFactory.getCurrentSession();

        return (List<ItemMenu>) session.createCriteria(Postre.class)
                .add(Restrictions.eq("menu.id", menuId))
                .setFetchMode("menu", FetchMode.EAGER)
                .list();
    }
    
    @Override
    public Postre consultarPostre(Long id){
        final Session session = sessionFactory.getCurrentSession();
        return session.get(Postre.class,id);
    }
}
