<!doctype html>
<html>
  <head>        
        <meta charset="utf-8"/>        
        <link rel="stylesheet" type="text/css" href="static/css/mesario-style.css">
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        
        <title>VoteON - Mesário Online</title>
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
                <a class="navbar-brand" href="#">VoteON - Mesário Online</a>
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
                
        <h2><p>Pesquise o Eleitor para Hablitar...</p></h2>

        <div class="box">
            <div class="barra-pesquisa">  
                <input type="text" id="input-num-eleitor" placeholder="Título de Eleitor" required>
                <button class="btn-pesquisar">Pesquisar</button>
            </div>
            <table id="hablitacao">
                <tr>
                    <th>Título de Eleitor</th>
                    <th>Eleitor</th>
                    <th>Habilitado</th>
                    <th>Não Habilitado</th>
                    <th>Zona</th>
                    <th>Seção Eleitoal</th>                    
                </tr>
                <tr>
                    <td>1234</td>
                    <td>Jonny Cage</td>
                    <td><input type="radio" name="1" value="true"></td>
                    <td><input type="radio" name="1" value="false"></td>
                    <td>02</td>
                    <td>25</td>                    
                </tr>
                <tr>
                    <td>4321</td>
                    <td>Ricardo Milos</td>
                    <td><input type="radio" name="2" value="true"></td>
                    <td><input type="radio" name="2" value="false"></td>
                    <td>02</td>
                    <td>27</td>  
                </tr>                    
                </table>
        </div>
    </body>
</html>