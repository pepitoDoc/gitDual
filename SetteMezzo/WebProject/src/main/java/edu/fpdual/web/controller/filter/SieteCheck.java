package edu.fpdual.web.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author : Álvaro Terrasa y Artem Korzhan
 * @version : 1.0
 * Filtro que evita entrar en la partida de siete y medio sin antes haber realizado la configuración
 * para la misma. Para ello, comprueba si existe el objeto correspondiente que lo controla en la sesión.
 */
@WebFilter(filterName = "SieteCheck", urlPatterns = {"/sieteJuego/juego.jsp", "/sieteResolucion/resolucion.jsp"})
public class SieteCheck implements Filter {

    /**
     * Inicialización del filtro
     * @param filterConfig - FilterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    /**
     * Implementación del filtro
     * @param servletRequest - ServletRequest
     * @param servletResponse - ServletResponse
     * @param filterChain - FilterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /**
         * Se transforma el ServletRequest en HttpServletRequest para así poder gestionar la sesión
         */
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        if (req.getSession().getAttribute("sieteSesion") == null) {
            ((HttpServletResponse)servletResponse).sendRedirect("/WebProject/index.jsp");
        }
    }
}
