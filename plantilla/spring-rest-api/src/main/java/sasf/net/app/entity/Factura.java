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

@Entity
@Table(name = "factura")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "estado", length = 1, nullable = false)
	private String estado;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paciente_id", nullable = false)
	private Users users;
	
	@Column(name = "fechafactura")
	private Date fechafactura;

	@Column(name = "total", nullable = false)
	private double total;
}
