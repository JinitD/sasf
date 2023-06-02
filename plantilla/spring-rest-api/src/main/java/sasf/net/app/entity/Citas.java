package sasf.net.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "citas")
public class Citas implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Users paciente;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medico_id", nullable = false)
    private Users medico;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enfermero_id", nullable = false)
    private Users enfermero;
    
    @Size(max = 1)
	@Column(name = "status", length = 1)
	private String status;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_area_conocimiento", nullable = false)
    private AreaConocimineto areaConocimiento;
    
    @Column(name = "fechacita")
	private Date fechacita;
    
   	@Column(name = "observaciones")
   	private String observaciones;
    
   	@Column(name = "recetamedica")
   	private String recetaMedica;

	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the paciente
	 */
	public Users getPaciente() {
		return paciente;
	}

	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(Users paciente) {
		this.paciente = paciente;
	}

	/**
	 * @return the medico
	 */
	public Users getMedico() {
		return medico;
	}

	/**
	 * @param medico the medico to set
	 */
	public void setMedico(Users medico) {
		this.medico = medico;
	}

	/**
	 * @return the enfermero
	 */
	public Users getEnfermero() {
		return enfermero;
	}

	/**
	 * @param enfermero the enfermero to set
	 */
	public void setEnfermero(Users enfermero) {
		this.enfermero = enfermero;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AreaConocimineto getAreaConocimiento() {
		return areaConocimiento;
	}

	public void setAreaConocimiento(AreaConocimineto areaConocimiento) {
		this.areaConocimiento = areaConocimiento;
	}

	public Date getFechacita() {
		return fechacita;
	}

	public void setFechacita(Date fechacita) {
		this.fechacita = fechacita;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getRecetaMedica() {
		return recetaMedica;
	}

	public void setRecetaMedica(String recetaMedica) {
		this.recetaMedica = recetaMedica;
	}
   	
   	

}
