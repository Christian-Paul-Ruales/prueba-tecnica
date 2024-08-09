
CREATE TABLE persona (
                id INT AUTO_INCREMENT NOT NULL,
                nombre VARCHAR(100) NOT NULL,
                genero VARCHAR(100) NOT NULL,
                edad INT NOT NULL,
                identificacion VARCHAR(15) NOT NULL,
                direccion VARCHAR(100) NOT NULL,
                telefono VARCHAR(100) NOT NULL,
                PRIMARY KEY (id)
);


CREATE TABLE cliente (
                id INT AUTO_INCREMENT NOT NULL,
                persona_id INT NOT NULL,
                cliente_id VARCHAR(20) NOT NULL,
                contrasena VARCHAR(255) NOT NULL,
                estado BOOLEAN NOT NULL,
                PRIMARY KEY (id)
);


CREATE TABLE cuenta (
                id INT AUTO_INCREMENT NOT NULL,
                cliente_id INT NOT NULL,
                numero_cuenta VARCHAR(25) NOT NULL,
                tipo_cuenta VARCHAR(25) NOT NULL,
                saldo_inicial NUMERIC(16,2) NOT NULL,
                estado BOOLEAN NOT NULL,
                PRIMARY KEY (id)
);


CREATE TABLE movimiento (
                id INT AUTO_INCREMENT NOT NULL,
                cuenta_id INT NOT NULL,
                valor NUMERIC(16,2) NOT NULL,
                saldo NUMERIC(16,2) NOT NULL,
                PRIMARY KEY (id)
);


ALTER TABLE cliente ADD CONSTRAINT persona_cliente_fk
FOREIGN KEY (persona_id)
REFERENCES persona (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE cuenta ADD CONSTRAINT cliente_cuenta_fk
FOREIGN KEY (cliente_id)
REFERENCES cliente (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE movimiento ADD CONSTRAINT cuenta_movimiento_fk
FOREIGN KEY (cuenta_id)
REFERENCES cuenta (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
