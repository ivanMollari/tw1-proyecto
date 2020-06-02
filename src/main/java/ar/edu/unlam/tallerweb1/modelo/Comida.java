package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
//@Table("Comida")
public class Comida {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Long precio;

    public Long getId() { return id; }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPrecio() {
        return precio;
    }
    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    @ManyToOne
    @JoinColumn(name="menu_id", nullable =false)
    Menu menu;
}
