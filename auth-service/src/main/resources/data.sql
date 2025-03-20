CREATE TABLE IF NOT EXISTS "users"
(
    id       UUID PRIMARY KEY,
    email    VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL,
    role     VARCHAR(50)         NOT NULL
);

INSERT INTO "users" (id, email, password, role)
VALUES ('223e4567-e89b-12d3-a456-426614174001','test3@test.com', '$2a$10$Ca9jedDIpGM4uaJryDLe9Og/MparF.hfV2YBhmn.ieuQ2RyW2PDzi', 'ADMIN')
ON CONFLICT (email) DO NOTHING;

SELECT * FROM users;