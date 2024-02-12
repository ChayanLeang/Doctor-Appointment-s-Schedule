package DoctorAppointmentSchedule;

import java.util.List;
import java.util.Scanner;

import DoctorAppointmentSchedule.Model.Availability;
import DoctorAppointmentSchedule.Services.DoctorService;

public class AvailabilityManagement {
	
	public void accessAvailabilityManagement(OutputOptionAndSelected outputOptionAndSelected,DoctorService doctorService,Scanner input,int doctorId) {
		String exit="N";
		do {
			outputOptionAndSelected.outputOption(List.of("\n1.Add Availability","2.View Availability","3.Exit\n"));
			switch(outputOptionAndSelected.selectChoice()) {
				case "1":{
					String res;
					do {
						input.nextLine();
						System.out.print("Enter Date : ");
						String date=input.nextLine();
						doctorService.addAvailability(new Availability(doctorService.getNumberOfAvailabilitiesByDoctorId(doctorId)+1,doctorId,date));
						System.out.print("Continue? (Y/N) : ");
						res=input.nextLine();
						System.out.println(res);
					}while(res.equals("y") || res.equals("Y"));
					break;
				}
				case "2":{
					System.out.println("\n              ID               Availability Appointment's Date");
					for(var de : doctorService.getAvailabilities(doctorId)) {
						System.out.printf("              %-17d%s\n",de.getId(),de.getDate());
					}
					
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
