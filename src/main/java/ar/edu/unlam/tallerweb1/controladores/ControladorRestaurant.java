package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.servicios.ServicioRestaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class ControladorRestaurant {

    private ServicioRestaurant servicioRestaurant;

    @Autowired
    public ControladorRestaurant(ServicioRestaurant servicioRestaurant) {
        this.servicioRestaurant = servicioRestaurant;
    }


    @RequestMapping(path = "/restaurant/{id}", method = RequestMethod.GET)
    public ModelAndView mostrarRestaurant(@PathVariable(value = "id") Long id) {
        ModelMap modelo = new ModelMap();

        Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
        Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());
        modelo.put("menu", restaurant.getMenu());
        modelo.put("restaurant", restaurant);
        modelo.put("items", ListaItems);

        return new ModelAndView("restaurant", modelo);
    }


    @RequestMapping(path = "/restaurant/{idResto}/pedido", method = RequestMethod.POST)
    public ModelAndView hacerPedido(@PathVariable(value = "idResto") Long id, @ModelAttribute("requestPedido") RequestPedido requestPedido, HttpServletRequest request) {
        ModelMap modelo = new ModelMap();
        Pedido pedido=new Pedido();
        Restaurant restaurant=servicioRestaurant.consultarRestaurant(id);
        List<Comida> comidas=new ArrayList<Comida>();
        for (Long idComida :requestPedido.getId_comidas()) {
            Comida comida=servicioRestaurant.consultarComida(idComida);
            if (comida!=null)
                comidas.add(comida);
        }
        pedido.setComidas(comidas);
        pedido.setRestaurant(restaurant);
        Integer statusCode = servicioRestaurant.crearPedido(pedido);
        if (statusCode==201){
            modelo.put("statusCode", statusCode);
            return new ModelAndView("pedidoRespuesta");
        }
        return new ModelAndView("pedido");

    }

    @RequestMapping(path = "/restaurant/pedido", method = RequestMethod.GET)
    public ModelAndView irPaginaPedidoComida(@RequestParam(name = "comida.id") Long comidaId, @RequestParam(name = "restaurant.id") Long restaurantId, HttpServletRequest request) {
        ModelMap modelo = new ModelMap();

        List<ItemMenu> comidas=new ArrayList<>();

        Comida comidaBuscada = servicioRestaurant.consultarComida(comidaId);


        RequestPedido requestPedido;
        if (request.getSession().getAttribute("requestPedido") == null) {
            requestPedido=new RequestPedido();
            request.getSession().setAttribute("requestPedido", requestPedido);
        } else {
            requestPedido = (RequestPedido) request.getSession().getAttribute("requestPedido");

        }

        if (comidaBuscada!=null && restaurantId!=null){
        requestPedido.agregarIdComida(comidaBuscada.getId());
        requestPedido.setId_restaurant(restaurantId);
        requestPedido.sumarTotal(comidaBuscada);
        }

        for (Long idComida:requestPedido.getId_comidas()) {
            comidas.add(servicioRestaurant.consultarComida(idComida));
        }
        modelo.put("requestPedido", requestPedido);
        modelo.put("comidas",comidas);
        return new ModelAndView("pedido", modelo);
    }


        @RequestMapping(path = "/restaurant/buscar", method = RequestMethod.GET)
        public ModelAndView buscarRestaurants (@RequestParam String searchText){
            ModelMap modelo = new ModelMap();

            List<Restaurant> listaResto = servicioRestaurant.buscarRestaurants(searchText);
            modelo.put("listaResto", listaResto);


            return new ModelAndView("buscarResto", modelo);
        }

    }

