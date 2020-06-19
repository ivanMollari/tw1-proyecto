package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComida;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPostre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioPostre")
@Transactional
public class ServicioPostreImpl implements ServicioPostre {
    private RepositorioPostre servicioPostreDao;

    @Autowired
    public ServicioPostreImpl(RepositorioPostre servicioPostreDao){
        this.servicioPostreDao = servicioPostreDao;
    }

    @Override
    public List<ItemMenu> getPostresByMenuId(Long menuId){
        List<ItemMenu> comidas = servicioPostreDao.getPostresByMenuId(menuId);

        return comidas;
    }
}
