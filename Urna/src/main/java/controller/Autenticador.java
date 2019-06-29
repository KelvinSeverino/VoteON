package controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Permissao;
import model.Usuario;
import service.UsuarioServiceImpl;

@WebServlet ("/autenticador")
public class Autenticador extends HttpServlet 
{
    private static final long serialVersionUID = -8608687049026173883L;

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

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        UsuarioServiceImpl usuarioServ = new UsuarioServiceImpl();
        Usuario usuario = usuarioServ.VerificaLogin(login, senha);


        try 
        {
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuario", usuario);

            if (usuario.getFk_nivel().getNivel() == 1)
            {
                sessao.getServletContext().getRequestDispatcher("/eleitor").forward(req, resp);
            }
            else if (usuario.getFk_nivel().getNivel() == 2)
            {
                sessao.getServletContext().getRequestDispatcher("/mesario").forward(req, resp);
            }
            else if (usuario.getFk_nivel().getNivel() == 3 )
            {
                sessao.getServletContext().getRequestDispatcher("/chefesessao").forward(req, resp);
            }

        } 
        catch (Exception e) 
        {
            req.setAttribute("falhaAutenticacao", true);
            resp.sendRedirect("/Urna");
        }
    }
}
