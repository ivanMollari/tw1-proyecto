package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table("Restaurant")
public class Restaurant{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	@Column (nullable = false)
	private String nombre;
	
	@ManyToOne()
	@JoinColumn(name= "id_mapa", referencedColumnName= "id")
	private Mapa mapa;
	private  Double latitudResto;
	private Double longitudResto;
	
	private Integer cantMesas;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="menu_id", referencedColumnName="id")
    private Menu menu;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantMesas() {
		return cantMesas;
	}

	public void setCantMesas(Integer cantMesas) {
		this.cantMesas = cantMesas;
	}

	public Integer modificarCantMesas(Integer cantMesasMod) {
		return cantMesas= cantMesasMod;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public Double getLatitudResto() {
		return latitudResto;
	}

	public void setLatitudResto(Double latitudResto) {
		this.latitudResto = latitudResto;
	}

	public Double getLongitudResto() {
		return longitudResto;
	}

	public void setLongitudResto(Double longitudResto) {
		this.longitudResto = longitudResto;
	}
	
	
	
	
}