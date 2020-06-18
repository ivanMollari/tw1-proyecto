package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	private RepositorioUsuario servicioUsuarioDao;

	@Autowired
	public ServicioUsuarioImpl(RepositorioUsuario servicioUsuarioDao){
		this.servicioUsuarioDao = servicioUsuarioDao;
	}

	@Override
	public Usuario buscarUsuario (Long idUsuario) {
		return servicioUsuarioDao.buscarUsuario(idUsuario);
	}
	
	@Override
	public void modificarUsuario (Usuario usuario) {
		 servicioUsuarioDao.modificarUsuario(usuario);
	}
}
