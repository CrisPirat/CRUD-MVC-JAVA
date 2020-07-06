
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
            <a class="btn btn-success" href="/CRUD-MVC-JAVA/">Menu</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">CLIENTE</th>
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
                        <td class="text-center">
                            <%
                                Cliente cli = (Cliente) per.getOrd_cliente();
                            %>
                            <%= cli.getCli_nombre()%>&nbsp;<%= cli.getCli_apellido()%></td>
                        <td><%= per.getOrd_fecha()%></td>
                        <td class="text-center">
                            <a class="btn btn-success" href="OrdenDetalleCon?accion=listar&id=<%= per.getId()%>">Ver Detalle</a>
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
