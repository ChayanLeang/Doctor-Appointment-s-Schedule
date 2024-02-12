package DoctorAppointmentSchedule.Model;

import java.math.BigDecimal;

public class Report {
	
	private int reportId;
	private int patientId;
	private int doctorId;;
	private String date;
	private BigDecimal paid;
	
	public Report(int reportId,int patientId,int doctorId,String date,BigDecimal paid) {
		this.reportId=reportId;
		this.patientId=patientId;
		this.doctorId=doctorId;
		this.date=date;
		this.paid=paid;
	}
	
	public int getReportId() {
		return reportId;
	}
	
	public int getPatientId() {
		return patientId;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	
	public String getDate() {
		return date;
	}
	public BigDecimal getPaid() {
		return paid;
	}
}
