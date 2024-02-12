package DoctorAppointmentSchedule.Model;

public class Doctor extends Person{
	
	private String position;
	private String workTime;
	
	public Doctor(int id,String fullName,String password,String position,String phoneNumber,String workTime) {
		super(id,fullName,password,phoneNumber);
		this.position=position;
		this.workTime=workTime;
	}
	
	public String getPosition() {
		return position;
	}
	
	public String getWorkTime() {
		return workTime;
	}
	
	public void setPosition(String position) {
		this.position=position;
	}
	
	public void setWorkTime(String workTime) {
		this.workTime=workTime;
	}
}
