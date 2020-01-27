package craftserp.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import craftserp.model.entities.SegCiudad;
import craftserp.model.entities.SegTipoUsuario;
import craftserp.model.manager.ManagerTipoUsuario;

@Named
@SessionScoped
public class BeanTipoUsuario implements Serializable {
	private String nombreTipoUsuario;

	@EJB
	private ManagerTipoUsuario managerTipoUsuario;
	private List<SegTipoUsuario> listaTipoUsuario;
	private SegTipoUsuario tipousuario;
	private int id;
	private SegTipoUsuario tipoUsuarioSelecionado;

	@PostConstruct
	public void inicializar() {
		listaTipoUsuario = managerTipoUsuario.findAllTipoUsuario();
		tipousuario = new SegTipoUsuario();
		tipoUsuarioSelecionado = new SegTipoUsuario();
	}

	public void actionListenerInsertarTipoUsuario() {
		try {
			managerTipoUsuario.insertarTipoUsuario(nombreTipoUsuario);
			listaTipoUsuario = managerTipoUsuario.findAllTipoUsuario();
			tipousuario = new SegTipoUsuario();
			JSFUtil.crearMensajeInfo("Datos de tipo de usuario registrada");
		} catch (Exception e) {
			JSFUtil.crearMensajeError("Este tipo de usuario ya se encuentra registrada");
		}
	}

	// eliminar tipo de usuario
	public String eliminarUsuario(Integer id) {
		try {
			System.out.println("id: " + id);
			managerTipoUsuario.eliminarTipoUsuario(id);
			listaTipoUsuario = managerTipoUsuario.findAllTipoUsuario();
			System.out.println("eliminado");

		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}
		return "registro_tipo_usuario.xhtml";
	}

	//
	public void actionListenerSeleccionarTipoUsuario(SegTipoUsuario tipousuario) {
		tipoUsuarioSelecionado = tipousuario;
	}

	public void actionListenerActualizarTipoUsuario() {
		try {
			managerTipoUsuario.actualizarCiudad(tipoUsuarioSelecionado);
			listaTipoUsuario = managerTipoUsuario.findAllTipoUsuario();
			JSFUtil.crearMensajeInfo("Datos actualizados.");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}

	// get y set

	public String getNombreTipoUsuario() {
		return nombreTipoUsuario;
	}

	public void setNombreTipoUsuario(String nombreTipoUsuario) {
		this.nombreTipoUsuario = nombreTipoUsuario;
	}

	public List<SegTipoUsuario> getListaTipoUsuario() {
		return listaTipoUsuario;
	}

	public void setListaTipoUsuario(List<SegTipoUsuario> listaTipoUsuario) {
		this.listaTipoUsuario = listaTipoUsuario;
	}

	public SegTipoUsuario getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(SegTipoUsuario tipousuario) {
		this.tipousuario = tipousuario;
	}

	public SegTipoUsuario getTipoUsuarioSelecionado() {
		return tipoUsuarioSelecionado;
	}

	public void setTipoUsuarioSelecionado(SegTipoUsuario tipoUsuarioSelecionado) {
		this.tipoUsuarioSelecionado = tipoUsuarioSelecionado;
	}

}