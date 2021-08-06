package com.carlos.restaurantesdata.dao;
import com.carlos.restauranteentities.entity.*;

import java.sql.SQLException;
import java.util.List;



/**
 * 
 * @author Carlos Interface que representa el CRUD de transacciones para la
 *         tabla restaurante
 *
 */

public interface RestauranteDAO {
	
	/**
	 * @param TipoRestaurante
	 * @return 1 o mas en caso de ser exitoso. 0 en caso de no guadar
	 */
	int guardar(Restaurante restaurante) throws SQLException;

	int actualizar(Restaurante restaurante) throws SQLException;

	/**
	 * 
	 * @param int idTipoRestaurnate, indetificador del tipo a eliminar
	 * @return
	 * @throws SQLException 
	 */
	int eliminar(int idRestaurnate) throws SQLException;

	List<Restaurante> consultar() throws SQLException;

	Restaurante consultar(int idRestaurnate) throws SQLException;

}
