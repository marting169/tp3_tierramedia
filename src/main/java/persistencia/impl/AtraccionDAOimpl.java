package persistencia.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import persistencia.AtraccionDAO;
import persistencia.commons.ConnectionProvider;
import persistencia.commons.MissingDataException;

public class AtraccionDAOimpl implements AtraccionDAO {

	public List<Atraccion> findAll() {
		try {
			String sql = "select * FROM atraccion";
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			List<Atraccion> todos = new LinkedList<Atraccion>();
			while (result.next()) {
				todos.add(toAtraccion(result));
				
			}
			return todos;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Atraccion toAtraccion(ResultSet result) throws SQLException {
		return new Atraccion(result.getInt(1), result.getString(2), result.getDouble(3),
				result.getDouble(4), result.getInt(5));
	}

	public ArrayList<Atraccion> findByIdPromocion(String id_prom) {
		try {
			Connection connection = ConnectionProvider.getConnection();
			String sql = "SELECT DISTINCT atraccion.* FROM promocion_atraccion JOIN atraccion ON promocion_atraccion.id_atraccion=atraccion.id WHERE ?=promocion_atraccion.id_promocion ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id_prom);

			ResultSet result = statement.executeQuery();
			ArrayList<Atraccion> todos = new ArrayList<Atraccion>();
			while (result.next()) {
				todos.add(toAtraccion(result));
			}
			return todos;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	public Atraccion find(Integer id) {
		try {
			String sql = "SELECT * FROM ATTRACTIONS WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			Atraccion attraction = null;
			if (resultados.next()) {
				attraction = toAtraccion(resultados);
			}

			return attraction;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Atraccion atraccion) {
		try {
			Connection connection = ConnectionProvider.getConnection();
			String sql = "UPDATE atraccion SET costo=?, tiempo=?, cupo=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, atraccion.getCosto());
			statement.setDouble(2, atraccion.getTiempo());
			statement.setDouble(3, atraccion.getCupo());
			statement.setInt(4, atraccion.getId());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	public int restaurar(int cupo, int id) {

		try {
			Connection connection = ConnectionProvider.getConnection();
			String sql = "UPDATE atraccion SET cupo=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, cupo);
			statement.setDouble(2, id);
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Atraccion attraction) {
		try {
			String sql = "DELETE FROM ATTRACTIONS WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, attraction.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);

		}

	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Atraccion t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
