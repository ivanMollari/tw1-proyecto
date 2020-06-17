package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComidaImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

public class ComidaTest extends SpringTest {
    SessionFactory sessionFactory= Mockito.mock(SessionFactory.class);
    Session session=Mockito.mock(Session.class);
    RepositorioComidaImpl instancia=new RepositorioComidaImpl(sessionFactory);

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
}
