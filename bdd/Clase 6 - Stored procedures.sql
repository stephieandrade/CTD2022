/*1. Vamos a crear un store procedure llamado facturacion_cliente() que dadas 2 fechas
como parámetros de entrada, nos devuelva los datos de todos los clientes y un campo donde
mostremos el monto total de facturas creadas entre las fechas recibidas por parámetro para
cada cliente. Recordemos que puede haber más de 1 factura por cliente. Para realizar ese
cálculo, vamos a crear una función llamada facturas_por_cliente() donde le vamos a pasar
como parámetro el id del cliente, las fechas desde y hasta y nos va a devolver la suma total
de las facturas por cada uno de ellos. Por último, si este campo nos devuelve null o 0
debemos mostrar la palabra ‘Sin Datos’ en ese cálculo. Ejecutar el store para las fechas
'2010-02-01' hasta '2010-02-11' y luego para '2010-02-01' hasta '2010-02-12'.*/
drop function if exists facturas_por_cliente
delimiter $$

CREATE FUNCTION facturas_por_cliente(id INT, fecha_inicio DATE, fecha_final DATE)
returns double 
begin
declare variable double;
DECLARE nodata varchar(10);
set variable = (select sum(total) from facturas where fecha_factura >= fecha_inicio and fecha_factura <= fecha_final and id = id_cliente);
case
	when variable <> 0
		then return variable;
	else
		set nodata = 'Sin datos';
        return nodata;
end case;
end $$

select facturas_por_cliente(1, '2012-02-01', '2012-02-03') from facturas
select sum(total) from facturas where fecha_factura >= '2010-02-01' and fecha_factura <= '2010-02-07'

DROP PROCEDURE IF EXISTS facturacion_cliente
delimiter $$
CREATE PROCEDURE facturacion_cliente(in fecha_inicio DATE, in fecha_final DATE)
BEGIN
    SELECT *, facturas_por_cliente(clientes.id, fecha_inicio, fecha_final) as suma FROM FACTURAS
    INNER JOIN clientes ON facturas.id_cliente = clientes.id;
END $$

#SET GLOBAL log_bin_trust_function_creators = 1;

CALL facturacion_cliente('2010-02-01', '2010-02-11');
CALL facturacion_cliente('2010-02-01', '2010-02-12');

-- 2. Vamos a generar un SP llamado calcular_impuesto(), donde vamos a pasarle un primer
-- parámetro de un valor de un producto y, como segundo parámetro, el impuesto que vamos a
-- calcularle a dicho valor. Una vez que realizamos el cálculo del impuesto, vamos a devolver en
-- el primer parámetro que teníamos, el valor del nuevo precio del producto con el impuesto
-- agregado. Probar el SSP con los siguientes valores: para el importe vamos a poner el valor
-- de 5000 y para el impuesto, vamos a ingresar el 21.

drop procedure if exists impuesto
delimiter $$
CREATE PROCEDURE impuesto(inout valor double, in impuesto int)
begin
set valor = valor * (impuesto/100 + 1);
end $$

SET @importe = 5000;
call impuesto(@importe, 21)
SELECT @importe;