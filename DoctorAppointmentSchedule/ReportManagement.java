package DoctorAppointmentSchedule;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import DoctorAppointmentSchedule.Model.Report;
import DoctorAppointmentSchedule.Services.DoctorService;
import DoctorAppointmentSchedule.Services.PatientService;
import DoctorAppointmentSchedule.Services.ReportService;

public class ReportManagement {
	
	public void accessReportManagement(OutputOptionAndSelected outputOptionAndSelected,PatientService patientService,DoctorService doctorService,
									   ReportService reportService,Scanner input,int adminId) {
		String exit="N";
		do {
			outputOptionAndSelected.outputOption(List.of("\n1.Pay Bill","2.View Report","3.Exit\n"));
			switch(outputOptionAndSelected.selectChoice()) {
				case "1":{
					input.nextLine();
					System.out.println("Select Patient");
					System.out.println("\n                   ID                   Name                   PhoneNumber");
					for(var pt : patientService.getPatients()) {
						System.out.printf("                   %-20d %-22s %s\n",pt.getId(),pt.getFullName(),pt.getPhoneNumber());
					}
					System.out.print("Enter PatientId : ");
					int patienId=input.nextInt();
					System.out.println("\nSelect Doctor");
					System.out.println("\n              ID                   Name                   Position                   PhoneNumber                   WorkTIme");
					for(var dr : doctorService.getDoctors()) {
						System.out.printf("              %-20d %-22s %-26s %-29s %s\n",dr.getId(),dr.getFullName(),dr.getPosition(),dr.getPhoneNumber(),dr.getWorkTime());
					}
					
					System.out.print("Enter DoctorId : ");
					int doctorId=input.nextInt();
					
					System.out.print("Enter Paid : ");
					BigDecimal paid=input.nextBigDecimal();
					
					input.nextLine();
					
					System.out.print("Enter Date : ");
					String date=input.nextLine();
					
					reportService.addReport(new Report(reportService.getNumberOfReports()+1,patienId,doctorId,date,paid));
					break;
				}
				case "2":{
					System.out.println("\n              ID                   PatientName                   DoctoName                   DoctorPos                   Date                          Paid");
					for(var rt : reportService.getReport()) {
						System.out.printf("              %-20d %-29s %-27s %-27s %-29s %s\n",rt.getReportId(),rt.getPatientName(),rt.getDoctorName(),rt.getDoctorPos(),rt.getDate(),rt.getPaid());
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
