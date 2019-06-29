package controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Candidatos;
import model.Usuario;
import dao.CandidatosDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
/**
 * ChefeSessao
 */
@WebServlet("/chefesessao")
public class ChefeSessao extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        CandidatosDAO candDao = new CandidatosDAO();
        List <Candidatos> candidatos = candDao.buscaTodosCandidatos();

        HttpSession sessao = req.getSession();
        sessao.setAttribute("candidatos", candidatos);

        Usuario user = (Usuario) sessao.getAttribute("usuario");

        try 
        {
            sessao.getServletContext().getRequestDispatcher("/dynamic/jsp/chefe.jsp").forward(req, resp);
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
    }
}