CREATE DATABASE banco;
USE banco;

CREATE TABLE usuarios (
id_usuario INTEGER PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
apellido VARCHAR(50) NOT NULL,
dni VARCHAR(50) UNIQUE NOT NULL,
email VARCHAR(50) UNIQUE NOT NULL,
fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE credenciales (
id_credencial INTEGER PRIMARY KEY AUTO_INCREMENT,
id_usuario INTEGER NOT NULL,
username VARCHAR(50) UNIQUE NOT NULL,
password VARCHAR(50) NOT NULL,
permiso VARCHAR(50) NOT NULL ,
FOREIGN KEY(id_usuario) REFERENCES usuarios(id_usuario) ON
DELETE CASCADE
);

CREATE TABLE cuentas (
id_cuenta INTEGER PRIMARY KEY AUTO_INCREMENT,
id_usuario INTEGER NOT NULL,
tipo VARCHAR(50) NOT NULL,
saldo DECIMAL DEFAULT 0,
fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY(id_usuario) REFERENCES usuarios(id_usuario) ON
DELETE CASCADE
);

SELECT *
FROM usuarios;

SELECT 
	CONCAT(u.nombre, " ",u.apellido) AS nombre,
	c.username AS username,
	c.password AS pass
FROM
	usuarios u JOIN credenciales c
    ON u.id_usuario = c.id_usuario;

DELETE FROM usuarios WHERE id_usuario = 12;