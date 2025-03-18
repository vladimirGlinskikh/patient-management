CREATE TABLE IF NOT EXISTS patient
(
    id              uuid PRIMARY KEY,
    address         VARCHAR(255)        NOT NULL,
    date_of_birth   DATE                NOT NULL,
    email           VARCHAR(255) UNIQUE NOT NULL,
    name            VARCHAR(255)        NOT NULL,
    registered_date DATE                NOT NULL
);

-- INSERT INTO patient (id, address, date_of_birth, email, name, registered_date)
-- VALUES ('3533edb3-7a06-4a38-88a5-f90638da3e15',
--         '89 Lenina street',
--         '1975-08-15',
--         'vladimir.vs2@gmail.com',
--         'Vladimir Vladimirov',
--         '2025-03-09');
