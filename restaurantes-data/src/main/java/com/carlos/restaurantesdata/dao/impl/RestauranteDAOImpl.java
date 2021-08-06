/**
 * 
 */
package com.carlos.restaurantesdata.dao.impl;

import com.carlos.restaurantesdata.dao.RestauranteDAO;
import com.carlos.restaurantesdata.connection.ConnectionFactory;
import com.carlos.restauranteentities.entity.Restaurante;
import com.carlos.restauranteentities.entity.TipoRestaurante;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



/**
 * @author Carlos clase que implementa los metodos de CRUD de la interface
 *         restaurante DAO
 *
 */
public class RestauranteDAOImpl implements RestauranteDAO {

	static {

		try {
			ConnectionFactory.conectar();
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("error en la conexion " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public int guardar(Restaurante restaurante) throws SQLException {
		String sql = "insert into restaurante(nombre,imagen,slogan,idTipoRestaurante,fechaCreacion,estatus,idMenu) values('"
				+ restaurante.getNombre() + "','" + restaurante.getImagen() + "','eslogan',"
				+ restaurante.getTipoRestaurante().getIdTipoRestaurante() + ",'" + restaurante.getFechaCreacion() + "',"
				+ restaurante.isEstatus() + "," + restaurante.getMenu().getIdMenu() + ");";

		int ejecutado = ConnectionFactory.ejecutarSql(sql);
		return ejecutado;
	}

	@Override
	public int actualizar(Restaurante restaurante) throws SQLException {
		String sql = "update restaurante set nombre ='" + restaurante.getNombre() + "',imagen = '"
				+ restaurante.getImagen() + "', slogan='" + restaurante.getSlogan() + "' , idTipoRestaurante="
				+ restaurante.getTipoRestaurante().getIdTipoRestaurante() + ", fechaModificacion='"
				+ restaurante.getFechaModificacion() + "', estatus=" + restaurante.isEstatus() + ", idMenu = "
				+ restaurante.getMenu().getIdMenu() + " where idRestaurante = " + restaurante.getIdRestaurante() + ";";

		int ejecutado = ConnectionFactory.ejecutarSql(sql);
		return ejecutado;
	}

	@Override
	public int eliminar(int idRestaurnate) throws SQLException {
		String sql = "delete from restaurante where idRestaurante = " + idRestaurnate + ";";

		int ejecutado = ConnectionFactory.ejecutarSql(sql);
		return ejecutado;
	}

	@Override
	public List<Restaurante> consultar() throws SQLException {

		String sql = "select r.*, tp.descripcion from restaurante r, tipo_restaurante tp where r.idTipoRestaurante = tp.idTipoRestaurante order by nombre";
		ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();

		if (rs != null) {			
			

			while (rs.next()) {
				TipoRestaurante tipoRestaurante = new TipoRestaurante();
				tipoRestaurante.setIdTipoRestaurante(rs.getInt("idTipoRestaurante"));
				tipoRestaurante.setDescripcion(rs.getString("descripcion"));

				Restaurante res = new Restaurante();
				res.setNombre(rs.getString("nombre"));
				res.setImagen(rs.getString("imagen"));
				res.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());
				res.setFechaModificacion(rs.getTimestamp("fechaModificacion") != null
						? rs.getTimestamp("fechaModificacion").toLocalDateTime()
						: null);
				res.setSlogan(rs.getString("slogan"));
				res.setEstatus(rs.getBoolean("estatus"));

				res.setTipoRestaurante(tipoRestaurante);
				
				restaurantes.add(res);
			}

		}
		return restaurantes;
	}

	@Override
	public Restaurante consultar(int idRestaurnate) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
