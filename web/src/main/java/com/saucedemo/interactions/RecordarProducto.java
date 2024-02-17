package com.saucedemo.interactions;

import com.saucedemo.models.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class RecordarProducto implements Interaction {

    private final int idProducto;

    private final Producto producto;

    public RecordarProducto(int idProducto, Producto producto) {
        this.idProducto = idProducto;
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember("producto" + idProducto, producto);
    }

    public static RecordarProducto con(int idProducto, Producto producto) {
        return Tasks.instrumented(RecordarProducto.class, idProducto, producto);
    }
}
