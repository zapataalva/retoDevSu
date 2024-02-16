package com.saucedemo.stepdefinitions;

import com.saucedemo.tasks.InicioSesion;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.saucedemo.utils.Constantes.PASS;
import static com.saucedemo.utils.Constantes.USUARIO;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class CompraProductosStepDefinition {
    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
    }
    @Given("Realizo login en saucedemo")
    public void realizoLoginEnSaucedemo() {
        theActorCalled("Actor").attemptsTo(Open.url("https://www.saucedemo.com/"),
                InicioSesion.con(USUARIO,PASS));
    }
    @When("Realizo una compra de productos")
    public void realizoUnaCompraDeProductos() {
    }
    @Then("Se debe visualizar el mensaje {string}")
    public void seDebeVisualizarElMensaje(String mensajeEsperado) {
    }
}
