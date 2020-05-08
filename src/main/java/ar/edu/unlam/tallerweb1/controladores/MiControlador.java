package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioMayusculaNombre;


@Controller
public class MiControlador{
	
	
	/*@RequestMapping(path="/saludar", method = RequestMethod.GET)
	public ModelAndView saludar(@RequestParam("nombre")String nombre) {
		ModelMap model = new ModelMap();// cominica al controlador con la vista.
		model.put("nombre",nombre.toUpperCase());
		return new ModelAndView( "saludo", model);
	}*/
	@RequestMapping(path="/saludar", method = RequestMethod.GET)
	public ModelAndView saludar() {
		String valor=ServicioMayusculaNombre.cambiarAmayuscula("ivan");
		ModelMap model = new ModelMap();
		model.put("nombre",valor);
		return new ModelAndView("saludo",model);
	}
}