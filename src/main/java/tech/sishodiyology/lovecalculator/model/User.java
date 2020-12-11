package tech.sishodiyology.lovecalculator.model;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import tech.sishodiyology.lovecalculator.validator.annotation.age.Age;

public class User {
	
	private Integer id;
	
	@NotEmpty(message="Name can not be blank")
	@Size(min=3,max=20,message="Minimum 3 and Maximum 20 Name should be of")	
	private String name = "Parveen Sishodiya";
	
	private String userName;
	private String password;
	
	@Age(min=5,max=10)
	private Integer age;
	
	private String country = "india";
	private String[] hobbies = {"talking"};
	private String gender = "female";
	
	
	private Contact contactDTO;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Contact getContactDTO() {
		return contactDTO;
	}
	public void setContactDTO(Contact contactDTO) {
		this.contactDTO = contactDTO;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", age=" + age + ", userName=" + userName + ", password="
				+ password + ", country=" + country + ", hobbies=" + Arrays.toString(hobbies) + ", gender=" + gender
				+ ", contactDTO=" + contactDTO + "]";
	}
	
}
