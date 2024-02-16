Feature: Compra de productos

  Scenario: Compra de productos exitosamente
    Given Realizo login en saucedemo
    When Realizo una compra de productos
    Then Se debe visualizar el mensaje "GRACIAS POR SU COMPRA"