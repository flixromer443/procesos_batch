# GENERADOR_NUEVO_ARCHIVO(V1.1)                    
**Autor: Felix Eduardo Etchegaray**\
**Fecha: 30/03/2023**

## Introducción

#### Descripción

* Se trata de un proceso que nos sirve de herramienta a modo local para el proceso **BC_SENTDW01**.
#### Objetivo principal
* Reacondicionar el archivo **BAJADA_EDOCUMENTO.csv** en base a nuestras necesidades.

## Instalación y configuración del entorno
* **Paso 1:** colocar los mismos archivos del proceso **BC_SENTDW01** reemplazando unicamente el archivo *.jar* por el archivo
"*GENERADOR_NUEVO_ARCHIVO-1.0.jar*".

* **Paso 2:** Renombrar todos los archivos excepto el *.jar* como "*GENERADOR_NUEVO_ARCHIVO*".

* **Paso 3:** Dentro de la misma carpeta que estan todos los archivos crear las carpetas "*./LOGS*", "*./ENTRADA*" y "*./SALIDA*".

* **Paso 4:** Reacondicionar el archivo "*GENERADOR_NUEVO_ARCHIVO.bat*" para que apunte al archivo "*GENERADOR_NUEVO_ARCHIVO-1.0.jar*".\
  Por ejemplo:
  
        CD C:\Users\a994159\Desktop\PRUEBAS_EJECUCION\GENERADOR_NUEVO_ARCHIVO
        java -jar GENERADOR_NUEVO_ARCHIVO-1.0.jar --spring.config.location=file:application.prod.properties
  
* **Paso 5:** Reacondicionar el archivo "*application.prod.properties*" para que las las propiedades **logging.file.name** y **carpeta.raiz**
  apunten a las carpetas "*/LOGS*" y la carpeta principal del proyecto.\
  Por ejemplo:
        
        #LOGS
        logging.file.name=C:/Users/a994159/Desktop/PRUEBAS_EJECUCION/GENERAR_NUEVO_ARCHIVO/LOGS/CONSOLE.log
        
        #ARCHIVOS DE ENTRADA Y SALIDA
        carpeta.raiz=C:/Users/a994159/Desktop/PRUEBAS_EJECUCION/GENERAR_NUEVO_ARCHIVO      
  
## Ejecución 

#### Mecanica
   * Este proceso cuenta con 2 modos de ejecucion(de momento), que se seleccionam colocando un valor numerico 
     en la property **modo.ejecucion** del archivo "*application.properties*" .\
     Por ejemplo:
    
         modo.ejecucion=1
   
   * Para ambos casos se necesita colocar un archivo "*BAJADA_EDOCUMENTO.csv*" en la carpeta "*/ENTRADA*".
   
   * Una vez que se haya seleccionado el modo de ejecucion y se haya colodao el archivo en la carpeta "*/ENTRADA*" sera necesario
   ejecutar el archivo "*GENERADOR_NUEVO_ARCHIVO.bat*" para correr el proceso.
  
  

#### Modos de ejecución 
*  **Modo 1:** Se extraen del archivo "*BAJADA_EDOCUMENTO.csv*" los registros no procesados por el proceso **BC_SENTDW01**
               y se colocan en un nuevo archivo alojado en la carpeta "*/SALIDA*".\
               Para este caso en particular es necesario colocar el archivo "*NO_PROCESADOs.txt*" del proceso **BC_SENTDW01**
               en la carpeta "*/ENTRADA*".
               
* **Modo 2:** Se crea un nuevo archivo "*BAJADA_EDOCUMENTO.csv*" en la carpeta "*/SALIDA*" con correcciones en los siguientes campos:
   * *Titulo*
   * *Descripcion*
   * *Ruta*
            
                 
                             
