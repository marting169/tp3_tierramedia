package servicios;

import model.Usuario;
import model.nullObject.NullUser;

import java.sql.SQLException;

import dao.DAOFactory;
import dao.UsuarioDAO;

public class LoginService {

	public Usuario login(String username, String password) throws SQLException {
		UsuarioDAO userDao = DAOFactory.getUserDAO();
    	Usuario user = userDao.findByUsername(username);
    	
    	if (user.isNull() || !user.checkPassword(password)) {
    		user = NullUser.build();
    	}
    	return user;

	}

}