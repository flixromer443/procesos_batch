# BC_SENTDW02(V1.0-BETA)                    
**Autor: Felix Eduardo Etchegaray**\
**Fecha: 05/04/2023**

#### Descripción
* Basicamente es un prototipo que fue pensado como un "PLAN B" en el caso de que no se pueda correr el proceso
  **BC_SENTDW01** en produccion.

*  Funciona exactamente igual que el **BC_SENTDW01** pero de momento no graba a traves del servicio.

## Instalación y configuración del entorno
* **Paso 1:** Despues de haber compilado la solucion colocar todos los archivos dentro de 
   una carpeta por ejemplo "*BC_SENTDW02/DLL*".

* **Paso 2:** Crear la carpeta "*BC_SENTDW02/ARCHIVOS*". 

* **Paso 3:** Crear accesos directos a los archivos **BC_SENTDW02.exe** y **BC_SENTDW02.dll** y colocarlos en la
   capeta "*/BC_SENTDW02*". 

* **Paso 4:** Reacondicionar el archivo **BC_SENTDW02.dll** accediendo a traves del acceso directo
  para que apunte a la carpeta "*BC_SENTDW02/ARCHIVOS*".\
  Por ejemplo:
  
        <add key="CarpetaRaiz" value="C:/BC_SENTDW02/ARCHIVOS"/>
  
* **Paso 5:** Reacondicionar el archivo **BC_SENTDW02.dll** accediendo a traves del acceso directo
  para que apunte a la carpeta de los logs.\
  Por ejemplo:
        
        <file value="//ansesbatch03/LogsAplicaciones/SE-BC_SENTDW02/log.txt" />
        
## Ejecución 

#### Mecanica
   * Colocar el archivo **BAJADA_EDOCUMENTO.csv** dentro de la carpeta "*BC_SENTDW02/ARCHIVOS*". 
               
   * Ejecutar el archivo **BC_SENTDW02.exe** a traves del acceso directo previamente creado.
   
   * Una vez finalizada la ejecucion revisar la carpeta "*BC_SENTDW02/ARCHIVOS*" para obtener los archivos de salida.
          
