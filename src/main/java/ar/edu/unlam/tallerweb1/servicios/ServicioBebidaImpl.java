package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBebida;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComida;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioBebida")
@Transactional
public class ServicioBebidaImpl implements ServicioBebida{
    private RepositorioBebida servicioBebidaDao;
    private RepositorioPedido servicioPedidoDao;

    @Autowired
    public ServicioBebidaImpl(RepositorioBebida servicioBebidaDao,RepositorioPedido servicioPedidoDao){
        this.servicioBebidaDao = servicioBebidaDao;
        this.servicioPedidoDao = servicioPedidoDao;
    }

    @Override
    public List<ItemMenu> getBebidasByMenuId(Long menuId){
        List<ItemMenu> comidas = servicioBebidaDao.getBebidasByMenuId(menuId);

        return comidas;
    }
    
    @Override
    public List<ItemMenu> getBebidasDeUnPedidoPorUsuarioId(Long usuarioId){
        List<ItemMenu> bebidas = servicioPedidoDao.getPedidosPorIdUsuario(usuarioId);

        return bebidas;
    }
    
   
}
