
package ar.edu.unlam.tallerweb1.persistencia;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;
import static org.assertj.core.api.Assertions.*;

public class RestaurantTest extends SpringTest {
    @Test
    @Transactional @Rollback
    public void insertarUnResto(){
        // preparacion
        Restaurant laParolacchia = new Restaurant();
        laParolacchia.setNombre("La Parolacchia de Mare");
        laParolacchia.setCantidadMesas(42);
        laParolacchia.setEstrellaMichelin(1);

        // ejecucion
        final Session session = session();
        session.save(laParolacchia);

        // comprobacion
        Restaurant buscado = session.get(Restaurant.class, laParolacchia.getId());
        assertThat(buscado).isNotNull();
    }
}



