/*package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Direccion{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String calle;
	private Integer numeroCalle;
	
	@ManyToOne(targetEntity= Barrio.class)
	@JoinColumn(name= "id_barrio", referencedColumnName= "id")
	private Barrio barrio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getNumeroCalle() {
		return numeroCalle;
	}
	public void setNumeroCalle(Integer numeroCalle) {
		this.numeroCalle = numeroCalle;
	}
	public Barrio getBarrio() {
		return barrio;
	}
	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}
	
	
	
}*/