-- 1. En una base de datos cualquiera, debemos confeccionar un stored procedure que le enviemos un entero comprendido entre 0 y 999 inclusive. El segundo parámetro debe retornar la cantidad de dígitos que tiene dicho número. Debemos utilizar la sentencia IF.

DELIMITER $$
CREATE PROCEDURE sp_random(IN valor INT, OUT digitos INT)
BEGIN
	IF (valor < 10) THEN
		SET digitos = 1;
	ELSEIF (valor < 100) THEN
		SET digitos = 2;
	ELSE
		SET digitos = 3;
	END IF;
END $$

CALL sp_random(5,@result1);
CALL sp_random(321,@result2);
CALL sp_random(66,@result3);
SELECT @result1, @result2, @result3;

-- 2. En la base de datos Musimundos, vamos a generar un SP donde le vamos a pasar por parámetro diferentes nombres de géneros en un varchar separados por |. Importante: al final siempre poner un |. Un ejemplo, 'Trap|Reggaeton|House|'. Luego, debemos insertar cada uno de ellos en nuestra tabla de géneros. Utilizar la sentencia WHILE. Tener en cuenta que para insertar el id, debemos ir a buscar el último número de id de la tabla de géneros.
drop procedure if exists generos
delimiter $$
CREATE PROCEDURE `generos` (in generos varchar(50))
begin
DECLARE ultimo_id INT DEFAULT (SELECT id FROM generos ORDER BY id DESC LIMIT 1);
while char_length(generos)>1 do
SET ultimo_id = ultimo_id + 1;
insert into generos (id, nombre) values(ultimo_id, left(generos,locate('|',generos)));

set generos = right(generos, char_length(generos)-locate('|', generos));
end while;
end $$

call generos('Trap|Reggaeton|House|')

-- En una base cualquiera, vamos a generar un SP que reciba por parámetros diferentes
-- números en un varchar separados por ;. Utilizar LOOP para recorrerlos. Importante: al final
-- siempre poner un ;. Un ejemplo, '10;66;138;37;-72;0.5;'. El SP devolverá 2 parámetros: la
-- suma total entre ellos y el promedio de los mismos. Solo debemos sumar y promediar los
-- números que son positivos. Validar lo dicho anteriormente con un CASE. Suponemos que
-- siempre se recibe al menos 1 número.

delimiter $$
CREATE PROCEDURE `loopNumeros` (IN valor VARCHAR(255), out respuesta1 double, out respuesta2 double)
BEGIN

	declare auxiliar double;
    declare cantidad int default 0;
	set respuesta1 = 0.00;
    set respuesta2 =0.00;
 
    loop1 : loop
    set auxiliar= cast(left(valor,locate(';',valor)-1) as  double);
		if auxiliar >0.0 then  
		set respuesta1 = respuesta1 + auxiliar ;
		set cantidad = cantidad + 1;
        set respuesta2= (respuesta1/cantidad);
		end if;
        
        set valor = right(valor, char_length(valor)-locate(';', valor));
		
     if  char_length(valor)<1 then leave loop1;
     end if;
    end loop;
END;
$$

call loopNumeros('10;66;138;37;-72;0.5;',@respuesta1,@respuesta2);
select @respuesta1 , @respuesta2;


