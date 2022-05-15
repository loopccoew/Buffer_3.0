import java.util.Scanner;


//Main class
public class DashBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
		System.out.println("\n----------WELCOME TO ORGAN TRANSPLANT CENTER----------");
		System.out.println("1-Register as a donor");
		System.out.println("2-Register as a receiver");
		System.out.println("3-Login as a receiver");
		int ch=sc.nextInt();
		switch(ch){
			case 1:
				//take input info
				//insert donor into db
				//show nearest hospitals
				Donor_info d1 = new Donor_info();
				d1.AcceptInfo();
				
				break;
			case 2:
				// Menu 1.See status
				Receiver_info r1 = new Receiver_info();
				r1.AcceptInfo();
				
				break;
			case 3:
				System.out.println("\nEnter your name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter Your Mobile No.:");
				long mob = sc.nextLong();
				Receiver_info r = new Receiver_info();
				r.Login(name, mob);
				//display data of receiver
				break;
			default:
				exit = true;
				break;
				
		}
		}
		

	}
}