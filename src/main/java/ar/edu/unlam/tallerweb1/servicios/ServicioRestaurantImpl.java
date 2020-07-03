package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.*;

import ar.edu.unlam.tallerweb1.modelo.dto.RequestPedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComida;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComidaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Comida consultarComida(Long id){

        Comida comida=servicioRestaurantDao.consultarComida( id);
        return comida;
    }
    public Postre consultarPostre(Long id){

        Postre postre=servicioRestaurantDao.consultarPostre( id);
        return postre;
    }
    public Bebida consultarBebida(Long id){

        Bebida bebida=servicioRestaurantDao.consultarBebida( id);
        return bebida;
    }

    @Override
    public Entrada consultarEntrada(Long id){

        Entrada entrada=servicioRestaurantDao.consultarEntrada( id);
        return entrada;
    }

    @Override
    public Pedido armarPedido(RequestPedido requestPedido,Restaurant restaurant) {
        Pedido pedido=new Pedido();
        for (Long idEntrada:requestPedido.getIdEntradas() ) {
            Entrada entrada=servicioRestaurantDao.consultarEntrada(idEntrada);
            pedido.agregarUnItemMenu(entrada);
        }
        for (Long idComida:requestPedido.getIdConmidas() ) {
            Comida comida=servicioRestaurantDao.consultarComida(idComida);
            pedido.agregarUnItemMenu(comida);
        }

        for (Long idPostre:requestPedido.getIdPostres() ) {
            Postre postre=servicioRestaurantDao.consultarPostre(idPostre);
            pedido.agregarUnItemMenu(postre);
        }
        for (Long idBebida:requestPedido.getIdBebidas()) {
            Bebida bebida=servicioRestaurantDao.consultarBebida(idBebida);
            pedido.agregarUnItemMenu(bebida);
        }
        pedido.setTotal(requestPedido.getTotal());
        pedido.setUsuario(requestPedido.getUsuario());
        pedido.setRestaurant(restaurant);
        return pedido;
    }




   @Override
   public List<Restaurant> buscarRestaurants(String searchText) {
        List<Restaurant> listaResto = servicioRestaurantDao.buscarRestaurants(searchText);

        return listaResto;
   }






}
