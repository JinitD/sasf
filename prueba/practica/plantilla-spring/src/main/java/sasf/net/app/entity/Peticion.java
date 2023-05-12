package sasf.net.app.entity;

import java.io.Serializable;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "peticion")

public class Peticion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpeticion;
	
	private char status;

	@ManyToOne
	@JoinColumn(name = "idcliente")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "idinmueble")
	private Inmueble inmueble;

	public Long getIdpeticion() {
		return idpeticion;
	}

	public void setIdpeticion(Long idpeticion) {
		this.idpeticion = idpeticion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	

}
