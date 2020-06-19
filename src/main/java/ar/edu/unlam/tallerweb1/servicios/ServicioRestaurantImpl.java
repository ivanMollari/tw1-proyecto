package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComida;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComidaImpl;
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

   /* public void tiempoTotalPedido(Restaurant resto) {
    	resto.
    }*/

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
   public List<Restaurant> buscarRestaurants(String searchText) {
        List<Restaurant> listaResto = servicioRestaurantDao.buscarRestaurants(searchText);

        return listaResto;
   }

}
