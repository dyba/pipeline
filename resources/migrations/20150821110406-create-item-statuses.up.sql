CREATE TABLE IF NOT EXISTS item_statuses
(id             serial,
 name           varchar(255),
 mark_as_closed boolean,
 is_default     boolean);
