package ar.edu.unlam.tallerweb1.servicio;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.modelo.dto.RequestPedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedidoImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurantImpl;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class PedidoServiceTest {


        RepositorioPedidoImpl repositorio = Mockito.mock(RepositorioPedidoImpl.class);


        ServicioPedidoImpl instancia = new ServicioPedidoImpl(repositorio);

        @Test
        public void testMostrarPedido() {

            // given:
            Usuario usuario=new Usuario();
            usuario.setId(1L);
            Pedido pedido=new Pedido();
            Pedido pedido2=new Pedido();
            List<Pedido>pedidos=new ArrayList<>();
            pedidos.add(pedido);
            pedidos.add(pedido2);
            when(repositorio.buscarPedidosUsuario(any())).thenReturn(pedidos);

            // when:
            List<Pedido> resultado = instancia.mostrarPedidosUsuario(usuario);

            // then:
            assertThat(resultado.size()).isEqualTo(2);
        }

    }