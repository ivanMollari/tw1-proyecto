package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	Usuario consultarUsuario (Usuario usuario);

	Usuario buscarUsuario(Long id);

	void modificarUsuario(Usuario usuario);

	void agregarUsuario(Usuario usuario);

	
	
	
}
