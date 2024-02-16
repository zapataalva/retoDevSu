package com.saucedemo.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaPrincipalPage {

    public static final Target NOMBRE_PRODUCTO = Target.the("Nombre del producto").locatedBy("//*[contains(text(),'{0}')]");
    public static final Target PRECIO_PRODUCTO = Target.the("Precio del producto").located(By.className("inventory_details_price"));
    public static final Target BTN_AGREGAR_PRODUCTO = Target.the("Boton agregar producto")
            .locatedBy("//*[contains(text(),'Add to cart')]");
    public static final Target BTN_VOLVER = Target.the("Boton volver al inventario")
            .locatedBy("//*[contains(text(),'Back to products')]");
    public static final Target BTN_CARRITO = Target.the("Boton carrito de compras").located(By.className("shopping_cart_link"));
    public static final Target PRODUCTOS_CARRITO = Target.the("Cantidad de productos en el carrito de compras").located(By.className("shopping_cart_badge"));
}
