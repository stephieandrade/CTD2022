SELECT BusinessEntityID, HireDate, VacationHours
FROM employee
WHERE HireDate > '2000/01/01 23:59:59.999';

SELECT lastname
FROM contact
WHERE lastname LIKE "_a%";


SELECT CONCAT(firstname, lastname) AS nombreApellido
FROM contact
WHERE title = "Mr." OR title = "Ms.";


SELECT name, ProductNumber
FROM product
WHERE ProductNumber LIKE "AR%" OR productNumber LIKE "BE%" OR productNumber LIKE "DC%";

SELECT firstname
FROM contact
WHERE firstname LIKE "c%" AND firstname NOT LIKE "_o%" AND firstname not like "_e%";

SELECT listprice
FROM product
WHERE listprice < 500 and listprice > 400;

SELECT EXTRACT(YEAR FROM birthdate) anioNacimiento
from employee
HAVING anioNacimiento BETWEEN '1960' 
AND '1980'
AND anioNacimiento % 2 = 0;

SELECT HireDate, VacationHours
FROM employee
WHERE HireDate > '2000/01/01 23:59:59.999';

/*
Mostrar el nombre, número de producto, precio de lista y el precio de lista
incrementado en un 10% de los productos cuya fecha de fin de venta sea anterior al
día de hoy.
Tablas: Product
Campos: Name, ProductNumber, ListPrice, SellEndDate
*/

select name, productnumber, listprice, ROUND(listprice*1.1, 2) as incrementado
from product 
where sellenddate < CURRENT_TIMESTAMP();

-- GROUP BY
/*
Mostrar la cantidad de empleados por año de nacimiento.
Tablas: Employee
Campos: BirthDate
*/
select count(employeeid) as cantidad, year(birthdate) AS anio
from employee
group by anio
order by anio ASC;

/*
Mostrar el promedio de precios de productos por año de inicio de venta.
Tablas: Product
Campos: ListPrice, SellStartDate
*/

select avg(listprice), year(sellstartdate)
from product
group by year(sellstartdate);

/*
Mostrar los productos y el total vendido de cada uno de ellos, ordenados por el total
vendido.
Tablas: SalesOrderDetail
Campos: ProductID, LineTotal
*/
select productid, round(sum(linetotal),2)
from salesorderdetail
group by productid
limit 10;

/*
Mostrar el promedio vendido por factura.
Tablas: SalesOrderDetail
Campos: SalesOrderID, LineTotal
*/
select salesorderid, avg(linetotal)
from salesorderdetail
group by salesorderid;

-- HAVING
/*Mostrar las subcategorías de los productos que tienen dos o más productos que
cuestan menos de $200.
Tablas: Product
Campos: ProductSubcategoryID, ListPrice*/

SELECT productsubcategoryid, name, listprice, count(productsubcategoryid) as cantidad
from product
where ListPrice < 200
group by productsubcategoryid
having count(productsubcategoryid) >= 2  ;

/*
2. Mostrar todos los códigos de subcategorías existentes junto con la cantidad para los
productos cuyo precio de lista sea mayor a $100 y el precio promedio sea menor a
$300.
Tablas: Product
Campos: ProductSubcategoryID, ListPrice*/

select productsubcategoryid, count(productsubcategoryid) as cantidad
from product
where listprice > 100 and productsubcategoryid is not null
group by productsubcategoryid
having avg(listprice) < 300;

-- JOINS

/*Mostrar los precios de venta de aquellos productos donde la cifra sea inferior al
precio de lista recomendado para ese producto ordenados por nombre de
producto.
Tablas: SalesOrderDetail, Product
Campos: ProductID, Name, ListPrice, UnitPrice*/

select name
from product as p
left join salesorderdetail as s on p.productid = s.ProductID
where p.ListPrice > s.UnitPrice
group by p.productid
order by name ASC;

/*
2. Mostrar todos los productos que tengan igual precio. Se deben mostrar de a pares,
código y nombre de cada uno de los dos productos y el precio de ambos. Ordenar
por precio en forma descendente.
Tablas: Product
Campos: ProductID, ListPrice, Name*/

SELECT n.productid, n.listprice
from (select p.productid, p.listprice from product as p
inner join product as pp on p.ProductID = pp.ProductId and p.listprice = pp.listprice order by p.listprice desc) as n
group by n.ProductID;

/*
3. Mostrar el nombre de los productos y de los proveedores ordenados por nombre
de proveedor descendente.
Tablas: Product, ProductVendor, Vendor
Campos: Name ,ProductID, BusinessEntityID, ProductSubcategoryID*/

select product.name, vendor.name, product.productid
from product 
left join productvendor on product.productid = productvendor.productid
left join vendor on productvendor.vendorid = vendor.vendorid
order by vendor.name desc;

/*4. Mostrar todas las personas —nombre y apellido— y en el caso que sean
empleados mostrar también el login id, caso contrario, mostrar null.
Tablas: Contact, Employee
Campos: FirstName, LastName, LoginID, BusinessEntityID
*/

select c.firstname, c.lastname, employee.loginID
from contact c
left join employee on employee.ContactID = c.ContactID






