package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.exception.ResultadoNegativoException;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioMapa;


@Controller
public class ControladorMapa {

	private ServicioMapa servicioMapa;
	private ServicioLogin servicioLogin;

	@Autowired
	public ControladorMapa(ServicioMapa servicioMapa, ServicioLogin servicioLogin) {
		this.servicioMapa = servicioMapa;
		this.servicioLogin = servicioLogin;
	}

	@RequestMapping(path = "/mapa", method = RequestMethod.GET)
	public ModelAndView mostrarMapa(HttpServletRequest request) {
		ModelMap model = new ModelMap();
		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
		model.put("usuario", usuarioBuscado.getEmail());
		return new ModelAndView("distancia", model);

	}

	@RequestMapping(path = "/mapa/modificar-ubicacion", method = RequestMethod.POST)

	public ModelAndView cambiarUbicacion(String ubicacion, Integer radioEnM, Double latitud, Double longitud,
			HttpServletRequest request) {
		List<Restaurant> listaRestosCercanos = new ArrayList();

		ModelMap model = new ModelMap();
		Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
		usuarioBuscado.setLatitud(latitud);
		usuarioBuscado.setLongitud(longitud);
		try {
			listaRestosCercanos = servicioMapa.mostrarRestosMasCercanos(usuarioBuscado, radioEnM);

		} catch (ResultadoNegativoException e) {
			e.printStackTrace();
			model.put("mensaje", e.getMessage());
		}

		model.put("listado", listaRestosCercanos);
		model.put("radioEnM", radioEnM);
		model.put("direccion", ubicacion);
		model.put("usuario", usuarioBuscado.getEmail());

		return new ModelAndView("modificarDistancia", model);
	}

}
