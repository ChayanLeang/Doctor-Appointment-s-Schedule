package DoctorAppointmentSchedule.Services;

import java.util.ArrayList;
import java.util.List;

import DoctorAppointmentSchedule.Model.Availability;
import DoctorAppointmentSchedule.Model.Doctor;

public class DoctorService {
	
	private List<Doctor> doctors;
	private List<Availability> availabilities;
	
	public DoctorService() {
		doctors=new ArrayList<>();
		availabilities=new ArrayList<>();
		doctors.add(new Doctor(1,"Aki Hasukawa","aki123","Dentist","097221223","Mon - Fri, 8:00 AM - 11:00 PM"));
		doctors.add(new Doctor(2,"Baki Hanma","baki344","Physical","098323444","Mon - Fri, 7:00 AM - 1:00 PM"));
	}
	
	public void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}
	
	public List<Doctor> getDoctors(){
		return doctors;
	}
	
	public Doctor getDoctorById(int id) {
		return doctors.stream().filter(dr->dr.getId()==id).findFirst().get();
	}
	
	public Doctor getDoctorByNameAndPassword(String fullName,String password) {
		return doctors.stream().filter(dr->dr.getPassword().equals(password) && dr.getFullName().equals(fullName)).findFirst().get();
	}
	
	public void updateDoctor(int id,Doctor doctor) {
		Doctor currentDoctor=getDoctorById(id);
		currentDoctor.setFullName(doctor.getFullName());
		currentDoctor.setPosition(doctor.getPosition());
		currentDoctor.setPhoneNumber(doctor.getPhoneNumber());
		currentDoctor.setWorkTime(doctor.getWorkTime());
		doctors.set(doctors.indexOf(currentDoctor), currentDoctor);
	}
	
	public void addAvailability(Availability availability) {
		availabilities.add(availability);
	}
	
	public List<Availability> getAvailabilities(int doctorId){
		return availabilities.stream().filter(ay->ay.getDoctorId()==doctorId).toList();
	}
	
	public Availability getAvailabilityById(int doctorId,int apId){
		return availabilities.stream().filter(ay->ay.getDoctorId()==doctorId && ay.getId()==apId).findFirst().get();
	}
	
	public void deleteDoctor(int id) {
		doctors.remove(doctors.indexOf(getDoctorById(id)));
	}
	
	public int getNumberOfDoctor() {
		return doctors.size();
	}
	
	public int getNumberOfAvailabilitiesByDoctorId(int doctorId) {
		return getAvailabilities(doctorId).size();
	}
}