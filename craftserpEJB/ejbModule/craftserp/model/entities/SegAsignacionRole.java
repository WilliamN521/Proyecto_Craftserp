package craftserp.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_asignacion_roles database table.
 * 
 */
@Entity
@Table(name="seg_asignacion_roles")
@NamedQuery(name="SegAsignacionRole.findAll", query="SELECT s FROM SegAsignacionRole s")
public class SegAsignacionRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_asignacion_rol")
	private Integer idAsignacionRol;

	//bi-directional many-to-one association to SegPersona
	@ManyToOne
	@JoinColumn(name="id_cedula")
	private SegPersona segPersona;

	//bi-directional many-to-one association to SegTipoUsuario
	@ManyToOne
	@JoinColumn(name="\"id_tipoUsuario\"")
	private SegTipoUsuario segTipoUsuario;

	//bi-directional many-to-one association to VenFacturaCabecera
	@OneToMany(mappedBy="segAsignacionRole1")
	private List<VenFacturaCabecera> venFacturaCabeceras1;

	//bi-directional many-to-one association to VenFacturaCabecera
	@OneToMany(mappedBy="segAsignacionRole2")
	private List<VenFacturaCabecera> venFacturaCabeceras2;

	public SegAsignacionRole() {
	}

	public Integer getIdAsignacionRol() {
		return this.idAsignacionRol;
	}

	public void setIdAsignacionRol(Integer idAsignacionRol) {
		this.idAsignacionRol = idAsignacionRol;
	}

	public SegPersona getSegPersona() {
		return this.segPersona;
	}

	public void setSegPersona(SegPersona segPersona) {
		this.segPersona = segPersona;
	}

	public SegTipoUsuario getSegTipoUsuario() {
		return this.segTipoUsuario;
	}

	public void setSegTipoUsuario(SegTipoUsuario segTipoUsuario) {
		this.segTipoUsuario = segTipoUsuario;
	}

	public List<VenFacturaCabecera> getVenFacturaCabeceras1() {
		return this.venFacturaCabeceras1;
	}

	public void setVenFacturaCabeceras1(List<VenFacturaCabecera> venFacturaCabeceras1) {
		this.venFacturaCabeceras1 = venFacturaCabeceras1;
	}

	public VenFacturaCabecera addVenFacturaCabeceras1(VenFacturaCabecera venFacturaCabeceras1) {
		getVenFacturaCabeceras1().add(venFacturaCabeceras1);
		venFacturaCabeceras1.setSegAsignacionRole1(this);

		return venFacturaCabeceras1;
	}

	public VenFacturaCabecera removeVenFacturaCabeceras1(VenFacturaCabecera venFacturaCabeceras1) {
		getVenFacturaCabeceras1().remove(venFacturaCabeceras1);
		venFacturaCabeceras1.setSegAsignacionRole1(null);

		return venFacturaCabeceras1;
	}

	public List<VenFacturaCabecera> getVenFacturaCabeceras2() {
		return this.venFacturaCabeceras2;
	}

	public void setVenFacturaCabeceras2(List<VenFacturaCabecera> venFacturaCabeceras2) {
		this.venFacturaCabeceras2 = venFacturaCabeceras2;
	}

	public VenFacturaCabecera addVenFacturaCabeceras2(VenFacturaCabecera venFacturaCabeceras2) {
		getVenFacturaCabeceras2().add(venFacturaCabeceras2);
		venFacturaCabeceras2.setSegAsignacionRole2(this);

		return venFacturaCabeceras2;
	}

	public VenFacturaCabecera removeVenFacturaCabeceras2(VenFacturaCabecera venFacturaCabeceras2) {
		getVenFacturaCabeceras2().remove(venFacturaCabeceras2);
		venFacturaCabeceras2.setSegAsignacionRole2(null);

		return venFacturaCabeceras2;
	}

}