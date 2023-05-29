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
@Table(name = "pabellon")
public class Pabellon implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpabellon;

	private String nombre;

	private int capacidad;

	@ManyToOne
	@JoinColumn(name = "id_personal_vigilancia")
	private User personavigilancia;



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

	public User getPersonavigilancia() {
		return personavigilancia;
	}

	public void setPersonavigilancia(User personavigilancia) {
		this.personavigilancia = personavigilancia;
	}
}
