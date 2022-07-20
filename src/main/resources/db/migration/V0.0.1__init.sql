CREATE TABLE users
(
    user_id  BIGSERIAL    NOT NULL PRIMARY KEY,
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(500) NOT NULL,
    enabled  BOOLEAN      NOT NULL
);

CREATE TABLE authorities
(
    user_id   BIGSERIAL   NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (user_id, authority);

-- password1234
insert into users (username, password, enabled) values ('tom', '3b977839c7d9fd9256514cb7974f825336ce587940d0252923380a419f4644926c1071bd93d88c28', true);
insert into authorities (user_id, authority) values (1, 'ADMIN');
insert into authorities (user_id, authority) values (1, 'USER');