package service;

import model.Usuario;

/**
 * UsuarioService
 */
public interface UsuarioService 
{
    public Usuario VerificaLogin (String titulo, String senha);
    public Boolean votar(int numero, Usuario user);    
    public Boolean AtivarVotante(String titulo);
}