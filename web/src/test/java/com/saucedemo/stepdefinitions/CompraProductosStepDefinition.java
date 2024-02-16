package com.saucedemo.stepdefinitions;

import com.saucedemo.questions.ObtenerProductos;
import com.saucedemo.tasks.CompraProducto;
import com.saucedemo.tasks.InicioSesion;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static com.saucedemo.utils.Constantes.PASS;
import static com.saucedemo.utils.Constantes.USUARIO;
import static net.serenitybdd.screenplay.actors.OnStage.*;

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
        List<String> productos = theActorInTheSpotlight().asksFor(ObtenerProductos.de());
        theActorInTheSpotlight().attemptsTo(CompraProducto.con(productos));
    }
    @Then("Se debe visualizar el mensaje {string}")
    public void seDebeVisualizarElMensaje(String mensajeEsperado) {
    }
}
