package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class RequestPedido {

    private Long id;
    private Double total;
   /* private Long idUsuario;
    private String email;
    private String password;
    private String rol;
    private Double latitud;
    private Double longitud;*/
    private Usuario usuario;
    private List<Long> id_comidas;
    private List<Long> id_bebidas;
    private List<Long> id_entradas;
    private List<Long> id_postre;
    private List<ItemMenu> pedido;
    private  Long id_restaurant;

    public  RequestPedido (){
        id_bebidas=new ArrayList<Long>();
        id_comidas=new ArrayList<Long>();
        id_entradas=new ArrayList<Long>();
        id_postre=new ArrayList<Long>();
        pedido = new ArrayList();
        total=0.0;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total=total;

    }
    public Double sumarTotal(ItemMenu comida) {
      return this.total+=comida.getPrecio();

    }
 /*   public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }*/

    public List<Long> getId_comidas() {
        return id_comidas;
    }

    public void setId_comidas(List<Long> id_comidas) {
        this.id_comidas = id_comidas;
    }

    public List<Long> getId_bebidas() {
        return id_bebidas;
    }

    public void setId_bebidas(List<Long> id_bebidas) {
        this.id_bebidas = id_bebidas;
    }

    public List<Long> getId_entradas() {
        return id_entradas;
    }

    public void setId_entradas(List<Long> id_entradas) {
        this.id_entradas = id_entradas;
    }

    public List<Long> getId_postre() {
        return id_postre;
    }

    public void setId_postre(List<Long> id_postre) {
        this.id_postre = id_postre;
    }

    public Long getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(Long id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public void agregarIdComida(Long idComida){
        this.id_comidas.add(idComida);
    }
    public void agregarIdEntrada(Long idEntrada){
        this.id_entradas.add(idEntrada);
    }
    public void agregarIdPostre(Long idPostre){
        this.id_postre.add(idPostre);
    }
    public void agregarIdBebida(Long idBebida){
        this.id_bebidas.add(idBebida);
    }
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<ItemMenu> getPedido() {
		return pedido;
	}
    public void agregarPedido(ItemMenu pedido){
        this.pedido.add(pedido);
    }
    
    


}
