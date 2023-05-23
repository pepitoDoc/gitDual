<%@ page contentType="text/html; charset=UTF-8" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modificar contraseña</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>
    <div class="container">
      <div class="row" id="user">
        <h2 class="text-center mt-4">Modificar contraseña de usuario</h2>
        <h4 class="text-center mt-2">Introduzca el correo de su cuenta</h4>
          <div class="mb-3 mt-4 row justify-content-center">
            <label for="email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-4">
              <input type="text" class="form-control" id="email" name="email" placeholder="Correo electrónico">
            </div>
          </div>
        <div class="row mt-2 d-flex justify-content-center">
          <button type="submit" id="checkEmail" class="btn btn-secondary" style="width:200px; height:40px">Comprobar correo</button>
        </div>
      </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="modificar.js"></script>
  </body>
</html>