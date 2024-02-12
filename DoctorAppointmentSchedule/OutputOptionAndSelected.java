package DoctorAppointmentSchedule;

import java.util.List;
import java.util.Scanner;
 
public class OutputOptionAndSelected {
	
	public Scanner input=new Scanner(System.in);
	
	public void outputOption(List<String> option) {
		for(var op : option) {
			System.out.println(op);
		}
	}
	
	public String selectChoice() {
		System.out.print("Enter your choice : ");
		String choice = input.next();
		return choice;
	}
}
