package hn.gob.sefin.covid.pojo;

import java.io.Serializable;

public class Egreso implements Serializable {

	private static final long serialVersionUID = -1117455802508702428L;
	
	private String titulo;
    private String descripcion;
    private double precio;


    public Egreso() {	
    
    }
    
    public Egreso(String titulo,String descripcion,double precio) {
    	setTitulo(titulo);
    	setDescripcion(descripcion);
    	setPrecio(precio);
    }
    
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
    
}
