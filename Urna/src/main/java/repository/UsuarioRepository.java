package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Usuario;

/**
 * UsuarioRepository
 */
public class UsuarioRepository 
{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("UrnaPersistence");
	private EntityManager em = emf.createEntityManager();

    public List<Usuario> buscarUsuarios() 
    {		
		Query query = em.createQuery("SELECT u FROM Usuario u");
        List<Usuario> usuarios = query.getResultList();        
        return usuarios;
    }
}