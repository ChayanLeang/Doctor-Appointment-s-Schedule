package DoctorAppointmentSchedule;

import java.util.List;
import java.util.Scanner;
import DoctorAppointmentSchedule.Services.AuthenticationService;

public class Main {
	
	private static Scanner input=new Scanner(System.in);
	private static AuthenticationService authService=new AuthenticationService();
	private static OutputOptionAndSelected outputOptionAndSelected=new OutputOptionAndSelected();
	
	public static void main(String[] args) {
		String exit="N";
		do {
			System.out.println("Select position");
			outputOptionAndSelected.outputOption(List.of("\n1.Patient","2.Doctor","3.Admin","4.Exit\n"));
			switch(outputOptionAndSelected.selectChoice()) {
				case "1":{
					System.out.print("Do you have an account yet?(Y/N) : ");
					String res=input.next();
					if(res.equals("y") || res.equals("Y")) {
						authService.SignIn(outputOptionAndSelected,input,"Patient");
					}else {
						authService.SignUp(outputOptionAndSelected,input);
					}
					break;
				}
				case "2":{
					authService.SignIn(outputOptionAndSelected,input,"Doctor");
					break;
				}
				case "3":{
					authService.SignIn(outputOptionAndSelected, input, "Admin");
					break;
				}
				case "4":{
					exit="Y";
					break;
				}
			}
		}while(exit=="N");
	}
}
