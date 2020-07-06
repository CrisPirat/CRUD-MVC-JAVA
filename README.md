# CRUD-MVC-JAVA
Ejercicio de Desarrollo de Software  
  
Desarrolle una aplicación web que se conecte a una base de datos en cualquier motor relacional (SQL Server, PostgreSQL, etc.). La aplicación debe hacer CRUD/ABM para la Entidades descritas más abajo.  
  
La aplicación debe gestionar un listado de Clientes, cada uno con Órdenes compuestas de Artículos. Para el Cliente, interesa registrar su nombre y apellido; para una Orden, su fecha y sus Artículos. Y para cada Artículo, un código, un nombre y un precio unitario. Para todas las Entidades, debe existir una pantalla correspondiente para crear instancias de la Entidad; sin embargo, solo para una de ellas, esa pantalla debe permitir modificar y eliminar además de crear (es suficiente un solo ejemplo de CRUD completo). Interesa principalmente la implementación de la lógica; no es necesario poner demasiado esfuerzo en asuntos visuales o de diseño gráfico.  

# REQUERIMIENTOS PARA CORRER EL CÓDIGO

NetBeans 8.1; Java 1.7; MySql; 

Dentro del proyecto modificar en la carpeta Configuracion la conexión a la base de datos


# SCRIPT MYSQL

CREATE TABLE cliente (
    id int NOT NULL AUTO_INCREMENT,
    apellido varchar(255) NOT NULL,
    nombre varchar(255),
    PRIMARY KEY (id)
); 

CREATE TABLE articulo (
    id int NOT NULL AUTO_INCREMENT,
    codigo varchar(255) NOT NULL,
    nombre varchar(255),
	precio float,
    PRIMARY KEY (id)
); 

CREATE TABLE orden (
    id int NOT NULL AUTO_INCREMENT,
	clienteId int,
	fecha date ,
    PRIMARY KEY (id),
	FOREIGN KEY (clienteId) REFERENCES cliente(id)
); 

CREATE TABLE ordenDetalle (
    id int NOT NULL AUTO_INCREMENT,
	ordenId int,
	articuloId int,
	cantidad float,
    PRIMARY KEY (id),
	FOREIGN KEY (ordenId) REFERENCES orden(id),
	FOREIGN KEY (articuloId) REFERENCES articulo(id)
); 
