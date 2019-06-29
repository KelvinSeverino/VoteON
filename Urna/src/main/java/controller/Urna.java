package controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/eleitor")
public class Urna extends HttpServlet{
    private static final long serialVersionUID = 121875378468696897L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();

        List<Usuario> usuarios = usuarioService.buscaTodosUsuarios();
        HttpSession sessao = req.getSession();

        sessao.setAttribute("usuarios", usuarios);

        try 
        {
            sessao.getServletContext().getRequestDispatcher("/dynamic/jsp/urna.jsp").forward(req, resp);
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
    }
}