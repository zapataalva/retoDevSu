package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.saucedemo.userinterfaces.InicioSesionPage.*;

public class InicioSesion implements Task {

    private final String usuario;
    private final String pass;

    public InicioSesion(String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(CAMPO_USUARIO),
                Enter.theValue(pass).into(CAMPO_PASS),
                Click.on(BTN_INICIAR_SESION)
        );
    }

    public static InicioSesion con(String usuario, String pass) {
        return Tasks.instrumented(InicioSesion.class, usuario, pass);
    }
}
