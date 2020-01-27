package craftserp.model.manager;

import java.sql.Timestamp;
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
 * Session Bean implementation class ManagerAsignacionRoles
 */
@Stateless
@LocalBean
public class ManagerAsignacionRoles {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerAsignacionRoles() {
        // TODO Auto-generated constructor stub
    }
    public List<SegAsignacionRole> findAllRol() {
		String consulta = "SELECT s FROM SegAsignacionRole s";
		Query q = em.createQuery(consulta, SegAsignacionRole.class);
		return q.getResultList();
	}

	// me sirve para buscar el rol
	public SegAsignacionRole findAsignacionRolById(Integer id) {
		return em.find(SegAsignacionRole.class, id);
	}

	public void insertarAsignacionRol(int idtipousuario,String idcedula) {
		SegAsignacionRole rol=new SegAsignacionRole();
		SegTipoUsuario tipousuario = (SegTipoUsuario) em.find(SegTipoUsuario.class, idtipousuario);
		SegPersona persona = (SegPersona) em.find(SegPersona.class, idcedula);
		rol.setSegPersona(persona);
		rol.setSegTipoUsuario(tipousuario);
		em.persist(rol);
	}
	//metodo para eliminar la ciudad
		public void eliminarAsignacionRoles(Integer idasignacionRoles) {
			SegAsignacionRole rol = findAsignacionRolById(idasignacionRoles);
			if (rol!= null)
				em.remove(rol);
		}
	//metodo para actualizar la ciudad
		public void actualizarAsignacionRoles(SegAsignacionRole rol,int tipousuario,String cedula) throws Exception {
			SegTipoUsuario usuario = (SegTipoUsuario) em.find(SegTipoUsuario.class, tipousuario);
			SegPersona persona=(SegPersona) em.find(SegPersona.class, cedula);
			SegAsignacionRole roles = findAsignacionRolById(rol.getIdAsignacionRol());
			if (roles == null)
				throw new Exception("No existe la ciudad con la nombre especifica");
			rol.setSegPersona(persona);
			rol.setSegTipoUsuario(usuario);
			em.merge(rol);
		}
	

}
