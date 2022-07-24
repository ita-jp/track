CREATE TABLE ticket_changes
(
    ticket_changes_id BIGSERIAL NOT NULL PRIMARY KEY,
    ticket_id         BIGSERIAL NOT NULL REFERENCES tickets (ticket_id),
    created_at        TIMESTAMP NOT NULL,
    created_by        BIGSERIAL NOT NULL REFERENCES users (user_id),
    field             VARCHAR(64),
    oldValue          VARCHAR(64),
    newValue          VARCHAR(64)
)