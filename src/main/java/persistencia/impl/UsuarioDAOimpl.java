package persistencia.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import model.nullObject.NullUser;
import persistencia.UsuarioDAO;
import persistencia.commons.ConnectionProvider;
import persistencia.commons.MissingDataException;

public class UsuarioDAOimpl implements UsuarioDAO{

	public List<Usuario> findAll() {
		 
		try {
			Connection	connection = ConnectionProvider.getConnection();
			String sql = "select * FROM usuario";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			List<Usuario> todos = new ArrayList<Usuario>();
			while (result.next()) {
				todos.add(toUsuario(result));
			}
			return todos;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}

	private Usuario toUsuario(ResultSet result) throws SQLException {
		return new Usuario(result.getInt("id"), result.getString("nombre"), result.getDouble("dinero"),
				result.getDouble("tiempo"), result.getString("password"), result.getString("rol"));
	}

	public Usuario find(Integer id) {
		 
		try {
			Connection connection = ConnectionProvider.getConnection();
			String sql = "select * FROM usuario WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();
			Usuario user = NullUser.build();
			if (result.next()) {
				user = toUsuario(result);
			}
			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}
	
	public Usuario findByUsername(String username) {
			 
			try {
				String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, username);
				ResultSet resultados = statement.executeQuery();

				Usuario user = NullUser.build();

				if (resultados.next()) {
					user = toUsuario(resultados);
				}

				return user;
			} catch (Exception e) {
				throw new MissingDataException(e);
			}
			
		
	}

	public int delete(Usuario usuario)  {
		try {
			Connection connection = ConnectionProvider.getConnection();
			String sql = "DELETE FROM usuario WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, usuario.getId());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}

	public int insert(Usuario usuario) {
		 
		try {
			Connection connection = ConnectionProvider.getConnection();
			
			String sql = "INSERT INTO usuario (nombre,dinero,tiempo,password,admin) VALUES (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setDouble(2, usuario.getPresupuesto());
			statement.setDouble(3, usuario.getTiempo_disponible());
			statement.setString(4, usuario.getPassword());
			statement.setString(5, usuario.getRol());
			
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}

	public int update(Usuario usuario) {
		try {
			Connection connection = ConnectionProvider.getConnection();
			String sql = "UPDATE usuario SET nombre=?,dinero=?, tiempo=?, username=?, password=?, admin=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setDouble(2, usuario.getPresupuesto());
			statement.setDouble(3, usuario.getTiempo_disponible());
			statement.setString(4, usuario.getPassword());
			statement.setString(5, usuario.getRol());
			statement.setInt(4, usuario.getId());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}

	public int restaurar(Double dinero,Double tiempo,int id) {
		try {
			Connection connection = ConnectionProvider.getConnection();
			String sql = "UPDATE usuario SET dinero=?, tiempo=? WHERE id=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, dinero);
			statement.setDouble(2, tiempo);
			statement.setInt(3,id);
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

	


}
