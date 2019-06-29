package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        HttpSession sessao = req.getSession();

        sessao.invalidate();

        try 
        {
            sessao.getServletContext().getRequestDispatcher("/dynamic/jsp/login.jsp").forward(req, resp);
        } 
        catch (Exception e) 
        {
            e.getStackTrace();
        }
    }
}