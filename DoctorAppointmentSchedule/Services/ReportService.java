package DoctorAppointmentSchedule.Services;

import java.util.ArrayList;
import java.util.List;
import DoctorAppointmentSchedule.Model.Report;
import DoctorAppointmentSchedule.Model.ReportViewModel;

public class ReportService {
	
	private PatientService patientService;
	private DoctorService doctorService;
	private List<Report> reports;
	
	public ReportService(PatientService patientService,DoctorService doctorService) {
		reports=new ArrayList<>();
		this.patientService=patientService;
		this.doctorService=doctorService;
	}
	
	public void addReport(Report report) {
		reports.add(report);
	}
	
	public List<ReportViewModel> getReport() {
		return reports.stream().map(rt->new ReportViewModel(rt.getReportId(),patientService.getPatientById(rt.getPatientId()).getFullName(),
				            		doctorService.getDoctorById(rt.getDoctorId()).getFullName(),doctorService.getDoctorById(rt.getDoctorId())
				            		.getPosition(),rt.getDate(),rt.getPaid())).toList();
	}
	
	public int getNumberOfReports() {
		return reports.size();
	}
}
