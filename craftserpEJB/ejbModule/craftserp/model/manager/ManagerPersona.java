package craftserp.model.manager;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import craftserp.model.entities.SegAsignacionRole;
import craftserp.model.entities.SegCiudad;
import craftserp.model.entities.SegEstadoCivil;
import craftserp.model.entities.SegPersona;
import craftserp.model.entities.SegTipoUsuario;

/**
 * Session Bean implementation class ManagerPersona
 */
@Stateless
@LocalBean
public class ManagerPersona {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ManagerPersona() {
		// TODO Auto-generated constructor stub
	}

	// me sirve para consultar las las personas
	public List<SegPersona> findAllPersona() {
		String consulta = "SELECT s FROM SegPersona s";
		Query q = em.createQuery(consulta, SegPersona.class);
		return q.getResultList();
	}

	// me sirve para buscar la cedula
	public SegPersona findPersonaByCedula(String cedula) {
		return em.find(SegPersona.class, cedula);
	}

	// me sirve para registrar las personas
	public void insertarPersona(SegPersona persona, int idciudad, int idestadocivil) {
		SegCiudad ciudad = (SegCiudad) em.find(SegCiudad.class, idciudad);
		SegEstadoCivil estadocivil = (SegEstadoCivil) em.find(SegEstadoCivil.class, idestadocivil);
		Date date=new Date();
		
		persona.setSegCiudad(ciudad);
		persona.setSegEstadoCivil(estadocivil);
		persona.setFechaRegistro(new Timestamp(date.getTime()));
		em.persist(persona);
	}

	// metodo para eliminar la persona
	public void eliminarPersona(String cedula) {
		SegPersona persona = findPersonaByCedula(cedula);
		if (persona != null)
			em.remove(persona);
	}

	// metodo para actualizar la persona
	public void actualizarPersona(SegPersona p, int idciudad, int idestadocivil) throws Exception {
		SegCiudad ciudad = (SegCiudad) em.find(SegCiudad.class, idciudad);
		SegEstadoCivil estadocivil = (SegEstadoCivil) em.find(SegEstadoCivil.class, idestadocivil);
		SegPersona persona = findPersonaByCedula(p.getIdCedula());
		if (persona == null)
			throw new Exception("No existe la persona con el nombre especifica");
		persona.setNombre(p.getNombre());
		persona.setApellido(p.getApellido());
		persona.setTelefono(p.getTelefono());
		persona.setMail(p.getMail());
		persona.setGenero(p.getGenero());
		persona.setDireccion(p.getDireccion());
		persona.setFechaRegistro(p.getFechaRegistro());
		persona.setContrasenia(p.getContrasenia());
		persona.setSegCiudad(ciudad);
		persona.setSegEstadoCivil(estadocivil);
		em.merge(persona);
	}

/////////
	public List<SegAsignacionRole> findAllRol() {
		String consulta = "SELECT s FROM SegPersona s";
		Query q = em.createQuery(consulta, SegPersona.class);
		return q.getResultList();
	}

	// me sirve para buscar el rol
	public SegAsignacionRole findAsignacionRolByNombre(String nombre) {
		return em.find(SegAsignacionRole.class, nombre);
	}

	public void insertarAsignacionRol(int idtipousuario, String idcedula) {

		SegAsignacionRole rol = new SegAsignacionRole();
		SegTipoUsuario tipousuario = (SegTipoUsuario) em.find(SegTipoUsuario.class, idtipousuario);
		SegPersona persona = (SegPersona) em.find(SegPersona.class, idcedula);
		rol.setSegPersona(persona);
		rol.setSegTipoUsuario(tipousuario);
		em.persist(rol);
	}

}
