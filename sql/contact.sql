
-- CONSTRUCTORES y DESTRUCTORES
CREATE OR REPLACE FUNCTION contact (
	IN p_dni                      integer,
	IN p_name                     text,
	IN p_surname                  text,
	IN p_phone                    text,
	IN p_email                    text
) RETURNS contact AS
$$
	INSERT INTO contact(dni, name, surname, phone, email)
		VALUES (p_dni, p_name, p_surname, p_phone, p_email)
	RETURNING *;
$$ LANGUAGE sql VOLATILE;


CREATE OR REPLACE FUNCTION contact_destroy (
	IN p_dni                      integer
) RETURNS void AS 
$$
	DELETE FROM contact WHERE dni = p_dni;
$$ LANGUAGE sql VOLATILE STRICT;


-- GETTERS Y SETTERS
CREATE OR REPLACE FUNCTION contact_get_dni (
	IN p_dni                      integer
) RETURNS integer AS
$$ 
	SELECT dni FROM contact WHERE dni = p_dni;
$$ LANGUAGE sql STABLE STRICT;


CREATE OR REPLACE FUNCTION contact_set_dni (
	IN p_dni                      integer,
	IN p_new_dni                  integer
) RETURNS void AS 
$$
	UPDATE contact SET dni = p_new_dni WHERE dni = p_dni;
$$ LANGUAGE sql VOLATILE STRICT;


CREATE OR REPLACE FUNCTION contact_get_name (
	IN p_dni                      integer
) RETURNS text AS
$$ 
	SELECT name FROM contact WHERE dni = p_dni;
$$ LANGUAGE sql STABLE STRICT;


CREATE OR REPLACE FUNCTION contact_set_name (
	IN p_dni                      integer,
	IN p_name                     text
) RETURNS void AS 
$$
	UPDATE contact SET name = p_name WHERE dni = p_dni;
$$ LANGUAGE sql VOLATILE STRICT;


CREATE OR REPLACE FUNCTION contact_get_name (
	IN p_dni                      integer
) RETURNS text AS
$$ 
	SELECT name FROM contact WHERE dni = p_dni;
$$ LANGUAGE sql STABLE STRICT;


CREATE OR REPLACE FUNCTION contact_set_name (
	IN p_dni                      integer,
	IN p_name                     text
) RETURNS void AS 
$$
	UPDATE contact SET name = p_name WHERE dni = p_dni;
$$ LANGUAGE sql VOLATILE STRICT;


CREATE OR REPLACE FUNCTION contact_get_surname (
	IN p_dni                      integer
) RETURNS text AS
$$ 
	SELECT surname FROM contact WHERE dni = p_dni;
$$ LANGUAGE sql STABLE STRICT;


CREATE OR REPLACE FUNCTION contact_set_surname (
	IN p_dni                      integer,
	IN p_surname                  text
) RETURNS void AS 
$$
	UPDATE contact SET surname = p_surname WHERE dni = p_dni;
$$ LANGUAGE sql VOLATILE STRICT;


CREATE OR REPLACE FUNCTION contact_get_phone (
	IN p_dni                      integer
) RETURNS text AS
$$ 
	SELECT phone FROM contact WHERE dni = p_dni;
$$ LANGUAGE sql STABLE STRICT;


CREATE OR REPLACE FUNCTION contact_set_phone (
	IN p_dni                      integer,
	IN p_phone                    text
) RETURNS void AS 
$$
	UPDATE contact SET phone = p_phone WHERE dni = p_dni;
$$ LANGUAGE sql VOLATILE STRICT;


CREATE OR REPLACE FUNCTION contact_get_email (
	IN p_dni                      integer
) RETURNS text AS
$$ 
	SELECT email FROM contact WHERE dni = p_dni;
$$ LANGUAGE sql STABLE STRICT;


CREATE OR REPLACE FUNCTION contact_set_email (
	IN p_dni                      integer,
	IN p_email                     text
) RETURNS void AS 
$$
	UPDATE contact SET email = p_email WHERE dni = p_dni;
$$ LANGUAGE sql VOLATILE STRICT;


-- IDENTIFICACION Y BUSQUEDA
CREATE OR REPLACE FUNCTION contact_search (
	IN p_surname                  text DEFAULT '%'
) RETURNS SETOF contact AS 
$$
	SELECT * FROM contact 
		WHERE unaccent(surname) ilike unaccent('%' || p_surname || '%');
$$ LANGUAGE sql STABLE STRICT;


CREATE OR REPLACE FUNCTION contact_identify (
	IN p_dni                      integer
) RETURNS contact AS 
$$
	SELECT c FROM contact c WHERE dni = p_dni;
$$ LANGUAGE sql STABLE STRICT;
