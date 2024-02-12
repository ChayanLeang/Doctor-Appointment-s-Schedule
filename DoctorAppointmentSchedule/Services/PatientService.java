package DoctorAppointmentSchedule.Services;

import java.util.ArrayList;
import java.util.List;

import DoctorAppointmentSchedule.Model.Patient;

public class PatientService {
	
	private List<Patient> patients;
	
	public PatientService() {
		patients=new ArrayList<>();
		patients.add(new Patient(1,"Kira","kira222","09872211"));
	}
	
	public void addPatient(Patient patient) {
		patients.add(patient);
	}
	
	public void updatePatient(int patientId,Patient patient) {
		Patient currentPatient=getPatientById(patientId);
		currentPatient.setFullName(patient.getFullName());
		currentPatient.setPhoneNumber(patient.getPhoneNumber());
		patients.set(patients.indexOf(currentPatient),currentPatient);
	}
	
	public List<Patient> getPatients() {
		return patients;
	}
	
	public Patient getPatientById(int id) {
		return patients.stream().filter(pt->pt.getId()==id).findFirst().get();
	}
	
	public Patient getPatientByNameAndPassword(String fullName,String password) {
		return patients.stream().filter(pt->pt.getPassword().equals(password) && pt.getFullName().equals(fullName)).findFirst().get();
	}
	
	public int getNumberOfPatients() {
		return patients.size();
	}
}
