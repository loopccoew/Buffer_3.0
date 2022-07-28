import java.sql.Connection;
import java.util.*;
class User_exception extends Exception{
	public User_exception(String s)
	{
		super(s);
	}
}
public class Donor_info {


	String donarName;
	String donarBloodGroup;
	String birthDate;
	char gender;
	double weight;
	String organ;
	String addr;
	long contactNum;
	Scanner sc=new Scanner(System.in);
	Area user_a ;
	Donor d;
	boolean valid_w = false;
	boolean valid_age = false;
	void AcceptInfo()
	{
		System.out.println("\n----------DONOR DETAILS-----------");
	    boolean correct = false;
	    while(!correct) {
	    	try {
				System.out.println("\nEnter your name :");
				donarName=sc.nextLine();
				if(donarName.isEmpty()) {
					throw new User_exception("Please enter valid name");
				}
				else {
					correct = true;
				}

			} catch (User_exception e) {
				System.out.println(e.getMessage());
			}
	    }
		correct = false;
		while(!correct) {
			 try {
					System.out.println("Enter Blood Group :\n1.A+\n2.A-\n3.B+\n4.AB+\n5.B-\n6.O+\n7.AB-\n8.O-");
					int ch = sc.nextInt();
					switch(ch) {
					case 1:
						donarBloodGroup = "A+";
						break;
					case 2:
						donarBloodGroup = "A-";
						break;
					case 3:
						donarBloodGroup = "B+";
						break;
					case 4:
						donarBloodGroup = "AB+";
						break;
					case 5:
						donarBloodGroup = "B-";
						break;
					case 6:
						donarBloodGroup = "O+";
						break;
					case 7:
						donarBloodGroup = "AB-";
						break;
					case 8:
						donarBloodGroup = "O-";
						break;
					}
					
					if(donarBloodGroup.isEmpty())
					{
						throw new User_exception("Please Enter valid Blood Group");
					}
					else {
						correct = true;
					}

				} catch (User_exception e1) {
					System.out.println(e1.getMessage());
				}
		 }
		correct = false;
		while(!correct) {
			try {
				System.out.println("Enter Birth  year :");
				birthDate=sc.next();
				int date=Integer.parseInt(birthDate);
				if(2022-date<18)
				{
					valid_age = false;
					break;
				}
				else if (2022-date<0) {
					throw new User_exception("Enter valid age ");
				}
				else {
					valid_age = true;
					correct = true;
				}
			} catch (User_exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		if (valid_age) {
			correct = false;
			while(!correct) {
				try {
					System.out.println("Enter Gender (M) or (F) :");
					gender=sc.next().charAt(0);
					
					if(gender == 'F' || gender=='M')
					{
						correct = true;
						
					}
					else {
						
						throw new User_exception("Enter valid Gender");
					}
				} catch (User_exception e3) {
					System.out.println(e3.getMessage());
				}
			}
			
			
			correct = false;
			while(!correct) {
				try {
					System.out.println("Enter Weight :");
					weight=sc.nextDouble();
					if(weight<0)
					{
						throw new User_exception("You are Under Weight, Not eligible to donate");
					}
					else if(weight<50 || weight>100) {
						break;
					}
					else {
						valid_w = true;
						correct = true;
					}
				} catch (User_exception e4) {
					System.out.println(e4.getMessage());
				}
			}
			
			if(valid_w) {
				correct = false;
				while(!correct) {
					try {
						System.out.println("Enter organ :\n1.Kidney\n2.Liver");
						int ch = sc.nextInt();
						switch(ch) {
						case 1:
							organ = "Kidney";
							break;
						case 2:
							organ = "Liver";
							break;
						
						}
						if(organ.isEmpty())
						{
							throw new User_exception("Please enter a valid option.");
						}
						else {
							correct = true;
						}
					} catch (User_exception e5) {
						System.out.println(e5.getMessage());
					}
				}
				
				correct = false;
				while(!correct) {
					try {
						System.out.println("Enter Area:\n1.Kothrud\n2.Katraj\n3.Hadapsar\n4.Kondhwa\n5.Swargate");
						
						int ch = sc.nextInt();
						switch(ch) {
						case 1:
							user_a = new Area("Kothrud",104);
							break;
						case 2:
							user_a = new Area("Katraj",101);
							break;
						
						case 3:
							user_a = new Area("Hadapsar",102);
							break;
						case 4:
							user_a = new Area("Kondhwa",103);
							break;
						case 5:
							user_a = new Area("Swargate",105);
							break;
						}
						if(user_a==null)
						{
							throw new User_exception("Enter valid option");
						}
						else {
							correct = true;
						}
					} catch (User_exception e6) {
						System.out.println(e6.getMessage());
					}
				}
				
				correct = false;
				while(!correct) {
					try {
						System.out.println("Enter Contact number :");
						contactNum=sc.nextLong();
						if(Long.toString(contactNum).length()<10 || Long.toString(contactNum).length()>10 )
						{
							throw new User_exception("Please enter correct phone no.");
						}
						else {
							correct = true;
						}
					} catch (User_exception e7) {
						System.out.println(e7.getMessage());
					}
				}
				
				/*
				 * Donor(String donorName, String donorBloodGroup, String birthDate, char gender, double weight, String org,
					Area areaOfDonor, long contactNo)
				 */
				d = new Donor(donarName, donarBloodGroup ,birthDate,gender, weight,organ,user_a,contactNum);
				d.area_hospitals(d);
				
				Matching(d);
				
			}
		}
		
		if (!valid_age || !valid_w) {
			System.out.println("Sorry you are not elligible for organ donation");
		}
		

	}
	 public void Matching(Donor d) {
		 General_info g = new General_info();
		 g.establish_connection();
		 boolean flag = false;
		 
		 for(int i=0;i<d.areawise_hospitals.size();i++) {
			 Hospital h = d.areawise_hospitals.get(i);
			 g.arraylist_receivers(h);
			 //System.out.println("h name"+h.getHospitalName());
			 Iterator value =  h.addToQueue().iterator();
			 while(!d.areawise_hospitals.get(i).pq.isEmpty()) {
				 Receiver r = d.areawise_hospitals.get(i).pq.poll();
				 //System.out.println("Receiver"+r.getReceiverName());
				 if(r.getReceiverBloodGroup().equals(d.getDonorBloodGroup()) && r.getorganName().equals(d.getorgan()) && r.getAllotmentStatus().equals("not alloted")) {
					 System.out.println("\n###Receiver Found!###");
					 System.out.println("Hospital              ::"+h.getHospitalName());
					 System.out.println("Donor                 :: "+ d.getDonorName());
					 System.out.println("Matched with Receiver :: "+r.getReceiverName() );
					 r.setAllotmentStatus("alloted");
					 r.setDonarAlloted(d.getDonorName());
					 g.updateReceiver(r);
					 flag = true;
					 break;
				 }
				 else {
					 
					 continue;
				 }
			 }
			 /*while(value.hasNext()) {
				 Receiver r = ((Receiver) value.next());
				 System.out.println(r.getReceiverName());
				 System.out.println("Blood grp :"+(r.getReceiverBloodGroup()));
				 System.out.println("Organ :"+r.getorganName());
				 if(r.getReceiverBloodGroup().equals(d.getDonorBloodGroup()) && r.getorganName().equals(d.getorgan())) {
					 System.out.println("Matched");
					 System.out.println("Donor :: "+ d.getDonorName());
					 System.out.println("Receiver :: "+r.getReceiverName() );
					 flag = true;
					 break;
				 }
				 else {
					 d.areawise_hospitals.get(i).pq.poll();
				 }
			 }*/
			 if(flag) {
				 break;
			 }
		 }
		 if (flag==false) {
			 g.extract_allhospital();

			 for(int i=0;i<g.all_hospitals.size();i++) {
				 
				 Hospital h = g.all_hospitals.get(i);
				 g.arraylist_receivers(h);
				 //System.out.println("Hospital name :"+h.getHospitalName());
				 h.addToQueue();
				 //Iterator value =  h.addToQueue().iterator();
				 while(!g.all_hospitals.get(i).pq.isEmpty()) {
					 Receiver r = g.all_hospitals.get(i).pq.poll();
					 //System.out.println("Receiver"+r.getReceiverName());
					 if(r.getReceiverBloodGroup().equals(d.getDonorBloodGroup()) && r.getorganName().equals(d.getorgan())&& r.getAllotmentStatus().equals("not alloted")) {
						 System.out.println("\n*****Receiver Found!*****");
						 System.out.println("Hospital:"+h.getHospitalName());
						 System.out.println("Donor :: "+ d.getDonorName());
						 System.out.println("Matched with Receiver :: "+r.getReceiverName() );
						 r.setAllotmentStatus("alloted");
						 r.setDonarAlloted(d.getDonorName());
						 g.updateReceiver(r);
						 flag = true;
						 break;
					 }
					 else {
						 continue;
					 }
				 }
				 if(flag) {
					 break;
				 }
			 }
			 if (flag==false) {
				 System.out.println("Sorry! No matched receiver found!");
			 }
		 }
	 }
   
	public static void main(String[] args) {
		
		Donor_info di = new Donor_info();
		di.AcceptInfo();
		//System.out.println(di.d.getDonorName());
		//System.out.println(di.d.getAreaOfDonor());
	}

}
