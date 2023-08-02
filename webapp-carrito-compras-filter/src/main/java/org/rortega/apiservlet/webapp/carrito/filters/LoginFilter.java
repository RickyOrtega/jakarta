package org.rortega.apiservlet.webapp.carrito.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rortega.apiservlet.webapp.carrito.services.LoginService;
import org.rortega.apiservlet.webapp.carrito.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/ver-carro", "/agregar-carro", "/actualizar-carro"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LoginService service = new LoginServiceSessionImpl();
        Optional<String> username = service.getUsername((HttpServletRequest) request);

        if(username.isPresent()){
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Lo sentimos, no estás autorizado para ingresar a esta página.");
        }
    }
}
