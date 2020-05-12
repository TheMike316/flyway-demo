--------------------
-- Version: 1.1.0
-- Engine: Postgres
-- changes: add version, created_at, last_modified_at to all tables
--------------------

ALTER TABLE todo
    ADD COLUMN version          bigint                      NOT NULL DEFAULT 0,
    ADD COLUMN created_at       timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ADD COLUMN last_modified_at timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE users
    ADD COLUMN version          bigint                      NOT NULL DEFAULT 0,
    ADD COLUMN created_at       timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ADD COLUMN last_modified_at timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP;