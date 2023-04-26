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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AccesoContactos", urlPatterns = {"/acceso-contactos"})
public class AccesoContactos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("listaContactos", new ContactoImpl().findAll((Connection) req.getSession().getAttribute("connection")));
        resp.sendRedirect("/EjerJavaWeb/formulariosContactos/menuContactos.jsp");
    }
}