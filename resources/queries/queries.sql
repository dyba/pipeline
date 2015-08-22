-- name: select-item-statuses
-- Selects all item statuses
SELECT *
FROM item_statuses

-- name: create-item-status<!
-- Creates a new item status
INSERT INTO item_statuses ( name, mark_as_closed, is_default )
VALUES ( :name, :mark_as_closed, :is_default )
