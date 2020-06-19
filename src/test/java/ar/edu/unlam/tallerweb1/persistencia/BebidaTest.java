package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBebidaImpl;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class BebidaTest extends SpringTest {
    @Autowired
    RepositorioBebidaImpl instancia;

    @Test
    @Transactional @Rollback
    public void insertarUnaBebida(){
        // preparacion
        Menu menu = new Menu();
        final Session session = session();

        menu.setDescripcion("Menu 1");
        session.save(menu);

        Bebida bebida = new Bebida();

        bebida.setNombre("Agua mineral");
        bebida.setDescripcion("Botella de 500ml");
        bebida.setPrecio(120L);
        bebida.setTiempoPreparacion(1.0);
        bebida.setMenu(menu);

        // ejecucion
        session.save(bebida);

        // comprobacion
        Bebida buscado = session.get(Bebida.class, bebida.getId());
        assertThat(buscado).isNotNull();
    }

    @Test
    @Transactional @Rollback
    public void modificarbebida() {
        Menu menu = new Menu();
        Bebida bebida = new Bebida();
        final Session session = session();

        menu.setDescripcion("Menu 1");
        session.save(menu);

        bebida.setMenu(menu);
        bebida.setNombre("Agua Mineral");


        session.save(bebida);
        bebida.setNombre("Agua con gas");
        session.update(bebida);

        Bebida buscado = session.get(Bebida.class, bebida.getId());
        assertThat(buscado.getNombre()).isEqualTo("Agua con gas");
    }

    @Test
    @Transactional @Rollback
    public void eliminarbebida() {
        Menu menu = new Menu();
        Bebida bebida = new Bebida();
        final Session session = session();

        menu.setDescripcion("Menu 1");
        session.save(menu);

        bebida.setMenu(menu);
        bebida.setNombre("Hamburguesa");
        bebida.setPrecio(200L);
        bebida.setTiempoPreparacion(20.0);

        session.save(bebida);
        session.delete(bebida);

        Bebida buscado = session.get(Bebida.class, bebida.getId());
        assertThat(buscado).isNull();
    }

    @Test
    @Transactional @Rollback
    public void testConsultarRestaurant() {
        //given:
        Menu menu = new Menu();
        Bebida bebida = new Bebida();
        Bebida bebida2 = new Bebida();
        final Session session = session();

        menu.setId(1L);
        menu.setDescripcion("Menu 1");
        session.save(menu);

        bebida.setMenu(menu);
        bebida.setNombre("Hamburguesa");
        bebida.setPrecio(200L);
        bebida.setTiempoPreparacion(20.0);
        session.save(bebida);

        bebida2.setMenu(menu);
        bebida2.setNombre("Ñoquis");
        bebida2.setPrecio(300L);
        bebida2.setTiempoPreparacion(30.0);
        session.save(bebida2);

        List<ItemMenu> lista = new ArrayList<>();

        lista.add(bebida);
        lista.add(bebida2);

        when(
                session.createCriteria(Bebida.class)
                        .add(Restrictions.eq("menu.id", menu.getId()))
                        .setFetchMode("menu", FetchMode.EAGER)
                        .list()
        ).thenReturn(lista);

        //when:
        List<ItemMenu> resultado = instancia.getBebidasByMenuId(menu.getId());

        System.out.println(resultado);
        //then:
//        assertThat(resultado.getMenu().getDescripcion()).isEqualTo("soy una descripcion");

    }
}
