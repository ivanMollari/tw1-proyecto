package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComidaImpl;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hsqldb.lib.HashMappedList;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ComidaTest extends SpringTest {
    SessionFactory sessionFactory= Mockito.mock(SessionFactory.class);
    Session session = Mockito.mock(Session.class);

    RepositorioComidaImpl instancia = new RepositorioComidaImpl(sessionFactory);

    @Test
    @Transactional @Rollback
    public void insertarUnaComida(){
        // preparacion
        Menu menu = new Menu();
        final Session session = session();

        menu.setDescripcion("Menu 1");
        session.save(menu);

        Comida comida = new Comida();

        comida.setNombre("Hamburguesa");
        comida.setDescripcion("Hamburguesa con queso");
        comida.setPrecio(250L);
        comida.setTiempoPreparacion(40);
        comida.setMenu(menu);

        // ejecucion
        session.save(comida);

        // comprobacion
        Comida buscado = session.get(Comida.class, comida.getId());
        assertThat(buscado).isNotNull();
    }

    @Test
    @Transactional @Rollback
    public void modificarComida() {
        Menu menu = new Menu();
        Comida comida = new Comida();
        final Session session = session();

        menu.setDescripcion("Menu 1");
        session.save(menu);

        comida.setMenu(menu);
        comida.setNombre("Hamburguesa");


        session.save(comida);
        comida.setNombre("Ñoquis");
        session.update(comida);

        Comida buscado = session.get(Comida.class, comida.getId());
        assertThat(buscado.getNombre()).isEqualTo("Ñoquis");
    }

    @Test
    @Transactional @Rollback
    public void eliminarComida() {
        Menu menu = new Menu();
        Comida comida = new Comida();
        final Session session = session();

        menu.setDescripcion("Menu 1");
        session.save(menu);

        comida.setMenu(menu);
        comida.setNombre("Hamburguesa");
        comida.setPrecio(200L);
        comida.setTiempoPreparacion(20);

        session.save(comida);
        session.delete(comida);

        Restaurant buscado = session.get(Restaurant.class, comida.getId());
        assertThat(buscado).isNull();
    }

    @Test
    @Transactional @Rollback
    public void testConsultarRestaurant() {
        //given:
        Menu menu = new Menu();
        Comida comida = new Comida();
        Comida comida2 = new Comida();


        menu.setId(1L);
        menu.setDescripcion("Menu 1");
        session.save(menu);

        comida.setMenu(menu);
        comida.setNombre("Hamburguesa");
        comida.setPrecio(200L);
        comida.setTiempoPreparacion(20);
        session.save(comida);

        comida2.setMenu(menu);
        comida2.setNombre("Ñoquis");
        comida2.setPrecio(300L);
        comida2.setTiempoPreparacion(30);
        session.save(comida2);

        List<ItemMenu> lista = new ArrayList<>();

        lista.add(comida);
        lista.add(comida2);

        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(
                session.createCriteria(Comida.class)
                        .add(Restrictions.eq("menu.id", menu.getId()))
                        .setFetchMode("menu", FetchMode.EAGER)
                        .list()
        ).thenReturn(lista);

        //when:
        List<ItemMenu> resultado = instancia.getComidasByMenuId(menu.getId());

        System.out.println(resultado);
        //then:
//        assertThat(resultado.getMenu().getDescripcion()).isEqualTo("soy una descripcion");

    }
}
