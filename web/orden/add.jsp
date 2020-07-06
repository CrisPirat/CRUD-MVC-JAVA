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
                <h1>Agregar Orden</h1>
                 <%
                ClienteDAO daoCli = new ClienteDAO();
                int idCli = Integer.parseInt((String) request.getAttribute("idcli"));
                Cliente cli = (Cliente) daoCli.show(idCli);
            %>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">APELLIDO</th>
                        <th class="text-center">NOMBRE</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="text-center"><%= cli.getId()%></td>
                        <td class="text-center"><%= cli.getCli_apellido()%></td>
                        <td><%= cli.getCli_nombre()%></td>
                        
                    </tr>
                </tbody>
            </table>
                <form action="OrdenCon">
                    C&oacute;digo:<br>
                    <input class="form-control" type="text" name="txtCod"><br>
                    Nombre: <br>
                    <input class="form-control" type="text" name="txtNom"><br>
                    Precio: <br>
                    <input class="form-control" type="number" step="0.01" name="txtPre" min="0.00" value="0.00"><br>
                    <input type="hidden" name="txtIdCli" value="<%= cli.getId()%>">
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a class="btn btn-default" href="ArticuloCon?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
