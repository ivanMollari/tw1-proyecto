package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Postre;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPostreImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPostreImpl;
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

public class PostreTest extends SpringTest {

    @Autowired
    RepositorioPostreImpl instancia;

    @Test
    @Transactional @Rollback
    public void insertarUnPostre(){
        // preparacion
        Menu menu = new Menu();
        final Session session = session();

        menu.setDescripcion("Menu 1");
        session.save(menu);

        Postre postre = new Postre();

        postre.setNombre("Flan");
        postre.setDescripcion("Flan con crema");
        postre.setPrecio(120L);
        postre.setTiempoPreparacion(1.0);
        postre.setMenu(menu);

        // ejecucion
        session.save(postre);

        // comprobacion
        Postre buscado = session.get(Postre.class, postre.getId());
        assertThat(buscado).isNotNull();
    }

    @Test
    @Transactional @Rollback
    public void modificarPostre() {
        Menu menu = new Menu();
        Postre postre = new Postre();
        final Session session = session();

        menu.setDescripcion("Menu 1");
        session.save(menu);

        postre.setMenu(menu);
        postre.setNombre("Flan");


        session.save(postre);
        postre.setNombre("Panqueque");
        session.update(postre);

        Postre buscado = session.get(Postre.class, postre.getId());
        assertThat(buscado.getNombre()).isEqualTo("Panqueque");
    }

    @Test
    @Transactional @Rollback
    public void eliminarPostre() {
        Menu menu = new Menu();
        Postre postre = new Postre();
        final Session session = session();

        menu.setDescripcion("Menu 1");
        session.save(menu);

        postre.setMenu(menu);
        postre.setNombre("Flan");
        postre.setPrecio(200L);
        postre.setTiempoPreparacion(20.0);

        session.save(postre);
        session.delete(postre);

        Postre buscado = session.get(Postre.class, postre.getId());
        assertThat(buscado).isNull();
    }

    @Test
    @Transactional @Rollback
    public void testConsultarRestaurant() {
        //given:
        Menu menu = new Menu();
        Postre postre = new Postre();
        Postre postre2 = new Postre();
        final Session session = session();

        menu.setId(1L);
        menu.setDescripcion("Menu 1");
        session.save(menu);

        postre.setMenu(menu);
        postre.setNombre("Flan");
        postre.setPrecio(200L);
        postre.setTiempoPreparacion(20.0);
        session.save(postre);

        postre2.setMenu(menu);
        postre2.setNombre("Panqueque");
        postre2.setPrecio(300L);
        postre2.setTiempoPreparacion(30.0);
        session.save(postre2);

        List<ItemMenu> lista = new ArrayList<>();

        lista.add(postre);
        lista.add(postre2);

        when(
                session.createCriteria(Postre.class)
                        .add(Restrictions.eq("menu.id", menu.getId()))
                        .setFetchMode("menu", FetchMode.EAGER)
                        .list()
        ).thenReturn(lista);

        //when:
        List<ItemMenu> resultado = instancia.getPostresByMenuId(menu.getId());

        System.out.println(resultado);
        //then:
//        assertThat(resultado.getMenu().getDescripcion()).isEqualTo("soy una descripcion");

    }
}
