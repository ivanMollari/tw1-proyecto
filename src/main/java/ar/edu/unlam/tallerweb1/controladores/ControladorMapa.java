package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.exception.ResultadoNegativoException;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioMapa;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;



@Controller
public class ControladorMapa{

    private ServicioMapa servicioMapa;
    private ServicioUsuario servicioUsuario;
    private ServicioLogin servicioLogin;

    @Autowired
    public ControladorMapa(ServicioMapa servicioMapa,ServicioUsuario servicioUsuario,ServicioLogin servicioLogin){
        this.servicioMapa = servicioMapa;
        this.servicioUsuario = servicioUsuario;
        this.servicioLogin = servicioLogin;
    }


    
    @RequestMapping(path = "/mapa", method = RequestMethod.GET)
    	public ModelAndView mostrarMapa (HttpServletRequest request){
    			ModelMap model = new ModelMap();
    			Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
    			model.put("usuario",usuarioBuscado.getEmail());
    			return new ModelAndView("distancia",model);
    	
    	}
    	  

@RequestMapping(path = "/mapa/modificar-ubicacion", method = RequestMethod.POST)
    
 	public ModelAndView cambiarUbicacion(String ubicacion
 										 ,Integer radioEnM,
 										  Double latitud, Double longitud,HttpServletRequest request) { 
     	List<Restaurant> listaRestosCercanos= new ArrayList();
     	
     	ModelMap model = new ModelMap();
     	Usuario usuarioBuscado = servicioLogin.buscarUsuario((Long) request.getSession().getAttribute("idUsuario"));
     	usuarioBuscado.setLatitud(latitud);
     	usuarioBuscado.setLongitud(longitud);
     	try {
     	listaRestosCercanos = servicioMapa.mostrarRestosMasCercanos(usuarioBuscado, radioEnM);
     	
 		} catch (ResultadoNegativoException e) {
 		e.printStackTrace();
 		model.put("mensaje",e.getMessage());
 		}


     	
     	model.put("listado", listaRestosCercanos);
     	model.put("radioEnM", radioEnM);
     	model.put("direccion", ubicacion);
 		
 		return new ModelAndView("modificarDistancia", model);
 	}

    



}
