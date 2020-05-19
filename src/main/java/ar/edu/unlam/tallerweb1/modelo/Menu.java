package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Menu {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Long precioDeLista;
    private String nombre;
    private String descripcion;



    @ManyToMany
    List<Comida> comidas;


    public Long getMenuId() {
        return Id;
    }

    public Long getPrecioDeLista() {
        return precioDeLista;
    }

    public void setPrecioDeLista(Long precioDeLista) {
        this.precioDeLista = precioDeLista;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
