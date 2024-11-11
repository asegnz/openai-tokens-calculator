# openai-tokens-calculator
Ejemplo de proyecto para el tutorial de adictosaltrabajo.com

## Requerimientos

Necesitas tener instalados en tu equipo los siguientes requerimientos:
* Java 17
* Maven 3

## ¿Qué es esto?

Esto es una calculadora de tokens para modelos de ChatGPT.

## ¿Cómo funciona?

Escribe el siguiente comando en la consola:
```bash
mvn clean install && mvn exec:java -Dexec.mainClass="com.ejemplo.App
```

Puedes jugar con la consola, en la opción 1) te calculará el precio de la consulta que haces a ChatGPT y la respuesta que esperas según el número de la variable maxTokens que esperas. 
