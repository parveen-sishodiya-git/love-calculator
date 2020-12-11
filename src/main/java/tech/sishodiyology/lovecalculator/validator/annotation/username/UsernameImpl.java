package tech.sishodiyology.lovecalculator.validator.annotation.username;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameImpl implements ConstraintValidator<Username, String>{

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		boolean result = isUserNameValid(username); 
		System.out.println("Returning "+result);
		return result;
	}

	private boolean isUserNameValid(String username) {
		System.out.println("validating username");
		String usernameRegex = "^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$";
		Pattern pattern = Pattern.compile(usernameRegex);
		Matcher match = pattern.matcher(username);
		if(match.find()) {
			return true;
		}
		return false;
	}

}
