package DoctorAppointmentSchedule;

import java.util.List;
import java.util.Scanner;

import DoctorAppointmentSchedule.Services.AdminService;
import DoctorAppointmentSchedule.Services.DoctorService;
import DoctorAppointmentSchedule.Services.PatientService;
import DoctorAppointmentSchedule.Services.ReportService;

public class AdminDashboard {
	
	private DoctorService doctorService;
	private PatientService patientService;
	private ReportService reportService;
	private DoctorMangement doctorManagement;
	private AdminManagement adminManagement;
	private ReportManagement reportManagement;
	private AdminService adminService;
	public AdminDashboard(ReportService reportService,PatientService patientService,DoctorService doctorService,AdminService adminService,DoctorMangement doctorManagement,
					      AdminManagement adminManagement,ReportManagement reportManagement) {
		this.doctorService=doctorService;
		this.reportService=reportService;
		this.adminService=adminService;
		this.patientService=patientService;
		this.doctorManagement=doctorManagement;
		this.adminManagement=adminManagement;
		this.reportManagement=reportManagement;
	}
	
	public void accessAdminDashboard(OutputOptionAndSelected outputOptionAndSelected,Scanner input,int adminId) {
		String exit="N";
		do {
			outputOptionAndSelected.outputOption(List.of("\n1.Admin Management","2.Doctor Management","3.Report Management","4.Exit\n"));
			switch(outputOptionAndSelected.selectChoice()) {
				case "1":{
					adminManagement.accessAdminManagement(outputOptionAndSelected, adminService, input, adminId);
					break;
				}
				case "2":{
					doctorManagement.accessDoctorManagement(outputOptionAndSelected, doctorService, input);
					break;
				}
				case "3":{
					reportManagement.accessReportManagement(outputOptionAndSelected,patientService,doctorService ,reportService, input, adminId);
					break;
				}
				case "4":{
					exit="Y";
					break;
				}
			}
		}while(exit=="N");
	}
}
