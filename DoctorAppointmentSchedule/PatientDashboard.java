package DoctorAppointmentSchedule;

import java.util.List;
import java.util.Scanner;
import DoctorAppointmentSchedule.Services.AppointmentService;
import DoctorAppointmentSchedule.Services.DoctorService;
import DoctorAppointmentSchedule.Services.PatientService;

public class PatientDashboard {
	
	private PetientAppointment patientAppointment;
	private PatientService patientService;
	private PatientManagement patientManagement;
	public PatientDashboard(PatientService patientService,DoctorService doctorService,PatientManagement patientManagement,AppointmentService appointmentService) {
		this.patientService=patientService;
		this.patientManagement=patientManagement;
		patientAppointment=new PetientAppointment(doctorService,appointmentService);
	}
	
	public void accessPatientDashboard(OutputOptionAndSelected outputOptionAndSelected,Scanner input,int patientId) {
		String exit="N";
		do {
			outputOptionAndSelected.outputOption(List.of("\n1.Patient Management","2.Appointment","3.Exit\n"));
			switch(outputOptionAndSelected.selectChoice()) {
				case "1":{
					patientManagement.accesssPatientManagement(outputOptionAndSelected, patientService, input, patientId);
					break;
				}
				case "2":{
					patientAppointment.accessPatientAppointmentDashboard(outputOptionAndSelected, input, patientId);
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
