package craftserp.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_tipo_usuario database table.
 * 
 */
@Entity
@Table(name="seg_tipo_usuario")
@NamedQuery(name="SegTipoUsuario.findAll", query="SELECT s FROM SegTipoUsuario s")
public class SegTipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_usuario")
	private Integer idTipoUsuario;

	private String nombre;

	//bi-directional many-to-one association to SegAsignacionRole
	@OneToMany(mappedBy="segTipoUsuario")
	private List<SegAsignacionRole> segAsignacionRoles;

	public SegTipoUsuario() {
	}

	public Integer getIdTipoUsuario() {
		return this.idTipoUsuario;
	}

	public void setIdTipoUsuario(Integer idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<SegAsignacionRole> getSegAsignacionRoles() {
		return this.segAsignacionRoles;
	}

	public void setSegAsignacionRoles(List<SegAsignacionRole> segAsignacionRoles) {
		this.segAsignacionRoles = segAsignacionRoles;
	}

	public SegAsignacionRole addSegAsignacionRole(SegAsignacionRole segAsignacionRole) {
		getSegAsignacionRoles().add(segAsignacionRole);
		segAsignacionRole.setSegTipoUsuario(this);

		return segAsignacionRole;
	}

	public SegAsignacionRole removeSegAsignacionRole(SegAsignacionRole segAsignacionRole) {
		getSegAsignacionRoles().remove(segAsignacionRole);
		segAsignacionRole.setSegTipoUsuario(null);

		return segAsignacionRole;
	}

}