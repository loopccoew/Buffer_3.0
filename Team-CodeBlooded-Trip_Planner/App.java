package trip;
import java.util.*;

public class App {
	Scanner scn = new Scanner(System.in);
	int n = 26;
	Graph g = new Graph(n);
	int c = 0;

	User user = null;
	User u = null;

	//SIGNUP METHOD
	void signup() {
		System.out.println("\n\t\t\t\t\t\t-*-*-Signup Window-*-*-");
		System.out.print("\t\t\t\t\t\t Enter name: ");
		String name = scn.nextLine();
		System.out.println();
		System.out.print("\t\t\t\t\t\t Enter mail_id: ");
		String id = scn.nextLine();
		System.out.println();
		System.out.print("\t\t\t\t\t\t Enter password: ");
		String password = scn.nextLine();
		System.out.println();
		u = new User(name,id,password);
		c++;
	}

	//LOGIN WINDOW
	public void login() {
		System.out.println("\n\t\t\t\t\t\t-*-*-Login Window-*-*-");
		System.out.print("\t\t\t\t\t\t Enter name: ");
		String user_name = scn.nextLine();
		System.out.println();
		System.out.print("\t\t\t\t\t\t Enter mail_id: ");
		String mail_id = scn.nextLine();
		System.out.println();
		System.out.print("\t\t\t\t\t\t Enter password: ");
		String password = scn.nextLine();
		user = new User(user_name,mail_id,password);
	}

	//LOGOUT METHOD
	public void logout() { 
		user = null;
		System.out.println("\t\t\t\t\t\t Loggedout successfully");
		System.out.print("\t\t\t\t\t\t Do you want to login again?  Enter yes/no");
		String choice = scn.nextLine();
		System.out.println();
		if (choice.equalsIgnoreCase("yes")) {
			login();
		} else {
			return;
		}
	}
}