package ar.edu.unlam.tallerweb1.servicio;

import ar.edu.unlam.tallerweb1.modelo.Postre;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPostreImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioPostreImpl;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class PostreServicioTest {
    RepositorioPostreImpl repositorio = Mockito.mock(RepositorioPostreImpl.class);

    ServicioPostreImpl instancia = new ServicioPostreImpl(repositorio);

    @Test
    public void consultarBebidasByMenuId() {
        //given:
        Postre postre = new Postre();
        Postre postre2 = new Postre();
        Menu menu=new Menu();

        menu.setId(1L);
        menu.setDescripcion("soy una descripcion");

        postre.setMenu(menu);
        postre2.setMenu(menu);

        List<ItemMenu> lista = new ArrayList<>();

        lista.add(postre);
        lista.add(postre2);

        when(repositorio.getPostresByMenuId(menu.getId())).thenReturn(lista);

        //when: Getting Postre by menu id
        List<ItemMenu> resultado = instancia.getPostresByMenuId(menu.getId());

        //then: The list should be size 2
        assertThat(resultado.size()).isEqualTo(2);
    }
}
