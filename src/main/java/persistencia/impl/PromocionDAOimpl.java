package persistencia.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.PromocionAXB;
import model.PromocionAbsoluta;
import model.PromocionPorcentual;
import persistencia.PromocionDAO;
import persistencia.commons.ConnectionProvider;
import persistencia.commons.MissingDataException;
import servicios.AtraccionService;

public class PromocionDAOimpl implements  PromocionDAO{
	private AtraccionService atraccionService;
	public List<Promocion> findAll() {
		
		try {
			Connection connection = ConnectionProvider.getConnection();
			String sql = "select * FROM promocion";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			ArrayList<Promocion> todos = new ArrayList<Promocion>();
			while (result.next()) {
				todos.add(toPromocion(result));
			}
			return todos;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}

	private Promocion toPromocion(ResultSet result) {
		
		try {
			double costo = 0;
			double tiempo = 0;
			this.atraccionService = new AtraccionService();
			List<Atraccion> atraccionesDisponibles = atraccionService.list();
			ArrayList<Atraccion> atraccionesEnPromocion = new ArrayList<Atraccion>();
			List<Integer> ides = findIdAtraccionByIdPromocion(result.getInt("id"));
			
			for (int i = 0; i < ides.size(); i++) {
				for (Atraccion atraccion : atraccionesDisponibles) {
					if(atraccion.getId()==ides.get(i)) {
						atraccionesEnPromocion.add(atraccion);
						costo += atraccion.getCosto();
						tiempo += atraccion.getTiempo();
						break;
					}
				}
			}
			if (result.getString("tipo").equals("ABSOLUTO")) {
				return new PromocionAbsoluta(result.getInt("id") ,result.getString("nombre"), costo, tiempo, atraccionesEnPromocion,
						result.getDouble("descuento"));
			} else if (result.getString("tipo").equals("PORCENTUAL")) {
				return new PromocionPorcentual(result.getInt("id") ,result.getString("nombre"), costo, tiempo, atraccionesEnPromocion,
						result.getDouble("descuento"));
			} else {
				return new PromocionAXB(result.getInt("id") ,result.getString("nombre"), costo, tiempo, atraccionesEnPromocion);
			}
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}

	public List<Integer> findIdAtraccionByIdPromocion(int i) {
		try {
			Connection connection = ConnectionProvider.getConnection();
			String sql = "SELECT id_atraccion FROM promocion_atraccion WHERE ?=promocion_atraccion.id_promocion ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, i);
			ResultSet result = statement.executeQuery();
			List<Integer> atracciones = new ArrayList<Integer>();
			while (result.next()) {
				atracciones.add(result.getInt("id_atraccion"));
			}
			return atracciones;
		} 
		catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Promocion find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Promocion promocion) {
		try {
			String sql = "INSERT INTO PROMOCIONES (NOMBRE, TIPO, DESCUENTO) VALUES (?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			int i = 1;
			statement.setString(i++, promocion.getNombre());
			statement.setString(i++, tipo);
			statement.setDouble(i++, promocion.getConDescuento());
			int rows = statement.executeUpdate();
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
			         int idGenerado = generatedKeys.getInt(1);
			}
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
