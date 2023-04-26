<%@ page contentType="text/html; charset=UTF-8" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio de sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>
  <form action="/EjerJavaWeb/servlet-login" method="POST">
    <div class="container">
        <div class="row">
          <div class="mb-3 mt-4 row">
            <div class="col-3"></div>
            <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
            <div class="col-4">
              <input type="text" class="form-control" id="user" name="user" placeholder="Nombre de usuario">
            </div>
          </div>
          <div class="mb-3 row">
            <div class="col-3"></div>
            <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
            <div class="col-4">
              <input type="password" class="form-control" id="password" name="password" placeholder="Contraseña">
            </div>
          </div>
      </div>
      <div class="row">
        <div class="col-5"></div>
        <div class="col-1 mt-4">
          <button type="submit" class="btn btn-primary" style="width:120px; height:40px">Iniciar sesión</button>
        </div>
      </div>
    </div>
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  </body>
</html>