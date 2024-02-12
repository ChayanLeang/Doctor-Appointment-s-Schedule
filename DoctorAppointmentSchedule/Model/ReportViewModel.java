package DoctorAppointmentSchedule.Model;

import java.math.BigDecimal;

public class ReportViewModel {
	
	private int reportId;
	private String patientName;
	private String doctorName;
	private String docotorPos;
	private String date;
	private BigDecimal paid;
	
	public ReportViewModel(int reportId,String patientName,String doctorName,String doctorPos,String date,BigDecimal paid) {
		this.reportId=reportId;
		this.patientName=patientName;
		this.doctorName=doctorName;
		this.docotorPos=doctorPos;
		this.date=date;
		this.paid=paid;
	}
	
	public int getReportId() {
		return reportId;
	}
	
	public String getPatientName() {
		return patientName;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	public String getDoctorPos() {
		return docotorPos;
	}
	public String getDate() {
		return date;
	}
	public BigDecimal getPaid() {
		return paid;
	}
}
