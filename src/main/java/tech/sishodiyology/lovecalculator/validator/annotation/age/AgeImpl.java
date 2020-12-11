package tech.sishodiyology.lovecalculator.validator.annotation.age;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeImpl implements ConstraintValidator<Age, Integer>{

	private int min;
	private int max;
	
	@Override
	public void initialize(Age age) {
		// TODO Auto-generated method stub
		this.min=age.min();
		this.max=age.max();
	}
	
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
			
		if(age == null || age < min || age > max) {
			return false;
		}
		return true;
	}

}
