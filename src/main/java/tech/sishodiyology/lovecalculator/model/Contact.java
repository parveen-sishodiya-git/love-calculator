package tech.sishodiyology.lovecalculator.model;

public class Contact {

	private String email;
	private Phone phone;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	

	@Override
	public String toString() {
		return "ContactDTO [email=" + email + ", phone=" + phone + "]";
	}
	
}
