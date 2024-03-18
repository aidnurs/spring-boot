CREATE TABLE workers
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(100),
    assigned_todo UUID REFERENCES todos (id),
    created_at    TIMESTAMP DEFAULT NOW(),
    updated_at    TIMESTAMP DEFAULT NOW()
);
