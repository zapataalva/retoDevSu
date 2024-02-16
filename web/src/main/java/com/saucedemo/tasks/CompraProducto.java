package com.saucedemo.tasks;

import com.saucedemo.interactions.RecordarProducto;
import com.saucedemo.models.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static com.saucedemo.userinterfaces.PaginaPrincipalPage.*;
import static com.saucedemo.utils.Constantes.CANTIDAD_PRODUCTOS;

public class CompraProducto implements Task {

    private final List<String> nombreProducto;

    public CompraProducto(List<String> nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 1; i <= CANTIDAD_PRODUCTOS; i++) {
            actor.attemptsTo(
                    Click.on(NOMBRE_PRODUCTO.of(nombreProducto.get(i)))
            );
            actor.attemptsTo(
                    RecordarProducto.con(i, new Producto(nombreProducto.get(i), Text.of(PRECIO_PRODUCTO).answeredBy(actor))),
                    Click.on(BTN_AGREGAR_PRODUCTO),
                    Click.on(BTN_VOLVER)
            );
        }
        actor.attemptsTo(Ensure.that(Text.of(PRODUCTOS_CARRITO)).isEqualTo(String.valueOf(CANTIDAD_PRODUCTOS)),
                Click.on(BTN_CARRITO));
    }

    public static CompraProducto con(List<String> nombreProducto) {
        return Tasks.instrumented(CompraProducto.class, nombreProducto);
    }
}
