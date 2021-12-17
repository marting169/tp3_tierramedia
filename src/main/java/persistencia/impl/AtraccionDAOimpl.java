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
			Connection conn = ConnectionProvider.getConnection();
			String sql = "SELECT * FROM atraccion";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();


			List<Atraccion> attractions = new LinkedList<Atraccion>();
			while (resultados.next()) {
				attractions.add(toAtraccion(resultados));
			}

			return attractions;
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
			String sql = "SELECT * FROM atraccion WHERE id = ?";
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
	public int delete(Atraccion atraccion) {
		try {
			String sql = "DELETE FROM ATRACCION WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, atraccion.getId());
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
	public int insert(Atraccion atraccion)  {
		try {
			String sql = "INSERT INTO ATRACCION (NOMBRE, COSTO, TIEMPO, CUPO) VALUES (?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, atraccion.getNombre());
			statement.setDouble(i++, atraccion.getCosto());
			statement.setDouble(i++, atraccion.getTiempo());
			statement.setInt(i++, atraccion.getCupo());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
