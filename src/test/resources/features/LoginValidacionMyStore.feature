Feature: Product - Store

  @testLoginMyStore
  Scenario Outline: Validación del precio de un producto
    Given estoy en la página de la tienda
    And me logueo con mi usuario "<username>" y clave "<password>"
    When navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
    And agrego <unidades> unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito
    Examples:
      | username                | password         | categoria  | subcategoria | unidades |
      | alexisdulanto@gmail.com | AlexisDulanto123 | clothes    | men          | 2        |
      | nttdata@outlook.com     | 123456778        | accesorios | stationery   | 3        |
      | alexisdulanto@gmail.com | AlexisDulanto123 | cars       | men          | 2        |