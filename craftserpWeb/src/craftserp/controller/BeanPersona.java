package craftserp.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import craftserp.model.entities.SegAsignacionRole;
import craftserp.model.entities.SegCiudad;
import craftserp.model.entities.SegPersona;
import craftserp.model.manager.ManagerAsignacionRoles;
import craftserp.model.manager.ManagerPersona;

@Named
@SessionScoped
public class BeanPersona implements Serializable {
	private static final long SerialVersionUID = 1L;

	@EJB
	private ManagerPersona managerPersona;
	private List<SegPersona> listaPersona;
	private SegPersona persona;
	private int idCiudad;
	private int idEstadoCivil;
	private SegPersona cedulaSelecionada;
	//
	private ManagerAsignacionRoles managerRol;
	private List<SegAsignacionRole> listaRol;
	private SegAsignacionRole rol;
	private String idcedula;
	private int idtipousuario;

	@PostConstruct
	public void inicializar() {
		listaPersona = managerPersona.findAllPersona();
		persona = new SegPersona();
		//
		// listaRol = managerRol.findAllRol();
		// rol=new SegAsignacionRole();
	}

	public void actionListenerInsertarPersona() {
		try {
			managerPersona.insertarPersona(persona, idCiudad, idEstadoCivil);
			listaPersona = managerPersona.findAllPersona();
			persona = new SegPersona();
			JSFUtil.crearMensajeInfo("Datos de persona registrada");
			//
			// managerRol.insertarAsignacionRol(idtipousuario, persona.getIdCedula());
			// listaRol = managerRol.findAllRol();
			// rol= new SegAsignacionRole();
		} catch (Exception e) {
			JSFUtil.crearMensajeError("Esta persona ya se encuentra registrada");
		}
	}

	// sirve para eliminar
	public void actionListenerEliminarPersona(String cedula) {
		managerPersona.eliminarPersona(cedula);
		listaPersona = managerPersona.findAllPersona();
		JSFUtil.crearMensajeInfo("Ciudad eliminado");
	}

//selecionar a una persona
	public void actionListenerSeleccionarPersona(SegPersona persona) {
		cedulaSelecionada = persona;
	}

//sirve para actualizar
	public void actionListenerActualizarPersona() {
		try {
			managerPersona.actualizarPersona(cedulaSelecionada,idCiudad,idEstadoCivil);
			listaPersona = managerPersona.findAllPersona();
			JSFUtil.crearMensajeInfo("Datos actualizados.");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}

	// set y get
	public List<SegPersona> getListaPersona() {
		return listaPersona;
	}

	public void setListaPersona(List<SegPersona> listaPersona) {
		this.listaPersona = listaPersona;
	}

	public SegPersona getPersona() {
		return persona;
	}

	public void setPersona(SegPersona persona) {
		this.persona = persona;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public int getIdEstadoCivil() {
		return idEstadoCivil;
	}

	public void setIdEstadoCivil(int idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}
////////////////

	public List<SegAsignacionRole> getListaRol() {
		return listaRol;
	}

	public void setListaRol(List<SegAsignacionRole> listaRol) {
		this.listaRol = listaRol;
	}

	public SegAsignacionRole getRol() {
		return rol;
	}

	public void setRol(SegAsignacionRole rol) {
		this.rol = rol;
	}

	public String getIdcedula() {
		return idcedula;
	}

	public void setIdcedula(String idcedula) {
		this.idcedula = idcedula;
	}

	public int getIdtipousuario() {
		return idtipousuario;
	}

	public void setIdtipousuario(int idtipousuario) {
		this.idtipousuario = idtipousuario;
	}

	public SegPersona getCedulaSelecionada() {
		return cedulaSelecionada;
	}

	public void setCedulaSelecionada(SegPersona cedulaSelecionada) {
		this.cedulaSelecionada = cedulaSelecionada;
	}

}
