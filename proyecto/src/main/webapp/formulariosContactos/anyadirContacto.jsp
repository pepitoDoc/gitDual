<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="org.example.web.persistence.dao.Contacto"%>
<%@ page import="java.util.List"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Añadir contactos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>
  <form action="/EjerJavaWeb/anyadir-contacto" method="POST">
    <div class="container">
        <div class="row">
          <div class="mb-3 mt-4 row">
            <div class="col-3"></div>
            <label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
            <div class="col-4">
              <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Pablo">
            </div>
          </div>
          <div class="mb-3 row">
            <div class="col-3"></div>
            <label for="apellidos" class="col-sm-2 col-form-label">Apellidos</label>
            <div class="col-4">
              <input type="text" class="form-control" id="apellidos" name="apellidos" placeholder="Ruiz Sánchez">
            </div>
          </div>
          <div class="mb-3 row">
            <div class="col-3"></div>
            <label for="telefono" class="col-sm-2 col-form-label">Teléfono</label>
            <div class="col-4">
              <input type="text" class="form-control" id="telefono" name="telefono" placeholder="000000000">
            </div>
          </div>
          <div class="mb-3 row">
            <div class="col-3"></div>
            <label for="email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-4">
              <input type="text" class="form-control" id="email" name="email" placeholder="Contraseña">
            </div>
          </div>
      </div>
      <div class="row">
        <div class="col-3"></div>
        <div class="col-3 mt-4">
          <button type="submit" class="btn btn-primary" style="width:200px; height:40px">Registrar contacto</button>
        </div>
        </form>
        <div class="col-1 mt-4">
        <form action="/EjerJavaWeb/formulariosContactos/menuContactos.jsp" method="GET">
            <button type="submit" class="btn btn-secondary" style="width:200px; height:40px">Salir sin añadir</button>
        </form>
        </div>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  </body>
</html>