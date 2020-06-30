package ar.edu.unlam.tallerweb1.servicio;

import ar.edu.unlam.tallerweb1.modelo.Bebida;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBebidaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedidoImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioBebidaImpl;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class BebidaServicioTest {
    RepositorioBebidaImpl repositorio = Mockito.mock(RepositorioBebidaImpl.class);
    RepositorioPedidoImpl repositorioPedido = Mockito.mock(RepositorioPedidoImpl.class);

    ServicioBebidaImpl instancia = new ServicioBebidaImpl(repositorio,repositorioPedido);

    @Test
    public void consultarBebidasByMenuId() {
        //given:
        Bebida bebida = new Bebida();
        Bebida bebida2 = new Bebida();
        Menu menu=new Menu();

        menu.setId(1L);
        menu.setDescripcion("soy una descripcion");

        bebida.setMenu(menu);
        bebida2.setMenu(menu);

        List<ItemMenu> lista = new ArrayList<>();

        lista.add(bebida);
        lista.add(bebida2);

        when(repositorio.getBebidasByMenuId(menu.getId())).thenReturn(lista);

        //when: Getting bebida by menu id
        List<ItemMenu> resultado = instancia.getBebidasByMenuId(menu.getId());

        //then: The list should be size 2
        assertThat(resultado.size()).isEqualTo(2);
    }
}
