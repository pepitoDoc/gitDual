package org.example.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/acceso-contactos", "/anyadir-contacto", "/borrar-contacto", "/modificar-contacto", "/formulariosContactos/menuContactos.jsp",
"/formulariosContactos/anyadirContacto.jsp", "/formulariosContactos/modificarContacto.jsp"})
public class FiltroSesion implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException{

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (req.getSession().getAttribute("usuarioSesion")==null) {
            resp.sendRedirect("/EjerJavaWeb/index.jsp");
        } else {
            filterChain.doFilter(req, resp);
        }
    }
}
