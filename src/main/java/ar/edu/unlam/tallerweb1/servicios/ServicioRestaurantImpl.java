package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.*;

import ar.edu.unlam.tallerweb1.modelo.dto.RequestPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Service("servicioRestaurant")
@Transactional
public class ServicioRestaurantImpl implements ServicioRestaurant{
    private RepositorioRestaurant servicioRestaurantDao;
    private ServicioComida servicioComida;
    private ServicioBebida servicioBebida;
    private ServicioEntrada servicioEntrada;
    private ServicioPostre servicioPostre;

    @Autowired
    public ServicioRestaurantImpl(
            RepositorioRestaurant servicioRestaurantDao,
            ServicioComida servicioComida,
            ServicioBebida servicioBebida,
            ServicioEntrada servicioEntrada,
            ServicioPostre servicioPostre

    ){
        this.servicioRestaurantDao = servicioRestaurantDao;
        this.servicioComida = servicioComida;
        this.servicioBebida = servicioBebida;
        this.servicioEntrada = servicioEntrada;
        this.servicioPostre = servicioPostre;

    }



    @Override
    public Restaurant consultarRestaurant (Long id) {
        Restaurant restaurant= servicioRestaurantDao.consultarRestaurant(id);

        return restaurant;
    }


    @Override
    public Map<String, List<ItemMenu>> consultarMenuCompleto(Long MenuId) {
        Map<String, List<ItemMenu>> menuCompleto = new HashMap<>();

        List<ItemMenu> comidas = servicioComida.getComidasByMenuId(MenuId);
        List<ItemMenu> bebidas = servicioBebida.getBebidasByMenuId(MenuId);
        List<ItemMenu> entradas = servicioEntrada.getEntradasByMenuId(MenuId);
        List<ItemMenu> postres = servicioPostre.getPostresByMenuId(MenuId);

        menuCompleto.put("Comidas", comidas);
        menuCompleto.put("Bebidas", bebidas);
        menuCompleto.put("Entradas", entradas);
        menuCompleto.put("Postres", postres);

        return menuCompleto;
    }
    
    @Override
    public void crearPedido (Pedido pedido) {
        servicioRestaurantDao.crearPedido(pedido);
    }
    
    @Override
    public Pedido armarPedido(RequestPedido requestPedido,Restaurant restaurant) {
        Pedido pedido=new Pedido();
        Double sumaTiempo=0.0;
        for (Long idEntrada:requestPedido.getIdEntradas() ) {
            Entrada entrada=servicioEntrada.consultarEntrada(idEntrada);
            pedido.agregarUnItemMenu(entrada);
            sumaTiempo+=entrada.getTiempoPreparacion();
        }
        for (Long idComida:requestPedido.getIdConmidas() ) {
            Comida comida=servicioComida.consultarComida(idComida);
            pedido.agregarUnItemMenu(comida);
            sumaTiempo+=comida.getTiempoPreparacion();
        }

        for (Long idPostre:requestPedido.getIdPostres() ) {
            Postre postre=servicioPostre.consultarPostre(idPostre);
            pedido.agregarUnItemMenu(postre);
            sumaTiempo+=postre.getTiempoPreparacion();
        }
        for (Long idBebida:requestPedido.getIdBebidas()) {
            Bebida bebida=servicioBebida.consultarBebida(idBebida);
            pedido.agregarUnItemMenu(bebida);
            sumaTiempo+=bebida.getTiempoPreparacion();
        }

        pedido.setTiempoTotal(sumaTiempo.intValue());
        pedido.setTotal(requestPedido.getTotal());
        pedido.setUsuario(requestPedido.getUsuario());
        pedido.setRestaurant(restaurant);
        return pedido;
    }
    
    @Override
    public List<ItemMenu> mostrarPedido(Pedido pedido) {
    	List<ItemMenu> listaPedido = new ArrayList();
    	listaPedido.addAll(pedido.getEntradas());
    	listaPedido.addAll(pedido.getComidas());
    	listaPedido.addAll(pedido.getBebidas());
    	listaPedido.addAll(pedido.getPostres());
    	
    	return listaPedido;
    }
    
   @Override
   public List<Restaurant> buscarRestaurants(String searchText) {
        List<Restaurant> listaResto = servicioRestaurantDao.buscarRestaurants(searchText);

        return listaResto;
   }






}
