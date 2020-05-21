package ar.edu.unlam.tallerweb1.servicios;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioMapa;


@Service("servicioMapa")
@Transactional
public class ServicioMapaImpl implements ServicioMapa{

	private RepositorioMapa servicioMapaDao;

    @Autowired
    public ServicioMapaImpl(RepositorioMapa servicioMapaDao){
        this.servicioMapaDao = servicioMapaDao;
    }

    @Override
    public Restaurant consultarRestaurant (Long id) {
        return servicioMapaDao.consultarRestaurant(id);
    }

    @Override
    public List<Restaurant> traerLista (){
    	return servicioMapaDao.consultarListaRestos();
    }



    @Override
    public Usuario consultarUsuario (Long id) {
        return servicioMapaDao.consultarUsuario(id);
    }

	public Double sacarDistancia(Restaurant resto, Usuario usuario) {

		Double distancia= 0.0;

		if(resto !=null && usuario != null) {

		Double	radianes= (Math.PI/180);
		Double radioTierra= 6372.795477598;

		Double diferenciaLatitud= ((resto.getLatitudResto())-(usuario.getLatitud()));
		Double diferenciaLongitud= 	((resto.getLongitudResto()) - (usuario.getLongitud()));
		Double calculoDentroDeLaRaiz= Math.pow((Math.sin(radianes*diferenciaLatitud/2)), 2) + Math.cos(radianes*usuario.getLatitud())* Math.cos(radianes*resto.getLatitudResto())* Math.pow((Math.sin(radianes*diferenciaLongitud/2)), 2);
		distancia= 2*radioTierra*Math.asin(Math.sqrt(calculoDentroDeLaRaiz));


		}
		else {
			distancia= -1.0;
		}
		return distancia;

	}

	public List<Restaurant> mostrarRestosMasCercanos(Usuario usuario) {

		List<Restaurant> listaRestaurantCercano = new ArrayList();

		for (Restaurant restaurant : this.traerLista()) {
			if(this.sacarDistancia(restaurant, usuario) >-1.0 && this.sacarDistancia(restaurant, usuario)<=1.0) {
				listaRestaurantCercano.add(restaurant);
			}

		}

		return listaRestaurantCercano;
	}
}