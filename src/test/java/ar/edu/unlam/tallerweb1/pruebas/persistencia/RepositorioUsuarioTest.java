/*package ar.edu.unlam.tallerweb1.pruebas.persistencia;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito.*;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurantImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioMapaImpl;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

public class RepositorioUsuarioTest extends SpringTest {
    
	@Inject
	private RepositorioUsuario sut;
	

	
	@Test @Transactional @Rollback(true)
	public void testQueBuscaUsuarioConElMismoId() {
		
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		session().save(usuario);
		
		final Usuario buscarUsuario = sut.buscarUsuario(1L);
		
		assertThat(buscarUsuario).isNotNull();
	}
	

	
}*/
