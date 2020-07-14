package ar.edu.unlam.tallerweb1.controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorRestaurant;
import ar.edu.unlam.tallerweb1.modelo.Bebida;
import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.Entrada;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Postre;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.dto.RequestPedido;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RestaurantControllerTest {

    ServicioRestaurant servicioRestaurant= Mockito.mock(ServicioRestaurantImpl.class);
    ServicioPedido servicioPedido= Mockito.mock(ServicioPedido.class);
	ServicioLogin servicioLogin = Mockito.mock(ServicioLogin.class);
	ServicioMapa servicioMapa = Mockito.mock(ServicioMapa.class);
    ControladorRestaurant instancia=new ControladorRestaurant(servicioRestaurant,servicioLogin,servicioPedido, servicioMapa);

    @Test
    public void consultarRestaurant() {

        //given:
    	HttpServletRequest requestMock=mock(HttpServletRequest.class);
    	HttpSession sessionMock = mock(HttpSession.class);
        Restaurant restaurant=new Restaurant();
        restaurant.setId(1L);
        Menu menu=new Menu();
        menu.setDescripcion("soy una descripcion");
        restaurant.setMenu(menu);
        Usuario pepe = mock(Usuario.class);

        when( servicioRestaurant.consultarRestaurant(restaurant.getId())).thenReturn(restaurant);
    	when(requestMock.getSession()).thenReturn(sessionMock);
    	when(servicioLogin.buscarUsuario((Long)requestMock.getSession().getAttribute("idUsuario"))).thenReturn(pepe);

        //when:
        ModelAndView resultado=instancia.mostrarRestaurant(1L,requestMock);

        //then:
        assertThat(resultado).isNotNull();
    }

    @Test
    public void testmuestraVistaRestaurant() {
    	HttpServletRequest requestMock=mock(HttpServletRequest.class);
    	HttpSession sessionMock = mock(HttpSession.class);
    	Restaurant resto = new Restaurant();
    	Menu menu = new Menu();
    	resto.setMenu(menu);
    	resto.setNombre("La Farola");
    	Usuario pepe = mock(Usuario.class);
    	Map<String, List<ItemMenu>> menuCompleto =mock(Map.class);
    	when( servicioRestaurant.consultarRestaurant(resto.getId())).thenReturn(resto);
    	when(servicioRestaurant.consultarMenuCompleto(resto.getMenu().getId())).thenReturn(menuCompleto);
    	when(requestMock.getSession()).thenReturn(sessionMock);
    	when(servicioLogin.buscarUsuario((Long)requestMock.getSession().getAttribute("idUsuario"))).thenReturn(pepe);

    	ModelAndView modelAndView = instancia.mostrarRestaurant(resto.getId(),requestMock);

    	assertThat(modelAndView).isNotNull();
    	assertThat(modelAndView.getViewName()).isEqualTo("restaurant");
    	assertThat(modelAndView.getModel()).containsKey("menu");
    	assertThat(modelAndView.getModel().get("menu")).isEqualTo(resto.getMenu());
    	assertThat(modelAndView.getModel()).containsKey("restaurant");
    	assertThat(modelAndView.getModel().get("restaurant")).isEqualTo(resto);
    	assertThat(modelAndView.getModel()).containsKey("items");
    	assertThat(modelAndView.getModel().get("items")).isEqualTo(menuCompleto);
    }


    @Test
    public void testlistaEntradas() {
    	HttpServletRequest requestMock=mock(HttpServletRequest.class);
    	HttpSession sessionMock = mock(HttpSession.class);
    	Usuario pepe = mock(Usuario.class);
    	Restaurant resto = new Restaurant();
    	Menu menu = mock(Menu.class);
    	resto.setNombre("La Farola");
    	resto.setMenu(menu);
    	Entrada entrada = new Entrada();
    	RequestPedido requestPedido = mock(RequestPedido.class);
    	Map<String, List<ItemMenu>> menuCompleto =mock(Map.class);

		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioLogin.buscarUsuario((Long)requestMock.getSession().getAttribute("idUsuario"))).thenReturn(pepe);
		when(servicioRestaurant.consultarRestaurant(resto.getId())).thenReturn(resto);
		when(servicioRestaurant.consultarMenuCompleto(resto.getMenu().getId())).thenReturn(menuCompleto);
		when(requestMock.getSession().getAttribute("requestPedido")).thenReturn(requestPedido);


		ModelAndView modelAndView = instancia.listaEntradas(resto.getId(), entrada, requestMock);

		verify(requestPedido, times(1)).armarPedido(entrada, resto.getId(), pepe);
		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("restaurant");
    	assertThat(modelAndView.getModel()).containsKey("menu");
    	assertThat(modelAndView.getModel().get("menu")).isEqualTo(resto.getMenu());
    	assertThat(modelAndView.getModel()).containsKey("restaurant");
    	assertThat(modelAndView.getModel().get("restaurant")).isEqualTo(resto);
    	assertThat(modelAndView.getModel()).containsKey("items");
    	assertThat(modelAndView.getModel().get("items")).isEqualTo(menuCompleto);
    	assertThat(modelAndView.getModel()).containsKey("requestPedido");
    	assertThat(modelAndView.getModel().get("requestPedido")).isEqualTo(requestPedido);
    	assertThat(modelAndView.getModel()).containsKey("total");
    	assertThat(modelAndView.getModel().get("total")).isEqualTo(requestPedido.getTotal());
    }

    @Test
    public void testlistaComidas() {
    	HttpServletRequest requestMock=mock(HttpServletRequest.class);
    	HttpSession sessionMock = mock(HttpSession.class);
    	Usuario pepe = mock(Usuario.class);
    	Restaurant resto = new Restaurant();
    	Menu menu = mock(Menu.class);
    	resto.setNombre("La Farola");
    	resto.setMenu(menu);
    	Comida comida = new Comida();
    	RequestPedido requestPedido = mock(RequestPedido.class);
    	Map<String, List<ItemMenu>> menuCompleto =mock(Map.class);

		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioLogin.buscarUsuario((Long)requestMock.getSession().getAttribute("idUsuario"))).thenReturn(pepe);
		when(servicioRestaurant.consultarRestaurant(resto.getId())).thenReturn(resto);
		when(servicioRestaurant.consultarMenuCompleto(resto.getMenu().getId())).thenReturn(menuCompleto);
		when(requestMock.getSession().getAttribute("requestPedido")).thenReturn(requestPedido);


		ModelAndView modelAndView = instancia.listaComidas(resto.getId(), comida, requestMock);

		verify(requestPedido, times(1)).armarPedido(comida, resto.getId(), pepe);
		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("restaurant");
    	assertThat(modelAndView.getModel()).containsKey("menu");
    	assertThat(modelAndView.getModel().get("menu")).isEqualTo(resto.getMenu());
    	assertThat(modelAndView.getModel()).containsKey("restaurant");
    	assertThat(modelAndView.getModel().get("restaurant")).isEqualTo(resto);
    	assertThat(modelAndView.getModel()).containsKey("items");
    	assertThat(modelAndView.getModel().get("items")).isEqualTo(menuCompleto);
    	assertThat(modelAndView.getModel()).containsKey("requestPedido");
    	assertThat(modelAndView.getModel().get("requestPedido")).isEqualTo(requestPedido);
    	assertThat(modelAndView.getModel()).containsKey("total");
    	assertThat(modelAndView.getModel().get("total")).isEqualTo(requestPedido.getTotal());
    }

    @Test
    public void testlistaBebidas() {
    	HttpServletRequest requestMock=mock(HttpServletRequest.class);
    	HttpSession sessionMock = mock(HttpSession.class);
    	Usuario pepe = mock(Usuario.class);
    	Restaurant resto = new Restaurant();
    	Menu menu = mock(Menu.class);
    	resto.setNombre("La Farola");
    	resto.setMenu(menu);
    	Bebida bebida = new Bebida();
    	RequestPedido requestPedido = mock(RequestPedido.class);
    	Map<String, List<ItemMenu>> menuCompleto =mock(Map.class);

		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioLogin.buscarUsuario((Long)requestMock.getSession().getAttribute("idUsuario"))).thenReturn(pepe);
		when(servicioRestaurant.consultarRestaurant(resto.getId())).thenReturn(resto);
		when(servicioRestaurant.consultarMenuCompleto(resto.getMenu().getId())).thenReturn(menuCompleto);
		when(requestMock.getSession().getAttribute("requestPedido")).thenReturn(requestPedido);


		ModelAndView modelAndView = instancia.listaBebidas(resto.getId(), bebida, requestMock);

		verify(requestPedido, times(1)).armarPedido(bebida, resto.getId(), pepe);
		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("restaurant");
    	assertThat(modelAndView.getModel()).containsKey("menu");
    	assertThat(modelAndView.getModel().get("menu")).isEqualTo(resto.getMenu());
    	assertThat(modelAndView.getModel()).containsKey("restaurant");
    	assertThat(modelAndView.getModel().get("restaurant")).isEqualTo(resto);
    	assertThat(modelAndView.getModel()).containsKey("items");
    	assertThat(modelAndView.getModel().get("items")).isEqualTo(menuCompleto);
    	assertThat(modelAndView.getModel()).containsKey("requestPedido");
    	assertThat(modelAndView.getModel().get("requestPedido")).isEqualTo(requestPedido);
    	assertThat(modelAndView.getModel()).containsKey("total");
    	assertThat(modelAndView.getModel().get("total")).isEqualTo(requestPedido.getTotal());
    }

    @Test
    public void testlistaPostres() {
    	HttpServletRequest requestMock=mock(HttpServletRequest.class);
    	HttpSession sessionMock = mock(HttpSession.class);
    	Usuario pepe = mock(Usuario.class);
    	Restaurant resto = new Restaurant();
    	Menu menu = mock(Menu.class);
    	resto.setNombre("La Farola");
    	resto.setMenu(menu);
    	Postre postre = new Postre();
    	RequestPedido requestPedido = mock(RequestPedido.class);
    	Map<String, List<ItemMenu>> menuCompleto =mock(Map.class);

		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioLogin.buscarUsuario((Long)requestMock.getSession().getAttribute("idUsuario"))).thenReturn(pepe);
		when(servicioRestaurant.consultarRestaurant(resto.getId())).thenReturn(resto);
		when(servicioRestaurant.consultarMenuCompleto(resto.getMenu().getId())).thenReturn(menuCompleto);
		when(requestMock.getSession().getAttribute("requestPedido")).thenReturn(requestPedido);


		ModelAndView modelAndView = instancia.listaPostres(resto.getId(), postre, requestMock);

		verify(requestPedido, times(1)).armarPedido(postre, resto.getId(), pepe);
		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("restaurant");
    	assertThat(modelAndView.getModel()).containsKey("menu");
    	assertThat(modelAndView.getModel().get("menu")).isEqualTo(resto.getMenu());
    	assertThat(modelAndView.getModel()).containsKey("restaurant");
    	assertThat(modelAndView.getModel().get("restaurant")).isEqualTo(resto);
    	assertThat(modelAndView.getModel()).containsKey("items");
    	assertThat(modelAndView.getModel().get("items")).isEqualTo(menuCompleto);
    	assertThat(modelAndView.getModel()).containsKey("requestPedido");
    	assertThat(modelAndView.getModel().get("requestPedido")).isEqualTo(requestPedido);
    	assertThat(modelAndView.getModel()).containsKey("total");
    	assertThat(modelAndView.getModel().get("total")).isEqualTo(requestPedido.getTotal());
    }

    @Test
    public void testHacerPedido() {
    	HttpServletRequest requestMock=mock(HttpServletRequest.class);
    	HttpSession sessionMock = mock(HttpSession.class);
    	Usuario pepe = mock(Usuario.class);
    	Restaurant resto = new Restaurant();
    	Menu menu = mock(Menu.class);
    	resto.setNombre("La Farola");
    	resto.setMenu(menu);
    	Pedido pedido = new Pedido();
    	RequestPedido requestPedido = new RequestPedido();
    	List<ItemMenu>listaPedido= mock(List.class);

    	when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioLogin.buscarUsuario((Long)requestMock.getSession().getAttribute("idUsuario"))).thenReturn(pepe);
		when(servicioRestaurant.consultarRestaurant(resto.getId())).thenReturn(resto);
		when(servicioRestaurant.armarPedido(requestPedido, resto)).thenReturn(pedido);
		when(servicioRestaurant.mostrarPedido(pedido)).thenReturn(listaPedido);



		ModelAndView modelAndView = instancia.hacerPedido(resto.getId(), requestPedido, requestMock);

		verify(servicioRestaurant, times(1)).crearPedido(pedido);
		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("pedidoRespuesta");
		assertThat(modelAndView.getModel()).containsKey("pedido");
		assertThat(modelAndView.getModel().get("pedido")).isEqualTo(pedido);
		assertThat(modelAndView.getModel()).containsKey("total");
		assertThat(modelAndView.getModel().get("total")).isEqualTo(requestPedido.getTotal());
		assertThat(modelAndView.getModel()).containsKey("restaurant");
		assertThat(modelAndView.getModel().get("restaurant")).isEqualTo(resto);
		assertThat(modelAndView.getModel()).containsKey("listaPedido");
		assertThat(modelAndView.getModel().get("listaPedido")).isEqualTo(listaPedido);

    }



    @Test
    public void testQueBuscaRestoPorNombre() {
    	List<Restaurant> listaRestos = new ArrayList();
    	Restaurant resto = new Restaurant();
    	HttpServletRequest requestMock=mock(HttpServletRequest.class);
    	HttpSession sessionMock = mock(HttpSession.class);
    	Usuario pepe = mock(Usuario.class);

    	when(servicioRestaurant.buscarRestaurants(resto.getNombre())).thenReturn(listaRestos);
    	when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioLogin.buscarUsuario((Long)requestMock.getSession().getAttribute("idUsuario"))).thenReturn(pepe);

    	ModelAndView modelAndView = instancia.buscarRestaurants(resto.getNombre(),requestMock);

    	assertThat(modelAndView).isNotNull();
    	assertThat(modelAndView.getViewName()).isEqualTo("buscarResto");
    	assertThat(modelAndView.getModel()).containsKey("listaResto");
    	assertThat(modelAndView.getModel().get("listaResto")).isEqualTo(listaRestos);
    }

	@Test
	public void testListarMisPedidosPorUsuario() {
    	Usuario usuario=new Usuario();
    	usuario.setEmail("usuariotest@gmail.com");
		List<Pedido> listaPedidos = new ArrayList();
		Pedido pedido=new Pedido();
		pedido.setComidas(new ArrayList<Comida>());
		Pedido pedido2=new Pedido();
		pedido2.setBebidas(new ArrayList<Bebida>());
		listaPedidos.add(pedido);
		listaPedidos.add(pedido2);
		HttpServletRequest requestMock=mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);
		when(servicioLogin.buscarUsuario(anyLong())).thenReturn(usuario);
		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioPedido.mostrarPedidosUsuario(any())).thenReturn(listaPedidos);

		ModelAndView modelAndView = instancia.mostrarPedidosUsuario(requestMock);

		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("misPedidos");
		assertThat(modelAndView.getModel()).containsKey("listita");
		assertThat(modelAndView.getModel().get("listita")).isEqualTo(listaPedidos);
	}

    /*
    public  void realizarPedido(){
        //given
        HttpServletRequest httpServletRequest=mock(HttpServletRequest.class);
        Integer statusCode=201;
        Pedido pedido=new Pedido();
        when(servicioRestaurant.crearPedido(pedido)).thenReturn(statusCode);

        //when:
        ModelAndView resultado=instancia.hacerPedido(1L,pedido);

        //then
        assertThat(resultado).isNotNull();
    }*/
}
