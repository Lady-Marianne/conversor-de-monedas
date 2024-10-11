# Alura Latam - Challenge: Conversor de monedas.

**Desarrolladora:** Mariana Andrea Lois.

## Descripción del proyecto:

Este proyecto es un **Conversor de Monedas**.
La aplicación permite convertir montos entre diferentes monedas utilizando una API externa (https://www.exchangerate-api.com/) para obtener las tasas de conversión en tiempo real.
Además, guarda un registro de las consultas realizadas en un archivo `JSON`.

## Estructura del proyecto:

El proyecto consta de las siguientes clases:

1. **`Principal`**:
    - Controla el flujo principal del programa y la interacción con el usuario.
    - Solicita al usuario que seleccione una moneda de origen, una moneda de destino, y el monto a convertir.
    - Llama a la clase `ConvertirMoneda` para realizar la conversión y muestra el resultado.
    - Guarda las conversiones realizadas en una lista que posteriormente se escribe en un archivo `JSON` mediante la clase `GeneradorDeArchivos`.

2. **`MonedaData`**:
    - Es un `record` que almacena los datos de una conversión: moneda de origen, moneda de destino, monto convertido, tasa de conversión, resultado y la hora de la última actualización de la tasa.
    - Proporciona un método `formatoConsulta` que devuelve una cadena formateada con los detalles de la conversión realizada.

3. **`ConvertirMoneda`**:
    - Esta clase se conecta a la API de ExchangeRate para obtener las tasas de conversión en tiempo real.
    - Utiliza la biblioteca `HttpClient` para enviar una solicitud HTTP y la librería `Gson` para parsear la respuesta en un objeto `MonedaData`.

4. **`GeneradorDeArchivos`**:
    - Se encarga de guardar las conversiones realizadas en un archivo `JSON`.
    - Utiliza la biblioteca `Gson` para convertir la lista de conversiones a formato JSON y guardarla en un archivo llamado `consultas.json`.

## Flujo del programa:

1. El usuario selecciona la moneda de origen y destino entre las opciones disponibles (ARS, USD, BRL, PEN, COP).
2. El usuario ingresa el monto a convertir.
3. El programa realiza la conversión y muestra el resultado en pantalla, indicando la cantidad convertida y la hora de la última actualización de la tasa de conversión.
4. Todas las conversiones realizadas se guardan en un archivo `consultas.json` al finalizar el programa.

## Bibliotecas utilizadas:

- **Gson**: Para convertir los datos de las respuestas de la API y las consultas en formato JSON.
- **HttpClient**: Para realizar solicitudes HTTP a la API de ExchangeRate.

## Archivo JSON generado:

El archivo `consultas.json` contiene un historial de todas las consultas realizadas durante la ejecución del programa.
Cada consulta incluye información sobre:

- Moneda de origen y destino.
- Tasa de conversión.
- Monto convertido.
- Fecha y hora de la última actualización de la tasa.

### Publicación en GitHub:

Este proyecto fue subido a GitHub utilizando Git Bash. 
A través de Git, se realizó el seguimiento de los cambios y el control de versiones del código, lo que permitió gestionar eficientemente el desarrollo del proyecto.
