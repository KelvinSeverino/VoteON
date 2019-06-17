<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
    HttpSession sessao = (HttpSession) request.getAttribute("sessao");
    int autorizacao = (int) request.getAttribute("autorizacao");

    if (autorizacao == 1)
    {
        request.getServletContext().getRequestDispatcher("/dynamic/jsp/urna.jsp").forward(request, response);
    }
    else if (autorizacao == 2)
    {
        request.getServletContext().getRequestDispatcher("/dynamic/jsp/mesario.jsp").forward(request, response);
    }
    else if (autorizacao == 3 )
    {
        request.getServletContext().getRequestDispatcher("/dynamic/jsp/chefe.jsp").forward(request, response);
    }
%>