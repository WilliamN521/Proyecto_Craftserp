package craftserp.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the prd_estado database table.
 * 
 */
@Entity
@Table(name="prd_estado")
@NamedQuery(name="PrdEstado.findAll", query="SELECT p FROM PrdEstado p")
public class PrdEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado", unique=true, nullable=false)
	private Integer idEstado;

	@Column(nullable=false, length=50)
	private String nombre;

	public PrdEstado() {
	}

	public Integer getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}