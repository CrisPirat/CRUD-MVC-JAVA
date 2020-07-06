
<%@page import="Modelo.Cliente"%>
<%@page import="ModeloDAO.ClienteDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Orden"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.OrdenDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Lista Ordenes</title>
    </head>
    <body>
        <div class="container">
            <h1>Ordenes</h1>
            <%
                ClienteDAO daoCli = new ClienteDAO();
                int idCli = Integer.parseInt((String) request.getAttribute("idcli"));
                Cliente cli = (Cliente) daoCli.show(idCli);
            %>
            <a class="btn btn-success" href="OrdenCon?accion=add&id=<%= cli.getId()%>">Nueva Orden</a>
            <a class="btn btn-success" href="/CRUD-MVC-JAVA/">Menu</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">APELLIDO</th>
                        <th class="text-center">NOMBRE</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="text-center"><%= cli.getId()%></td>
                        <td class="text-center"><%= cli.getCli_apellido()%></td>
                        <td><%= cli.getCli_nombre()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="ClienteCon?accion=editar&id=<%= cli.getId()%>">Editar</a>
                        </td>
                    </tr>
                </tbody>
            </table>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">FECHA</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        OrdenDAO dao = new OrdenDAO();
                        List<Orden> list = dao.list();
                        Iterator<Orden> iter = list.iterator();
                        Orden per = null;
                        while (iter.hasNext()) {
                            per = iter.next();
                    %>
                    <tr>
                        <td class="text-center"><%= per.getId()%></td>
                        <td class="text-center"><%= per.getOrd_fecha()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="OrdenCon?accion=editar&id=<%= per.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="OrdenCon?accion=eliminar&id=<%= per.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

        </div>
    </body>
</html>
