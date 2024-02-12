package DoctorAppointmentSchedule.Model;

public class Appointment {
	
	private int id;
	
	private int doctorId;
	
	private int patientId;
	
	private String date;
	
	private boolean isCancel;
	
	public Appointment(int id,int doctorId,int patientId,String date,boolean isCancel) {
		this.id=id;
		this.doctorId=doctorId;
		this.patientId=patientId;
		this.date=date;
		this.isCancel=isCancel;
	}
	
	public int getId() {
		return id;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	
	public int getPatientId() {
		return patientId;
	}
	
	public String getDate() {
		return date;
	}
	
	public boolean getIsCancel() {
		return isCancel;
	}
	
	public void setIsCancel(boolean isCancel) {
		this.isCancel=isCancel;
	}
}
