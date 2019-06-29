package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Usuario;

public class UsuarioDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("UrnaPersistence");
    private EntityManager em = emf.createEntityManager();  



    public List<Usuario> buscarUsuarios() {		
        Query query = em.createQuery("SELECT u FROM Usuario u");
        
        @SuppressWarnings("unchecked")
        List<Usuario> usuarios = query.getResultList(); 

        return usuarios;
    }



    public List<Usuario> buscarUsuariosAtivos() {
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u where u.habilitado = true");
      
            @SuppressWarnings("unchecked")
            List<Usuario> usuarios = query.getResultList(); 

            for (Usuario usuario : usuarios) {
                System.out.println(usuario.getNome());
            }
            return usuarios;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    public List<Usuario> buscarUsuariosInativos() {
        try 
        {
            Query query = em.createQuery("SELECT u FROM Usuario u where u.habilitado = false");
   
            @SuppressWarnings("unchecked")
            List<Usuario> usuarios = query.getResultList(); 
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.getNome());
            }
            return usuarios;
        } 
        catch (Exception e) 
        {
            e.getStackTrace();
            return null;
        }	
      
    }



    public Usuario buscarUsuariosTitulo(String titulo) 
    {
        try 
        {
            Query query = em.createQuery("select u from Usuario u where u.titulo = :titulo");
            query.setParameter("titulo", titulo);
            Usuario usuario = (Usuario) query.getSingleResult();
        
            System.out.println(usuario);
            return usuario;
        } 
        catch (Exception e) 
        {

            //TODO: handle exception
            e.getStackTrace();
            return null;
        } 
    }

    public void Votado (Usuario user)
    {
        user.setVotado(true);
        em.getTransaction().begin();

        try 
        {
            em.merge(user);
            em.getTransaction().commit();
            em.close();
        } 
        catch (Exception e) 
        {
            e.getStackTrace();
        }
    }



    public void Habilitar (Usuario user)
    {
        user.setHabilitado(true);
        em.getTransaction().begin();

        try 
        {
            em.merge(user);
            em.getTransaction().commit();
            em.close();

        } 
        catch (Exception e) 
        {

            e.getStackTrace();
        }
    }
}