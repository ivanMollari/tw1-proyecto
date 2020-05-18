package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.servicios.ServicioRestaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ControladorRestaurant {

    private ServicioRestaurant servicioRestaurant;

    @Autowired
    public ControladorRestaurant(ServicioRestaurant servicioRestaurant){
        this.servicioRestaurant = servicioRestaurant;
    }

    @RequestMapping(path = "/restaurant/menu/{id}",method = RequestMethod.GET)
    public ModelAndView mostrarMenu(@PathVariable Long id) {
        ModelMap modelo = new ModelMap();
        Menu menuBuscado = servicioRestaurant.consultarMenu(id);
        modelo.put("menu",menuBuscado);
        return new ModelAndView("menu", modelo);
    }
}
