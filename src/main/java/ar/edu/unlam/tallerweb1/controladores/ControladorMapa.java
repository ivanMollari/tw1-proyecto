package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ResultadoNegativoException;
import ar.edu.unlam.tallerweb1.servicios.ServicioMapa;



@Controller
public class ControladorMapa{

    private ServicioMapa servicioMapa;

    @Autowired
    public ControladorMapa(ServicioMapa servicioMapa){
        this.servicioMapa = servicioMapa;
    }

	@RequestMapping(path = "/{idUsuario}/{latitud}/{longitud}/{radioEnM}", method = RequestMethod.GET)
	public ModelAndView mostrarLista(@PathVariable(value = "idUsuario") Long idUsuario,
									 @PathVariable(value = "latitud") Double latitud,
									 @PathVariable(value = "longitud") Double longitud,
									 @PathVariable(value = "radioEnM") Integer radioEnM
	) {


		Usuario usuarioBuscado = servicioMapa.consultarUsuario(idUsuario);

		List<Restaurant> listaRestosCercanos= new ArrayList();
		try {
			if (usuarioBuscado!=null) {
				usuarioBuscado.setLongitud(longitud);
				usuarioBuscado.setLatitud(latitud);
				listaRestosCercanos = servicioMapa.mostrarRestosMasCercanos(usuarioBuscado, radioEnM);
			}

		} catch (ResultadoNegativoException e) {
			e.printStackTrace();
		}

		ModelMap model = new ModelMap();
		model.put("listado", listaRestosCercanos);
		model.put("usuario", usuarioBuscado);



		return new ModelAndView("distancia", model);

	}

	@RequestMapping(path = "/{idUsuario}/{direccion}/{radioEnKm}", method = RequestMethod.GET)
	public ModelAndView mostrarLista2(@PathVariable(value = "idUsuario") Long idUsuario,
									  @PathVariable(value = "radioEnKm") Integer radioEnKm, @PathVariable(value = "direccion") String direccion) {

		Usuario usuarioBuscado = servicioMapa.consultarUsuario(idUsuario);

		List<Restaurant> listaRestosCercanos = new ArrayList();
		try {
			listaRestosCercanos = servicioMapa.mostrarRestosMasCercanos(usuarioBuscado, radioEnKm);
		} catch (ResultadoNegativoException e) {
			e.printStackTrace();
		}

		ModelMap model = new ModelMap();
		model.put("listado", listaRestosCercanos);
		model.put("usuario", usuarioBuscado);
		model.put("direccion", direccion);

		return new ModelAndView("distancia", model);

	}
}
