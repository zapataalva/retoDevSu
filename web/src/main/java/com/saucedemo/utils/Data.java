package com.saucedemo.utils;

import com.github.javafaker.Faker;
import com.saucedemo.models.Usuario;

public class Data {
    public static Usuario nuevoUsuario() {
        Faker faker = new Faker();
        return new Usuario(faker.name().firstName(), faker.name().lastName(), faker.bothify("######"));
    }
}
