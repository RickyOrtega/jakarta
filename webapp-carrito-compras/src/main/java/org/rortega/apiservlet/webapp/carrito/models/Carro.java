package org.rortega.apiservlet.webapp.carrito.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {
    List<ItemCarro> itemsCarro;

    public Carro() {
        this.itemsCarro = new ArrayList<>();
    }

    public void addItemCarro(ItemCarro itemCarro){

        if(itemsCarro.contains(itemCarro)){
            Optional<ItemCarro> optionalItemCarro = itemsCarro.stream()
                    .filter(i -> i.equals(itemCarro))
                    .findAny();
            if (optionalItemCarro.isPresent()){
                ItemCarro i = optionalItemCarro.get();
                i.setCantidad(i.getCantidad()+1);
            }
        } else {
            this.itemsCarro.add(itemCarro);
        }
    }

    public List<ItemCarro> getItemsCarro() {
        return itemsCarro;
    }

    public Integer getTotal(){
        return itemsCarro.stream().mapToInt(ItemCarro::getImporte).sum();
    }
}