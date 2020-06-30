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
        Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
        Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());
        modelo.put("menu", restaurant.getMenu());
        modelo.put("restaurant", restaurant);
        modelo.put("comida", comida);
        modelo.put("items", ListaItems);
        modelo.put("entrada", entrada);
        modelo.put("bebida", bebida);
        modelo.put("postre", postre);
       
        
        

        return new ModelAndView("restaurant", modelo);
    }
    
    @RequestMapping(path = "/restaurant/{id}/entrada", method = RequestMethod.POST)
    public ModelAndView listaEntradas(@PathVariable(value = "id") Long id,
    								  @ModelAttribute("entrada") Entrada entrada,HttpServletRequest request) {
    	
        ModelMap modelo = new ModelMap();
        
        Comida comida = new Comida();
        Bebida bebida = new Bebida();
        Postre postre = new Postre();
        
        Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
        Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
        Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());
        
         RequestPedido requestPedido;
    
        if (request.getSession().getAttribute("requestPedido") == null) {
            requestPedido=new RequestPedido();
            request.getSession().setAttribute("requestPedido", requestPedido);
        } else {
            requestPedido = (RequestPedido) request.getSession().getAttribute("requestPedido");
        }

        if (entrada!=null && id!=null){
        requestPedido.agregarPedido(entrada);
        requestPedido.setId_restaurant(id);
        requestPedido.sumarTotal(entrada);
        requestPedido.setUsuario(usuarioBuscado);
        }
              
        modelo.put("menu", restaurant.getMenu());
        modelo.put("requestPedido", requestPedido);
        modelo.put("restaurant", restaurant);
        modelo.put("items", ListaItems);
        modelo.put("pedidos",requestPedido.getPedido());
        modelo.put("comida", comida);
        modelo.put("bebida",bebida);
        modelo.put("postre",postre);
        modelo.put("total",requestPedido.getTotal());
        return new ModelAndView("restaurant", modelo);
    }
    
    @RequestMapping(path = "/restaurant/{id}/comida", method = RequestMethod.POST)
    public ModelAndView listaComidas(@PathVariable(value = "id") Long id
    										,@ModelAttribute("comida") Comida comida,HttpServletRequest request) {
    	
    	
        ModelMap modelo = new ModelMap();
        Entrada entrada = new Entrada();
        Bebida bebida = new Bebida();
        Postre postre = new Postre();

        Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
        
        Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
        Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());
        
        RequestPedido requestPedido;
        if (request.getSession().getAttribute("requestPedido") == null) {
            requestPedido=new RequestPedido();
            request.getSession().setAttribute("requestPedido", requestPedido);
        } else {
            requestPedido = (RequestPedido) request.getSession().getAttribute("requestPedido");

        }

        if (comida!=null && id!=null){
        requestPedido.agregarPedido(comida);
        requestPedido.setId_restaurant(id);
        requestPedido.sumarTotal(comida);
        requestPedido.setUsuario(usuarioBuscado);
        }
        
        modelo.put("menu", restaurant.getMenu());
        modelo.put("requestPedido", requestPedido);
        modelo.put("pedidos",requestPedido.getPedido());
        modelo.put("restaurant",restaurant);
        modelo.put("items", ListaItems);
        modelo.put("entrada", entrada);
        modelo.put("bebida",bebida);
        modelo.put("postre",postre);
        modelo.put("total",requestPedido.getTotal());
        return new ModelAndView("restaurant", modelo);
    }
    
    @RequestMapping(path = "/restaurant/{id}/bebida", method = RequestMethod.POST)
    public ModelAndView listaBebidas(@PathVariable(value = "id") Long id,
    								  @ModelAttribute("bebida") Bebida bebida,HttpServletRequest request) {
    	
        ModelMap modelo = new ModelMap();
        
        Comida comida = new Comida();
        Entrada entrada = new Entrada();
        Postre postre = new Postre();
        
        Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
        Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
        Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());
        
         RequestPedido requestPedido;
    
        if (request.getSession().getAttribute("requestPedido") == null) {
            requestPedido=new RequestPedido();
            request.getSession().setAttribute("requestPedido", requestPedido);
        } else {
            requestPedido = (RequestPedido) request.getSession().getAttribute("requestPedido");
        }

        if (bebida!=null && id!=null){
        requestPedido.agregarPedido(bebida);
        requestPedido.setId_restaurant(id);
        requestPedido.sumarTotal(bebida);
        requestPedido.setUsuario(usuarioBuscado);
        }
              
        modelo.put("menu", restaurant.getMenu());
        modelo.put("requestPedido", requestPedido);
        modelo.put("restaurant", restaurant);
        modelo.put("items", ListaItems);
        modelo.put("pedidos",requestPedido.getPedido());
        modelo.put("comida", comida);
        modelo.put("entrada", entrada);
        modelo.put("postre",postre);
        modelo.put("total",requestPedido.getTotal());
        return new ModelAndView("restaurant", modelo);
    }
    
    @RequestMapping(path = "/restaurant/{id}/postre", method = RequestMethod.POST)
    public ModelAndView listaPostres(@PathVariable(value = "id") Long id,
    								  @ModelAttribute("postre") Postre postre,HttpServletRequest request) {
    	
        ModelMap modelo = new ModelMap();
        
        Comida comida = new Comida();
        Entrada entrada = new Entrada();
        Bebida bebida = new Bebida();
        
        Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
        Restaurant restaurant = servicioRestaurant.consultarRestaurant(id);
        Map<String, List<ItemMenu>> ListaItems = servicioRestaurant.consultarMenuCompleto(restaurant.getMenu().getId());
        
         RequestPedido requestPedido;
    
        if (request.getSession().getAttribute("requestPedido") == null) {
            requestPedido=new RequestPedido();
            request.getSession().setAttribute("requestPedido", requestPedido);
        } else {
            requestPedido = (RequestPedido) request.getSession().getAttribute("requestPedido");
        }

        if (postre!=null && id!=null){
        requestPedido.agregarPedido(postre);
        requestPedido.setId_restaurant(id);
        requestPedido.sumarTotal(postre);
        requestPedido.setUsuario(usuarioBuscado);
        }
              
        modelo.put("menu", restaurant.getMenu());
        modelo.put("requestPedido", requestPedido);
        modelo.put("restaurant", restaurant);
        modelo.put("items", ListaItems);
        modelo.put("pedidos",requestPedido.getPedido());
        modelo.put("comida", comida);
        modelo.put("entrada", entrada);
        modelo.put("bebida",bebida);
        modelo.put("total",requestPedido.getTotal());
        return new ModelAndView("restaurant", modelo);
    }

    

   /* @RequestMapping(path = "/restaurant/{idResto}/pedido", method = RequestMethod.POST)
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
            modelo.put("idRestaurant", restaurant.getId());
            return new ModelAndView("pedidoRespuesta",modelo);
        }
        return new ModelAndView("pedido");

    }*/


    




        @RequestMapping(path = "/restaurant/buscar", method = RequestMethod.GET)
        public ModelAndView buscarRestaurants (@RequestParam String searchText){
            ModelMap modelo = new ModelMap();

            List<Restaurant> listaResto = servicioRestaurant.buscarRestaurants(searchText);
            modelo.put("listaResto", listaResto);
            

            return new ModelAndView("buscarResto", modelo);
        }

    }

