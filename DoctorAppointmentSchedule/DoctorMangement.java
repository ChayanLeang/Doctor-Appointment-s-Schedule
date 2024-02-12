package DoctorAppointmentSchedule;

import java.util.List;
import java.util.Scanner;

import DoctorAppointmentSchedule.Model.Doctor;
import DoctorAppointmentSchedule.Services.DoctorService;

public class DoctorMangement {
	
	public void accessDoctorManagement(OutputOptionAndSelected outputOptionAndSelected,DoctorService doctorService,Scanner input) {
		String exit="N";
		do {
			outputOptionAndSelected.outputOption(List.of("\n1.View Doctors","2.Add New Doctor","3.Update Doctor","4.Delete Doctor","5.Exit\n"));
			switch(outputOptionAndSelected.selectChoice()) {
				case "1":{
					System.out.println("\n              ID                   Name                   Position                   PhoneNumber                   WorkTIme");
					for(var dr : doctorService.getDoctors()) {
						System.out.printf("              %-20d %-22s %-26s %-29s %s\n",dr.getId(),dr.getFullName(),dr.getPosition(),dr.getPhoneNumber(),dr.getWorkTime());
					}
					
					break;
				}
				case "2":{
					input.nextLine();
					System.out.print("Enter FullName : ");
					String name=input.nextLine();
					System.out.print("Enter Password : ");
					String pass=input.nextLine();
					System.out.print("Enter Position : ");
					String pos=input.nextLine();
					System.out.print("Enter PhoneNumber : ");
					String phone=input.nextLine();
					System.out.print("Enter WorkTime : ");
					String time=input.nextLine();
					doctorService.addDoctor(new Doctor(doctorService.getNumberOfDoctor()+1,name,pass,pos,phone,time));
					break;
				}
				case "3":{
					input.nextLine();
					System.out.print("Enter Doctor Id that you want to update : ");
					int doctorId=input.nextInt();
					input.nextLine();
					System.out.print("Enter FullName : ");
					String name=input.nextLine();
					input.nextLine();
					System.out.print("Enter Position : ");
					String pos=input.nextLine();
					input.nextLine();
					System.out.print("Enter PhoneNumber : ");
					String phone=input.nextLine();
					input.nextLine();
					System.out.print("Enter WorkTime : ");
					String time=input.nextLine();
					doctorService.updateDoctor(doctorId, new Doctor(doctorId,name,"",pos,phone,time));
					break;
				}
				case "4":{
					input.nextLine();
					System.out.print("Enter Doctor Id that you want to update : ");
					int doctorId=input.nextInt();
					doctorService.deleteDoctor(doctorId);
					break;
				}
				case "5":{
					exit="Y";
					break;
				}
			}
		}while(exit=="N");
	}
}
