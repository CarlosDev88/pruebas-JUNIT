package com.carlos.restaurantesdata.dao.impl;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.carlos.restaurantesdata.dao.TipoRestauranteDAO;
import com.carlos.restaurantesdata.connection.ConnectionFactory;
import com.carlos.restauranteentities.entity.TipoRestaurante;

/**
 * 
 * @author Carlos clase que implementa el CRUD y otros metodos personalizados a
 *         la base de datos en la tabla tipo_restaurante
 *
 */

public class TipoRestauranteDAOImpl implements TipoRestauranteDAO {

	@Override
	public int guardar(TipoRestaurante tipoRestaurante) throws SQLException {
		String sql = "insert into tipo_restaurante (descripcion,fechaCreacion,estatus) values('"
				+ tipoRestaurante.getDescripcion() + "','" + tipoRestaurante.getFechaCreacion() + "',"
				+ tipoRestaurante.isEstatus() + ");";

		int ejecutado = ConnectionFactory.ejecutarSql(sql);
		return ejecutado;
	}

	@Override
	public int actualizar(TipoRestaurante tipoRestaurante) throws SQLException {
		String sql = "update tipo_restaurante set descripcion = '" + tipoRestaurante.getDescripcion()
				+ "',fechaModificacion='" + tipoRestaurante.getFechaModificacion() + "' ,estatus ="
				+ tipoRestaurante.isEstatus() + " where idTipoRestaurante=" + tipoRestaurante.getIdTipoRestaurante()
				+ ";";

		int ejecutado = ConnectionFactory.ejecutarSql(sql);
		return ejecutado;
	}

	@Override
	public int eliminar(int idTipoRestaurnate) throws SQLException {
		String sql = "delete from tipo_restaurante where idTipoRestaurante=" + idTipoRestaurnate + ";";
		int ejecutado = ConnectionFactory.ejecutarSql(sql);
		return ejecutado;

	}

	@Override
	public List<TipoRestaurante> consultar() throws SQLException {
		String sql = "select * from tipo_restaurante order by descripcion;";
		ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);
		List<TipoRestaurante> tiposRestaurantes = new ArrayList<TipoRestaurante>();

		if (rs != null) {

			while (rs.next()) {
				TipoRestaurante tipoRestaurante = new TipoRestaurante();
				tipoRestaurante.setIdTipoRestaurante(rs.getInt("idTipoRestaurante"));
				tipoRestaurante.setDescripcion(rs.getString("descripcion"));
				tipoRestaurante.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());

				tipoRestaurante.setFechaModificacion(rs.getTimestamp("fechaModificacion") != null
						? rs.getTimestamp("fechaModificacion").toLocalDateTime()
						: null);

				tipoRestaurante.setEstatus(rs.getBoolean("estatus"));

				tiposRestaurantes.add(tipoRestaurante);
			}

		}
		return tiposRestaurantes;
	}

	@Override
	public TipoRestaurante consultar(int idTipoRestaurnate) throws SQLException {
		String sql = "select * from tipo_restaurante where idTipoRestaurante =" + idTipoRestaurnate + ";";
		ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);
		TipoRestaurante tipoRestaurante = null;

		if (rs != null) {

			if(rs.next()) {

				tipoRestaurante = new TipoRestaurante();
				tipoRestaurante.setIdTipoRestaurante(rs.getInt("idTipoRestaurante"));
				tipoRestaurante.setDescripcion(rs.getString("descripcion"));
				tipoRestaurante.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());

				tipoRestaurante.setFechaModificacion(rs.getTimestamp("fechaModificacion") != null
						? rs.getTimestamp("fechaModificacion").toLocalDateTime()
						: null);

				tipoRestaurante.setEstatus(rs.getBoolean("estatus"));
			}

		}

		return tipoRestaurante;
	}

}