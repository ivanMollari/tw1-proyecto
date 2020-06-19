package ar.edu.unlam.tallerweb1.servicio;

import ar.edu.unlam.tallerweb1.exception.ResultadoNegativoException;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurantImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioMapaImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class mapaServicioTest {


    @InjectMocks
    private ServicioMapaImpl servicioMapa;
    @Mock
    private RepositorioRestaurantImpl repositorioRestaurant;




    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void mostrarDistanciaTest()  {
        Restaurant laFarola = new Restaurant();
        laFarola.setId(1L);
        laFarola.setNombre("La Farola");
        laFarola.setLatitudResto(-34.647658);
        laFarola.setLongitudResto(-58.628743);


        Menu menu1 = new Menu();
        laFarola.setMenu(menu1);

        Usuario jose = new Usuario();
        jose.setId(1L);
        jose.setLatitud(-34.647858);
        jose.setLongitud(-58.62861);


        Mockito.when(repositorioRestaurant.consultarRestaurant(1L)).thenReturn(laFarola);


        try {

            assertThat(servicioMapa.sacarDistancia(laFarola,jose)).isEqualTo(25);
        } catch (ResultadoNegativoException e) {
            e.getMessage();
        }
    }

    @Test
    public void mostrarListaRestosCercanosTest()  {
        Restaurant laFarola = new Restaurant();
        laFarola.setId(1L);
        laFarola.setNombre("La Farola");
        laFarola.setLatitudResto(-34.647658);
        laFarola.setLongitudResto(-58.628743);
        Restaurant tioDue= new Restaurant();
        tioDue.setNombre("Tio Due");
        tioDue.setId(2L);
        tioDue.setLatitudResto(-34.645704);
        tioDue.setLongitudResto(-58.640903);
        Restaurant noi= new Restaurant();
        noi.setNombre("Noi");
        noi.setId(3L);
        noi.setLatitudResto(-34.647503);
        noi.setLongitudResto(-58.629588);


        Menu menu1 = new Menu();
        laFarola.setMenu(menu1);
        tioDue.setMenu(menu1);
        noi.setMenu(menu1);

        Usuario jose = new Usuario();
        jose.setId(1L);
        jose.setLatitud(-34.647858);
        jose.setLongitud(-58.62861);

        List<Restaurant> listita = new ArrayList();

        listita.add(laFarola);
        listita.add(tioDue);
        listita.add(noi);

        Mockito.when(repositorioRestaurant.consultarRestaurant(1L)).thenReturn(laFarola);
        Mockito.when(repositorioRestaurant.consultarRestaurant(2L)).thenReturn(tioDue);
        Mockito.when(repositorioRestaurant.consultarRestaurant(3L)).thenReturn(noi);
        Mockito.when(repositorioRestaurant.consultarListaRestos()).thenReturn(listita);

        List<Restaurant> listitaCercanos= new ArrayList();
        listitaCercanos.add(laFarola);
        listitaCercanos.add(noi);

        try {

            assertThat(servicioMapa.sacarDistancia(laFarola,jose)).isEqualTo(25);
            assertThat(servicioMapa.sacarDistancia(tioDue,jose)).isEqualTo(1150);
            assertThat(servicioMapa.sacarDistancia(noi,jose)).isEqualTo(97);
            assertThat(servicioMapa.mostrarRestosMasCercanos(jose, 100)).isEqualTo(listitaCercanos);
            assertThat(servicioMapa.mostrarRestosMasCercanos(jose, 100).size()).isEqualTo(2);
        } catch (ResultadoNegativoException e) {
            e.getMessage();
        }
    }
}
