package ar.edu.unlam.tallerweb1.persistencia;


import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;



public class RestaurantTest extends SpringTest {
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

        Restaurant LaFarola = new Restaurant();
        List<Menu> menues=new ArrayList<>();
        Menu menu1=new Menu();
        Menu menu2=new Menu();
        menues.add(menu1);
        menues.add(menu2);
        LaFarola.setMenu(menues);
        LaFarola.setNombre("La Farola");
        LaFarola.setCantMesas(19);

        final Session session = session();
        session.save(LaFarola);

       assertThat(LaFarola.getMenu()).isNotNull();

    }
}

