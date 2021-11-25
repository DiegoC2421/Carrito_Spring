package pe.edu.upc.trabajo.business.crud;

import pe.edu.upc.trabajo.models.entities.User;

public interface UserService {
	User findByUsername(String username);
}
