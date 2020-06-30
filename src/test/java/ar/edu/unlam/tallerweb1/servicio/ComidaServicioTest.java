package ar.edu.unlam.tallerweb1.servicio;

import ar.edu.unlam.tallerweb1.modelo.Comida;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Restaurant;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComidaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedidoImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurantImpl;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ComidaServicioTest {
    RepositorioComidaImpl repositorio= Mockito.mock(RepositorioComidaImpl.class);
    RepositorioPedidoImpl repositorioPedido= Mockito.mock(RepositorioPedidoImpl.class);

    ServicioComidaImpl instancia=new ServicioComidaImpl(repositorio,repositorioPedido);

    @Test
    public void consultarComidasByMenuId() {
        //given:
        Comida comida = new Comida();
        Comida comida2 = new Comida();
        Menu menu=new Menu();

        menu.setId(1L);
        menu.setDescripcion("soy una descripcion");

        comida.setMenu(menu);
        comida2.setMenu(menu);

        List<ItemMenu> lista = new ArrayList<>();

        lista.add(comida);
        lista.add(comida2);

        when(repositorio.getComidasByMenuId(menu.getId())).thenReturn(lista);

        //when: Getting Comida by menu id
        List<ItemMenu> resultado = instancia.getComidasByMenuId(menu.getId());

        //then: The list should be size 2
        assertThat(resultado).hasSize(2);
    }
}
