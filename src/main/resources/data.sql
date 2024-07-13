-- CREATE DATABASE auraderm;

-- USE auraderm;


INSERT INTO clientes (correo, direccion, nombre, telefono)
VALUES
    ('juan.perez@example.com', 'Calle A, Ciudad X', 'Juan Pérez', '555-1234'),
    ('maria.lopez@example.com', 'Avenida B, Ciudad Y', 'María López', '555-5678'),
    ('carlos.garcia@example.com', 'Calle C, Ciudad Z', 'Carlos García', '555-9876'),
    ('ana.martinez@example.com', 'Avenida D, Ciudad W', 'Ana Martínez', '555-4321'),
    ('pedro.ramirez@example.com', 'Calle E, Ciudad V', 'Pedro Ramírez', '555-8765');

INSERT INTO categorias (nombre)
VALUES
    ('Electrónica'),
    ('Ropa'),
    ('Alimentos'),
    ('Juguetes'),
    ('xxxxx');


INSERT INTO productos (categoria_id, descripcion, nombre, precio, stock)
VALUES
   (1, 'Smartphone de última generación', 'Teléfono móvil', 20000, 50),
    (2, 'Camiseta para deportes', 'Camiseta deportiva', 6000, 100),
    (3, 'Arroz blanco de grano largo', 'Arroz', 5000, 200),
    (5, 'Muñeca de juguete para niños', 'Muñeca', 1900, 80);


INSERT INTO pedidos (cliente_id, fecha)
VALUES
    (1, '2024-07-13'),
    (2, '2024-07-14'),
    (3, '2024-07-15');

INSERT INTO pedido_productos (cantidad, pedido_id, producto_id)
VALUES
    (1, 1, 1),
    (4, 2, 2),
    (5, 3, 3);

-- SELECT * FROM pedidos;
-- SELECT * FROM productos;
-- SELECT * FROM clientes;
-- SELECT * FROM pedido_productos;
-- SELECT * FROM categorias;
