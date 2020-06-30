package ar.edu.unlam.tallerweb1.controlador;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorMapa;
import ar.edu.unlam.tallerweb1.exception.ResultadoNegativoException;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioMapa;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

public class MapaControllerTest {

	
	ServicioMapa servicioMapa = Mockito.mock(ServicioMapa.class);
	ServicioLogin servicioLogin = Mockito.mock(ServicioLogin.class);
	ControladorMapa controladorMapa= new ControladorMapa(servicioMapa,servicioLogin);
	
	@Test
	public void testQuePruebaElMetodoDeMostrarMapa() {
		HttpServletRequest requestMock=mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);
	
		Usuario pepe = mock(Usuario.class);
		pepe.setId(1L);
		pepe.setEmail("pepe@gmail.com");

		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioLogin.buscarUsuario((Long)requestMock.getSession().getAttribute("idUsuario"))).thenReturn(pepe);
		
		ModelAndView modelAndView = controladorMapa.mostrarMapa(requestMock);
		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("distancia");
		assertThat(modelAndView.getModel()).containsKey("usuario");
		assertThat(modelAndView.getModel().get("usuario")).isEqualTo(pepe.getEmail());
	}
	
	@Test
	public void testQuePruebaElMetodoDeCambiarUbicacion() {
		HttpServletRequest requestMock=mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);
	
		Usuario pepe = mock(Usuario.class);
		pepe.setId(1L);
		pepe.setLatitud(-34.647858);
		pepe.setLongitud(-58.62861);

		Integer radioEnM = 100;
		List<Restaurant> listaRestosCercanos= mock(List.class);
		String direccion = "Ituzaingo,Provincia de Buenos Aires,Argentina";

		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioLogin.buscarUsuario((Long)requestMock.getSession().getAttribute("idUsuario"))).thenReturn(pepe);
		try {
			when(servicioMapa.mostrarRestosMasCercanos(pepe, radioEnM)).thenReturn(listaRestosCercanos);
		} catch (ResultadoNegativoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = controladorMapa.cambiarUbicacion(direccion, radioEnM, pepe.getLatitud(),
									pepe.getLongitud(), requestMock);
		
		assertThat(modelAndView).isNotNull();
		assertThat(modelAndView.getViewName()).isEqualTo("modificarDistancia");
		assertThat(modelAndView.getModel()).containsKey("listado");
		assertThat(modelAndView.getModel()).containsKey("radioEnM");
		assertThat(modelAndView.getModel()).containsKey("direccion");
		assertThat(modelAndView.getModel().get("radioEnM")).isEqualTo(radioEnM);
		assertThat(modelAndView.getModel().get("direccion")).isEqualTo(direccion);
	}
	
}
