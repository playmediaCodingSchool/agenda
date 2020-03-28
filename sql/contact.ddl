
CREATE EXTENSION unaccent;

CREATE TABLE contact (
	dni                           integer PRIMARY KEY,
	name                          text NOT NULL,
	surname                       text NOT NULL,
	phone                         text NULL,
	email                         text NULL
);
