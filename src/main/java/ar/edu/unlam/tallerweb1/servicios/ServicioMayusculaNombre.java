package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;

@Service("ServicioMayusculaNombre")


public class ServicioMayusculaNombre{
	
	public static String cambiarAmayuscula(String nombre) {
		return nombre.toUpperCase();
	}
	
}