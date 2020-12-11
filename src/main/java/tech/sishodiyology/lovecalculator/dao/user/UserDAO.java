package tech.sishodiyology.lovecalculator.dao.user;

import java.util.List;

import tech.sishodiyology.lovecalculator.model.User;

public interface UserDAO {
	
	public void saveUser(User user);
	public void deleteUser(int id);
	public void updateUser(User user);
	public User getUserById(int id);
	public List<User> getAllUser();
	
}
