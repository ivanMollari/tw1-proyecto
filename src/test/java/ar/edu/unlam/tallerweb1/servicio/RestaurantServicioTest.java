package ar.edu.unlam.tallerweb1.servicio;
import ar.edu.unlam.tallerweb1.modelo.Bebida;
import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.Entrada;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Postre;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void consultarMenuCompleto() {
    	Comida comida1 = new Comida();
    	comida1.setId(1L);
    	Comida comida2 = new Comida();
    	comida2.setId(2L);
    	Entrada entrada1 = new Entrada();
    	entrada1.setId(1L);
    	Entrada entrada2 = new Entrada();
    	entrada2.setId(2L);
    	Bebida bebida1 = new Bebida();
    	bebida1.setId(1L);
    	Bebida bebida2 = new Bebida();
    	bebida2.setId(2L);
    	Postre postre1 = new Postre();
    	postre1.setId(1L);
    	Postre postre2 = new Postre();
    	postre2.setId(2L);
    	Menu menu = new Menu();
    	menu.setId(1L);
    	
    	List<ItemMenu> comidas = new ArrayList();
    	comidas.add(comida1);
    	comidas.add(comida2);
    	List<ItemMenu> entradas = new ArrayList();
    	entradas.add(entrada1);
    	entradas.add(entrada2);
    	List<ItemMenu> bebidas = new ArrayList();
    	bebidas.add(bebida1);
    	bebidas.add(bebida2);
    	List<ItemMenu> postres = new ArrayList();
    	postres.add(postre1);
    	postres.add(postre2);
    	
    	when(servicioComida.getComidasByMenuId(menu.getId())).thenReturn(comidas);
    	when(servicioEntrada.getEntradasByMenuId(menu.getId())).thenReturn(entradas);
    	when(servicioBebida.getBebidasByMenuId(menu.getId())).thenReturn(bebidas);
    	when(servicioPostre.getPostresByMenuId(menu.getId())).thenReturn(postres);
    	
    	Map<String, List<ItemMenu>> menuCompleto = new HashMap<>();
    	menuCompleto.put("Comidas", comidas);
        menuCompleto.put("Bebidas", bebidas);
        menuCompleto.put("Entradas", entradas);
        menuCompleto.put("Postres", postres);
        
        List<ItemMenu> comidaAux = menuCompleto.get("Comidas");
        List<ItemMenu> entradaAux = menuCompleto.get("Entradas");
        List<ItemMenu> bebidaAux = menuCompleto.get("Bebidas");
        List<ItemMenu> postreAux = menuCompleto.get("Postres");
        
        
        
        assertThat(menuCompleto.size()).isEqualTo(4);
        assertThat(comidaAux.size()).isEqualTo(2);
        assertThat(entradaAux.size()).isEqualTo(2);
        assertThat(bebidaAux.size()).isEqualTo(2);
        assertThat(postreAux.size()).isEqualTo(2);
    }


}
