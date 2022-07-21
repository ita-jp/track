CREATE TABLE tickets
(
    ticket_id   BIGSERIAL    NOT NULL PRIMARY KEY,
    summary     VARCHAR(50)  NOT NULL,
    description VARCHAR(500),
    created_at  TIMESTAMP
);