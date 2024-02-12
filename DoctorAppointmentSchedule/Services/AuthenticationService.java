package DoctorAppointmentSchedule.Services;

import java.util.Scanner;

import DoctorAppointmentSchedule.AdminDashboard;
import DoctorAppointmentSchedule.AdminManagement;
import DoctorAppointmentSchedule.AvailabilityManagement;
import DoctorAppointmentSchedule.DoctorDashboard;
import DoctorAppointmentSchedule.DoctorMangement;
import DoctorAppointmentSchedule.OutputOptionAndSelected;
import DoctorAppointmentSchedule.PatientDashboard;
import DoctorAppointmentSchedule.PatientManagement;
import DoctorAppointmentSchedule.ReportManagement;
import DoctorAppointmentSchedule.Model.Patient;

public class AuthenticationService {
	private AdminService adminSerivce;
	private PatientService patientService;
	private DoctorService doctorService;
	private ReportService reportService;
	private PatientDashboard patientDashboard;
	private DoctorDashboard doctorDashboard;
	private AppointmentService appointmentService;
	private AvailabilityManagement availabilityMangement;
	private DoctorMangement doctorMangement;
	private PatientManagement patientManagement;
	private AdminDashboard adminDashboard;
	private AdminManagement adminManagement;
	private ReportManagement reportManagement;
	public AuthenticationService() {
		adminSerivce=new AdminService();
		patientService = new PatientService();
		doctorService=new DoctorService();
		reportService=new ReportService(patientService,doctorService);
		availabilityMangement=new AvailabilityManagement();
		doctorMangement=new DoctorMangement();
		patientManagement=new PatientManagement();
		adminManagement=new AdminManagement();
		reportManagement=new ReportManagement();
		appointmentService=new AppointmentService(patientService,doctorService);
		patientDashboard = new PatientDashboard(patientService,doctorService,patientManagement,appointmentService);
		doctorDashboard = new DoctorDashboard(doctorService,appointmentService,availabilityMangement);
		adminDashboard=new AdminDashboard(reportService,patientService,doctorService,adminSerivce,doctorMangement,adminManagement,reportManagement);
		
	}
	
	public void SignIn(OutputOptionAndSelected outputOptionAndSelected,Scanner input,String pos) {
		input.nextLine();
		System.out.print("Enter FullName : ");
		String fullName=input.nextLine();
		System.out.print("Enter Password : ");
		String password=input.nextLine();
		if(pos=="Patient") {
			int patientId=patientService.getPatientByNameAndPassword(fullName,password).getId();
			patientDashboard.accessPatientDashboard(outputOptionAndSelected, input,patientId);
		}
		if(pos=="Doctor") {
			int doctorId= doctorService.getDoctorByNameAndPassword(fullName,password).getId();
			doctorDashboard.accessDoctorDashboard(outputOptionAndSelected, input, doctorId);
		}
		if(pos=="Admin") {
			int adminId=adminSerivce.getAdminByNameAndPassword(fullName, password).getId();
			adminDashboard.accessAdminDashboard(outputOptionAndSelected, input, adminId);
		}
	}
	
	public void SignUp(OutputOptionAndSelected outputOptionAndSelected,Scanner input) {
		input.nextLine();
		System.out.print("Enter FullName : ");
		String fullName=input.nextLine();
		System.out.print("Enter Password : ");
		String password=input.nextLine();
		System.out.print("Enter PhoneNumber : ");
		String phoneNumber=input.nextLine();
		patientService.addPatient(new Patient(patientService.getNumberOfPatients()+1,fullName,password,phoneNumber));
		patientDashboard.accessPatientDashboard(outputOptionAndSelected, input,patientService.getNumberOfPatients());
	}
}
