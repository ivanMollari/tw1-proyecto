package ar.edu.unlam.tallerweb1.persistencia;


import ar.edu.unlam.tallerweb1.SpringTest;

import ar.edu.unlam.tallerweb1.modelo.Mapa;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioMapa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


/*public class MapaTest extends SpringTest {
	
	@Test
	@Transactional @Rollback
	public void mostrarDistanciaTest() {
		
		
		Restaurant laFarola = new Restaurant();
		laFarola.setNombre("La Farola");
		laFarola.setLatitudResto(-34.647658);
		laFarola.setLongitudResto(-58.628743);
		
		
		
		Usuario jose = new Usuario();
		jose.setLatitud(-34.646986);
		jose.setLongitud(-58.633182);
		
		
		
		
		Mapa Mimapa = new Mapa();
		Mimapa.agregarResto(laFarola);

		final Session session= session();
		session.save(laFarola);
		session.save(jose);
		session.save(Mimapa);
		
		Mapa buscado= session.get(Mapa.class, Mimapa.getId());
		assertThat(buscado.sacarDistancia(laFarola, jose)).isEqualTo(0.4129980737872941);
		
		
	}*/
	
	/*@Test
	@Transactional @Rollback
	public void mostrarRestosCercanosTest() {
		
		ServicioMapa servicioMapa;
		
		Restaurant laFarola = new Restaurant();
		laFarola.setNombre("La Farola");
		laFarola.setLatitudResto(-34.647658);
		laFarola.setLongitudResto(-58.628743);
		Restaurant tioDue = new Restaurant();
		tioDue.setNombre("Tio Due");
		tioDue.setLatitudResto(-34.645704);
		tioDue.setLongitudResto(-58.640903);
		Restaurant noi = new Restaurant();
		noi.setNombre("Noi");
		noi.setLatitudResto(-34.647503);
		noi.setLongitudResto(-58.629588);
		
		
		Usuario jose = new Usuario();
		jose.setLatitud(-34.647858);
		jose.setLongitud(-58.628610);
		
		Mapa miMapa = new Mapa(jose);
		
		miMapa.agregarResto(laFarola);
		miMapa.agregarResto(tioDue);
		miMapa.agregarResto(noi);
		
		
		final Session session = session();
		session.save(laFarola);
		session.save(tioDue);
		session.save(noi);
		session.save(jose);
		session.save(miMapa);
		
		Criteria criteria = session.createCriteria(Restaurant.class)
				.add(Restrictions.isNotNull("id"));
		
		List <Restaurant> listaRestos = criteria.list();
	
		assertThat(miMapa.mostrarRestosMasCercanos(jose, listaRestos).size()).isEqualTo(2);
		
		/*for(Mapa m : mapa) {
			
			if(miMapa.getResto().contains(m)){
				assertThat(m.getResto().contains(laFarola)).isTrue();
				assertThat(m.getResto().contains(tioDue)).isTrue();
			}
		}
		
		//assertThat(miMapa.mostrarRestosMasCercanos(jose).size()).isEqualTo(2);
		
		
		
	}
}*/