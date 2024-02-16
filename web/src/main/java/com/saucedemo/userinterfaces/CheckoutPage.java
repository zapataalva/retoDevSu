package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {
    public static final Target CAMPO_NOMBRE = Target.the("Campo del nombre").located(By.id("first-name"));
    public static final Target CAMPO_APELLIDO = Target.the("Campo del apellido").located(By.id("last-name"));
    public static final Target CAMPO_CODIGO_POSTAL = Target.the("Campo del codigo postal").located(By.id("postal-code"));
    public static final Target BTN_CHECKOUT = Target.the("Boton checkout").located(By.id("checkout"));
    public static final Target BTN_CONTINUAR = Target.the("Boton continuar").located(By.id("continue"));
    public static final Target ITEM_TOTAL = Target.the("Item total").located(By.className("summary_subtotal_label"));
    public static final Target BTN_FINALIZAR = Target.the("Boton finalizar").located(By.id("finish"));

}
