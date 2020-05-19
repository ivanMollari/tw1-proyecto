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


    @ManyToMany
    List<Comida> comidas;


    public Long getMenuId() {
        return Id;
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

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
