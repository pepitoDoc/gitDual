<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="org.example.web.persistence.dao.Contacto"%>
<%@ page import="java.util.List"%>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Menu de contactos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-2"></div>
            <table class="table table-striped mt-4" style="width: 70%; height: auto">
                <thead>
                    <tr>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Teléfono</th>
                        <th scope="col">Email</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    int idLista = 0;
                    List<Contacto> listaContactos = (List<Contacto>) session.getAttribute("listaContactos");
                    for (Contacto contacto:listaContactos) { %>
                        <td><%=contacto.getNombre()%></td>
                        <td><%=contacto.getApellido()%></td>
                        <td><%=contacto.getTelefono()%></td>
                        <td><%=contacto.getEmail()%></td>
                        <form action="/EjerJavaWeb/formulariosContactos/modificarContacto.jsp" method="POST">
                            <input type="hidden" name="modificarId" value=<%=contacto.getId()%>>
                            <input type="hidden" name="idLista" value=<%=idLista%>>
                            <td><button type="submit" class="btn btn-success">Modificar</button><td>
                        </form>
                        <form action="/EjerJavaWeb/borrar-contacto" method="POST">
                            <input type="hidden" name="borrarId" value=<%=contacto.getId()%>>
                            <td><button type="submit" class="btn btn-danger">Eliminar</button></td>
                        </form>
                </tbody>
                <%
                    idLista++;
                    }
                %>
            </table>
        </div>
        <form action="/EjerJavaWeb/formulariosContactos/anyadirContacto.jsp" method="GET">
            <div class="row">
                <div class="col-3"></div>
                <div class="col-3 mt-4">
                    <button type="submit" class="btn btn-primary" style="width:200px; height:40px">Añadir contacto</button>
                </div>
        </form>
            <div class="col-1 mt-4">
        <form action="/EjerJavaWeb/cerrar-sesion" method="GET">
                <button type="submit" class="btn btn-secondary" style="width:200px; height:40px">Cerrar sesión</button>
            </div>
            </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>