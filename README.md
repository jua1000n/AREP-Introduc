# AREP-Introduc

# Conversor de unidades de temperatura
Por medio de esta API se plantea hacer la conversion de unidades Celcius a Fahrenheit y viceversa, los recursos que se usaron principalmente fueronSpark, Java, Javascript, HTML.


## Arquitectura
Esta API, esta basada Reset, como sabemoa Reset usa como recurso pricipal JSON(JavaScript Object Notation), esta interactua con este para poder comunicarse de manera eficiente teniendo en cuenta que llega a ser mas ligera y eficiente que XML, la arquitectura que se esta manejando es Cliente/Servidor se basa en que desde el frontend el cual implenta HTML, que se comunica con un Javascript, este manda por medio de una peticion GET hacia una URL en la cual se encuentra en escucha el backend,este hace el calculo y por medio de JSON retorna los valores para que el fronted los reciba y los pueda interpretar. Para hacer que el backend pueda consultarse desde internet o de forma local se uso un Framework llamado Spark. Para que esto pueda servir se necesita que el backend y el frontend se encuentren desplegados en la nube, en este caso el servicio que se esta usando es Heroku.

### URL Backend
Para consultar desde internet 
> https://arep-backend-jc.herokuapp.com

Para consultar desde local con heroku
> localhost:5000

Para ejecutar desde local
> localhost:4567

En este caso si se realiza la consulta debe mandar un error debido a que falta la ruta y los parametros, las rutas que se encuentran disponibles son:
> /convert/fahrenheitC
> /convert/celsiusF

Para poder emviar parametros usamos:
> ?value=

En caso de que se envie algun parametro que no es permitido este debolvera un error 406 Not Acceptable, que hace referencia a, que lo que se esta enviando no es aceptable.

### URL Fronted
Para consultar desde internet 
> https://arep-fronted-jc.herokuapp.com/

En caso de que se quiera correr de forma local, se debe abrir la carpeta resources y en esta abrir el idex.html. Si al momento de realizar una consulta los campos se dejan vacios esta no realizara esta, por tanto no arroja ninguna respuesta, este permite hacer consultas ambas consultas al tiempo o solo una.

## Ejecucion de forma local 
Para poder correr el proyecto de forma local debemos clonar el proyecto:

> git clone https://github.com/jua1000n/AREP-Introduc.git

Para poder correr el proyecto se debe tener instalado Maven y JDK 8, despues de esto ejecutaremos el comando(se debe encontrar dentro de la carpeta del proyecto):

> mvn package

Lo que hara es que se descargue todos los recursos necesarios, que compile, y realice los test.En este caso con vamos a usar Heroku para desplegar de forma local el proyecto, debemos terminar el proceso que realizo el comando antrior. Ejecutaremos el comando:

> heroku local web

### Author
Juan Sebastian Cadavid
