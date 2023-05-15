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
public class Peticion  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpeticion;
	
    private char estado;

    @ManyToOne
    @JoinColumn(name = "fk_idinmueble")
    private Inmueble inmueble;

    @ManyToOne
    @JoinColumn(name = "fk_idcliente")
    private Usuario cliente;

	public Long getIdpeticion() {
		return idpeticion;
	}

	public void setIdpeticion(Long idpeticion) {
		this.idpeticion = idpeticion;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	
    
    
}
