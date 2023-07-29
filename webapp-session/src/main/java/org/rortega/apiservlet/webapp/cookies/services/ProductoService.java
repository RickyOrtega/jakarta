package org.rortega.apiservlet.webapp.cookies.services;

import org.rortega.apiservlet.webapp.cookies.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();

    Optional<Producto> buscarProducto(String nombre);
}