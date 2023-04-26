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

@WebServlet(name = "BorrarContacto", urlPatterns = {"/borrar-contacto"})
public class BorrarContacto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new ContactoImpl().deleteById((Connection) req.getSession().getAttribute("connection"), Integer.parseInt(req.getParameter("borrarId")));
        req.getRequestDispatcher("/acceso-contactos").forward(req, resp);
    }
}