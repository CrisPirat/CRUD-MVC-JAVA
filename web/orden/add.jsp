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
                <h1>Agregar Articulo</h1>
                <form action="ArticuloCon">
                    C&oacute;digo:<br>
                    <input class="form-control" type="text" name="txtCod"><br>
                    Nombre: <br>
                    <input class="form-control" type="text" name="txtNom"><br>
                    Precio: <br>
                    <input class="form-control" type="number" step="0.01" name="txtPre" min="0.00" value="0.00"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a class="btn btn-default" href="ArticuloCon?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
