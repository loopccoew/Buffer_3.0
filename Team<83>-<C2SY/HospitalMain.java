package loop;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HospitalMain {

	static PatientList plist = new PatientList();
	static DoctorList dlist = new DoctorList();

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		String choice;
		while (true) {
			MainMenu();
			choice = sc.nextLine();
			if (choice.equals("1")) {
				System.out.println("\nDoctor Id ");
				String Id = sc.nextLine();
				System.out.println("\nDoctor Name ");
				String name = sc.nextLine();
				System.out.println("\nDoctor Speciality ");
				String spec = sc.nextLine();
				System.out.println("\nDoctor fees ");
				int fees = sc.nextInt();
				sc.nextLine();
				Doctor d = new Doctor(Id, name, spec, fees);
				dlist.Insert(d);

			} else if (choice.equals("2")) {
				System.out.println("\nPatient Id");
				String Id = sc.nextLine();
				System.out.println("\nPatient Name");
				String Name = sc.nextLine();
				System.out.println("\nPatient Age");
				String Age = sc.nextLine();
				System.out.println("\nPatient Contact number");
				String ContNo = sc.nextLine();
				System.out.println("\nPatient Blood group");
				String BloodGrp = sc.nextLine();

				Patient patient = new Patient(Id, Name, Age, ContNo, BloodGrp);
				plist.Insert(patient);

			} else if (choice.equals("3")) {

				dlist.PrintData();

			} else if (choice.equals("4")) {

				plist.PrintData();

			} else if (choice.equals("5")) {
				System.out.println("\n");
				System.out.println("   ______________________________________________ ");
				System.out.println("  |             WELCOME TO CHECKUP LIST          | ");
				System.out.println("  |______________________________________________|  ");
				CheckUpList[] clist = new CheckUpList[dlist.Size()];

				for (int i = 0; i < clist.length; i++) {
					clist[i] = new CheckUpList();
					Doctor doctor = dlist.getAtIndex(i);
					System.out.println("\nEnter Patient for Doctor");
					System.out.println("\nName : " + doctor.getName());
					System.out.println("\nSpeciality :" + doctor.getSpeciality());
					System.out.println("\nFees : " + doctor.getFees());
					System.out.println("\nAll Patient : ");
					plist.PrintData();
					while (true) {
						System.out.println("Enter patient Id or type null to stop");
						String Id = sc.nextLine();
						if (Id.equals("null")) {
							break;
						}

						System.out.println("priority 3 for emergency , 2 for intermidiate , any other key for normal");
						String per = sc.nextLine();
						int p = 1;
						if (per.equals("3")) {
							p = 3;
						} else if (per.equals("2")) {
							p = 2;
						}

						Patient patient = plist.searchById(Id);
						if (patient == null) {
							System.out.println("\n Invalid Patient ID:\n");
						} else {
							Checkup cup = new Checkup(doctor, patient, p, "",
									"" + java.util.Calendar.getInstance().getTime().toString());
							clist[i].Enqueue(cup);
						}
					}

				}

				for (int i = 0; i < clist.length; i++) {
					System.out
							.println("\n\n Patient" + (i + 1) + "In Queue for doctor " + dlist.getAtIndex(i).getName());


				}

			}
			else if(choice.equals("6"))
			{
				System.out.println("Enter Speciality Which you want to search");
				String speciality =sc.next();
				
				dlist.searchBySpeciality(speciality);
				
				
			}
			else if(choice.equals("7"))
			{
				System.out.println("Enter Name of patient to search");
				String name =sc.next();
				
				plist.searchByName(name);
				
				
			}

			else if (choice.equals("0")) {
				break;
			} 
		}
	}

	public static void MainMenu() {
		System.out.println("\n");
		System.out.println("  *************************************************** ");
		System.out.println("  *            Hospital Manegment System            * ");
		System.out.println("  *                     Main Menu                   * ");
		System.out.println("  *************************************************** ");
		System.out.println("Enter 1 for  insert new  doctor");
		System.out.println("Enter 2 for  insert  patient");
		System.out.println("Enter 3 for print all doctor ");
		System.out.println("Enter 4 for print all patient");
		System.out.println("Enter 5 for CheckUp Menu");
		System.out.println("nEnter 6 for Search doctor by Speciality ");
		System.out.println("nEnter 7 for Search patient by name ");
		System.out.println("Enter 0 for exit ");
	}

}