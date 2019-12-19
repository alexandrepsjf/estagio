<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body> 
        <nav class="navbar navbar-dark bg-dark navbar-expand-lg navbar-light bg-light">

            <a class="navbar-brand" href="#">CRUD</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#conteudoNavbarSuportado" aria-controls="conteudoNavbarSuportado" aria-expanded="false" aria-label="Alterna navegação">
                <span class="navbar-toggler-icon"></span>
            </button>

           <div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(página atual)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="FrontController?action=ConsultarCliente">Cliente</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="FrontController?action=AnalisarCliente">Análise</a>
                    </li>

                </ul>

            </div>
        </nav>
        <div class="center ">
            <h3>Pesquisa de Clientes</h3></div>
       <table class="table table-striped">
  <thead class="thead-dark">            
      <tr> 
                    <th scope="col">Código </th>
                    <th scope="col">Nome </th>
                    <th scope="col">Sexo </th>
                    <th scope="col">Cidade </th>
                    <th scope="col">Data Cadastro</th>
                    <th scope="col" colspan="2">Ação</th>                
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${clientes}" var="cliente">
                    <tr>
                        <td ><c:out value="${cliente.codContato}" /> </td>
                        <td ><c:out value="${cliente.nome}" /> </td>
                        <td ><c:out value="${cliente.sexo}" /> </td>
                        <td ><c:out value="${cliente.cidade}" /> </td>
                        <td ><c:out value="${cliente.data}" /> </td>
                        <td ><a href="FrontController?action=PrepararEditarCliente&codContato=<c:out value='${cliente.codContato}' /> " ><i class="fas fa-pen-square"></i>edit</i></a></td>
                        <td ><a href="FrontController?action=ApagarCliente&codContato=<c:out value='${cliente.codContato}' /> " ><i class="fas fa-trash"></i>delete</i></a></td>
                    </tr>
                </c:forEach>
            </tbody> 
        </table>

        <form action="gravarCliente.jsp" method="POST" class="center">
            <div class="input-field col s1 btn waves-effect waves-light">
                <input id="submit" type="submit" class="submit" name="btnIncluir" value="Incluir">                 
               <i class="fas fa-user-plus"></i>

            </div>
        </form>

    </body>    
</html>
