
<%@page import="Modelo.Articulo"%>
<%@page import="ModeloDAO.ArticuloDAO"%>
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
              ArticuloDAO dao=new ArticuloDAO();
              int id=Integer.parseInt((String)request.getAttribute("idart"));
              Articulo p=(Articulo)dao.show(id);
          %>
            <h1>Modificar Persona</h1>
            <form action="ArticuloCon">
                C&oacute;digo:<br>
                <input class="form-control" type="text" name="txtCod" value="<%= p.getArt_codigo()%>"><br>
                Nombre: <br>
                <input class="form-control" type="text" name="txtNom" value="<%= p.getArt_nombre()%>"><br>
                Precio: <br>
                <input class="form-control" type="number" step="0.01" name="txtPre" value="<%= p.getArt_precio()%>"><br>
               
                <input type="hidden" name="txtid" value="<%= p.getId()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a class="btn btn-default" href="ArticuloCon?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
