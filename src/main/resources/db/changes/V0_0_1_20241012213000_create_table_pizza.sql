--liquibase formatted sql

--changeset gustavotaima:1
CREATE TABLE pizza_category (
    id_pizza_category INT AUTO_INCREMENT,
    name_pizza_category VARCHAR(100) NOT NULL,

    CONSTRAINT pk_pizza_category
        PRIMARY KEY (id_pizza_category)
);

--rollback drop table pizza_category;

--changeset gustavotaima:2
INSERT INTO pizza_category (name_pizza_category) VALUES
    ('Tradicional'),
    ('Gourmet'),
    ('Doce');

--rollback delete from pizza_category;

--changeset gustavotaima:3
CREATE TABLE pizza (
    id_pizza INT AUTO_INCREMENT,
    id_pizza_category INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(200) NOT NULL,
    image LONGTEXT NOT NULL,
    price FLOAT NOT NULL,

    CONSTRAINT pk_pizza
        PRIMARY KEY (id_pizza),

    CONSTRAINT fk_pizza_pizza_category
        FOREIGN KEY (id_pizza_category) REFERENCES pizza_category (id_pizza_category)
);

--rollback drop table pizza;
