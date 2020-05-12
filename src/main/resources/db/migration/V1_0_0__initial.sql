--------------------
-- Version: 1.0.0
-- Engine: Postgres
--------------------

-- SCHEMA

CREATE EXTENSION "uuid-ossp" SCHEMA PG_CATALOG;

-- Tables
CREATE TABLE todo
(
    id uuid NOT NULL DEFAULT uuid_generate_v1(),
    title varchar NOT NULL,
    description varchar DEFAULT NULL,
    completed boolean NOT NULL DEFAULT FALSE,
    user_id uuid NOT NULL
);

CREATE TABLE users
(
    id uuid NOT NULL DEFAULT uuid_generate_v1(),
    username varchar UNIQUE NOT NULL,
    password varchar NOT NULL
);

ALTER TABLE todo ADD CONSTRAINT pk_todo PRIMARY KEY (id);

ALTER TABLE users ADD CONSTRAINT pk_user PRIMARY KEY (id);

ALTER TABLE todo ADD CONSTRAINT fk_todo_user FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE ON UPDATE CASCADE;
