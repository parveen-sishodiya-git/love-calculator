package tech.sishodiyology.lovecalculator.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import tech.sishodiyology.lovecalculator.model.Phone;

public class PhoneFormatter implements Formatter<Phone>{

	@Override
	public String print(Phone phone, Locale locale) {
		// TODO Auto-generated method stub
		System.out.println("printing phone formatter");
		return phone.getCountryCode()+"-"+phone.getPhoneNumber();
	}

	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {
		System.out.println("Parsing phone");
		String[] phoneArray = completePhoneNumber.split("-");
		return new Phone(phoneArray[0],phoneArray[1]);
	}

}
