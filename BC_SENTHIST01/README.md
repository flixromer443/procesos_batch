# BC_SENTHIST01(V1.0)                    
**Autor: Felix Eduardo Etchegaray**\
**Fecha: 04/03/2024**

### Introducción
En principio se trata de un pequeño proyecto hecho con el fin de correjir los estados historicos mal grabados
correspondientes a **SICASENT** mediante el uso de las herramientas Spring Boot y Spring Batch.

### Instalación y configuración del entorno
* **Paso 1**: Apuntar la propiedad "***carpeta.raiz***" del archivo "**application.properties**" a una carpeta que 
  contenga el siguiente arbol de directorios(no importa como se llame la carpeta raiz.\
  Por ejemplo:
  * **. /carpeta_raiz** 
     * . /ENTRADA 
     * . /SALIDA
  
  
* **Paso 2**: Apuntar la propiedad "***logging.file.name***" del archivo "**application.properties**" a la misma carpeta
  raiz apuntada en  el **Paso 1**.\
  Por ejemplo:
  * *logging.file.name=/var/carpeta_raiz/console.log*
  
* **Paso 3**: Colocar las credenciales de la base de datos de producción de **SICASENT** en las siguientes
  propiedades correspondientes al archivo "**appication.properties**" :
  * *sicasent.datasource.jdbcUrl*
  * *sicasent.datasource.driver-class-name*
  * *sicasent.datasource.username*
  * *sicasent.datasource.password*
  * *sicasent.jpa.database-platform*


* **Paso 4**: Correr dentro de un **IDE**(preferentemente **IntellijIdea**) el siguiente comando:
  * ***mvn clean packaje*** 

* **Paso 5**: Copiar el archivo "***ENTRADA.csv***" dentro de la carpeta ***./ENTRADA*** de la carpeta raiz 
    creada en el **Paso1**. 
  
### Ejecución y salidas

* Copiar el archivo **BC_SENTHIST01-1.0.jar** creado en la carpeta *./target* y ejecutar por consola a traves
  del siguiente comando:
  * ***java -jar BC_SENTHIST01-1.0.jar***
* Enviar una copia de la carpeta raiz creada en el **Paso 1** de "**Instalación y configuración del entorno**".
