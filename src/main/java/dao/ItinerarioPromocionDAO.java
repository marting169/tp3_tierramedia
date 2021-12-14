package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ConnectionProvider;

public class ItinerarioPromocionDAO implements GenericDAO<Integer>{

	public int insert(Integer id_promocion, Integer id_usuario) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO itinerario_promocion (id_promocion,id_usuario) VALUES (?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id_promocion);
		statement.setInt(2, id_usuario);

		int rows = statement.executeUpdate();
		return rows;
	}

	@Override
	public ArrayList<Integer> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Integer t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Integer t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
