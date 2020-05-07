package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
//@Table("RESTOS")
public class Restaurant {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 12)
    private String nombre;

    private Integer estrellaMichelin;

    private Integer cantidadMesas;

    public Long getId(){ return this.id; };
    public void setId(Long id){ this.id = id; };

    public String getNombre(){ return this.nombre; };
    public void setNombre(String nombre) { this.nombre = nombre; };


    public Integer getCantidadMesas(){ return this.cantidadMesas; };
    public void setCantidadMesas(Integer cantidadMesas) { this.cantidadMesas = cantidadMesas; };

    public Integer getEstrellaMichelin(){ return this.estrellaMichelin; };
    public void setEstrellaMichelin(Integer estrellaMichellin) { this.estrellaMichelin = estrellaMichellin; };

}
