--liquibase formatted sql

--changeset gustavotaima:1
CREATE TABLE pizza (
    id_pizza INT AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(200) NOT NULL,
    image LONGTEXT NOT NULL,
    price FLOAT NOT NULL,

    CONSTRAINT pk_pizza
        PRIMARY KEY (id_pizza)
);

--rollback drop table pizza;
