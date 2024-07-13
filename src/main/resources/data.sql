-- CREATE DATABASE auraderm;

-- USE auraderm;


INSERT INTO clientes (correo, direccion, nombre, telefono)
VALUES
    ('juan.perez@example.com', 'Calle A, Ciudad X', 'Juan Pérez', '555-1234'),
    ('maria.lopez@example.com', 'Avenida B, Ciudad Y', 'María López', '555-5678'),
    ('carlos.garcia@example.com', 'Calle C, Ciudad Z', 'Carlos García', '555-9876'),
    ('ana.martinez@example.com', 'Avenida D, Ciudad W', 'Ana Martínez', '555-4321'),
    ('pedro.ramirez@example.com', 'Calle E, Ciudad V', 'Pedro Ramírez', '555-8765');



INSERT INTO productos (descripcion, nombre, precio, stock, categoria)
VALUES
   ('Smartphone de última generación', 'Teléfono móvil', 20000, 50, "Tecnologia"),
    ('Camiseta para deportes', 'Camiseta deportiva', 6000, 100,"Ropa"),
    ('Arroz blanco de grano largo', 'Arroz', 5000, 200, "Alimentos"),
    ('Muñeca de juguete para niños', 'Muñeca', 1900, 80, "Jugueteria");


INSERT INTO pedidos (cliente_id, fecha)
VALUES
    (1, '2024-07-13'),
    (2, '2024-07-14'),
    (3, '2024-07-15');


INSERT INTO pedido_productos (cantidad, pedido_id, producto_id)
VALUES
    (20, 1, 2),
    (4, 3, 1);

-- SELECT * FROM pedidos;
-- SELECT * FROM productos;
-- SELECT * FROM clientes;
-- SELECT * FROM pedido_productos;
-- SELECT * FROM categorias;


--SELECT * FROM clientes c
--INNER JOIN pedidos p
--ON c.id = p.cliente_id
--INNER JOIN pedido_productos pp
--ON c.id = pp.pedido_id
--INNER JOIN productos pr
--ON pp.producto_id = pr.id;
--
--SELECT c.nombre, c.direccion, c.correo, p.fecha, pr.nombre, pp.cantidad, pr.categoria FROM clientes c
--INNER JOIN pedidos p
--ON c.id = p.cliente_id
--INNER JOIN pedido_productos pp
--ON c.id = pp.pedido_id
--INNER JOIN productos pr
--ON pp.producto_id = pr.id;
