package com.saucedemo.stepdefinitions;

import com.saucedemo.models.Producto;
import com.saucedemo.questions.ObtenerProductos;
import com.saucedemo.tasks.CompraProducto;
import com.saucedemo.tasks.InicioSesion;
import com.saucedemo.tasks.ValidaInformacion;
import com.saucedemo.utils.Data;
import com.saucedemo.utils.FormatoCaracteres;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static com.saucedemo.userinterfaces.CheckoutPage.BTN_FINALIZAR;
import static com.saucedemo.userinterfaces.CheckoutPage.ITEM_TOTAL;
import static com.saucedemo.userinterfaces.PaginaPrincipalPage.PRODUCTOS_CARRITO;
import static com.saucedemo.utils.Constantes.*;
import static com.saucedemo.utils.Data.nuevoUsuario;
import static com.saucedemo.utils.FormatoCaracteres.formatoValor;
import static com.saucedemo.utils.FormatoCaracteres.limpiaValor;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompraProductosStepDefinition {

    private Producto producto1;
    private Producto producto2;
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
        theActorInTheSpotlight().attemptsTo(CompraProducto.con(productos),
                ValidaInformacion.del(nuevoUsuario()));
        producto1 = theActorInTheSpotlight().recall("producto1");
        producto2 = theActorInTheSpotlight().recall("producto2");

        double precioTotal = limpiaValor(producto1.getPrecio()) + limpiaValor(producto2.getPrecio());
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(Text.of(ITEM_TOTAL)).contains(formatoValor(precioTotal)),
                Click.on(BTN_FINALIZAR));
    }
    @Then("Se debe visualizar el mensaje {string}")
    public void seDebeVisualizarElMensaje(String mensajeEsperado) {

    }
}
