-- Base de datos
CREATE DATABASE IF NOT EXISTS distribuidora_bebidas;
USE distribuidora_bebidas;

-- Tabla: Bebida
CREATE TABLE Bebida (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo ENUM('GASEOSA', 'AGUA', 'JUGO', 'CERVEZA') NOT NULL,
    precioUnitario DECIMAL(10,2) NOT NULL CHECK (precioUnitario > 0),
    stock INT NOT NULL CHECK (stock >= 0)
);

-- Tabla: Cliente
CREATE TABLE Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    localidad VARCHAR(100) NOT NULL,
    tipoCliente ENUM('KIOSCO', 'ALMACEN', 'SUPERMERCADO') NOT NULL
);

-- Tabla: Pedido
CREATE TABLE Pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idCliente INT NOT NULL,
    idBebida INT NOT NULL,
    cantidad INT NOT NULL CHECK (cantidad > 0),
    estado ENUM('PENDIENTE', 'PREPARADO', 'ENTREGADO') NOT NULL DEFAULT 'PENDIENTE',
    FOREIGN KEY (idCliente) REFERENCES Cliente(id),
    FOREIGN KEY (idBebida) REFERENCES Bebida(id)
);

INSERT INTO Bebida (nombre, tipo, precioUnitario, stock) VALUES
('Coca Cola', 'GASEOSA', 200.00, 50),
('Pepsi', 'GASEOSA', 190.00, 30),
('Agua Villavicencio', 'AGUA', 120.00, 100),
('Agua Evian', 'AGUA', 150.00, 70),
('Jugo Cepita Naranja', 'JUGO', 160.00, 40),
('Jugo Baggio Manzana', 'JUGO', 155.00, 25),
('Cerveza Quilmes', 'CERVEZA', 250.00, 60),
('Cerveza Heineken', 'CERVEZA', 320.00, 20),
('Sprite', 'GASEOSA', 195.00, 45),
('Agua Saborizada Levite', 'AGUA', 140.00, 90);

INSERT INTO Cliente (nombre, localidad, tipoCliente) VALUES
('Almacen Don Pepe', 'La Plata', 'ALMACEN'),
('Kiosco 24hs', 'Buenos Aires', 'KIOSCO'),
('Supermercado El Gigante', 'Cordoba', 'SUPERMERCADO'),
('Kiosco Las Heras', 'Mendoza', 'KIOSCO'),
('Almacen El Progreso', 'Rosario', 'ALMACEN'),
('Supermercado Centro', 'Santa Fe', 'SUPERMERCADO'),
('Kiosco Express', 'Mar del Plata', 'KIOSCO'),
('Almacen La Esquina', 'Tucuman', 'ALMACEN'),
('Supermercado Norte', 'Salta', 'SUPERMERCADO'),
('Kiosco del Parque', 'Bahia Blanca', 'KIOSCO');

INSERT INTO Pedido (idCliente, idBebida, cantidad, estado) VALUES
(1, 1, 10, 'PENDIENTE'),
(2, 3, 5, 'ENTREGADO'),
(3, 7, 15, 'PREPARADO'),
(4, 5, 8, 'PENDIENTE'),
(5, 2, 12, 'ENTREGADO'),
(6, 8, 7, 'PREPARADO'),
(7, 6, 4, 'PENDIENTE'),
(8, 9, 6, 'PENDIENTE'),
(9, 4, 10, 'PREPARADO'),
(10, 10, 3, 'ENTREGADO');