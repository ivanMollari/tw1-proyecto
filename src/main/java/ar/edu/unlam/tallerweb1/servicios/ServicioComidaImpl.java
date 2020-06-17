package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioComida")
@Transactional
public class ServicioComidaImpl implements ServicioComida{
    private RepositorioComida servicioComidaDao;

    @Autowired
    public ServicioComidaImpl(RepositorioComida servicioComidaDao){
        this.servicioComidaDao = servicioComidaDao;
    }

    @Override
    public List<ItemMenu> getComidasByMenuId(Long menuId){
        List<ItemMenu> comidas = servicioComidaDao.getComidaByMenuId(menuId);

        return comidas;
    }
}
