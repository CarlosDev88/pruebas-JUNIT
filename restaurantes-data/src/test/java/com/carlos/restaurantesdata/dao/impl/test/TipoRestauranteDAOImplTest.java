/**
 * 
 */
package com.carlos.restaurantesdata.dao.impl.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.carlos.restauranteentities.entity.TipoRestaurante;
import com.carlos.restauranteentities.entity.*;
import com.carlos.restaurantesdata.dao.impl.*;
/**
 * @author Usuario
 *
 */
class TipoRestauranteDAOImplTest {

	@Test
	void testGuardarExitoso() {
		RestauranteDAOImpl restauranteDAOimpl = new RestauranteDAOImpl();
		TipoRestaurante tipoRestaurante = new TipoRestaurante();
		tipoRestaurante.setIdTipoRestaurante(20);

		Menu menu = new Menu();
		menu.setIdMenu(4);

		Restaurante res = new Restaurante();
		res.setNombre("Restaurante Hiroshima");
		res.setImagen("hiroshimares.png");
		res.setFechaCreacion(LocalDateTime.now());
		res.setEstatus(true);
		res.setTipoRestaurante(tipoRestaurante);
		res.setMenu(menu);

		int guardado = 0;
		try {
			// primer caso: exito si guardado > 0
			guardado = restauranteDAOimpl.guardar(res);

			assertTrue(guardado > 0);
			System.out.println("se guardo de manera exitosa");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testGuradarErrorEnSql() {

		RestauranteDAOImpl restauranteDAOimpl = new RestauranteDAOImpl();
		TipoRestaurante tipoRestaurante = new TipoRestaurante();
		tipoRestaurante.setIdTipoRestaurante(20);

		Menu menu = new Menu();
		menu.setIdMenu(4);

		Restaurante res = new Restaurante();
		res.setNombre("Restaurante Hiroshima");
		res.setImagen("hiroshimares.png");
		res.setFechaCreacion(LocalDateTime.now());
		res.setEstatus(true);
		res.setTipoRestaurante(tipoRestaurante);
		res.setMenu(menu);

		int guardado = 0;
		try {
			guardado = restauranteDAOimpl.guardar(res);

		} catch (SQLException e) {
			// segundo caso: si no se guardo el restaurante por un erro en la sentencia sql
			assertTrue(guardado == 0);
			System.err.println("No se guardo");

			e.printStackTrace();
		}

	}

	@Test
	void tetstActualizarExitoso() {

		RestauranteDAOImpl restauranteDAOimpl = new RestauranteDAOImpl();
		TipoRestaurante tipoRestaurante = new TipoRestaurante();
		tipoRestaurante.setIdTipoRestaurante(20);

		Menu menu = new Menu();
		menu.setIdMenu(4);

		Restaurante res = new Restaurante();
		res.setNombre("Restaurante tokyo");
		res.setIdRestaurante(16);
		res.setImagen("tokyoRes.png");
		res.setFechaModificacion(LocalDateTime.now());
		res.setEstatus(true);
		res.setTipoRestaurante(tipoRestaurante);
		res.setMenu(menu);

		assertTrue(res.getTipoRestaurante().getIdTipoRestaurante() == 20);

		assertTrue(res.getMenu().getIdMenu() == 4);

		int actualizar = 0;
		try {
			actualizar = restauranteDAOimpl.actualizar(res);
			assertTrue(actualizar > 0);
			System.out.println("Se actualizo el restaturante");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testEliminraRestaurante() {
		int idRestaurnate = 15;
		RestauranteDAOImpl restauranteDAOimpl = new RestauranteDAOImpl();
		int eliminado = 0;
		try {
			eliminado = restauranteDAOimpl.eliminar(idRestaurnate);
			assertTrue(eliminado > 0);
			System.out.println("restaurante con id " + idRestaurnate + " eliminado exitoso");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Test
	void testConsultarExitoso() {
		RestauranteDAOImpl restauranteDAOimpl = new RestauranteDAOImpl();
		List<Restaurante> restaurantesConsultados;

		try {
			restaurantesConsultados = restauranteDAOimpl.consultar();

			assertTrue(restaurantesConsultados.size() > 0);

			for (Restaurante restaurante : restaurantesConsultados) {
				System.out.println(restaurante.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
