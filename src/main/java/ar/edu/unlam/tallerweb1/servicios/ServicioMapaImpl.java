package ar.edu.unlam.tallerweb1.servicios;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.exception.ResultadoNegativoException;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurant;



@Service("servicioMapa")
@Transactional
public class ServicioMapaImpl implements ServicioMapa{

	private RepositorioRestaurant servicioRestaurantDao;

    @Autowired
    public ServicioMapaImpl(RepositorioRestaurant servicioRestaurantDao){
        this.servicioRestaurantDao = servicioRestaurantDao;
    }

    @Override
    public Restaurant consultarRestaurant (Long id) {
        return servicioRestaurantDao.consultarRestaurant(id);
    }

    @Override
    public List<Restaurant> traerLista (){
    	List<Restaurant>restaurants=servicioRestaurantDao.consultarListaRestos();
    	return  restaurants;
    }




	public Integer sacarDistancia(Restaurant resto, Usuario usuario) throws ResultadoNegativoException {
		Double distancia = 0.0;
		Integer resultado;

		Double radianes = (Math.PI / 180);
		Double radioTierra = 6372.795477598;

		Double diferenciaLatitud = ((resto.getLatitudResto()) - (usuario.getLatitud()));
		Double diferenciaLongitud = ((resto.getLongitudResto()) - (usuario.getLongitud()));
		Double calculoDentroDeLaRaiz = Math.pow((Math.sin(radianes * diferenciaLatitud / 2)), 2)
				+ Math.cos(radianes * usuario.getLatitud()) * Math.cos(radianes * resto.getLatitudResto())
						* Math.pow((Math.sin(radianes * diferenciaLongitud / 2)), 2);
		distancia = 2 * radioTierra * Math.asin(Math.sqrt(calculoDentroDeLaRaiz));

		if(distancia > 0) {
			resultado= (int) (distancia*1000);
		}
		else {
			throw new ResultadoNegativoException("La distancia no puede ser negativa");
		}

		return resultado;

	}

	public List<Restaurant> mostrarRestosMasCercanos(Usuario usuario,Integer radioEnKm) throws ResultadoNegativoException {

		List<Restaurant> listaRestaurantCercano = new ArrayList();

		for (Restaurant restaurant : this.traerLista()) {
			if ( this.sacarDistancia(restaurant, usuario) <= radioEnKm) {
				listaRestaurantCercano.add(restaurant);
			}
		}

		return listaRestaurantCercano;
	}
}
