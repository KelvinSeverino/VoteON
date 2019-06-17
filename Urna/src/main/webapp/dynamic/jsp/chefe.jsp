<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    String contexto = request.getContextPath();
    if (!contexto.equals(""))
        contexto = contexto + "/";
%>
<!DOCTYPE html>
<html>
  <head>        
        <meta charset="utf-8"/>        
        <link rel="stylesheet" type="text/css" href="static/css/chefe-style.css">
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        
        <title>VoteON - Chefe de Sessão Online</title>
        <%
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            HttpSession sessao = (HttpSession) request.getAttribute("sessao");
        %>
    </head>

    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                <a class="navbar-brand" href="#">VoteON - Chefe de Sessão Online</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Relatório de Votos</a></li>
                    <li><a href="dynamic/jsp/urna.jsp">Votar</a></li>
                    <li><a href="dynamic/jsp/mesario.jsp">Habilitar Voto</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-log-out"></span>Sair</a></li>
                    <!-- Modal -->
                    <div class="modal fade" id="myModal" role="dialog">
                        <div class="modal-dialog">                    
                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Caixa de Diálogo</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Deseja realmente sair?</p>
                                </div>
                                <!--Botões-->
                                <form action="/Urna">
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger" data-dismiss="modal">Não</button>
                                        <button class= "btn btn-success"> 
                                            <%
                                                sessao.invalidate();
                                            %> Sim
                                        </button>
                                    </div>
                                </form>
                            </div>                    
                        </div>
                    </div>            
                </ul>
            </div>
        </nav>
        Olá. logou como chefe de seção: 
        <%
            String nomeUsuario = (String) request.getAttribute("nomeUsuario");
            String data = (String) request.getAttribute("nascimento");

            out.print("<p>" + nomeUsuario + "</p>");
            out.print("<p>" + data + "</p>");
            out.print("<p>" + sessao.getId() + "</p>");
        %>
        <div class="container-relatorio">
            <div class="gerar-relatorio"> 
                <h2>Relatório de votos da Sessão</h2>
                <h5>Clique abaixo para gerar o relatório</h5>
                <button class="btn-gerar">Gerar</button>
            </div>
            <table id="relatorio">
                <tr>
                    <th>Candidatos</th>
                    <th>Qtde Votos</th>                
                </tr>
                <tr>
                    <td>Kratos</td>
                    <td>12</td>                  
                </tr>
                <tr>
                    <td>Vin Diesel Brasileiro</td>
                    <td>7</td> 
                </tr>
                <tr>
                    <td>The Rock</td>
                    <td>5</td> 
                </tr>
                <tr>
                    <td>The Rocha</td>
                    <td>2</td> 
                </tr>                                          
            </table>

            <table id="relatorio">
                <tr>
                    <th id="total-votos">Total de Votos</th>                
                </tr>
                <tr>
                    <td>200 Votos</td>
                </tr>
            </table>  
        </div>
    </body>
</html>