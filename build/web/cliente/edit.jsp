
<%@page import="Modelo.Cliente"%>
<%@page import="ModeloDAO.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
              <%
              ClienteDAO dao=new ClienteDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              Cliente p=(Cliente)dao.show(id);
          %>
            <h1>Modificar Persona</h1>
            <form action="ClienteCon">
                Apellido:<br>
                <input class="form-control" type="text" name="txtApe" value="<%= p.getCli_apellido()%>"><br>
                Nombre: <br>
                <input class="form-control" type="text" name="txtNom" value="<%= p.getCli_nombre()%>"><br>
               
                <input type="hidden" name="txtid" value="<%= p.getId()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a class="btn btn-default" href="ClienteCon?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
