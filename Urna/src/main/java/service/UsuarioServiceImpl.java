package service;

import java.util.List;

import model.Usuario;
import repository.UsuarioRepository;

/**
 * UsuarioServiceImpl
 */
public class UsuarioServiceImpl implements UsuarioService 
{
    @Override
    public Usuario VerificaLogin(String titulo, String senha) 
    {
        UsuarioRepository usuarioRepo = new UsuarioRepository();

        List<Usuario> usuarios = usuarioRepo.buscarUsuarios();

        for (Usuario u : usuarios) 
        {
            try 
            {
                if (titulo.equals(u.getTitulo()) && senha.equals(u.getSenha())) 
                {
                    return u;
                }
            } 
            catch (Exception e) 
            {
                // TODO: handle exception
                return null;
            }
        }
        return null;
    }
}