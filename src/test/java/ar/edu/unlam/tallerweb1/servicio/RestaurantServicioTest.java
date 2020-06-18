package ar.edu.unlam.tallerweb1.servicio;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurantImpl;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class RestaurantServicioTest {
    RepositorioRestaurantImpl repositorio= Mockito.mock(RepositorioRestaurantImpl.class);
    ServicioComida servicioComida = Mockito.mock(ServicioComida.class);
    ServicioEntrada servicioEntrada = Mockito.mock(ServicioEntrada.class);
    ServicioBebida servicioBebida = Mockito.mock(ServicioBebida.class);
    ServicioPostre servicioPostre = Mockito.mock(ServicioPostre.class);

    ServicioRestaurantImpl instancia=new ServicioRestaurantImpl(
            repositorio,
            servicioComida,
            servicioBebida,
            servicioEntrada,
            servicioPostre
    );

    @Test
    public void consultarRestaurant() {

        //given:
        Restaurant restaurant=new Restaurant();
        restaurant.setId(1L);
        Menu menu=new Menu();
        menu.setDescripcion("soy una descripcion");
        restaurant.setMenu(menu);
        when( repositorio.consultarRestaurant(restaurant.getId())).thenReturn(restaurant);

        //when:
        Restaurant resultado=instancia.consultarRestaurant(1L);

        //then:
        assertThat(resultado.getMenu().getDescripcion()).isEqualTo("soy una descripcion");
    }
}
