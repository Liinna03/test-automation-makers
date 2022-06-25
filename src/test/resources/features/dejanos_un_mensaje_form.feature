Feature: Completar el formulario dejanos un mensaje de la pagina makers.

  Scenario: completar formulario.
    Given la siguiente url "https://somosmakers.co/"
    When hacemos clic en el enlace de CONTACTO
    Then capturar el numero de celular de servicio al cliente
    And llenar el formulario dejanos un mensaje y en el campo mensaje adjuntar el numero de celular capturado
    And antes de hacer clic en el boton enviar mensaje tomar un pantallazo con la informacion diligenciada