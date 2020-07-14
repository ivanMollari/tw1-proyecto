package ar.edu.unlam.tallerweb1.servicio;

import ar.edu.unlam.tallerweb1.modelo.Entrada;
import ar.edu.unlam.tallerweb1.modelo.ItemMenu;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Postre;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEntradaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedidoImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioEntradaImpl;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class EntradaServicioTest {
    RepositorioEntradaImpl repositorio = Mockito.mock(RepositorioEntradaImpl.class);
    RepositorioPedidoImpl repositorioPedido = Mockito.mock(RepositorioPedidoImpl.class);

    ServicioEntradaImpl instancia = new ServicioEntradaImpl(repositorio,repositorioPedido);

    @Test
    public void consultarBebidasByMenuId() {
        //given:
        Entrada entrada = new Entrada();
        Entrada entrada2 = new Entrada();
        Menu menu=new Menu();

        menu.setId(1L);
        menu.setDescripcion("soy una descripcion");

        entrada.setMenu(menu);
        entrada2.setMenu(menu);

        List<ItemMenu> lista = new ArrayList<>();

        lista.add(entrada);
        lista.add(entrada2);

        when(repositorio.getEntradasByMenuId(menu.getId())).thenReturn(lista);

        //when: Getting entrada by menu id
        List<ItemMenu> resultado = instancia.getEntradasByMenuId(menu.getId());

        //then: The list should be size 2
        assertThat(resultado.size()).isEqualTo(2);
    }
    
    @Test
    public void consultarEntrada() {
    	Entrada entrada= new Entrada();
    	entrada.setId(1L);
    	
    	when((repositorio.consultarEntrada(entrada.getId()))).thenReturn(entrada);
    	
    	Entrada rabas = instancia.consultarEntrada(entrada.getId());
    	
    	assertThat(rabas).isNotNull();
    	assertThat(rabas.getId()).isEqualTo(1L);
    }
}
