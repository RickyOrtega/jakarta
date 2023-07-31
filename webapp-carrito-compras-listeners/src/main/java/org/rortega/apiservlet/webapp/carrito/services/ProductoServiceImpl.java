package org.rortega.apiservlet.webapp.carrito.services;
import org.rortega.apiservlet.webapp.carrito.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService{

    @Override
    public List<Producto> listar() {
        return Arrays.asList(
                new Producto(1L, "Notebook", "Computación", 175000),
                new Producto(2L, "Mesa Escritorio", "Oficina", 100000),
                new Producto(3L, "Teclado Redragon", "Computación", 40000));
    }

    @Override
    public Optional<Producto> buscarProductoPorNombre(String nombre) {
        return this.listar().stream().filter(p -> {

            if(nombre == null || nombre.isBlank()){
                return false;
            }
            return p.getNombre().contains(nombre);
        }).findFirst();
    }

    @Override
    public Optional<Producto> buscarProductoPorId(Long id) {
        return listar()
                .stream()
                .filter(p -> p.getId().equals(id))
                .findAny();
    }
}