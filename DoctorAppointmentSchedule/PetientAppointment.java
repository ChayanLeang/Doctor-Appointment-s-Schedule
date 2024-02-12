package DoctorAppointmentSchedule;

import java.util.List;
import java.util.Scanner;

import DoctorAppointmentSchedule.Services.DoctorService;
import DoctorAppointmentSchedule.Model.Appointment;
import DoctorAppointmentSchedule.Services.AppointmentService;

public class PetientAppointment {
	
	private DoctorService doctorService;
	private AppointmentService appointmentService;
	
	public PetientAppointment(DoctorService doctorService,AppointmentService appointmentService) {
		this.doctorService=doctorService;
		this.appointmentService=appointmentService;
	}
	
	public void accessPatientAppointmentDashboard(OutputOptionAndSelected outputOptionAndSelected,Scanner input,int patientId) {
		String exit="N";
		do {
			outputOptionAndSelected.outputOption(List.of("\n1.Appointment Booking","2.Appointment History","3.Exit\n"));
			switch(outputOptionAndSelected.selectChoice()) {
				case "1":{
					System.out.println("\n              ID                   Name                   Position                   PhoneNumber                   WorkTIme");
					for(var dr : doctorService.getDoctors()) {
						System.out.printf("              %-20d %-22s %-26s %-29s %s\n",dr.getId(),dr.getFullName(),dr.getPosition(),dr.getPhoneNumber(),dr.getWorkTime());
					}
					
					System.out.print("\nEnter The DoctorId which that you want to make an appointment with : ");
					int doctorId=input.nextInt();
					System.out.println("Choose Appointment Date");
					System.out.println("\n              ID               Availability Appointment's Date");
					for(var de : doctorService.getAvailabilities(doctorId)) {
						System.out.printf("              %-17d%s\n",de.getId(),de.getDate());
					}
					System.out.print("Enter Appointment Date Id : ");
					input.nextLine();
					int apId=input.nextInt();
					
					appointmentService.appoinmentBooking(new Appointment(appointmentService.getNumberOfAppointments()+1,doctorId,patientId,doctorService.getAvailabilityById(doctorId, apId).getDate(),false));
					break;
				}
				case "2":{
					System.out.println("\n               ID               DoctorName               PhoneNumber               Appointment_Date               IsCancel");
					for(var at : appointmentService.getPatientAppointmentHistory(patientId)) {
						System.out.printf("               %-16d %-24s %-25s %-31s %s\n",at.getId(),at.getDoctorName(),at.getDoctorPhoneNumber(),at.getDate(),at.getIsCancel());
					}
					
					System.out.print("Do you want to cancel appointment ? (Y/N) : ");
					String res=input.next();
					if(res.equals("Y") || res.equals("y")) {
						System.out.print("Enter AppointmentId that you want ot cancel : ");
						int apId=input.nextInt();
						appointmentService.cancelAppointment(apId);
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
