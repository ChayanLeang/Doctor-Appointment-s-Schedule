package DoctorAppointmentSchedule.Model;

public class Person {
	
	private int id;
	private String fullName;
	private String password;
	private String phoneNumber;
	
	public Person(int id,String fullName,String password,String phoneNumber) {
		this.id=id;
		this.fullName=fullName;
		this.password=password;
		this.phoneNumber=phoneNumber;
	}
	
	public int getId() {
		return id;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setFullName(String fullName) {
		this.fullName=fullName;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber=phoneNumber;
	}
}
