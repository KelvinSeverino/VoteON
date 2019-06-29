<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<%

		HttpSession sessao = (HttpSession) request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		List<Usuario> usuariosAtivos = (List<Usuario>) request.getAttribute("usuariosAtivos");
		List<Usuario> usuariosInativos = (List<Usuario>) request.getAttribute("usuariosInativos");

		if (usuario != null) {
			sessao.getServletContext().getRequestDispatcher("/UrnaOnline");
		}

		if (usuario.getFk_nivel().getNivel() != 3 && usuario.getFk_nivel().getNivel() != 2) {
			sessao.getServletContext().getRequestDispatcher("urna").forward(request, response);
		}
%>

<!doctype html>
<html>
  <head>        
        <meta charset="utf-8"/>        
        <link rel="stylesheet" type="text/css" href="static/css/mesario-style.css">
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> 
        
        <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
        <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>

        <title>VoteON - Mesário</title>
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

        <%if (usuario.getFk_nivel().getNivel() == 3) 
        {
        %>
            <br>Olá! Você logou como chefe de seção:</br> 
            <p>Chefe de Sessão: <%=usuario.getNome()%></p>
            <p>Seção Eleitoral: <%=usuario.getFk_id_secao().getId_secao()%></p>
            <p>Zona Eleitoral: <%=usuario.getFk_id_zona().getNome()%></p>
        <%
        }
        %> 

        <form action="AtivarVotante" method="GET">
			<div class="input-group mb-3">
				<input type="text" name="tituloUser" required>
				<button class="btn btn-outline-success" type="Submit">Ativar Usuario</button>
			</div>
        </form>
        
        <%
			if (!usuariosAtivos.isEmpty()) 
			{
		%>
			<h3>Usuarios Habilitados</h3>
				<table id="hablitacao">
					<thead>
						<tr>
							<th>Usuario</th>
							<th>Titulo</th>
						</tr>
					</thead>
					<tbody>
							<%
								for (Usuario cUser : usuariosAtivos) 
								{
							%>
								<tr>
									<td><%= cUser.getNome() %></td>
									<td><%= cUser.getTitulo() %></td>
								</tr>
							<%
							}
							%>
					</tbody>
			</table>
		<% 
			} 
		%>
		<%
			if (!usuariosInativos.isEmpty()) 
			{
		%>
			<h3>Usuarios NÃO Habilitados</h3>
			<table id="hablitacao">
					<thead>
						<tr>
							<th>Usuario</th>
							<th>Titulo</th>
						</tr>
					</thead>
					<tbody>
							<%
								for (Usuario cUserInativos : usuariosInativos) 
								{
							%>
								<tr>
									<td><%= cUserInativos.getNome() %></td>
									<td><%= cUserInativos.getTitulo() %></td>
								</tr>
							<%
								}
							%>
					</tbody>
			</table>
		<% 
			} 
		%>
    </body>
</html>