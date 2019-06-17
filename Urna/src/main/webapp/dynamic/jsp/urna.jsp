<!doctype html>
<html>
  <head>        
        <meta charset="utf-8"/>        
        <link rel="stylesheet" type="text/css" href="static/css/urna-style.css">   
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

        <title>VoteON - Urna Online</title>
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
                <a class="navbar-brand" href="#">VoteON - Urna Online</a>
                </div>
                <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="urna.html">Votar</a></li>
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

        <h2>VoteON - Urna ONLINE</h2>
        <p>Insira o número do candidato e clique em confirma!</p>
        
        <div class="urna">
            <div class="info-candidato">
                <form action="#">
                    <div class="imagem">
                        <img src="https://pm1.narvii.com/6821/ac5c009801812b7b43c3e12c55bcfaca96234383v2_hq.jpg" width="200" height="150" alt="Candidato X">
                    </div>
                    <div class="nome-candidato">
                        <h5>Kratos</h5>
                    </div>
                    <div class="num-candidato">
                        <h5>40</h5>
                    </div>
                    <div class="partido">
                        <h5>Partido Olimpio</h5>
                    </div>
                </div>

                <div class="input-text">
                    <input type="number" id="num-candidato" min="2" max="2" required onkeypress='if (!isNaN(String.fromCharCode(window.event.keyCode))) return true; else return false;'>
                </div>

                <div class="btn-voto">
                    <button type="submit" class="btn-branco">Branco</button>
                    <button type="submit" class="btn-corrige">Corrige</button>
                    <a data-toggle="modal" data-target="#popup-confirma"><button type="submit" class="btn-confirma">Confirma</button></a>
                    <!-- Modal -->
                    <div class="modal fade" id="popup-confirma" role="dialog">
                        <div class="modal-dialog">                    
                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Caixa de Diálogo</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Voto realizado com sucesso!</p>
                                </div>
                                <!--Botões-->
                                <form action="./login.html">
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger" data-dismiss="modal">Não</button>
                                        <button class="btn btn-success">Sim</button>
                                    </div>
                                </form>
                            </div>                    
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>