package tech.sishodiyology.lovecalculator.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.sishodiyology.lovecalculator.dao.login.LoginDAO;
import tech.sishodiyology.lovecalculator.model.Login;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO loginDAO;

	@Override
	public boolean isValidUser(Login login) {
		Login login1 = null;
		try {
			login1 = loginDAO.getLoginByUsername(login.getUsername());
		} catch (Exception e) {
			// There could be an query syntax exception
			e.printStackTrace();
		}
		if (login1 == null) {
			System.out.println("Login(null) not found");
			return false;
		} else if (login.getPassword().equals(login1.getPassword())) {
			System.out.println("Login Passed");
			return true;
		}
		System.out.println("Incorrect Password");
		System.out.println("Passwords: ");
		System.out.println("Typed: " + login.getPassword());
		System.out.println("DB: " + login1.getPassword());
		return false;
	}

}
