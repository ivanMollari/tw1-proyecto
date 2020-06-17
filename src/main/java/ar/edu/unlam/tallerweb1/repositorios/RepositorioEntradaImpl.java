package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.Entrada;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioEntrada")
public class RepositorioEntradaImpl implements RepositorioEntrada{
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioEntradaImpl(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    @Override
    public List<ItemMenu> getEntradasByMenuId(Long menuId){
        final Session session = sessionFactory.getCurrentSession();

        return (List<ItemMenu>) session.createCriteria(Entrada.class)
                .add(Restrictions.eq("menu.id", menuId))
                .setFetchMode("menu", FetchMode.EAGER)
                .list();
    };
}
