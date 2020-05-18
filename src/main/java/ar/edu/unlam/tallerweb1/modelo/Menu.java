package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table("Menu")
public class Menu {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    private Long precioDeLista;
    private String nombre;
    private String descripcion;

    @OneToMany
    private List<Comida>menu;

    public Long getMenuId() {
        return menuId;
    }

    public Long getPrecioDeLista() {
        return precioDeLista;
    }

    public void setPrecioDeLista(Long precioDeLista) {
        this.precioDeLista = precioDeLista;
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
