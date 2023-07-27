package org.rortega.apiservlet.webapp.headers.services;

import org.rortega.apiservlet.webapp.headers.models.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> listar();
}