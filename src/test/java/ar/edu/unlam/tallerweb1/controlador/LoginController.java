package ar.edu.unlam.tallerweb1.controlador;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginController {

	ServicioLogin servicioLogin = Mockito.mock(ServicioLogin.class);
	ControladorLogin instancia = new ControladorLogin(servicioLogin);

	
	@Test
	public void testQueVaAlaPaginaLogin() {
		ModelAndView modelAndView = instancia.irALogin();
		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("login");
		assertThat(modelAndView.getModel()).containsKey("usuario");
	}
	
	@Test
	public void testQueValidaLogin() {
		Usuario usuario = new Usuario();
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);

		when(servicioLogin.consultarUsuario(usuario)).thenReturn(usuario);
		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioLogin.buscarUsuario((Long) requestMock.getSession().getAttribute("idUsuario")))
				.thenReturn(usuario);

		ModelAndView modelAndView = instancia.validarLogin(usuario, requestMock);

		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/home");
	}

	@Test
	public void testQueNoLogueaUsuario() {
		Usuario usuario = new Usuario();
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);

		when(servicioLogin.consultarUsuario(usuario)).thenReturn(null);
		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioLogin.buscarUsuario((Long) requestMock.getSession().getAttribute("idUsuario")))
				.thenReturn(usuario);

		ModelAndView modelAndView = instancia.validarLogin(usuario, requestMock);

		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("login");
		assertThat(modelAndView.getModel()).containsKey("error");
		assertThat(modelAndView.getModel().get("error")).isEqualTo("Usuario o clave incorrecta");
	}

	@Test
	public void testQueVaAlaPaginaDeRegistro() {
		ModelAndView modelAndView = instancia.registro();
		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("registrarUsuario");
		assertThat(modelAndView.getModel()).containsKey("usuario");

	}

	@Test
	public void testRegistraUsuario() {
		Usuario usuario = new Usuario();
		usuario.setEmail("jose@gmail.com");
		usuario.setPassword("1234");

		when(servicioLogin.consultarUsuario(usuario)).thenReturn(null);

		ModelAndView modelAndView = instancia.guardarRegistro(usuario);

		verify(servicioLogin, times(1)).agregarUsuario(usuario);

		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/login");

	}

	@Test
	public void testQueNoRegistraUsuario() {

		Usuario usuario = new Usuario();
		usuario.setEmail("jose@gmail.com");
		usuario.setPassword("1234");

		when(servicioLogin.consultarUsuario(usuario)).thenReturn(usuario);

		ModelAndView modelAndView = instancia.guardarRegistro(usuario);

		verify(servicioLogin, times(0)).agregarUsuario(usuario);

		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("registrarUsuario");
		assertThat(modelAndView.getModel()).containsKey("error");
		assertThat(modelAndView.getModel().get("error")).isEqualTo("El usuario ya existe");

	}
	
	@Test
	public void testPaginaLogin() {
		Usuario usuario = new Usuario();
		usuario.setEmail("jose@gmail.com");
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);
		
		when(servicioLogin.consultarUsuario(usuario)).thenReturn(null);
		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioLogin.buscarUsuario((Long) requestMock.getSession().getAttribute("idUsuario")))
				.thenReturn(usuario);
		
		ModelAndView modelAndView = instancia.irAHome(requestMock);
		
		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("home");
		assertThat(modelAndView.getModel()).containsKey("usuario");
		assertThat(modelAndView.getModel().get("usuario")).isEqualTo(usuario.getEmail());
		
	}
	
	@Test
	public void testQueVaAlaPaginaInicial() {
		ModelAndView modelAndView = instancia.inicio();
		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/registrarUsuario");
	}
	
}
