package ar.edu.unlam.tallerweb1.modelo;

import org.hibernate.mapping.PrimaryKey;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.List;

@Entity
public class Menu {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String descripcion;


    @OneToMany(fetch =FetchType.EAGER)
    List<Comida> comidas;

    @OneToMany(fetch =FetchType.EAGER)
    List<Bebida> bebidas;

    @OneToMany(fetch =FetchType.EAGER)
    List<Postre> postres;

    @OneToMany(fetch =FetchType.EAGER)
    List<Entrada> entradas;


    public Long getMenuId() {
        return Id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMenuId(Long id) {
        this.Id = id;
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

    public List<Postre> getPostres() {
        return postres;
    }
    public void setPostres(List<Postre> postres) {
        this.postres = postres;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }
    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
