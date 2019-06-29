package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import dao.CandidatosDAO;
import service.UsuarioServiceImpl;


@WebServlet("/registraVoto")
public class Votacao extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        try 
        {
			req.setCharacterEncoding("UTF-8"); 
        } 
        catch (Exception e) 
        {
        }
        
        HttpSession sessao = req.getSession();
        
        try 
        {
            UsuarioServiceImpl userServ = new UsuarioServiceImpl();
            userServ.votar(Integer.parseInt(req.getParameter("numcandidato")),(Usuario)sessao.getAttribute("usuario"));
            System.out.println(req.getParameter("numcandidato"));
            sessao.getServletContext().getRequestDispatcher("/dynamic/jsp/urnasucesso.jsp").forward(req,resp);
        } 
        catch (Exception e) 
        {
            e.getStackTrace();
            req.setAttribute("erroVotacao", true);
            sessao.getServletContext().getRequestDispatcher("/eleitor").forward(req,resp);
        }
    }    
}