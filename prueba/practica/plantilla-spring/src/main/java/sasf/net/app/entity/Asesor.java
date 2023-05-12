package sasf.net.app.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "asesor")
public class Asesor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idasesor;

	private String nomber;
	private String telefono;

	@OneToMany(mappedBy = "asesor")
	private List<Inmueble> inmuebles;

	public Long getIdasesor() {
		return idasesor;
	}

	public void setIdasesor(Long idasesor) {
		this.idasesor = idasesor;
	}

	public String getNomber() {
		return nomber;
	}

	public void setNomber(String nomber) {
		this.nomber = nomber;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
