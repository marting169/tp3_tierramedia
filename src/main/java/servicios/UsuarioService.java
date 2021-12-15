package servicios;

import java.util.List;

import model.Usuario;
import persistencia.UsuarioDAO;
import persistencia.commons.DAOFactory;


public class UsuarioService {

	public List<Usuario> list() {
		return DAOFactory.getUsuarioDAO().findAll();
	}

	public Usuario create(String nombre, double presupuesto, double tiempo_disponible, String username, String password, Boolean admin) {
		Usuario user = new Usuario(-1, nombre, presupuesto, tiempo_disponible, username, password, false);
		user.setPassword(password);

		if (user.esValido()) {
			DAOFactory.getUsuarioDAO().insert(user);
		}

		return user;
	}
	
	public Usuario update(Integer id, String nombre, double presupuesto, double tiempo_disponible, String username, String password, Boolean admin) {

		UsuarioDAO userDAO = DAOFactory.getUsuarioDAO();
		Usuario user = userDAO.find(id);

		user.setId(id);
		user.setNombre(nombre);
		user.setPresupuesto(presupuesto);
		user.setTiempo_disponible(tiempo_disponible);
		user.setUsername(username);
		user.setPassword(password);
		user.setAdmin(admin);

		if (user.esValido()) {
			userDAO.update(user);
		}

		return user;
	}

	public void delete(int id) {
		Usuario user = new Usuario(id, null, null, null, null, null, null);

		UsuarioDAO userDAO = DAOFactory.getUsuarioDAO();
		userDAO.delete(user);
	}

	public Usuario find(Integer id) {
		return DAOFactory.getUsuarioDAO().find(id);
	}

}