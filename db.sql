CREATE TABLE feedback
(
    id            SERIAL PRIMARY KEY,
    name          TEXT      NOT NULL,
    email         TEXT      NOT NULL,
    rating        INT       NOT NULL,
    comment       TEXT      NOT NULL,
    allow_contact BOOLEAN   NOT NULL,
    submitted_at  TIMESTAMP NOT NULL
);

INSERT INTO feedback (name, email, rating, comment, allow_contact, submitted_at)
VALUES ('Alice', 'alice@example.com', 5, 'Great job!', true, NOW()),
       ('Bob', 'bob@example.com', 4, 'Nice interface.', false, NOW()),
       ('Charlie', 'charlie@example.com', 3, 'Okay-ish', true, NOW()),
       ('Dana', 'dana@example.com', 2, 'Could be better.', false, NOW()),
       ('Eve', 'eve@example.com', 1, 'Not good.', true, NOW());