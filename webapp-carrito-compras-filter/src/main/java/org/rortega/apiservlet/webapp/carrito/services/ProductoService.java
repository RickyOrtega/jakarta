package org.rortega.apiservlet.webapp.carrito.services;


import org.rortega.apiservlet.webapp.carrito.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();

    Optional<Producto> buscarProductoPorNombre(String nombre);
    Optional<Producto> buscarProductoPorId(Long Id);

}