package org.example.web.servlets;

import org.example.web.persistence.manager.impl.ContactoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "AnyadirContacto", urlPatterns = {"/anyadir-contacto"})
public class AnyadirContacto extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        new ContactoImpl().insert((Connection) req.getSession().getAttribute("connection"), (String) req.getParameter("nombre"),
                (String) req.getParameter("apellidos"), (String) req.getParameter("telefono"), (String) req.getParameter("email"));
        req.getRequestDispatcher("/acceso-contactos").forward(req, resp);


    }
}