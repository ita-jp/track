CREATE TABLE mst_ticket_types (
    mst_ticket_types_id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(64)
);

INSERT INTO mst_ticket_types (name) VALUES ('Bug');
INSERT INTO mst_ticket_types (name) VALUES ('Enhancement');
INSERT INTO mst_ticket_types (name) VALUES ('Task');

CREATE TABLE tickets
(
    ticket_id   BIGSERIAL NOT NULL PRIMARY KEY,
    mst_ticket_types_id BIGSERIAL NOT NULL REFERENCES mst_ticket_types(mst_ticket_types_id),
    summary     VARCHAR(50)  NOT NULL,
    description VARCHAR(500),
    created_at  TIMESTAMP NOT NULL
);