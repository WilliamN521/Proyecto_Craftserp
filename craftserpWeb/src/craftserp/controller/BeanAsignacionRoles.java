package craftserp.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import craftserp.model.entities.SegAsignacionRole;
import craftserp.model.entities.SegCiudad;
import craftserp.model.manager.ManagerAsignacionRoles;


@Named
@SessionScoped
public class BeanAsignacionRoles implements Serializable{
	@EJB
	private ManagerAsignacionRoles managerRol;
	private List<SegAsignacionRole> listaRol;
	private SegAsignacionRole rol;
	private String idcedula;	
	private int idtipousuario;
	private SegAsignacionRole rolSelecionada;
	

	@PostConstruct
	public void inicializar() {
		listaRol = managerRol.findAllRol();
		rol=new SegAsignacionRole();
	}
	public void actionListenerRol() {
		try {
			managerRol.insertarAsignacionRol(idtipousuario, idcedula);
			listaRol = managerRol.findAllRol();
			rol= new SegAsignacionRole();
			JSFUtil.crearMensajeInfo("Datos de roles Registrada");			   
		} catch (Exception e) {
			JSFUtil.crearMensajeError("Este usuario ya se encuentra registrada");
		}
	}
	//sirve para eliminar
		public void actionListenerEliminarRol(Integer idrol) {
			managerRol.eliminarAsignacionRoles(idrol);
			listaRol= managerRol.findAllRol();
			JSFUtil.crearMensajeInfo("Ciudad eliminado");
		}

		public void actionListenerSeleccionarRol(SegAsignacionRole rol) {
			rolSelecionada= rol;
		}

		public void actionListenerActualizarRol() {
			try {
				managerRol.actualizarAsignacionRoles(rolSelecionada, idtipousuario, idcedula);
				listaRol= managerRol.findAllRol();
				JSFUtil.crearMensajeInfo("Datos actualizados.");
			} catch (Exception e) {
				JSFUtil.crearMensajeError(e.getMessage());
				e.printStackTrace();
			}
		}
	//set y get
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
	public SegAsignacionRole getRolSelecionada() {
		return rolSelecionada;
	}
	public void setRolSelecionada(SegAsignacionRole rolSelecionada) {
		this.rolSelecionada = rolSelecionada;
	}
	

}
