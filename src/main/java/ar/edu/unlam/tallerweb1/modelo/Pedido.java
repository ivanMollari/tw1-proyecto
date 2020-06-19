package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pedido {

    @Id
    @GeneratedValue
    private Long id;

    private Float total;

    @ManyToOne
    private Usuario usuario;


    @ManyToMany
    @JoinColumn(name="comida_id")
    Set<Comida> comidas;

    @ManyToMany
    @JoinColumn(name="bebida_id")
    Set<Bebida> bebidas;

    @ManyToMany
    @JoinColumn(name="entrada_id")
    Set<Entrada> entradas;

    @ManyToMany
    @JoinColumn(name="postre_id")
    Set<Postre> postres;


    public Set<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(Set<Comida> comidas) {
        this.comidas = comidas;
    }

    public Set<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(Set<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public Set<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(Set<Entrada> entradas) {
        this.entradas = entradas;
    }

    public Set<Postre> getPostres() {
        return postres;
    }

    public void setPostres(Set<Postre> postres) {
        this.postres = postres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
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
}
