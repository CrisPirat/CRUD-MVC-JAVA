
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Articulo"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.ArticuloDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Lista Articulos</title>
    </head>
    <body>
        <div class="container">
            <h1>Articulos</h1>
            <a class="btn btn-success" href="ArticuloCon?accion=add">Agregar Nuevo</a>
            <a class="btn btn-success" href="/CRUD-MVC-JAVA/">Menu</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">C&Oacute;DIGO</th>
                        <th class="text-center">NOMBRE</th>
                        <th class="text-center">PRECIO</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArticuloDAO dao = new ArticuloDAO();
                        List<Articulo> list = dao.list();
                        Iterator<Articulo> iter = list.iterator();
                        Articulo per = null;
                        while (iter.hasNext()) {
                            per = iter.next();
                    %>
                    <tr>
                        <td class="text-center"><%= per.getId()%></td>
                        <td class="text-center"><%= per.getArt_codigo()%></td>
                        <td><%= per.getArt_nombre()%></td>
                        <td><%= per.getArt_precio()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="ArticuloCon?accion=editar&id=<%= per.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="ArticuloCon?accion=eliminar&id=<%= per.getId()%>">Eliminar</a>
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
