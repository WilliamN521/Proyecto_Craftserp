package craftserp.model.manager;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import craftserp.model.entities.SegCiudad;
import craftserp.model.entities.SegTipoUsuario;

/**
 * Session Bean implementation class ManagerTipoUsuario
 */
@Stateless
@LocalBean
public class ManagerTipoUsuario {
	@PersistenceContext
	private EntityManager em;

	public ManagerTipoUsuario() {
		// TODO Auto-generated constructor stub
	}

	// me sirve para consultar el tipo de usuario
	public List<SegTipoUsuario> findAllTipoUsuario() {
		String consulta = "SELECT s FROM SegTipoUsuario s";
		Query q = em.createQuery(consulta, SegTipoUsuario.class);
		return q.getResultList();
	}

	public SegTipoUsuario findTipoUsuarioByNombre(String nombre) {
		return em.find(SegTipoUsuario.class, nombre);
	}

	public void insertarTipoUsuario(String nombre){
		SegTipoUsuario tipousuario = new SegTipoUsuario();
		//if (findTipoUsuarioByNombre(tipousuario.getNombre()) == null) 
		 //throw new Exception("Ya existe la ciudad indicada");			
		tipousuario.setNombre(nombre);
		
		em.persist(tipousuario);
		
	}

	// metodo para buscar por el id
	public SegTipoUsuario buscarTipoUsuario(Integer id) {
		SegTipoUsuario u = new SegTipoUsuario();
		u = em.find(SegTipoUsuario.class, id);
		return u;

	}
//metodo para eliminar
	public void eliminarTipoUsuario(Integer id) {
		SegTipoUsuario u = new SegTipoUsuario();
		u = em.find(SegTipoUsuario.class, id);
		em.remove(u);
	}

	// actualizar
	public void actualizarCiudad(SegTipoUsuario usuario) throws Exception {
		SegTipoUsuario u = buscarTipoUsuario(usuario.getIdTipoUsuario());
		if (u == null)
			throw new Exception("No existe la ciudad con el nombre especifica");
		u.setNombre(usuario.getNombre());
		em.merge(u);
	}
}
