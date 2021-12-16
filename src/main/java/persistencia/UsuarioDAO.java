package persistencia;

import model.Usuario;
import persistencia.commons.GenericDAO;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	public abstract Usuario findByUsername(String username);
}
