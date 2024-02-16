package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InicioSesionPage {
    public static final Target CAMPO_USUARIO = Target.the("Campo de user name").located(By.id("user-name"));
    public static final Target CAMPO_PASS = Target.the("Campo de contraseña").located(By.id("password"));
    public static final Target BTN_INICIAR_SESION = Target.the("Boton inicio de sesion").located(By.id("login-button"));
}
