package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Entrada;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBebida;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEntrada;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioEntrada")
@Transactional
public class ServicioEntradaImpl implements ServicioEntrada{
    private RepositorioEntrada servicioEntradaDao;

    @Autowired
    public ServicioEntradaImpl(RepositorioEntrada servicioEntradaDao,RepositorioPedido servicioPedido){
        this.servicioEntradaDao = servicioEntradaDao;
    }

    @Override
    public List<ItemMenu> getEntradasByMenuId(Long menuId){
        List<ItemMenu> comidas = servicioEntradaDao.getEntradasByMenuId(menuId);

        return comidas;
    }   
    
    @Override
    public Entrada consultarEntrada(Long id){

        Entrada entrada=servicioEntradaDao.consultarEntrada( id);
        return entrada;
    }



}
