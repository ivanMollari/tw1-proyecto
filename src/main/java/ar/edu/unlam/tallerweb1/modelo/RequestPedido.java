package ar.edu.unlam.tallerweb1.modelo;



import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class RequestPedido {


    private Long idRequestPedido;
    private Double total;
    private Long idUsuario;
    private String email;
    private String password;
    private String rol;
    private Double latitud;
    private Double longitud;
    private Usuario usuario;
    private List<Long> idEntradas;
    private List<Long> idConmidas;
    private List<Long> idPostres;
    private List<Long> idBebidas;
    private Long id_restaurant;
    private List<ItemMenu> pedido;

    public  RequestPedido (){
        idEntradas=new ArrayList<>();
        idConmidas=new ArrayList<>();
        idPostres=new ArrayList<>();
        idBebidas=new ArrayList<>();
        pedido=new ArrayList<>();
        total=0.0;
    }
    public Long getId() {
        return idRequestPedido;
    }

    public void setId(Long id) {
        this.idRequestPedido = id;
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
   public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void agregarPedido(ItemMenu comida){
        pedido.add(comida);
    }

    public List<Long> getIdEntradas() {
        return idEntradas;
    }

    public void setIdEntradas(List<Long> idEntradas) {
        this.idEntradas = idEntradas;
    }

    public List<Long> getIdConmidas() {
        return idConmidas;
    }

    public void setIdConmidas(List<Long> idConmidas) {
        this.idConmidas = idConmidas;
    }

    public List<Long> getIdPostres() {
        return idPostres;
    }

    public void setIdPostres(List<Long> idPostres) {
        this.idPostres = idPostres;
    }

    public List<Long> getIdBebidas() {
        return idBebidas;
    }

    public void setIdBebidas(List<Long> idBebidas) {
        this.idBebidas = idBebidas;
    }

    public void setPedido(List<ItemMenu> pedido) {
        this.pedido = pedido;
    }



    public List<ItemMenu> getPedido() {
        return pedido;
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
    }



    public Long getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(Long id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public void agregarComida(ItemMenu menu){

        if (menu.getClass().equals(Entrada.class)){
            this.idEntradas.add(((Entrada) menu).getId());
        }
        if (menu.getClass().equals(Comida.class)){
            this.idConmidas.add(((Comida) menu).getId());
        }
        if (menu.getClass().equals(Postre.class)){
            this.idPostres.add(((Postre) menu).getId());
        }
        if (menu.getClass().equals(Bebida.class)){
            this.idBebidas.add(((Bebida) menu).getId());
        }

    }

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

    public Long getIdRequestPedido() {
        return idRequestPedido;
    }
    public void setIdRequestPedido(Long idRequestPedido) {
        this.idRequestPedido = idRequestPedido;
    }



    


}
