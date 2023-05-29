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
@Table(name = "fechaingreso")
public class FechaIngreso implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idfechaingreso;
	
	@ManyToOne
	@JoinColumn(name = "id_recluso")
	private Recluso recluso;
	
	private Boolean es_valida;

	

	public Long getIdfechaingreso() {
		return idfechaingreso;
	}

	public void setIdfechaingreso(Long idfechaingreso) {
		this.idfechaingreso = idfechaingreso;
	}

	public Recluso getRecluso() {
		return recluso;
	}

	public void setRecluso(Recluso recluso) {
		this.recluso = recluso;
	}

	public boolean isEs_valida() {
		return es_valida;
	}

	public void setEs_valida(boolean es_valida) {
		this.es_valida = es_valida;
	}
	
	
}
