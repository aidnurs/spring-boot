CREATE OR REPLACE FUNCTION create_worker_on_todo_insert()
    RETURNS TRIGGER
AS
$$
BEGIN
    INSERT INTO workers (name, assigned_todo)
    VALUES ('Task: ' || NEW.title, NEW.id);

    RETURN NEW;
END;
$$
    LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS create_worker_on_todo_insert ON todos;

CREATE TRIGGER create_worker_on_todo_insert
    AFTER INSERT
    ON todos
    FOR EACH ROW
EXECUTE FUNCTION create_worker_on_todo_insert();
