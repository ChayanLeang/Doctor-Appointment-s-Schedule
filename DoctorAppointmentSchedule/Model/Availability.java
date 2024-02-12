package DoctorAppointmentSchedule.Model;

public class Availability {
	
	private int id;
	private int doctorId;
	private String date;
	
	public Availability(int id,int doctorId,String date) {
		this.id=id;
		this.doctorId=doctorId;
		this.date=date;
	}
	
	public int getId() {
		return id;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	
	public String getDate() {
		return date;
	}
}
