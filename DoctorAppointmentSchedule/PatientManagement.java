package DoctorAppointmentSchedule;

import java.util.List;
import java.util.Scanner;

import DoctorAppointmentSchedule.Model.Patient;
import DoctorAppointmentSchedule.Services.PatientService;

public class PatientManagement {
	
	public void accesssPatientManagement(OutputOptionAndSelected outputOptionAndSelected,PatientService patientService,Scanner input,int patientId) {
		String exit="N";
		do {
			outputOptionAndSelected.outputOption(List.of("\n1.Patient Profile","2.Update Profile","3.Exit\n"));
			switch(outputOptionAndSelected.selectChoice()) {
				case "1":{
					Patient pt=patientService.getPatientById(patientId);
					System.out.println("\n                   ID                   Name                   PhoneNumber");
					System.out.printf("                   %-20d %-22s %s\n",pt.getId(),pt.getFullName(),pt.getPhoneNumber());
					break;
				}
				case "2":{
					input.nextLine();
					System.out.print("Enter FullName : ");
					String name=input.nextLine();
					System.out.print("Enter PhoneNumber : ");
					String phone=input.nextLine();
					patientService.updatePatient(patientId, new Patient(patientId,name,"",phone));
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
