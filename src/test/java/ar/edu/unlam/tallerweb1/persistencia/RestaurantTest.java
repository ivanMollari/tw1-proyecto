package ar.edu.unlam.tallerweb1.persistencia;


import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Bebida;
import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurantImpl;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.junit.Test;

import org.mockito.Mockito;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;
import static org.mockito.Mockito.*;

import java.util.HashSet;


import static org.assertj.core.api.Assertions.*;



public class RestaurantTest extends SpringTest {
    SessionFactory sessionFactory= Mockito.mock(SessionFactory.class);
    Session session=Mockito.mock(Session.class);
    Criteria criteria=Mockito.mock(Criteria.class);
    RepositorioRestaurantImpl instancia=new RepositorioRestaurantImpl(sessionFactory);

    @Test
    @Transactional @Rollback
    public void insertarUnResto(){
        // preparacion
        Menu menu=new Menu();
        Restaurant laParolacchia = new Restaurant();
        laParolacchia.setNombre("La Parolacchia de Mare");
        laParolacchia.setCantMesas(42);
        laParolacchia.setMenu(menu);
       // laParolacchia.setEstrellaMichelin(1);
        // ejecucion
        final Session session = session();
        session.save(laParolacchia);
        // comprobacion
        Restaurant buscado = session.get(Restaurant.class, laParolacchia.getId());
        assertThat(buscado).isNotNull();
    }
    
    @Test
    @Transactional @Rollback
    public void modificarResto() {
    	
    	Restaurant LaFarola = new Restaurant();
        Menu menu=new Menu();
        LaFarola.setMenu(menu);
    	LaFarola.setNombre("La Farola");
    	LaFarola.setCantMesas(19);
    	
    	
    	final Session session = session();
    	session.save(LaFarola);
    	LaFarola.modificarCantMesas(40);
    	session.update(LaFarola);
    	
    	Restaurant buscado = session.get(Restaurant.class, LaFarola.getId());
    	assertThat(buscado.getCantMesas()).isEqualTo(40);
   	
    }
    
    @Test
    @Transactional @Rollback
    public void eliminarResto() {
        Menu menu=new Menu();
    	Restaurant LaFarola = new Restaurant();
    	LaFarola.setMenu(menu);
    	LaFarola.setNombre("La Farola");
    	LaFarola.setCantMesas(19);
    	
    	
    	final Session session = session();
    	session.save(LaFarola);
    	session.delete(LaFarola);
    	
    	Restaurant buscado = session.get(Restaurant.class, LaFarola.getId());
    	assertThat(buscado).isNull();
   	
    }
    @Test
    @Transactional @Rollback
    public void obtenerMenues() {
        //given:
        Menu menu=new Menu();
        menu.setDescripcion("soy una descripcion");
        when( sessionFactory.getCurrentSession()).thenReturn(session);
        when(criteria.add(any())).thenReturn( criteria);
        when(session.createCriteria(Menu.class)).thenReturn(criteria);
        when(criteria.uniqueResult()).thenReturn( menu);

        //when:
        Menu menuResultado=instancia.consultarMenu(1L);

        //then:
       assertThat(menuResultado.getDescripcion()).isEqualTo("soy una descripcion");

    }
}

