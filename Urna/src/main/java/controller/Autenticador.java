package Controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Permissao;
import model.Usuario;
import service.UsuarioServiceImpl;

@WebServlet ("/autenticador")
public class Autenticador extends HttpServlet {

    private static final long serialVersionUID = -8608687049026173883L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8"); 
        } catch (Exception e) {
        }
        HttpSession sessao = req.getSession(true);
        ServletContext sc = sessao.getServletContext();

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        UsuarioServiceImpl usuarioServ = new UsuarioServiceImpl();
        Usuario usuario = usuarioServ.VerificaLogin(login, senha);

		try 
		{
            req.setAttribute("cpf", usuario.getCpf());
            req.setAttribute("nomeUsuario", usuario.getNome());
            req.setAttribute("sessao", sessao);
            req.setAttribute("autorizacao", usuario.getFk_nivel().getNivel());

            sc.getRequestDispatcher("/dynamic/jsp/redirecionador.jsp").forward(req, resp);
		} 
		catch (Exception e) 
		{
            req.setAttribute("falhaAutenticacao", true);
            sc.getRequestDispatcher("/dynamic/jsp/login.jsp").forward(req, resp);
        }
    }
}