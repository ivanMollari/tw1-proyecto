/*package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Farmacia{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private Integer cantidadDeEmpleados;
	private String diaTurno;
	@ManyToOne(targetEntity = Barrio.class)
	@JoinColumn(name= "id_barrio", referencedColumnName= "id")
	private Barrio barrio;
	
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
	public Integer getCantidadDeEmpleados() {
		return cantidadDeEmpleados;
	}
	public void setCantidadDeEmpleados(Integer cantidadDeEmpleados) {
		this.cantidadDeEmpleados = cantidadDeEmpleados;
	}
	public String getDiaTurno() {
		return diaTurno;
	}
	public void setDiaTurno(String diaTurno) {
		this.diaTurno = diaTurno;
	}
	public Barrio getBarrio() {
		return barrio;
	}
	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}
	
	
	
}*/