package service;

import java.util.List;

import model.*;
import dao.*;


public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioDAO usuarioDao = new UsuarioDAO(); 
    private List<Usuario> usuarios = usuarioDao.buscarUsuarios();

    @Override
    public Usuario VerificaLogin(String titulo, String senha) {
        for (Usuario u : usuarios) {
            try {
                if (titulo.equals(u.getTitulo()) && senha.equals(u.getSenha())) {
                    return u;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

	public List<Usuario> buscaTodosUsuarios() {
        try {
            return usuarios;
        } catch (Exception e) {

            //TODO: handle exception
            return null;
        }
    }
    

    @Override
    public Boolean votar(int numero, Usuario user){
        try {
           CandidatosDAO candDao = new CandidatosDAO();
            candDao.SomarVotacao(numero);
            UsuarioDAO userDao = new UsuarioDAO();
            userDao.Votado(user);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    @Override
    public Boolean AtivarVotante(String titulo) {
        try {
            UsuarioDAO userDao = new UsuarioDAO();
            userDao.Habilitar(userDao.buscarUsuariosTitulo(titulo));
            return true;
        } catch (Exception e) {
            //TODO: handle exception
            e.getStackTrace();
            return false;
        }       
    }   
}