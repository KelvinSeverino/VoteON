<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.*" %>
<%@ page import="java.util.List" %>

<%
    HttpSession sessao = request.getSession();
    Usuario usuario = (Usuario) sessao.getAttribute("usuario"); 
    List<Candidatos> candidatos = (List<Candidatos>) sessao.getAttribute("candidatos");

    if (usuario.equals(null)) 
    {
        sessao.getServletContext().getRequestDispatcher("/urna").forward(request, response);
        return;
    }

    if (usuario.getFk_nivel().getNivel() != 3) 
    {
        sessao.getServletContext().getRequestDispatcher("/eleitor").forward(request, response);
        return;
    }
%>

<!DOCTYPE html>
<html>
  <head>        
        <meta charset="utf-8"/>        
        <link rel="stylesheet" type="text/css" href="static/css/chefe-style.css">
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> 

        
        <title>VoteON - Chefe de Sessão</title>
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
                <form action="mesario" method="POST">    
                    <button type="submit" class="btn btn-outline-primary">Habilitar Voto</button>    
                </form>
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

        <br>Olá! Você logou como chefe de seção:</br> 
        <p>Chefe de Sessão: <%=usuario.getNome()%></p>
        <p>CPF: <%=usuario.getCpf()%></p>
        <p>Seção Eleitoral: <%=usuario.getFk_id_secao().getId_secao()%></p>
        <p>Zona Eleitoral: <%=usuario.getFk_id_zona().getNome()%></p>
            
        <div class="container-relatorio">
            <!--<div class="gerar-relatorio"> 
                <h2>Relatório de votos da Sessão</h2>
                <h5>Clique abaixo para gerar o relatório</h5>
                <button class="btn-gerar">Gerar</button>
            </div>
            -->
            <table id="relatorio">
                <tr>
                    <th>Posição</th>
                    <th>Candidatos</th>
                    <th>Partido</th>
                    <th>Qtde Votos</th>                
                </tr>
                <%
                    if (!candidatos.isEmpty()) 
                    {
                        for (Candidatos candidato : candidatos) 
                        {
                %>
                <tr>
                    <td><%= (candidatos.indexOf(candidato)+ 1)%></td>
                    <td><%= candidato.getNome() %></td>
                    <td><%= candidato.getPartido() %></td>
                    <td><%= candidato.getVotos() %></td> 
                </tr>
                <%
                        } 
                    }
                %>                                       
            </table>

            <table id="relatorio">
                <tr>
                    <th id="total-votos">Total de Votos</th>                
                </tr>
                <tr>
                    <td>0Votos</td>
                </tr>
            </table>  
        </div>
    </body>
</html>