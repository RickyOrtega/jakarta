package org.rortega.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name="cabecerasRequest", value = "/cabeceras-request")
public class CabecerasHttpRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String metodoHttp = req.getMethod();
        String requestUri = req.getRequestURI();
        String requestUrl = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ipCliente = req.getRemoteAddr();
        String ip = req.getLocalAddr();
        Integer port = req.getLocalPort();
        String scheme = req.getScheme();
        String host = req.getHeader("host");
        String url = scheme.concat("://").concat(host).concat(contextPath).concat(servletPath);
        String url2 = scheme.concat("://").concat(ip).concat(":").concat(String.valueOf(port)).concat(contextPath).concat(servletPath);

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(" <head>");
            out.println("     <meta charset=\"UTF-8\">");
            out.println("     <title>¡Cabeceras HTTP Request!</title>");
            out.println(" </head>");
            out.println(" <body>");
            out.println("     <h1>¡Cabeceras HTTP Request!</h1>");
            out.println("       <ul>");
            out.println("           <li>Método HTTP: ".concat(metodoHttp).concat("</li>"));
            out.println("           <li>Request URI: ".concat(requestUri).concat("</li>"));
            out.println("           <li>Request URL: ".concat(requestUrl).concat("</li>"));
            out.println("           <li>Context Path: ".concat(contextPath).concat("</li>"));
            out.println("           <li>Servlet Path: ".concat(servletPath).concat("</li>"));
            out.println("           <li>Ip Local: ".concat(ip).concat("</li>"));
            out.println("           <li>Ip Remota: ".concat(ipCliente).concat("</li>"));
            out.println("           <li>Port: ".concat(String.valueOf(port)).concat("</li>"));
            out.println("           <li>Scheme: ".concat(scheme).concat("</li>"));
            out.println("           <li>Host: ".concat(host).concat("</li>"));
            out.println("           <li>Url: ".concat(url).concat("</li>"));
            out.println("           <li>Url2: ".concat(url2).concat("</li>"));

            Enumeration<String> headerNames = req.getHeaderNames();
            while(headerNames.hasMoreElements()){
                String cabecera = headerNames.nextElement();
                out.println("<li>".concat(cabecera).concat(": ".concat(req.getHeader(cabecera))).concat("</li>"));
            }

            out.println("       </ul>");
            out.println(" </body>");
            out.println("</html>");
        }
    }
}