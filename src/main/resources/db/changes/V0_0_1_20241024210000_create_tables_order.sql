--liquibase formatted sql

--changeset gustavotaima:1
CREATE TABLE status_order (
    id_status_order SERIAL,
    name_status VARCHAR(100) NOT NULL,

    CONSTRAINT pk_status_order
        PRIMARY KEY (id_status_order)
);

--rollback drop table status_order;

--changeset gustavotaima:2
INSERT INTO status_order (name_status) VALUES
    ('Pendente'),
    ('Preparando'),
    ('Aguardando entrega'),
    ('Em rota de entrega'),
    ('Finalizado');

--rollback delete from status_order;

--changeset gustavotaima:3
CREATE TABLE order_app (
    id_order SERIAL,
    id_user INT,
    id_status_order INT,
    total_price NUMERIC(10, 2) NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE,

    CONSTRAINT pk_order
        PRIMARY KEY (id_order),

    CONSTRAINT fk_order_user
        FOREIGN KEY (id_user) REFERENCES users (id_user),
    CONSTRAINT fk_order_status
        FOREIGN KEY (id_status_order) REFERENCES status_order (id_status_order)
);

--rollback drop table order_app;

--changeset gustavotaima:4
CREATE TABLE order_pizza (
    id_order INT,
    id_pizza INT,
    quantity INT NOT NULL,

    CONSTRAINT pk_order_pizza
        PRIMARY KEY (id_order, id_pizza),

    CONSTRAINT fk_order_pizza_order
        FOREIGN KEY (id_order) REFERENCES order_app (id_order),

    CONSTRAINT fk_order_pizza_pizza
        FOREIGN KEY (id_pizza) REFERENCES pizza (id_pizza)
);

--rollback drop table order_pizza;
