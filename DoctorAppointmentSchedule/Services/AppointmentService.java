package DoctorAppointmentSchedule.Services;

import java.util.ArrayList;
import java.util.List;
import DoctorAppointmentSchedule.Model.Appointment;
import DoctorAppointmentSchedule.Model.AppointmentHistory;

public class AppointmentService {
	
	private PatientService patientService;
	private DoctorService doctorService;
	private List<Appointment> appointments;
	
	public AppointmentService(PatientService patientService,DoctorService doctorService) {
		appointments=new ArrayList<>();
		this.patientService=patientService;
		this.doctorService=doctorService;
	}
	
	public void appoinmentBooking(Appointment appointment) {
		appointments.add(appointment);
	}
	
	public List<AppointmentHistory> getPatientAppointmentHistory(int patientId){
		return appointments.stream().filter(at->at.getPatientId()==patientId).map(at->new AppointmentHistory(at.getId(),patientService
					  	   .getPatientById(patientId).getFullName(),"",doctorService.getDoctorById(at.getDoctorId()).getFullName(),doctorService
					  	   .getDoctorById(at.getDoctorId()).getPhoneNumber(),at.getDate(),at.getIsCancel())).toList();
	}
	
	public List<AppointmentHistory> getDoctorAppointment(int doctorId){
		return appointments.stream().filter(at->at.getDoctorId()==doctorId).map(at->new AppointmentHistory(at.getId(),patientService
						   .getPatientById(at.getPatientId()).getFullName(),patientService.getPatientById(at.getPatientId()).getPhoneNumber()
						   ,"","",at.getDate(),at.getIsCancel())).toList();
	}
	
	public void cancelAppointment(int id) {
		Appointment appointment = appointments.stream().filter(at->at.getId()==id).findFirst().get();
		appointment.setIsCancel(true);
		appointments.set(appointments.indexOf(appointment), appointment);
	}
	
	public int getNumberOfAppointments() {
		return appointments.size();
	}
}
