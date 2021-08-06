package com.carlos.restaurantesdata.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	private static Connection connection;

	/**
	 * Statement objeto encargado de habilirat y ejecutar la sentencias SQL
	 */
	private static Statement statement;

	public static Connection conectar() throws ClassNotFoundException, SQLException {
		// cargar el driver de conexion
		Class.forName("com.mysql.cj.jdbc.Driver");

		// establecer los datos de conexion
		String url = "jdbc:mysql://localhost:3306/restaurante?serverTimezone=UTC";
		String user = "root";
		String password = "12345";

		// establecer la conexion
		connection = DriverManager.getConnection(url, user, password);
		statement = connection.createStatement();// habilita el proseso para ejecutar sentnecias sql

		return connection;
	}

	/**
	 * permite ejecutar sentencias INSERT, UPDATE, DELETE
	 * 
	 * @param sql
	 * @return 1 exitoso 0 error
	 * @throws SQLException excepcion generada en caso de dar error
	 */

	public static int ejecutarSql(String sql) throws SQLException {
		System.out.println("Query: " + sql);
		return statement.executeUpdate(sql);
	}
	
	/**
	 * ejecuta sentencias SELECT
	 * @param sql
	 * @return un resultset con toda la informacion de la tabla proveniente de la setnecia sql
	 * @throws SQLException excepcion generada en caso de dar error
	 */
	
	public static ResultSet ejecutarSQLSelect(String sql) throws SQLException {
		System.out.println("Query: " + sql);
		
		return statement.executeQuery(sql);
		
	}
}
