import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Receiver_info {

	String receiverName;
	String receiverBloodGroup;
	String birthDate;
	char gender;
	float weight;
	String organ;
	String addr;
	long contactNum;
	int emergency;
	boolean correct;
	Scanner sc=new Scanner(System.in);
	Area user_r ;
	String hosp_name;
	int hosp_code;
	boolean valid_w = false;
	boolean valid_age = false;
	General_info g = new General_info();
	void AcceptInfo()
	{
		boolean correct = false;
		while(!correct) {
			try {
				System.out.println("Enter your Name :");
				receiverName=sc.nextLine();
				if(receiverName.isEmpty()) {
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
					receiverBloodGroup = "A+";
					break;
				case 2:
					receiverBloodGroup = "A-";
					break;
				case 3:
					receiverBloodGroup = "B+";
					break;
				case 4:
					receiverBloodGroup = "AB+";
					break;
				case 5:
					receiverBloodGroup = "B-";
					break;
				case 6:
					receiverBloodGroup = "O+";
					break;
				case 7:
					receiverBloodGroup = "AB-";
					break;
				case 8:
					receiverBloodGroup = "O-";
					break;
				default:
					throw new User_exception("Please Enter valid Blood Group");
				}

				
				
					correct = true;
				

			} catch (User_exception e1) {
				System.out.println(e1.getMessage());
				correct = false;
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
					//System.out.println(gender=='F');
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
					weight=sc.nextFloat();
					if(weight<0)
					{
						throw new User_exception("You are Under Weight");
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
						g.establish_connection();
						g.extract_allhospital();
						System.out.println("Enter Hospital name where you are registered:");
						int i =0;
						for(i=0;i<g.all_hospitals.size();i++) {
							System.out.println((i+1)+". "+g.all_hospitals.get(i).getHospitalName());
						}
						//System.out.println("Enter Hospital name where you are registered:\n1.Kothrud\n2.Katraj\n3.Hadapsar\n4.Kondhwa\n5.Swargate");
						int ch = sc.nextInt();
						if(ch>0 && ch<=i) {
							correct = true;
							hosp_name = g.all_hospitals.get(ch-1).getHospitalName();
							hosp_code = g.all_hospitals.get(ch-1).getHospitalCode();
						}
						else
						{
							throw new User_exception("Enter valid option");
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

				try {
					System.out.println("Emergency (1 to 10):");
					emergency=sc.nextInt();
					if(emergency>10 || emergency<1)
					{
						throw new User_exception("Please Enter valid Emergency bit");
					}

				}catch(User_exception e8)
				{
					System.out.println(e8.getMessage());
				}

				/*
				 *public Receiver(String receiverName, String receiverBloodGroup, String birthDate, char gender, double weight,
			String hosp, long contactNum, int emergency) {
				 */
				
				Receiver user=new Receiver(receiverName, receiverBloodGroup, birthDate, gender, weight, hosp_name, contactNum,emergency,organ);
				g.insert_into_receiever(user, hosp_code);
				System.out.println("Thank you for registering!");
			}
		}

		if (!valid_age || !valid_w) {
			System.out.println("Sorry you are not elligible ");
		}
	}
	/*private String ReceiverName; 2
	private String ReceiverBloodGroup; 3
	private String birthDate; 4
	private char gender; 5
	private float weight; 6
	private Area areaOfReceiver; 8
	private long contactNum; 9
	private int Emergency;12
	private boolean approvedReceiver; 10
	private String Organ;7
	private String enrolled_hosp; 11*/
	
	/*public Receiver(String receiverName, String receiverBloodGroup, String birthDate, char gender, float weight,
			String hosp, long contactNum, int emergency,String Org) {*/
	
	public static void showData(Receiver r) {
		System.out.println("-----------------------------RECEIVER DETAILS-----------------------------------");
		System.out.println("Name            ::  "+r.getReceiverName());
		System.out.println("Hospital        ::  "+r.gethospitalName());
		System.out.println("Blood group     ::  "+r.getReceiverBloodGroup());
		System.out.println("Contact Number  ::  "+r.getContactNum());
		System.out.println("Allotted status ::  "+r.getAllotmentStatus());
		System.out.println("Donor Name      ::  "+r.getDonarAlloted());
		//add only donor name 
	}
	public Receiver  Login(String name,long mobno) {
		General_info g=new General_info();
		Connection con=g.establish_connection();
		Receiver r=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from Receiver where receiverName=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				if(rs.getLong(9)==mobno) {
					Area a=new Area(rs.getString(8),1);
					r=new Receiver();
					r.setReceiverName(rs.getString("receiverName"));
					r.setAllotmentStatus(rs.getString("allotmentStatus"));
					r.setDonarAlloted(rs.getString("donorAlloted"));
					r.sethospitalcode(rs.getInt("hospital_reg"));
					r.setReceiverBloodGroup(rs.getString("receiverBloodGroup"));
					r.setContactNum(rs.getLong("mobileNo"));
					
					break;
				}
			}
			if(r!=null) {
				PreparedStatement ps1=con.prepareStatement("select hospitalName from Hospital where hospitalCode =?");
				ps1.setInt(1,r.gethospitalcode() );
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next()) {
					r.sethospital(rs1.getString("hospitalName"));
				}
				showData(r);
			}
			if(r==null) {
				System.out.println("Enter Correct Login credentials");
			}
		}
		catch(Exception e) {
			System.out.println("Exception "+e);
		}
		return r;
	}
    public static void main(String[] args) {
		
		Receiver_info di = new Receiver_info();
		di.AcceptInfo();
	}
}

