package com.carlos.restaurantesdata.dao;
import com.carlos.restauranteentities.entity.*;

import java.sql.SQLException;
import java.util.List;



/**
 * 
 * @author Carlos Interface que representa el CRUD de transacciones para la
 *         tabla empleado
 *
 */

public interface EmpleadoDAO {
	
	/**
	 * @param TipoRestaurante
	 * @return 1 o mas en caso de ser exitoso. 0 en caso de no guadar
	 */
	int guardar(Empleado empleado) throws SQLException;

	int actualizar(Empleado empleado) throws SQLException;

	/**
	 * 
	 * @param int idEmpleado, indetificador del tipo a eliminar
	 * @return
	 * @throws SQLException 
	 */
	int eliminar(int idEmpleado) throws SQLException;

	List<Empleado> consultar() throws SQLException;

	Empleado consultar(int idEmpleado) throws SQLException;

}
