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
                <h1>Agregar Cliente</h1>
                <form action="ClienteCon">
                    Apellido<br>
                    <input class="form-control" type="text" name="txtApe"><br>
                    Nombre: <br>
                    <input class="form-control" type="text" name="txtNom"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a class="btn btn-default" href="ClienteCon?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
