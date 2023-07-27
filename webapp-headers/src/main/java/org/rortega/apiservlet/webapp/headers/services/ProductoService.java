package org.rortega.apiservlet.webapp.headers.services;

import org.rortega.apiservlet.webapp.headers.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();

    Optional<Producto> buscarProducto(String nombre);
}