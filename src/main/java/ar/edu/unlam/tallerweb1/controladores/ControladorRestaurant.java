package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.modelo.dto.RequestPedido;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioRestaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class ControladorRestaurant {

	private ServicioRestaurant servicioRestaurant;
	private ServicioLogin servicioLogin;


	@Autowired
	public ControladorRestaurant(ServicioRestaurant servicioRestaurant, ServicioLogin servicioLogin) {
		this.servicioRestaurant = servicioRestaurant;
		this.servicioLogin = servicioLogin;
	}


	@RequestMapping(path = "/restaurant/{id}", method = RequestMethod.GET)
	public ModelAndView mostrarRestaurant(@PathVariable(value = "id") Long id) {
		ModelMap modelo = new ModelMap();
		Entrada entrada = new Entrada();
		Comida comida = new Comida();
		Bebida bebida = new Bebida();
		Postre postre = new Postre();
		RequestPedido requestPedido = new RequestPedido();
		Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
		Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());
		modelo.put("menu", restaurant.getMenu());
		modelo.put("restaurant", restaurant);
		modelo.put("comida", comida);
		modelo.put("items", ListaItems);
		modelo.put("entrada", entrada);
		modelo.put("bebida", bebida);
		modelo.put("postre", postre);
		modelo.put("requestPedido", requestPedido);


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

		if (request.getSession().getAttribute("requestPedido") == null) {
			requestPedido = new RequestPedido();
			request.getSession().setAttribute("requestPedido", requestPedido);
		} else {
			requestPedido = (RequestPedido) request.getSession().getAttribute("requestPedido");
		}

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
		return new ModelAndView("restaurant", modelo);
	}

	@RequestMapping(path = "/restaurant/{idResto}/comida", method = RequestMethod.POST)
	public ModelAndView listaComidas(@PathVariable(value = "idResto") Long idResto
			, @ModelAttribute("comida") Comida comida, HttpServletRequest request) {


		ModelMap modelo = new ModelMap();
		Entrada entrada = new Entrada();
		Bebida bebida = new Bebida();
		Postre postre = new Postre();

		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));

		Restaurant restaurant = servicioRestaurant.consultarRestaurant(idResto);
		Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());

		RequestPedido requestPedido;
		if (request.getSession().getAttribute("requestPedido") == null) {
			requestPedido = new RequestPedido();
			request.getSession().setAttribute("requestPedido", requestPedido);

		} else {
			requestPedido = (RequestPedido) request.getSession().getAttribute("requestPedido");

		}

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

		if (request.getSession().getAttribute("requestPedido") == null) {
			requestPedido = new RequestPedido();
			request.getSession().setAttribute("requestPedido", requestPedido);
		} else {
			requestPedido = (RequestPedido) request.getSession().getAttribute("requestPedido");
		}

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

		if (request.getSession().getAttribute("requestPedido") == null) {
			requestPedido = new RequestPedido();
			request.getSession().setAttribute("requestPedido", requestPedido);
		} else {
			requestPedido = (RequestPedido) request.getSession().getAttribute("requestPedido");
		}


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
		return new ModelAndView("restaurant", modelo);
	}


	@RequestMapping(path = "/restaurant/{idResto}/pedido", method = RequestMethod.POST)
	public ModelAndView hacerPedido(@PathVariable(value = "idResto") Long id, @ModelAttribute("requestPedido") RequestPedido requestPedido, HttpServletRequest request) {

		ModelMap modelo = new ModelMap();
		Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
		requestPedido.setUsuario(servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario")));
		//pedido.agregarComidas(obtenerComidas(requestPedido.getIdConmidas()));
		//pedido.agregarEntrasdas(obtenerComidas(requestPedido.getIdEntradas()));
		Pedido pedido = servicioRestaurant.armarPedido(requestPedido, restaurant);

		servicioRestaurant.crearPedido(pedido);
		modelo.put("pedido", pedido);

		return new ModelAndView("pedidoRespuesta", modelo);

	}


	private List<ItemMenu> obtenerComidas(List<Long> ids) {
		List<ItemMenu> comidas = new LinkedList<>();
		ItemMenu comida;

		for (Long idEntrada : ids) {
			comida = servicioRestaurant.consultarEntrada(idEntrada);
			comidas.add(comida);


		}
		return comidas;
	}
	@RequestMapping(path = "/restaurant/buscar", method = RequestMethod.GET)
	public ModelAndView buscarRestaurants(@RequestParam String searchText) {
		ModelMap modelo = new ModelMap();

		List<Restaurant> listaResto = servicioRestaurant.buscarRestaurants(searchText);
		modelo.put("listaResto", listaResto);


		return new ModelAndView("buscarResto", modelo);
	}


}


