# BC_SENTDW-01(v1.1)                    
**Autor: Felix Eduardo Etchegaray**\
**Fecha: 08/02/2023**

### Introducción
En principio se trata de un pequeño proyecto hecho con el fin de correjir los campos de "***secuencia****" mal grabados
correspondientes a **SICASENT** en la tabla "***EDocumento***" de la base de datos de **DigiWeb**
mediante el uso de las herramientas Spring Boot y Spring Batch.

### Instalación y configuración del entorno
* **Paso 1**: Apuntar la propiedad "***carpeta.raiz***" del archivo "**application.properties**" a una carpeta que 
  contenga el siguiente arbol de directorios(no importa como se llame la carpeta raiz).\
  Por ejemplo:
  * **. /carpeta_raiz** 
     * . /BAJADAS 
     * . /TRAMITES
  
  
* **Paso 2**: Apuntar la propiedad "***logging.file.name***" del archivo "**application.properties**" a la misma carpeta
  raiz apuntada en  el **Paso 1**.\
  Por ejemplo:
  * *logging.file.name=/var/carpeta_raiz/console.log*
  
* **Paso 3**: Reemplazar los valores de las propiedades "*digiweb.webservice*" y "*servidor.nas*" del archivo "**application.properties**"
  por lo siguiente:

  * *digiweb.webservice=http://webservices.anses.gov.ar/Digitalizacionservicios/DigitalizacionServicio.asmx*
  * *servidor.nas=SICASENT*
  
* **Paso 4**: Colocar las credenciales de la base de datos de producción de **SICASENT** en las siguientes
  propiedades correspondientes al archivo "**appication.properties**" :
  * *sicasent.datasource.jdbcUrl*
  * *sicasent.datasource.driver-class-name*
  * *sicasent.datasource.username*
  * *sicasent.datasource.password*
  * *sicasent.jpa.database-platform*


* **Paso 5**: Correr dentro de un **IDE**(preferentemente **IntellijIdea**) el siguiente comando:
  * ***mvn clean packaje*** 

* **Paso 6**: Copiar el archivo "***BAJADA_EDOCUMENTO.csv***" dentro de la carpeta ***./BAJADAS*** de la carpeta raiz 
    creada en el **Paso1**. 
  
### Ejecución y salidas

* Copiar el archivo **BC_SENTDW01-1.0.jar** creado en la carpeta *./target* y ejecutar por consola a traves
  del siguiente comando:
  * ***java -jar BC_SENTDW01-1.0.jar***
* Enviar una copia de la carpeta raiz creada en el **Paso 1** de "**Instalación y configuración del entorno**".

### Novedades
* **Nuevas casuisticas procesables**:.\
  * **Titular y tipo tramite 232 en DigiWeb**: Se reemplaza el CUIL y el tipo de tramite del registro por lo que esta en el expediente
    de sentencias.
  * **Titular en DigiWeb**: Se reemplaza el CUIL del registro por el que esta en el expediente de sentencias.
  * **Tipo tramite 232 en DigiWeb**: Se reemplaza el tipo de tramite del registro por el que esta en el expediente de sentencias.
    