package ar.edu.unlam.tallerweb1.modelo;

import org.hibernate.mapping.PrimaryKey;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Menu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String descripcion;

    @OneToMany(mappedBy = "menu",fetch =FetchType.EAGER)
    Set<Comida> comidas;

    @OneToMany(mappedBy = "menu",fetch = FetchType.EAGER)
    Set<Bebida> bebidas;

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

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

    public Long getId() {
        return Id;
    }
}
