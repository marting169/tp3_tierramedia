package persistencia.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import persistencia.commons.ConnectionProvider;
import persistencia.commons.GenericDAO;
import persistencia.commons.MissingDataException;


public class ItinerarioPromocionDAOimpl implements GenericDAO<Integer>{

	public int insert(Integer id_promocion, Integer id_usuario) {
		try {
			Connection connection = ConnectionProvider.getConnection();
			String sql = "INSERT INTO itinerario_promocion (id_promocion,id_usuario) VALUES (?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id_promocion);
			statement.setInt(2, id_usuario);

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}

	@Override
	public Integer find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Integer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Integer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
