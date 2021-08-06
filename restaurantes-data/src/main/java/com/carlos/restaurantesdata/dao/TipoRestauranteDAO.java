package com.carlos.restaurantesdata.dao;

import com.carlos.restauranteentities.entity.*;

import java.sql.SQLException;
import java.util.List;



/**
 * 
 * @author Carlos Interface que representa el CRUD de transacciones para la
 *         tabla de tipo_restaurante
 *
 */

public interface TipoRestauranteDAO {
	/**
	 * @param tipoRestaurante
	 * @return 1 o mas en caso de ser exitoso. 0 en caso de no guadar
	 */
	int guardar(TipoRestaurante tipoRestaurante) throws SQLException;

	int actualizar(TipoRestaurante tipoRestaurante) throws SQLException;

	/**
	 * 
	 * @param int idTipoRestaurnate, indetificador del tipo a eliminar
	 * @return
	 * @throws SQLException 
	 */
	int eliminar(int idTipoRestaurnate) throws SQLException;

	List<TipoRestaurante> consultar() throws SQLException;

	TipoRestaurante consultar(int idTipoRestaurnate) throws SQLException;
}
