package ar.edu.unlam.tallerweb1.pruebas.persistencia;
/*package ar.edu.unlam.tallerweb1.persistencia;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class FarmaciaTest extends SpringTest{
	
	@Test
	@Transactional @Rollback
	
	public void testBuscaFarmaciaPorNombre() {
		
		Farmacia farmacity = new Farmacia();
		Farmacia farmacia2 = new Farmacia();
		farmacity.setNombre("Farmacity");
		farmacia2.setNombre("Farmacity");
		
		final Session session = session();
		session.save(farmacity);
		session.save(farmacia2);
		Criteria criteria =session.createCriteria(Farmacia.class);
		criteria.add(Restrictions.like("nombre", "%Farmacity%"));
		List<Farmacia> farmacias = criteria.list();
		
		for (Farmacia f : farmacias) {
			assertThat(f.getNombre()).isEqualTo("Farmacity");
		}
		
		assertThat(farmacias.size()).isEqualTo(2);	
	}
	
	@Test
	@Transactional @Rollback
	
	public void testBuscaFarmaciasPorTurno() {
		
		Farmacia farmacia1 = new Farmacia();
		Farmacia farmacia2 = new Farmacia();
		Farmacia farmacia3 = new Farmacia();
		Farmacia farmacia4 = new Farmacia();
		
		farmacia1.setNombre("Farmacity");
		farmacia1.setDiaTurno("Lunes");
		farmacia2.setNombre("FarmaTruchi1");
		farmacia2.setDiaTurno("Martes");
		farmacia3.setNombre("FarmaTruchi");
		farmacia3.setDiaTurno("Domingo");
		farmacia4.setNombre("Farmacity2");
		farmacia4.setDiaTurno("Miercoles");
		
		final Session session = session();
		session.save(farmacia1);
		session.save(farmacia2);
		session.save(farmacia3);
		session.save(farmacia4);
		Criteria criteria = session.createCriteria(Farmacia.class)
		.add(Restrictions.or(
				Restrictions.like("diaTurno", "Martes"),
				Restrictions.like("diaTurno", "Miercoles")
				));
		List <Farmacia> farmacias = criteria.list();
		
		for (Farmacia f : farmacias) {
			if(f.getDiaTurno() == "Martes") {
				assertThat(f).isEqualTo(farmacia2);
			}
			else if(f.getDiaTurno() == "Miercoles"){
				assertThat(f).isEqualTo(farmacia4);
			}
		}
		
		assertThat(farmacias.size()).isEqualTo(2);	
	}
	
	@Test
	@Transactional @Rollback
	
	public void testBuscaFarmaciaPorTurnoYcantEmpleados() {
		
		Farmacia farmacia1 = new Farmacia();
		Farmacia farmacia2 = new Farmacia();
		Farmacia farmacia3 = new Farmacia();
		Farmacia farmacia4 = new Farmacia();
		
		farmacia1.setNombre("Farmacity");
		farmacia1.setDiaTurno("Domingo");
		farmacia1.setCantidadDeEmpleados(2);
		farmacia2.setNombre("FarmaTruchi1");
		farmacia2.setDiaTurno("Martes");
		farmacia2.setCantidadDeEmpleados(8);
		farmacia3.setNombre("FarmaTruchi");
		farmacia3.setDiaTurno("Domingo");
		farmacia3.setCantidadDeEmpleados(5);
		farmacia4.setNombre("Farmacity2");
		farmacia4.setDiaTurno("Miercoles");
		farmacia4.setCantidadDeEmpleados(10);
		
		final Session session = session();
		session.save(farmacia1);
		session.save(farmacia2);
		session.save(farmacia3);
		session.save(farmacia4);
		Criteria criteria = session.createCriteria(Farmacia.class)
		.add(Restrictions.and(
				Restrictions.like("diaTurno", "Domingo"),
				Restrictions.like("cantidadDeEmpleados", 5)
				));
		List <Farmacia> farmacias = criteria.list();
		Integer valorObtenido = 0;
		
		for (Farmacia f : farmacias) {
			if(f.getDiaTurno() == "Domingo" && f.getCantidadDeEmpleados()>= 5) {
				assertThat(f).isEqualTo(farmacia3);
				valorObtenido++;
			}
		}
		
		assertThat(farmacias.size()).isEqualTo(valorObtenido);	
	}
	
	@Test
	@Transactional @Rollback
	
	public void testQueBuscaQueLaFarmaciaEstaEnCongreso() {
		
		Farmacia farmacia1 = new Farmacia();
		Farmacia farmacia2 = new Farmacia();
		Farmacia farmacia3 = new Farmacia();
		
		Barrio barrio1 = new Barrio();
		Barrio barrio2 = new Barrio();
		
		barrio1.setNombre("Congreso");
		barrio2.setNombre("Castelar");
		
		farmacia1.setNombre("Farmacity");
		farmacia1.setBarrio(barrio1);
		farmacia2.setNombre("Farmacity");
		farmacia2.setBarrio(barrio2);
		farmacia3.setNombre("Farmacity");
		farmacia3.setBarrio(barrio1);
		
		final Session session = session();
		session.save(farmacia1);
		session.save(farmacia2);
		session.save(farmacia3);
		session.save(barrio1);
		session.save(barrio2);
		
		Criteria criteria = session.createCriteria(Farmacia.class)
				.add(Restrictions.like("barrio", barrio1));
		
		List <Farmacia> farmacias = criteria.list();
		
		for(Farmacia f : farmacias) {
			if(f.getBarrio().getId()== barrio1.getId()) {
				assertThat(f.getBarrio()).isEqualTo(barrio1);
			}
		}
		
		assertThat(farmacias.size()).isEqualTo(2);
	}
	
	
}*/