
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Lista Clientes</title>
    </head>
    <body>
        <div class="container">
            <h1>Clientes</h1>
            <a class="btn btn-success" href="ClienteCon?accion=add">Agregar Nuevo</a>
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
                    <%
                        ClienteDAO dao = new ClienteDAO();
                        List<Cliente> list = dao.list();
                        Iterator<Cliente> iter = list.iterator();
                        Cliente per = null;
                        while (iter.hasNext()) {
                            per = iter.next();
                    %>
                    <tr>
                        <td class="text-center"><%= per.getId()%></td>
                        <td class="text-center"><%= per.getCli_apellido()%></td>
                        <td><%= per.getCli_nombre()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="ClienteCon?accion=editar&id=<%= per.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="ClienteCon?accion=eliminar&id=<%= per.getId()%>">Eliminar</a>
                            <a class="btn btn-success" href="OrdenCon?accion=listarCliente&id=<%= per.getId()%>">Ordenes</a>
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
