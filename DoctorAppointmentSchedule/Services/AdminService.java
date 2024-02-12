package DoctorAppointmentSchedule.Services;

import java.util.ArrayList;
import java.util.List;

import DoctorAppointmentSchedule.Model.Admin;

public class AdminService {
	
	private List<Admin> admins;
	
	public AdminService() {
		admins=new ArrayList<>();
		admins.add(new Admin(1,"Yuki Aoi","yuki111","087344211"));
	}
	
	public Admin getAdminById(int adminId) {
		return admins.stream().filter(an->an.getId()==adminId).findFirst().get();
	}
	
	public Admin getAdminByNameAndPassword(String fullName,String password) {
		return admins.stream().filter(an->an.getFullName().equals(fullName) && an.getPassword().equals(password)).findFirst().get(); 
	}
	
	public void updateAdmin(int adminId,Admin admin) {
		var currentAdmin = getAdminById(adminId);
		currentAdmin.setFullName(admin.getFullName());
		currentAdmin.setPhoneNumber(admin.getPhoneNumber());
		admins.set(admins.indexOf(currentAdmin), currentAdmin);
	}
}
