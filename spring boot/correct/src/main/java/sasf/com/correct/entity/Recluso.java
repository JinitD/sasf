package sasf.com.correct.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "reclusos")
public class Recluso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idrecluso;
	
	private String nombre;
	private String delitos;
	private String sentencia;
	private String informacion_adicional;
	
	@ManyToOne
	@JoinColumn(name = "id_celda")
	private Celda celda;
	
	
	
	
	public Long getIdrecluso() {
		return idrecluso;
	}
	public void setIdrecluso(Long idrecluso) {
		this.idrecluso = idrecluso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDelitos() {
		return delitos;
	}
	public void setDelitos(String delitos) {
		this.delitos = delitos;
	}
	public String getSentencia() {
		return sentencia;
	}
	public void setSentencia(String sentencia) {
		this.sentencia = sentencia;
	}
	public String getInformacion_adicional() {
		return informacion_adicional;
	}
	public void setInformacion_adicional(String informacion_adicional) {
		this.informacion_adicional = informacion_adicional;
	}
	public Celda getCelda() {
		return celda;
	}
	public void setCelda(Celda celda) {
		this.celda = celda;
	}

	
}
