package org.example.web.servlets;

import org.example.web.persistence.dao.Contacto;
import org.example.web.persistence.manager.impl.ContactoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "ModificarContacto", urlPatterns = {"/modificar-contacto"})
public class ModificarContacto extends HttpServlet {

    private Contacto contacto = new Contacto();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idContacto = Integer.parseInt(req.getParameter("modificarId"));
        String nombre = (String) req.getParameter("nombre");
        String apellido = (String) req.getParameter("apellidos");
        String telefono = (String) req.getParameter("telefono");
        String email = (String) req.getParameter("email");
        contacto.setId(idContacto);
        contacto.setNombre(nombre);
        contacto.setApellido(apellido);
        contacto.setTelefono(telefono);
        contacto.setEmail(email);
        new ContactoImpl().updateById((Connection) req.getSession().getAttribute("connection"), contacto);
        req.getRequestDispatcher("/acceso-contactos").forward(req, resp);
    }
}