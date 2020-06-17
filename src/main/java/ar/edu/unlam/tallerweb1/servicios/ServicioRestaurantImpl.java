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

    @Autowired
    public ServicioRestaurantImpl(RepositorioRestaurant servicioRestaurantDao,
                                  ServicioComida servicioComida,
                                  ServicioBebida servicioBebida){
        this.servicioRestaurantDao = servicioRestaurantDao;
        this.servicioComida = servicioComida;
        this.servicioBebida = servicioBebida;
    }

    @Override
    public Menu consultarMenu (Long id) {
        Menu menu=servicioRestaurantDao.consultarMenu(id);

        return menu;
    }

    @Override
    public Restaurant consultarRestaurant (Long id) {
        Restaurant restaurant= servicioRestaurantDao.consultarRestaurant(id);

        return restaurant;
    }

    @Override
    public Map<String, List<ItemMenu>> consultarMenuCompleto(Long MenuId) {
        Map<String, List<ItemMenu>> menuCompleto = new HashMap<>();
        System.out.println(MenuId);

        List<ItemMenu> comidas = servicioComida.getComidasByMenuId(MenuId);
        List<ItemMenu> bebidas = servicioBebida.getBebidasByMenuId(MenuId);

        menuCompleto.put("Comidas", comidas);
        menuCompleto.put("Bebidas", bebidas);

        return menuCompleto;
    }

}
