package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioServiceImpl;

@WebServlet ("/autenticador")
public class Autenticador extends HttpServlet 
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		try 
        {
			req.setCharacterEncoding("UTF-8"); 
		} 
        catch (Exception e) 
        {

        }

		ServletContext sc = req.getServletContext();
		String login = (String) req.getParameter("nomeUsuario");
		String senha = (String) req.getParameter("senha");
		
		UsuarioServiceImpl usuarioServ = new UsuarioServiceImpl();
		Usuario usuario = usuarioServ.VerificaLogin(login, senha);

		System.out.println(usuario.getNome());

		try 
        {
			req.setAttribute("nomeUsuario", usuario.getNome().toString());
			req.setAttribute("nascimento", usuario.getNascimento().toString());

			sc.getRequestDispatcher("/dynamic/jsp/home.jsp").forward(req, resp);
		} 
        catch (Exception e) 
        {
			req.setAttribute("falhaAutenticacao", true);
			sc.getRequestDispatcher("/dynamic/jsp/login.jsp").forward(req, resp);
		}
	}
}