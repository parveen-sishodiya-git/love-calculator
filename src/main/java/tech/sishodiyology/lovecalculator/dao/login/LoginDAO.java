package tech.sishodiyology.lovecalculator.dao.login;

import java.util.List;

import tech.sishodiyology.lovecalculator.model.Login;

public interface LoginDAO {

	void addLogin(Login login);
	void deleteLogin(int id);
	void updateLogin(Login login);
	Login getLoginById(int id);
	List<Login> getLogins();
	Login getLoginByUsername(String username);
	
}
