package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioRestaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class ControladorRestaurant {

    private ServicioRestaurant servicioRestaurant;

    @Autowired
    public ControladorRestaurant(ServicioRestaurant servicioRestaurant){
        this.servicioRestaurant = servicioRestaurant;
    }



    @RequestMapping(path = "/restaurant/{id}",method = RequestMethod.GET)
    public ModelAndView mostrarRestaurant(@PathVariable (value="id") Long id) {
        ModelMap modelo = new ModelMap();

        Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
        modelo.put("menu", restaurant.getMenu());
        modelo.put("restaurant", restaurant);

        return new ModelAndView("restaurant", modelo);
    }

    @RequestMapping(path = "/restaurant/{id}/pedido",method = RequestMethod.POST)
    public ModelAndView hacerPedido(@PathVariable (value="id") Long id, @ModelAttribute("pedido") Pedido pedido, HttpServletRequest request) {
        ModelMap modelo = new ModelMap();

        Integer statusCode=servicioRestaurant.crearPedido(pedido);
        modelo.put("statusCode", statusCode);
        return new ModelAndView("pedido", modelo);
    }
    @RequestMapping(path = "/restaurant/comida/{id}/pedido", method = RequestMethod.GET)

    public ModelAndView irPaginaPedidoComida(@PathVariable (value="id") Long id) {

        ModelMap modelo = new ModelMap();
        Comida comidaBuscada=servicioRestaurant.consultarComida(id);
        modelo.put("comida",comidaBuscada);
        return new ModelAndView("pedido",modelo);
    }




}
