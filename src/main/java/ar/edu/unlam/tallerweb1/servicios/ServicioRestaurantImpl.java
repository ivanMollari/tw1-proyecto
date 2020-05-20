package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurant;

import java.util.List;

@Service("servicioRestaurant")
@Transactional
public class ServicioRestaurantImpl implements ServicioRestaurant{
    private RepositorioRestaurant servicioRestaurantDao;

    @Autowired
    public ServicioRestaurantImpl(RepositorioRestaurant servicioRestaurantDao){
        this.servicioRestaurantDao = servicioRestaurantDao;
    }

    @Override
    public Menu consultarMenu (Long id) {
        Menu menu=servicioRestaurantDao.consultarMenu(id);
        return menu;
    }
}
