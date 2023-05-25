package sasf.com.correct.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;






@Entity
@Table(name = "details")
public class Details implements Serializable{

	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddetails;
	
	private String nombre;
	private String area;
	private String informacion_adicional;
	private String rol;
	
	
	
	public Long getIddetails() {
		return iddetails;
	}
	public void setIddetails(Long iddetails) {
		this.iddetails = iddetails;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getInformacion_adicional() {
		return informacion_adicional;
	}
	public void setInformacion_adicional(String informacion_adicional) {
		this.informacion_adicional = informacion_adicional;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	
	
}
