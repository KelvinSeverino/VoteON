<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.*" %>
<%@ page import="java.util.List" %>

<%
    HttpSession sessao = request.getSession();
    Usuario usuario = (Usuario) sessao.getAttribute("usuario"); 
    Candidatos candidato = (Candidatos) sessao.getAttribute("candidato");

    if (sessao.getId().equals(null)) 
    {
        sessao.getServletContext().getRequestDispatcher("/urna").forward(request, response);
        return;
    }
%>

<!doctype html>
<html>
    <head>        
        <meta charset="utf-8"/>        
        <link rel="stylesheet" type="text/css" href="static/css/urna-style.css">   
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> 

        <title>VoteON - Urna</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Urna - Chefe De Sessão</a>    
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>   
            <div class="collapse navbar-collapse" id="navbarSupportedContent">                    
                <form action="eleitor" method="POST">    
                    <button type="submit" class="btn btn-outline-primary">Urna</button>    
                </form>
                <%if (usuario.getFk_nivel().getNivel() == 2) 
                {
                %>    
                    <form action="mesario" method="POST">    
                        <button type="submit" class="btn btn-outline-primary">Habilitar Voto</button>    
                    </form>
                <%
                }
                %>
                <%if (usuario.getFk_nivel().getNivel() == 3) 
                {
                %>    
                    <form action="mesario" method="POST">    
                        <button type="submit" class="btn btn-outline-primary">Habilitar Voto</button>    
                    </form>
                <%
                }
                %>
                <%if (usuario.getFk_nivel().getNivel() == 3) 
                {
                %>
                    <form action="chefesessao" method="POST">
                        <button type="submit" class="btn btn-outline-primary">Relatório de Votação</button>
                    </form>
                <%
                }
                %>   
                <ul class="navbar-nav mr-auto">    
                </ul>    
                    <form action="logout" method="POST">    
                        <button type="submit" class="btn btn-outline-danger">Logout</button>    
                    </form>    
            </div>    
        </nav>
        
        <div align="center"><p><br>Olá! Você está na tela de dados do Candidato Inserido</br></p></div>

        <div class="container">
            <div align="center">
                <div class="urna">
                    <div class="info-candidato">
                    <% if (usuario.isVotado() == false) 
                    {
                    %>
                    <div class="imagem">
                        <img src="<%= candidato.getLink()%>" width="200" height="150" alt="Candidato X">
                    </div>
                    <form action="registraVoto" method="POST">                    
                        <div class="nome-candidato">
                            <h5>Candidato: <%= candidato.getNome()%></h5>
                        </div>
                        <div class="num-candidato">
                            <h5>Num: <%= candidato.getNumero()%></h5>
                        </div>
                        <div class="partido">
                            <h5>Partido: <%= candidato.getPartido()%></h5>
                        </div>            
                                
                        <div class="input-text">
                            <input value="<%= candidato.getNumero()%>" type="text" id="num-candidato" name="numcandidato" required maxlength="2" [0-]>
                        </div>
                        <% 
                            if ( sessao.getAttribute("erro") != null )
                                out.print("<p> Esse candidato não existe.</p>"); 
                        %>                           
                        
                        <div class="btn-voto">                        
                            <button type="submit" class="btn-confirma">Confirma</button>
                        </div> 
                        <% 
                            if (sessao.getAttribute("erroVotacao") != null) 
                            {
                                out.print("<p> ERROR... Aconteceu alguma coisa no processamento do seu voto, tente novamente. </p>"); 
                            }
                        %>
                    </form>
                    <% 
                    } 
                    else 
                    {
                        out.print("<p> Não é permitido votar mais de uma vez! </p>"); 
                    }
                    %>
                    <form action="eleitor" method="POST">
                        <div class="btn-voto">                        
                            <button type="submit" class="btn-branco">Retornar</button>
                        </div>                        
                    </form>
                </div>
            </div>
        </div>        
    </body>
</html>