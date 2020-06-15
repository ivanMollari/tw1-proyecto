package ar.edu.unlam.tallerweb1.controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorRestaurant;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurantImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioRestaurant;
import ar.edu.unlam.tallerweb1.servicios.ServicioRestaurantImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class RestaurantControllerTest {

    ServicioRestaurant servicioRestaurant= Mockito.mock(ServicioRestaurantImpl.class);
    ControladorRestaurant instancia=new ControladorRestaurant(servicioRestaurant);

    @Test
    public void consultarRestaurant() {

        //given:
        Restaurant restaurant=new Restaurant();
        restaurant.setId(1L);
        Menu menu=new Menu();
        menu.setDescripcion("soy una descripcion");
        restaurant.setMenu(menu);
        when( servicioRestaurant.consultarRestaurant(restaurant.getId())).thenReturn(restaurant);

        //when:
        ModelAndView resultado=instancia.mostrarRestaurant(1L);

        //then:
        assertThat(resultado).isNotNull();
    }
}
