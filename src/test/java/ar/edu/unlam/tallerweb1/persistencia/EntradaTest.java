package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Entrada;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEntradaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEntradaImpl;
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

public class EntradaTest extends SpringTest {
    @Autowired
    RepositorioEntradaImpl instancia;


    @Test
    @Transactional @Rollback
    public void insertarUnaEntrada(){
        // preparacion
        final Session session = session();
        Menu menu = new Menu();
        menu.setDescripcion("Menu 1");
        session.save(menu);

        Entrada entrada = new Entrada();
        entrada.setNombre("Rabas");
        entrada.setDescripcion("Porcion para 2 personas");
        entrada.setPrecio(120L);
        entrada.setTiempoPreparacion(1.0);
        entrada.setMenu(menu);


        // ejecucion
        session.save(entrada);

        // comprobacion
        Entrada buscado = session.get(Entrada.class, entrada.getId());
        assertThat(buscado).isNotNull();
    }

    @Test
    @Transactional @Rollback
    public void modificarEntrada() {
        Menu menu = new Menu();
        Entrada entrada = new Entrada();
        final Session session = session();

        menu.setDescripcion("Menu 1");
        session.save(menu);

        entrada.setMenu(menu);
        entrada.setNombre("Rabas");



        session.save(entrada);
        entrada.setNombre("Papas fritas");
        session.update(entrada);

        Entrada buscado = session.get(Entrada.class, entrada.getId());
        assertThat(buscado.getNombre()).isEqualTo("Papas fritas");
    }

    @Test
    @Transactional @Rollback
    public void eliminarEntrada() {
        final Session session = session();
        Menu menu = new Menu();
        Entrada entrada = new Entrada();

        menu.setDescripcion("Menu 1");
        session.save(menu);


        entrada.setMenu(menu);
        entrada.setNombre("Hamburguesa");
        entrada.setPrecio(200L);
        entrada.setTiempoPreparacion(20.0);


        session.save(entrada);
        session.delete(entrada);

        Entrada buscado = session.get(Entrada.class, entrada.getId());
        assertThat(buscado).isNull();
    }


    @Test
    @Transactional @Rollback
    public void testConsultarRestaurant() {
        //given:
        final Session session = session();
        Menu menu = new Menu();
        Entrada entrada = new Entrada();
        Entrada entrada2 = new Entrada();



        menu.setId(1L);
        menu.setDescripcion("Menu 1");
        session.save(menu);


        entrada.setMenu(menu);
        entrada.setNombre("Rabas");
        entrada.setPrecio(200L);
        entrada.setTiempoPreparacion(20.0);


        session.save(entrada);

        entrada2.setMenu(menu);
        entrada2.setNombre("Papas fritas");
        entrada2.setPrecio(300L);
        entrada2.setTiempoPreparacion(30.0);
        session.save(entrada2);


        List<ItemMenu> lista = new ArrayList<>();

        lista.add(entrada);
        lista.add(entrada2);


        //when:
        List<ItemMenu> resultado = instancia.getEntradasByMenuId(menu.getId());


       //then:
        assertThat(resultado.size()).isEqualTo(2);
//

    }


}
