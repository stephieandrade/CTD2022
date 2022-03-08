/*Crear un SP que liste los apellidos, nombres y edad de los empleados ordenados
alfabéticamente.
Tip: Para la edad, crear una función que tenga como parámetro de entrada la fecha de
nacimiento y devuelva la edad.
b) Invocar el SP para verificar el resultado.*/
drop function if exists calcularedad
DELIMITER $$
CREATE FUNCTION calcularEdad(fechaNacimiento DATEtime)
returns int deterministic 
begin
	
return year(current_date())- year(fechaNacimiento);

end $$

delimiter $$
CREATE PROCEDURE primerejercicio()
begin
select apellido, nombre, calcularEdad(fechaNacimiento) from empleados;
end; $$ 

/*
Crear un SP que reciba el nombre de una ciudad y liste los empleados de esa ciudad que
sean mayores a 25 años.
Tip: Utilizar la función creada en punto 1.
*/
delimiter $$
create procedure listar(in ciudad varchar(50))
begin
select nombre from empleados
where calcularEdad(fechanacimiento) > 25;

end; 

call listar('Seattle')

/*FALTA TERMINAR!!!
Crear un SP que liste los apellidos, nombres, edad y la diferencia en años de edad con el
valor máximo de edad que tiene la tabla de clientes.
Tip: Utilizar la función creada en punto 1. Crear una función que devuelva la fecha de
nacimiento mínima de la tabla clientes.*/

drop function if exists minimo
delimiter $$
create function minimo()
returns datetime
begin select min(fechanacimiento) from empleados;
end $$

drop procedure if exists calcular
delimiter $$
create procedure calcular()
begin 
select nombre, apellido, calcularedad(fechanacimiento), timestampdiff(year, fechanacimiento , minimo()) from empleados;
end

	