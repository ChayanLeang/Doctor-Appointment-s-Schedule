package DoctorAppointmentSchedule;

import java.util.List;
import java.util.Scanner;

import DoctorAppointmentSchedule.Model.Admin;
import DoctorAppointmentSchedule.Services.AdminService;

public class AdminManagement {
	
	public void accessAdminManagement(OutputOptionAndSelected outputOptionAndSelected,AdminService adminService,Scanner input,int adminId) {
		String exit="N";
		do {
			outputOptionAndSelected.outputOption(List.of("\n1.View Admin Profile","2.Update Admin Profile","3.Exit\n"));
			switch(outputOptionAndSelected.selectChoice()) {
				case "1":{
					Admin an=adminService.getAdminById(adminId);
					System.out.println("\n                   ID                   Name                   PhoneNumber");
					System.out.printf("                   %-20d %-22s %s\n",an.getId(),an.getFullName(),an.getPhoneNumber());
					break;
				}
				case "2":{
					input.nextLine();
					System.out.print("Enter FullName : ");
					String name=input.nextLine();
					System.out.print("Enter PhoneNumber : ");
					String phone=input.nextLine();
					adminService.updateAdmin(adminId, new Admin(adminId,name,"",phone));
					break;
				}
				case "3":{
					exit="Y";
					break;
				}
			}
		}while(exit=="N");
	}
}
