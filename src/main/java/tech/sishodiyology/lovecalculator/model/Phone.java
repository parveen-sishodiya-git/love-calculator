package tech.sishodiyology.lovecalculator.model;

public class Phone {

	private String countryCode="91";
	private String phoneNumber="9700393007";
	
	@Override
	public String toString() {
		return countryCode + "-" + phoneNumber;
	}

	public Phone() {}
	
	public Phone(String countryCode, String phoneNumber) {
		super();
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
