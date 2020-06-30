package ar.edu.unlam.tallerweb1.modelo;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue
    private Long id;

    private Double total;

    @ManyToOne
    private Usuario usuario;


    @ManyToMany
    @JoinColumn(name="comida_id")
    List<Comida> comidas;

    @ManyToMany
    @JoinColumn(name="bebida_id")
    List<Bebida> bebidas;

    @ManyToMany
    @JoinColumn(name="entrada_id")
    List<Entrada> entradas;

    @ManyToMany
    @JoinColumn(name="postre_id")
    List<Postre> postres;

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    Restaurant restaurant;
    
  /*  @ManyToMany
    @JoinColumn(name="lista_id")
    List<ItemMenu> pedidos;*/
    
    

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Pedido(){
        comidas=new ArrayList<Comida>();
        bebidas=new ArrayList<Bebida>();
        entradas=new ArrayList<Entrada>();
        postres=new ArrayList<Postre>();
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public List<Postre> getPostres() {
        return postres;
    }

    public void setPostres(List<Postre> postres) {
        this.postres = postres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void agregarComida(Comida comida) {
        this.comidas.add(comida);
    }



	/*public List<ItemMenu> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<ItemMenu> pedidos) {
		this.pedidos = pedidos;
	}*/
    
    
}
