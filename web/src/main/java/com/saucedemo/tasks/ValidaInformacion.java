package com.saucedemo.tasks;

import com.saucedemo.models.Usuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.saucedemo.userinterfaces.CheckoutPage.*;

public class ValidaInformacion implements Task {

    private final Usuario usuario;

    public ValidaInformacion(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CHECKOUT),
                Enter.theValue(usuario.getNombre()).into(CAMPO_NOMBRE),
                Enter.theValue(usuario.getApellido()).into(CAMPO_APELLIDO),
                Enter.theValue(usuario.getCodigoPostal()).into(CAMPO_CODIGO_POSTAL),
                Click.on(BTN_CONTINUAR)
        );
    }

    public static ValidaInformacion del(Usuario usuario){
        return Tasks.instrumented(ValidaInformacion.class, usuario);
    }
}
