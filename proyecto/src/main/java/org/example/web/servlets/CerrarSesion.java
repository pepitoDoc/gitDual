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

@WebServlet(name = "CerrarSesopm", urlPatterns = {"/cerrar-sesion"})
public class CerrarSesion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/EjerJavaWeb/index.jsp");
        destroy();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
