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
@Table(name = "celda")
public class Celda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcelda;
	
	private int capacidad;
	
	@ManyToOne
	@JoinColumn(name = "id_pabellon")
	private Pabellon pabellon;
	
	@ManyToOne
	@JoinColumn(name = "id_guardia")
	private User guardia;

	public Long getIdcelda() {
		return idcelda;
	}

	public void setIdcelda(Long idcelda) {
		this.idcelda = idcelda;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Pabellon getPabellon() {
		return pabellon;
	}

	public void setPabellon(Pabellon pabellon) {
		this.pabellon = pabellon;
	}

	public User getGuardia() {
		return guardia;
	}

	public void setGuardia(User guardia) {
		this.guardia = guardia;
	}
	
	
	
	

}