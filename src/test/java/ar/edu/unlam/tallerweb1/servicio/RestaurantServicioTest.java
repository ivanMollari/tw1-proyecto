package ar.edu.unlam.tallerweb1.servicio;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComidaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedidoImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurantImpl;

import ar.edu.unlam.tallerweb1.servicios.ServicioRestaurantImpl;

import ar.edu.unlam.tallerweb1.servicios.*;


import org.junit.Test;
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

    @Test
    public void crearPedido() {

        //given:
        Pedido pedido=new Pedido();

        when( repositorio.crearPedido(pedido)).thenReturn(200);

        //when:
        Integer resultado=instancia.crearPedido(pedido);

        //then:
        assertThat(resultado).isEqualTo(200);
    }
}
