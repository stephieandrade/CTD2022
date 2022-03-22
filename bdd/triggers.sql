-- 1- Modificar la tabla artistas, agregar el campo usuarioCreador varchar(50) y fechaCreacion datetime. Luego realizar lo siguiente:
-- Crear un trigger que cuando se inserte un registro en la tabla artistas, se agregue en la columna usuarioCreador, el usuario que realizó la creación del registro. Pista: ¿que función usamos para obtener el usuario?
-- Además, que se agregue en el campo fechaCreacion en qué día y en qué hora se realizó la ejecución.
-- Ejecutar un insert en la tabla artistas y luego hacer un select del último registro para ver los resultados. ¿Qué usuario fue agregado?

/*2 -Modificar la tabla artistas, agregar el campo usuarioModificacion varchar(50) y fechaModificacion datetime. Luego realizar lo siguiente:
Crear un trigger que cuando se actualice un registro en la tabla artistas, se agregue en la columna usuarioModificacion, el usuario que realizó la actualización del registro.
Además, que se agregue en el campo fechaMoficacion en qué día y en qué hora se realizó la ejecución.
Ejecutar un update en la tabla artistas y luego hacer un select del último registro para ver los resultados. ¿Qué usuario fue el que modificó los datos? */ 

/*Crear la tabla artistas_historico con los campos: id int, nombre varchar(85), rating double(3,1), usuario varchar(50), fecha datetime, acción varchar(10).
Crear un trigger que cuando se inserta un registro en la tabla artistas, se inserte un valor en la tabla artistas_historico, con los mismos valores de id, nombre y rating, el usuario que realizó la acción, el día y hora de la ejecución y, en acción, agregar el valor "Insert"
Crear un trigger que cuando se hace un update de un registro en la tabla artistas, se inserte un valor en la tabla artistas_historico, con los mismos valores de id, nombre y rating, el usuario que realizó la acción, el día y hora de la ejecución y, en acción, agregar el valor "Update"
Crear un trigger que cuando se hace una eliminación de un registro en la tabla artistas, se inserte un valor en la tabla artistas_historico, con los mismos valores de id, nombre y rating, el usuario que realizó la acción, el día y hora de la ejecución y, en acción, agregar el valor "Delete"
Realizar un insert, update y un delete en la tabla artistas. Luego hacer un select en la tabla artistas_historico. 
*/
