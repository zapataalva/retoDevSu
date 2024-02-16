package com.saucedemo.questions;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;


public class ObtenerProductos implements Question<List<String>> {

    public List<String> answeredBy(Actor actor) {
        ListOfWebElementFacades elementos = BrowseTheWeb.as(actor).findAll(By.className("inventory_item_name"));
        return elementos.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public static ObtenerProductos de() {
        return new ObtenerProductos();
    }
}
