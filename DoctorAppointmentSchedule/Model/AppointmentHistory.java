package DoctorAppointmentSchedule.Model;

public class AppointmentHistory {
	
	private int id;
	private String patientName;
	private String patientPhoneNumber;
	private String doctorName;
	private String doctorPhoneNumber;
	private String date;
	private boolean isCancel;
	
	public AppointmentHistory(int id,String patientName,String patientPhoneNumber,String doctorName,String doctorPhoneNumber,String date,boolean isCancel) {
		this.id=id;
		this.patientPhoneNumber=patientPhoneNumber;
		this.patientName=patientName;
		this.doctorName=doctorName;
		this.doctorPhoneNumber=doctorPhoneNumber;
		this.date=date;
		this.isCancel=isCancel;
	}
	
	public int getId() {
		return id;
	}
	
	public String getPatientPhoneNumber() {
		return patientPhoneNumber;
	}
	
	public String getPatientName() {
		return patientName;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	
	public String getDoctorPhoneNumber() {
		return doctorPhoneNumber;
	}
	
	public String getDate() {
		return date;
	}
	
	public boolean getIsCancel() {
		return isCancel;
	}
}
