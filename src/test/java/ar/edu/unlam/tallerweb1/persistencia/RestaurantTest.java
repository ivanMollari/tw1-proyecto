package ar.edu.unlam.tallerweb1.persistencia;


import ar.edu.unlam.tallerweb1.SpringTest;

import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurantImpl;


import org.hibernate.Session;


import org.junit.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;


import javax.transaction.Transactional;
import java.util.HashSet;





import static org.assertj.core.api.Assertions.*;



public class RestaurantTest extends SpringTest {

    @Autowired
    RepositorioRestaurantImpl instancia;





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
    public void testConsultarRestaurant() {
       //given:
        final Session session=session();
        Restaurant restaurant=new Restaurant();
        /*restaurant.setId(1L);*/
        Menu menu=new Menu();
        menu.setDescripcion("soy una descripcion");
        restaurant.setMenu(menu);
        restaurant.setNombre("nombre");

        session.save(restaurant);


        //when:
       Restaurant resultado=instancia.consultarRestaurant(restaurant.getId());

        //then:
       assertThat(resultado.getMenu().getDescripcion()).isEqualTo("soy una descripcion");

    }
    @Test
    @Transactional @Rollback
    public void testCrearPedido() {
        //given:

        Pedido pedido=new Pedido();
        //when:
         instancia.crearPedido(pedido);

        //then:
        assertThat(session().get(Pedido.class,1l)).isNotNull();

    }
    
    @Test
    @Transactional @Rollback
    public void testBuscarRestoPorId() {
        //given:
    	Restaurant resto = new Restaurant();
    	Menu menu = new Menu();
    	resto.setMenu(menu);
    	resto.setNombre("La Farola");
        final Session session = session();
        //when:
        session.save(resto);
        Restaurant restoBuscado = instancia.consultarRestaurant(resto.getId());

        //then:
        assertThat(restoBuscado).isNotNull();

    }
    
    

}

