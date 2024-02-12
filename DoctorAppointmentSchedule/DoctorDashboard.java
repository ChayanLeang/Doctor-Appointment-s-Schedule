package DoctorAppointmentSchedule;

import java.util.List;
import java.util.Scanner;
import DoctorAppointmentSchedule.Model.Doctor;
import DoctorAppointmentSchedule.Services.AppointmentService;
import DoctorAppointmentSchedule.Services.DoctorService;

public class DoctorDashboard {
	
	private DoctorService doctorService;
	private AppointmentService appointmentService;
	private AvailabilityManagement availabilityMangement;
	public DoctorDashboard(DoctorService doctorService,AppointmentService appointmentService,AvailabilityManagement availabilityMangement) {
		this.doctorService=doctorService;
		this.appointmentService=appointmentService;
		this.availabilityMangement=availabilityMangement;
	}
	
	public void accessDoctorDashboard(OutputOptionAndSelected outputOptionAndSelected,Scanner input,int doctorId) {
		String exit="Y";
		do {
			outputOptionAndSelected.outputOption(List.of("\n1.Doctor Profile","2.Appointment","3.Availability Management","4.Exit\n"));
			switch(outputOptionAndSelected.selectChoice()) {
				case "1":{
					System.out.println("\n              ID                   Name                   Position                   PhoneNumber                   WorkTIme");
					Doctor dr=doctorService.getDoctorById(doctorId);
					System.out.printf("              %-20d %-22s %-26s %-29s %s\n",dr.getId(),dr.getFullName(),dr.getPosition(),dr.getPhoneNumber(),dr.getWorkTime());
					break;
				}
				case "2":{
					System.out.println("\n               ID               PatientName               PhoneNumber               Appointment_Date                 IsCancel");
					for(var at : appointmentService.getDoctorAppointment(doctorId)) {
						System.out.printf("               %-16d %-25s %-25s %-32s %s\n",at.getId(),at.getPatientName(),at.getPatientPhoneNumber(),at.getDate(),at.getIsCancel());
					}
					
					break;
				}
				case "3":{
					availabilityMangement.accessAvailabilityManagement(outputOptionAndSelected, doctorService, input, doctorId);
					break;
				}
				case "4":{
					exit="N";
					break;
				}
			}
		}while(exit=="Y");
	}
}
