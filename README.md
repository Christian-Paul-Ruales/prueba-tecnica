# Prueba Tecnica
## Herramientas usadas
* IDE: Intellij Idea
* docker desktop
* Base de datos: Mysql (docker-compose)
* Postman
* Spring Boot 3.3.2 (JDK 17)

## Ejecucion de la base de datos
1. Arrancar el proyecto en la carpeta raiz, el proceso demorara un poco
```bash
docker compose up -d
```

2. Ingresar en base de datos
```bash
mysql -P 3333 -u root -p
```

3. Creacion de la base de datos
```
CREATE DATABASE cuentas character set utf8;
```

4. Importar sql generados que se encuentran en la carpeta BaseDatos
```
mysql -P 3333 -u root -p cuentas < ./BaseDatos/cuentas.sql
```
## Ejecucion del proyecto

1. Ejecutar eureka server desde el archivo main en su IDE
2. Ejecutar el api gateway desde el archivo main en su IDE
3. Ejecutar el microservicio mcsv-personacliente desde el archivo main en su IDE
4. Ejecutar el microservicio mcsv-cuentamovimientos desde el archivo main en su IDE

## Postman

Los archivos se encuentran en la carpeta **PruebasPostman**
son colecciones relacionadas a los endpoins y ejemplos

## Pruebas
En el apartado de pruebas de los proyectos **mcsv-personacliente** y **mcsv-cuentamovimientos** se encuentran una prueba por cada proyecto

