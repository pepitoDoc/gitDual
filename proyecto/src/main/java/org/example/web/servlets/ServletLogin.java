package org.example.web.servlets;

import org.example.web.dto.AltaUsuario;
import org.example.web.persistence.connector.MySQLConnector;
import org.example.web.persistence.dao.Contacto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletLogin", urlPatterns = {"/servlet-login"})
public class ServletLogin extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws
            ServletException,
            IOException {
        if (req.getSession().getAttribute("usuarioSesion") != null) {
            req.getRequestDispatcher("/acceso-contactos").forward(req, resp);
        } else if (req.getParameter("user").equals(req.getServletContext().getInitParameter("user"))
                && req.getParameter("password").equals(req.getServletContext().getInitParameter("password"))) {
            AltaUsuario usuario = AltaUsuario.builder().user(req.getParameter("user")).password(req.getParameter("password")).build();
            req.getSession().setAttribute("usuarioSesion", usuario);
            try {
                req.getSession().setAttribute("connection", new MySQLConnector().getMySQLConnection());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            req.getRequestDispatcher("/acceso-contactos").forward(req, resp);
        } else {
            resp.sendRedirect("/EjerJavaWeb/index.jsp");
        }
    }
}

