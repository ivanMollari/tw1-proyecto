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
import ar.edu.unlam.tallerweb1.servicios.ServicioMapa;



@Controller
public class ControladorMapa{
	
    private ServicioMapa servicioMapa;

    @Autowired
    public ControladorMapa(ServicioMapa servicioMapa){
        this.servicioMapa = servicioMapa;
    }
	
	@RequestMapping(path= "/mapa/restos_cercanos/{idUsuario}", method = RequestMethod.GET)
	public ModelAndView mostrarLista(@PathVariable (value="idUsuario") Long idUsuario) {
		
		Usuario usuarioBuscado = servicioMapa.consultarUsuario(idUsuario);
		List<Restaurant> listaRestosCercanos = servicioMapa.mostrarRestosMasCercanos(usuarioBuscado);
		
		
		ModelMap model = new ModelMap();
		model.put("listado",listaRestosCercanos );
		
		return new ModelAndView("distancia",model);
		
		
	}
}