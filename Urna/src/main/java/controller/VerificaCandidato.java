package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Candidatos;
import dao.CandidatosDAO;

/**
 * VerificaCandidato
 */
@WebServlet("/votacao")
public class VerificaCandidato extends HttpServlet 
{
    private static final long serialVersionUID = -1547546431545719670L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
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
            CandidatosDAO candDao = new CandidatosDAO();
            int numero = Integer.parseInt(req.getParameter("numcandidato"));
            Candidatos cand = candDao.buscaCandidatosNumero(numero);
    
            sessao.setAttribute("candidato", cand);
            sessao.getServletContext().getRequestDispatcher("/dynamic/jsp/urnacandidato.jsp").forward(req, resp);   
        } 
        catch (Exception e) 
        {
            //TODO: handle exception
            e.getStackTrace();
            sessao.setAttribute("erro", true);
            sessao.getServletContext().getRequestDispatcher("/dynamic/jsp/urna.jsp").forward(req, resp);  
        }
    }
}