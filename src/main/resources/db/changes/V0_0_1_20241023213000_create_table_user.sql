--liquibase formatted sql

--changeset felipecosta:1
CREATE TABLE users (
    id_user SERIAL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    address VARCHAR(200) NOT NULL,

    CONSTRAINT pk_user
        PRIMARY KEY (id_user)
);

--rollback drop table users;
