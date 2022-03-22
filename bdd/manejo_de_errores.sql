/* Crear la tabla artistasCopia ejecutando la siguiente sentencia: Create table artistasCopia select * from artistas. Luego realizar lo siguiente:
Crear un procedimiento almacenado que inserta un registro en la tabla artistasCopia. Los parámetros de entrada son: nombre, rating. El campo id se tiene que calcular en el procedimiento para insertar.
En el procedimiento creado, agregar una condition y un handler para capturar el error de que no exista la tabla. Cuando no exista la tabla debemos de mostrar el mensaje: "No existe la tabla artistasCopia"
Para probarlo, eliminemos la tabla artistasCopia, ejecutemos el procedimiento almacenado y.. ¿qué nos devolvió?
*/

/*Crear un procedimiento almacenado que inserta un registro en la tabla albumes. Los parámetros de entrada son:  titulo varchar(95), id_artista int. El campo id se tiene que calcular al insertar. Al procedimiento agregar una condition y handler para devolver el mensaje "Error de Foreign Key" cuando intente crear un registro donde el campo id_artista no exista en la tabla artista.
Probar el procedimiento con el valor idArtista que no existan en la tabla artista.
*/