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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ComidaTest extends SpringTest {
    @Autowired
    RepositorioComidaImpl instancia;

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
        comida.setPrecio(250.0);
        comida.setTiempoPreparacion(40.0);
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
        comida.setPrecio(200.0);
        comida.setTiempoPreparacion(20.0);

        session.save(comida);
        session.delete(comida);

        Comida buscado = session.get(Comida.class, comida.getId());
        assertThat(buscado).isNull();
    }

    @Test
    @Transactional @Rollback
    public void testConsultarRestaurant() {
        //given:
        Menu menu = new Menu();
        Comida comida = new Comida();
        Comida comida2 = new Comida();
        final Session session = session();

        menu.setId(1L);
        menu.setDescripcion("Menu 1");
        session.save(menu);

        comida.setMenu(menu);
        comida.setNombre("Hamburguesa");
        comida.setPrecio(200.0);
        comida.setTiempoPreparacion(20.0);
        session.save(comida);

        comida2.setMenu(menu);
        comida2.setNombre("Ñoquis");
        comida2.setPrecio(300.0);
        comida2.setTiempoPreparacion(30.0);
        session.save(comida2);

        List<ItemMenu> lista = new ArrayList<>();

        lista.add(comida);
        lista.add(comida2);

        //when:
        List<ItemMenu> resultado = instancia.getComidasByMenuId(menu.getId());

        //then:
        assertThat(resultado).hasSize(2);

    }
}
