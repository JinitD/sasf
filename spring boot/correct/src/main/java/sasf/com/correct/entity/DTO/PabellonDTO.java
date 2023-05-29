package sasf.com.correct.entity.DTO;

import java.io.Serializable;


public class PabellonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idpabellon;

	private String nombre;

	private int capacidad;

	private Long id_personal_vigilancia;

	public Long getIdpabellon() {
		return idpabellon;
	}

	public void setIdpabellon(Long idpabellon) {
		this.idpabellon = idpabellon;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Long getId_personal_vigilancia() {
		return id_personal_vigilancia;
	}

	public void setId_personal_vigilancia(Long id_personal_vigilancia) {
		this.id_personal_vigilancia = id_personal_vigilancia;
	}

	
	



}
