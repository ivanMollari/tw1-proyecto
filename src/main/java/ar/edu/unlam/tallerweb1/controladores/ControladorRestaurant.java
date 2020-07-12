package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.modelo.dto.RequestPedido;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;
import ar.edu.unlam.tallerweb1.servicios.ServicioRestaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class ControladorRestaurant {

	private ServicioRestaurant servicioRestaurant;
	private ServicioLogin servicioLogin;
	private ServicioPedido servicioPedido;

	@Autowired
	public ControladorRestaurant(ServicioRestaurant servicioRestaurant, ServicioLogin servicioLogin,ServicioPedido servicioPedido) {
		this.servicioRestaurant = servicioRestaurant;
		this.servicioLogin = servicioLogin;
		this.servicioPedido = servicioPedido;
	}

	@RequestMapping(path = "/restaurant/{id}", method = RequestMethod.GET)
	public ModelAndView mostrarRestaurant(@PathVariable(value = "id") Long id, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Entrada entrada = new Entrada();
		Comida comida = new Comida();
		Bebida bebida = new Bebida();
		Postre postre = new Postre();
		RequestPedido requestPedido = new RequestPedido();
		Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
		Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());
		modelo.put("menu", restaurant.getMenu());
		modelo.put("restaurant", restaurant);
		modelo.put("comida", comida);
		modelo.put("items", ListaItems);
		modelo.put("entrada", entrada);
		modelo.put("bebida", bebida);
		modelo.put("postre", postre);
		modelo.put("requestPedido", requestPedido);
		modelo.put("usuario",usuarioBuscado.getEmail());
		
		return new ModelAndView("restaurant", modelo);
	}

	@RequestMapping(path = "/restaurant/{idResto}/entrada", method = RequestMethod.POST)
	public ModelAndView listaEntradas(@PathVariable(value = "idResto") Long idResto,
			@ModelAttribute("entrada") Entrada entrada, HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		Comida comida = new Comida();
		Bebida bebida = new Bebida();
		Postre postre = new Postre();

		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
		Restaurant restaurant = servicioRestaurant.consultarRestaurant(idResto);
		Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());

		RequestPedido requestPedido;

		requestPedido = obtenerRequestPedido(request);

		requestPedido.armarPedido(entrada, idResto, usuarioBuscado);

		modelo.put("menu", restaurant.getMenu());
		modelo.put("requestPedido", requestPedido);
		modelo.put("restaurant", restaurant);
		modelo.put("items", ListaItems);
		modelo.put("pedidos", requestPedido.getPedido());
		modelo.put("comida", comida);
		modelo.put("bebida", bebida);
		modelo.put("postre", postre);
		modelo.put("total", requestPedido.getTotal());
		modelo.put("usuario",usuarioBuscado.getEmail());
		return new ModelAndView("restaurant", modelo);
	}
	

	@RequestMapping(path = "/restaurant/{idResto}/comida", method = RequestMethod.POST)
	public ModelAndView listaComidas(@PathVariable(value = "idResto") Long idResto,
			@ModelAttribute("comida") Comida comida, HttpServletRequest request) {

		ModelMap modelo = new ModelMap();
		Entrada entrada = new Entrada();
		Bebida bebida = new Bebida();
		Postre postre = new Postre();

		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));

		Restaurant restaurant = servicioRestaurant.consultarRestaurant(idResto);
		Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());

		RequestPedido requestPedido;
		requestPedido = obtenerRequestPedido(request);

		requestPedido.armarPedido(comida, idResto, usuarioBuscado);

		modelo.put("menu", restaurant.getMenu());
		modelo.put("requestPedido", requestPedido);
		modelo.put("pedidos", requestPedido.getPedido());
		modelo.put("restaurant", restaurant);
		modelo.put("items", ListaItems);
		modelo.put("entrada", entrada);
		modelo.put("bebida", bebida);
		modelo.put("postre", postre);
		modelo.put("total", requestPedido.getTotal());
		modelo.put("usuario",usuarioBuscado.getEmail());
		return new ModelAndView("restaurant", modelo);
	}

	@RequestMapping(path = "/restaurant/{idResto}/bebida", method = RequestMethod.POST)
	public ModelAndView listaBebidas(@PathVariable(value = "idResto") Long idResto,
			@ModelAttribute("bebida") Bebida bebida, HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		Comida comida = new Comida();
		Entrada entrada = new Entrada();
		Postre postre = new Postre();

		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
		Restaurant restaurant = servicioRestaurant.consultarRestaurant(idResto);
		Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());

		RequestPedido requestPedido;

		requestPedido = obtenerRequestPedido(request);

		requestPedido.armarPedido(bebida, idResto, usuarioBuscado);

		modelo.put("menu", restaurant.getMenu());
		modelo.put("requestPedido", requestPedido);
		modelo.put("restaurant", restaurant);
		modelo.put("items", ListaItems);
		modelo.put("pedidos", requestPedido.getPedido());
		modelo.put("comida", comida);
		modelo.put("entrada", entrada);
		modelo.put("postre", postre);
		modelo.put("total", requestPedido.getTotal());
		modelo.put("usuario",usuarioBuscado.getEmail());
		return new ModelAndView("restaurant", modelo);
	}

	@RequestMapping(path = "/restaurant/{idResto}/postre", method = RequestMethod.POST)
	public ModelAndView listaPostres(@PathVariable(value = "idResto") Long idResto,
			@ModelAttribute("postre") Postre postre, HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		Comida comida = new Comida();
		Entrada entrada = new Entrada();
		Bebida bebida = new Bebida();
		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
		Restaurant restaurant = servicioRestaurant.consultarRestaurant(idResto);
		Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());

		RequestPedido requestPedido;

		requestPedido = obtenerRequestPedido(request);

		requestPedido.armarPedido(postre, idResto, usuarioBuscado);

		modelo.put("menu", restaurant.getMenu());
		modelo.put("requestPedido", requestPedido);
		modelo.put("restaurant", restaurant);
		modelo.put("items", ListaItems);
		modelo.put("pedidos", requestPedido.getPedido());
		modelo.put("comida", comida);
		modelo.put("entrada", entrada);
		modelo.put("bebida", bebida);
		modelo.put("total", requestPedido.getTotal());
		modelo.put("usuario",usuarioBuscado.getEmail());
		return new ModelAndView("restaurant", modelo);
	}

	@RequestMapping(path = "/restaurant/{idResto}/pedido", method = RequestMethod.POST)
	public ModelAndView hacerPedido(@PathVariable(value = "idResto") Long id,
			@ModelAttribute("requestPedido") RequestPedido requestPedido, HttpServletRequest request) {

		ModelMap modelo = new ModelMap();
		Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
		requestPedido.setUsuario(servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario")));

		Pedido pedido = servicioRestaurant.armarPedido(requestPedido, restaurant);
		List<ItemMenu> listaPedido = servicioRestaurant.mostrarPedido(pedido);

		servicioRestaurant.crearPedido(pedido);
		modelo.put("pedido", pedido);
		modelo.put("total", requestPedido.getTotal());
		modelo.put("restaurant", restaurant);
		modelo.put("listaPedido", listaPedido);
		modelo.put("usuario",usuarioBuscado.getEmail());
		return new ModelAndView("pedidoRespuesta", modelo);

	}

	@RequestMapping(path = "/restaurant/buscar", method = RequestMethod.GET)
	public ModelAndView buscarRestaurants(@RequestParam String searchText,HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
		List<Restaurant> listaResto = servicioRestaurant.buscarRestaurants(searchText);
		modelo.put("listaResto", listaResto);
		modelo.put("usuario",usuarioBuscado.getEmail());
		return new ModelAndView("buscarResto", modelo);
	}
	
	@RequestMapping(path= "/mis-pedidos")
	public ModelAndView mostrarPedidosUsuario(HttpServletRequest request) {
		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
		List<Pedido> listita = servicioPedido.mostrarPedidosUsuario(usuarioBuscado);
		List<List<ItemMenu>> listaPedido = new ArrayList<List<ItemMenu>>();
		ModelMap modelo = new ModelMap();
		
		for(Pedido aux: listita) {
			List<ItemMenu> pedido = servicioRestaurant.mostrarPedido(aux);
			listaPedido.add(pedido);
		}
		
		modelo.put("listita",listaPedido);
		modelo.put("usuario",usuarioBuscado.getEmail());
		return new ModelAndView("prueba",modelo);
	}

	private RequestPedido obtenerRequestPedido(HttpServletRequest request) {
		RequestPedido requestPedido;
		if (request.getSession().getAttribute("requestPedido") == null) {
			requestPedido = new RequestPedido();
			request.getSession().setAttribute("requestPedido", requestPedido);

		} else {
			requestPedido = (RequestPedido) request.getSession().getAttribute("requestPedido");

		}
		return requestPedido;
	}

}
