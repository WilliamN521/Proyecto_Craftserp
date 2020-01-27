package craftserp.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the seg_persona database table.
 * 
 */
@Entity
@Table(name="seg_persona")
@NamedQuery(name="SegPersona.findAll", query="SELECT s FROM SegPersona s")
public class SegPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cedula")
	private String idCedula;

	private String apellido;

	private String contrasenia;

	private String direccion;

	@Column(name="fecha_registro")
	private Timestamp fechaRegistro;

	private String genero;

	private String mail;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to SegAsignacionRole
	@OneToMany(mappedBy="segPersona")
	private List<SegAsignacionRole> segAsignacionRoles;

	//bi-directional many-to-one association to SegCiudad
	@ManyToOne
	@JoinColumn(name="id_ciudad")
	private SegCiudad segCiudad;

	//bi-directional many-to-one association to SegEstadoCivil
	@ManyToOne
	@JoinColumn(name="estado_civil")
	private SegEstadoCivil segEstadoCivil;

	public SegPersona() {
	}

	public String getIdCedula() {
		return this.idCedula;
	}

	public void setIdCedula(String idCedula) {
		this.idCedula = idCedula;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<SegAsignacionRole> getSegAsignacionRoles() {
		return this.segAsignacionRoles;
	}

	public void setSegAsignacionRoles(List<SegAsignacionRole> segAsignacionRoles) {
		this.segAsignacionRoles = segAsignacionRoles;
	}

	public SegAsignacionRole addSegAsignacionRole(SegAsignacionRole segAsignacionRole) {
		getSegAsignacionRoles().add(segAsignacionRole);
		segAsignacionRole.setSegPersona(this);

		return segAsignacionRole;
	}

	public SegAsignacionRole removeSegAsignacionRole(SegAsignacionRole segAsignacionRole) {
		getSegAsignacionRoles().remove(segAsignacionRole);
		segAsignacionRole.setSegPersona(null);

		return segAsignacionRole;
	}

	public SegCiudad getSegCiudad() {
		return this.segCiudad;
	}

	public void setSegCiudad(SegCiudad segCiudad) {
		this.segCiudad = segCiudad;
	}

	public SegEstadoCivil getSegEstadoCivil() {
		return this.segEstadoCivil;
	}

	public void setSegEstadoCivil(SegEstadoCivil segEstadoCivil) {
		this.segEstadoCivil = segEstadoCivil;
	}

}