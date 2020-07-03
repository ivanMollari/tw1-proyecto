package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
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

	@RequestMapping(path = "/restaurant/{id}/entrada", method = RequestMethod.POST)
	public ModelAndView listaEntradas(@PathVariable(value = "id") Long id, @ModelAttribute("entrada") Entrada entrada,
			HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		Comida comida = new Comida();
		Bebida bebida = new Bebida();
		Postre postre = new Postre();

		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
		Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
		Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());

		RequestPedido requestPedido;

		if (request.getSession().getAttribute("requestPedido") == null) {
			requestPedido = new RequestPedido();
			request.getSession().setAttribute("requestPedido", requestPedido);
		} else {
			requestPedido = (RequestPedido) request.getSession().getAttribute("requestPedido");
		}

		if (entrada != null && id != null) {
			requestPedido.agregarPedido(entrada);
			requestPedido.agregarComida(entrada);
			requestPedido.setId_restaurant(id);
			requestPedido.sumarTotal(entrada);
			requestPedido.setUsuario(usuarioBuscado);
		}

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

	@RequestMapping(path = "/restaurant/{id}/comida", method = RequestMethod.POST)
	public ModelAndView listaComidas(@PathVariable(value = "id") Long id, @ModelAttribute("comida") Comida comida,
			HttpServletRequest request) {

		ModelMap modelo = new ModelMap();
		Entrada entrada = new Entrada();
		Bebida bebida = new Bebida();
		Postre postre = new Postre();

		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));

		Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
		Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());

		RequestPedido requestPedido;
		if (request.getSession().getAttribute("requestPedido") == null) {
			requestPedido = new RequestPedido();
			request.getSession().setAttribute("requestPedido", requestPedido);

		} else {
			requestPedido = (RequestPedido) request.getSession().getAttribute("requestPedido");

		}

		if (comida != null && comida.getId() != null) {

			requestPedido.agregarPedido(comida);
			requestPedido.agregarComida(comida);
			requestPedido.setId_restaurant(id);
			requestPedido.sumarTotal(comida);
			requestPedido.setUsuario(usuarioBuscado);
		}

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

	@RequestMapping(path = "/restaurant/{id}/bebida", method = RequestMethod.POST)
	public ModelAndView listaBebidas(@PathVariable(value = "id") Long id, @ModelAttribute("bebida") Bebida bebida,
			HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		Comida comida = new Comida();
		Entrada entrada = new Entrada();
		Postre postre = new Postre();

		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
		Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
		Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());

		RequestPedido requestPedido;

		if (request.getSession().getAttribute("requestPedido") == null) {
			requestPedido = new RequestPedido();
			request.getSession().setAttribute("requestPedido", requestPedido);
		} else {
			requestPedido = (RequestPedido) request.getSession().getAttribute("requestPedido");
		}

		if (bebida != null && id != null) {
			requestPedido.agregarPedido(bebida);
			requestPedido.agregarComida(bebida);
			requestPedido.setId_restaurant(id);
			requestPedido.sumarTotal(bebida);
			requestPedido.setUsuario(usuarioBuscado);
		}

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

	@RequestMapping(path = "/restaurant/{id}/postre", method = RequestMethod.POST)
	public ModelAndView listaPostres(@PathVariable(value = "id") Long id, @ModelAttribute("postre") Postre postre,
			HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		Comida comida = new Comida();
		Entrada entrada = new Entrada();
		Bebida bebida = new Bebida();
		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
		Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
		Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());

		RequestPedido requestPedido;

		if (request.getSession().getAttribute("requestPedido") == null) {
			requestPedido = new RequestPedido();
			request.getSession().setAttribute("requestPedido", requestPedido);
		} else {
			requestPedido = (RequestPedido) request.getSession().getAttribute("requestPedido");
		}

		if (postre != null && id != null) {
			requestPedido.agregarPedido(postre);
			requestPedido.agregarComida(postre);
			requestPedido.setId_restaurant(id);
			requestPedido.sumarTotal(postre);
			requestPedido.setUsuario(usuarioBuscado);
		}
		requestPedido.getIdUsuario();

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
	public ModelAndView hacerPedido(@PathVariable(value = "idResto") Long id,
			@ModelAttribute("requestPedido") RequestPedido requestPedido, HttpServletRequest request) {

		ModelMap modelo = new ModelMap();
		Pedido pedido = new Pedido();
		Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
		List<Comida> comidas = new ArrayList<>();
		List<Entrada> entradas = new ArrayList<>();
		List<Postre> postres = new ArrayList<>();
		List<Bebida> bebidas = new ArrayList<>();
		Comida comida;
		Bebida bebida;
		Postre postre;
		Entrada entrada;
		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));

		//pedido.agregarComidas(obtenerComidas(requestPedido.getIdConmidas()));
		pedido.agregarEntrasdas(obtenerComidas(requestPedido.getIdEntradas()));
		
		if (requestPedido.getIdBebidas().size() > 0)
			for (Long idBebida : requestPedido.getIdBebidas()) {
				bebida = servicioRestaurant.consultarBebida(idBebida);
				bebidas.add(bebida);
			}

		if (requestPedido.getIdPostres().size() > 0)
			for (Long idPostre : requestPedido.getIdPostres()) {
				postre = servicioRestaurant.consultarPostre(idPostre);
				postres.add(postre);
			}



		pedido.setUsuario(usuarioBuscado);
		pedido.setRestaurant(restaurant);
		pedido.setTotal(requestPedido.getTotal());
		Integer statusCode = servicioRestaurant.crearPedido(pedido);
		if (statusCode == 201) {
			modelo.put("statusCode", statusCode);
			modelo.put("idRestaurant", restaurant.getId());
			return new ModelAndView("pedidoRespuesta", modelo);
		}
		return new ModelAndView("pedido");

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
