# Prueba Tecnica
## Base de datos
1. Ingresar a la base de datos
```
mysql -P 3333 -u root -p
```
2. Password: Cpro123db

3. Creacion de la base de datos
```
CREATE DATABASE cuentas character set utf8;
```

4. Importar sql generados
```
mysql -P 3333 -u root -p cuentas < ./BaseDatos/cuentas.sql
```
