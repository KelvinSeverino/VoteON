<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>      
        <link rel="stylesheet" type="text/css" href="static/css/login-style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>VoteON - LOGIN</title>
    </head>
    <body>
        <div>
            <h2>VoteON</h2>
        </div>

        <div class="container">
                <form method="post" action="autenticador">
                    <div class="form-group txt-login">
                        <label>Título de Eleitor</label>
                        <input type="text" class="form-control" id=login name="login" required>                  
                    </div>
                    <div class="form-group txt-login">
                        <label>Senha</label>
                        <input type="password" class="form-control" id=senha name="senha" required>
                    </div>
                    <div class="btn_confirma">
                        <button type="submit" class="btn btn-primary btn-confirma" id="confirma" value="Autenticar">Entrar</button>
                    </div>
                    <% 
                        if ( request.getAttribute("falhaAutenticacao")!=null )
                            out.print("<p class=\"warning\"> Usuário ou senha inválidos.</p>"); 
                    %> 
                </form>
            </div> 
         
        
        <%-- <c:forEach var="x" begin="1" end="3">
            <c:out value="${x}"> a </c:out>
        </c:forEach> --%>
    </body>
</html>
