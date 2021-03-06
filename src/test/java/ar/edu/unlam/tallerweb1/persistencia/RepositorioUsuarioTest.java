package ar.edu.unlam.tallerweb1.persistencia;



import ar.edu.unlam.tallerweb1.SpringTest;



import ar.edu.unlam.tallerweb1.modelo.Usuario;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioImpl;

import org.hibernate.Session;


import org.junit.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;


import javax.transaction.Transactional;






import static org.assertj.core.api.Assertions.*;


public class RepositorioUsuarioTest extends SpringTest {
    
	@Autowired
	private RepositorioUsuarioImpl sut;
	

	@Test 
	@Transactional @Rollback
	public void testQueBuscaUsuarioPorId() {
		
		Usuario jose = new Usuario();
		jose.setEmail("pepe@gmail.com");
		jose.setPassword("1234");
		final Session session = session();
		session.save(jose);
		
		final Usuario buscarUsuario = sut.buscarUsuario(jose.getId());
		
		
		assertThat(buscarUsuario.getId()).isNotNull();
	}
	
	
	
	
	@Test 
	@Transactional @Rollback
	public void testQueMeDevuelveUnUsuarioSiElMailEsElMismo() {
		
		Usuario usuario2 = new Usuario();
		usuario2.setId(2L);
		usuario2.setEmail("pepe@gmail.com");
		usuario2.setPassword("1234");
		final Session session = session();
		session.save(usuario2);
		
		final Usuario buscarUsuario = sut.consultarUsuario(usuario2);
		
		
		assertThat(buscarUsuario).isNotNull();
	}
	
	
	@Test 
	@Transactional @Rollback
	public void testQueDaVerdeSiElMailEsElMismo() {
		
		Usuario usuario2 = new Usuario();
		
		usuario2.setEmail("pepe@gmail.com");
		usuario2.setPassword("1234");
		final Session session = session();
		session.save(usuario2);
		
		final Usuario buscarUsuario = sut.consultarUsuario(usuario2);
		
		assertThat(buscarUsuario.getEmail()).isEqualTo("pepe@gmail.com");
		
	}
	
	@Test 
	@Transactional @Rollback
	public void testQueDaVerdeSiElMailNoEsElMismo() {
		
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		
		usuario1.setEmail("noEspepe@gmail.com");
		usuario2.setEmail("pepe@gmail.com");
		usuario2.setPassword("1234");
		final Session session = session();
		session.save(usuario2);
		
		final Usuario buscarUsuario = sut.consultarUsuario(usuario2);
		
		assertThat(buscarUsuario.getEmail()).isNotEqualTo(usuario1.getEmail());
		
	}
	
	@Test 
	@Transactional @Rollback
	public void testQueAgregaUsuario() {
		
		Usuario usuario1 = new Usuario();
		
		usuario1.setEmail("juan@hotmail.com");
		usuario1.setPassword("1234juan");
		usuario1.setRol("usuario");
		final Session session = session();
		session.save(usuario1);
		
		sut.agregarUsuario(usuario1);
		
		final Usuario buscarUsuario = sut.consultarUsuario(usuario1);
		
		assertThat(buscarUsuario).isNotNull();
		assertThat(buscarUsuario.getEmail()).isEqualTo("juan@hotmail.com");
		
	}
	

	
}
