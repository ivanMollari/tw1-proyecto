package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
//@Table("Postre")
public class Postre implements ItemMenu{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;
    private Double tiempoPreparacion;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="menu_id", nullable =false)
    Menu menu;




    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }

    @Override
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTiempoPreparacion() {
		return tiempoPreparacion;
	}
	public void setTiempoPreparacion(Double tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}
	public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Menu getMenu() { return menu; }
    public void setMenu(Menu menu) { this.menu = menu; }



}
