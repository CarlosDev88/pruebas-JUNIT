/**
 * 
 */
package com.carlos.restaurantesdata.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.carlos.restauranteentities.entity.Empleado;
import com.carlos.restauranteentities.entity.Rol;
import com.carlos.restaurantesdata.connection.ConnectionFactory;
import com.carlos.restaurantesdata.dao.EmpleadoDAO;

/**
 * @author Carlos
 * clase que implementa la funcionalidad de CRUD empleados
 *
 */
public class EmpleadoDAOimpl implements EmpleadoDAO {
	
	static {
		try {
			ConnectionFactory.conectar();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public int guardar(Empleado empleado) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizar(Empleado empleado) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(int idEmpleado) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Empleado> consultar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado consultar(int idEmpleado) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Metodo que permite consultar un empleaod desde el login con su informacion y perfil en el sistema
	 * @param usuario parametro capturado del usuario desde el formulario de login en la vista login.xhtml
	 * @param password parametro capturado del usuario desde el formulario de login en la vista login.xhtml
	 * @param esSuperAdminGeneral verifica si el usuario es super admin general
	 * @return regresa el objeto de tipo empleado con el empleado logeado
	 * @throws SQLException excepcion en caso de error al ejecutar la sentencia SQL
	 */

	public Empleado consultarPorUsuarioYPassword(String usuario, String password, boolean esSuperAdminGeneral)
			throws SQLException {

		Empleado empleado = null;
		String sql = "";

		if (esSuperAdminGeneral) {
			sql = "select e.*, r.nombre as nombreRol from empleado e, rol r where e.idRol = r.idRol and (e.usuario = '"
					+ usuario + "' or e.email='" + usuario + "') and e.password='" + password
					+ "' and e.idSucursal is null;";
		} else {
			// agregar el codigo para usuario administardor sucursal y empleado
		}

		ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);
		
		if(rs !=null) {
			if(rs.next()) {
				empleado = new Empleado();
				empleado.setIdEmpleado(rs.getInt("idEmpleado"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setPrimerApellido(rs.getString("primerApellido"));
				empleado.setSegundoApellido(rs.getString("segundoApellido"));
				empleado.setUsuario(rs.getString("usuario"));
				empleado.setPassword(rs.getString("password"));
				empleado.setEmail(rs.getString("email"));
				empleado.setEstatus(rs.getBoolean("estatus"));
				empleado.setSuperAdmin(rs.getBoolean("superadmin"));
				empleado.setSuperAdminGeneral(rs.getBoolean("superadmingeneral"));
				
				Rol rol = new Rol();
				rol.setIdRol(rs.getInt("idRol"));
				rol.setNombre(rs.getString("nombreRol"));
				empleado.setRol(rol);
				
				//añadir funcionalodad para el caso de administardor de sucursal y empleado
				
				if(!empleado.isSuperAdminGeneral()) {
					
				}
				
			}
		}

		return empleado;

	}

}
