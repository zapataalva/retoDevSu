package com.saucedemo.utils;

public class FormatoCaracteres {
    public static double limpiaValor(String valor) {
        return Double.parseDouble(valor.replace("$", ""));
    }

    public static String formatoValor(Double valor) {
        return "$".concat(String.valueOf(valor));
    }
}
