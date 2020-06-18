package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBebida;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioBebida")
@Transactional
public class ServicioBebidaImpl implements ServicioBebida{
    private RepositorioBebida servicioBebidaDao;

    @Autowired
    public ServicioBebidaImpl(RepositorioBebida servicioBebidaDao){
        this.servicioBebidaDao = servicioBebidaDao;
    }

    @Override
    public List<ItemMenu> getBebidasByMenuId(Long menuId){
        List<ItemMenu> comidas = servicioBebidaDao.getBebidasByMenuId(menuId);

        return comidas;
    }
}
