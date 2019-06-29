import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import dao.UsuarioDAO;
import service.UsuarioServiceImpl;

/**
 * Mesario
 */
@WebServlet("/mesario")
public class Mesario extends HttpServlet{
    private static final long serialVersionUID = 121875378468696896L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
        List<Usuario> usuarios = usuarioService.buscaTodosUsuarios();
        HttpSession sessao = req.getSession();
        UsuarioDAO userDao = new UsuarioDAO();
        
        sessao.setAttribute("usuarios", usuarios);
        req.setAttribute("usuariosAtivos", userDao.buscarUsuariosAtivos());
        req.setAttribute("usuariosInativos", userDao.buscarUsuariosInativos()); 

        try {
            sessao.getServletContext().getRequestDispatcher("/dynamic/jsp/mesario.jsp").forward(req, resp);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
}