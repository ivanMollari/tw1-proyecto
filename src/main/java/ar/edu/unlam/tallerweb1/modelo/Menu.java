package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Menu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return Id;
    }
}
