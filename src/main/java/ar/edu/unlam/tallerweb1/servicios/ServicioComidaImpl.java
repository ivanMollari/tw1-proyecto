package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComida;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioComida")
@Transactional
public class ServicioComidaImpl implements ServicioComida {
	private RepositorioComida servicioComidaDao;
	private RepositorioPedido servicioPedidoDao;

	@Autowired
	public ServicioComidaImpl(RepositorioComida servicioComidaDao, RepositorioPedido servicioPedidoDao) {
		this.servicioComidaDao = servicioComidaDao;
		this.servicioPedidoDao = servicioPedidoDao;
	}

	@Override
	public List<ItemMenu> getComidasByMenuId(Long menuId) {
		List<ItemMenu> comidas = servicioComidaDao.getComidasByMenuId(menuId);

		return comidas;
	}

	
    @Override
    public Comida consultarComida(Long id) {

        Comida comida=servicioComidaDao.consultarComida( id);
        return comida;
    }
}
