
import java.util.*;
import java.sql.*;
class hospital_node{
	Hospital h;
	int dist;
	hospital_node next;
	int reference;
	hospital_node(int num,Hospital hosp){
		next =null;
		this.reference = num; // reference variable to get index of the node in the array
		this.h = hosp;
		this.dist =0;
	}
}
public class General_info{
	 Scanner sc = new Scanner(System.in);
	 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	 static final String DB_URL = "jdbc:mysql://localhost:3306/OrganDonation";
	 static final String USER = "root";
	 static final String PASS = "priyanka2240";
	 Connection con;
	 Set <Integer> hospitals = new HashSet<Integer>();
	 public ArrayList<Hospital> all_hospitals = new ArrayList<Hospital>();
	 
	 ArrayList<Integer> elligible_hospitals = new ArrayList<Integer>(); //list of hospital codes having at least one receiver
	 int[][] adjMat;
	 int n;
	 Hospital ref []; //Array to remember index numbers
	 ArrayList<hospital_node> head = new ArrayList<hospital_node>();

	 
	 public Connection establish_connection(){
		 try {
		   Class.forName(JDBC_DRIVER);
		   con=DriverManager.getConnection(DB_URL,USER,PASS);
		 }
		 catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		 catch(SQLException e) {
		     System.out.println("Not found");
		     e.printStackTrace();
		 }
		 return con;
	 }
	 public void insert_into_receiever(Receiver r, int hosp_code) {
		 try {
			PreparedStatement p;
			 String query = "insert into Receiver(receiverName,receiverBloodGroup, gender, weight, organName, mobileNo,hospital_reg,emergency)"+"values(?,?,?,?,?,?,?,?);";
			 p = con.prepareStatement(query);
		
			 p.setString(1, r.getReceiverName());
			 p.setString(2, r.getReceiverBloodGroup());
			 p.setString(3, Character.toString(r.getGender()));
			 p.setFloat(4, r.getWeight());
			 p.setString(5, r.getorganName());
			 p.setLong(6, r.getContactNum());
			 p.setInt(7, hosp_code);
			 p.setInt(8,r.getEmergency());			 
			 p.executeUpdate();
			 
			 
		} 
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public void updateReceiver(Receiver r) {
		 try {
			 this.establish_connection();
			PreparedStatement p;
			 String query = "update Receiver set allotmentStatus=?,donorAlloted=? where receiverName=?;";
			 p = con.prepareStatement(query);
			 p.setString(1, r.getAllotmentStatus());
			 p.setString(2, r.getDonarAlloted());
			 p.setString(3, r.getReceiverName());
			 p.executeUpdate();
			 
			 
		} 
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	
	 void extract_allhospital() {
		 try {
			 String query = "select * from Hospital";
			 PreparedStatement preparedStmt1;
			 preparedStmt1 = con.prepareStatement(query);
			 ResultSet rs = preparedStmt1.executeQuery(query);

			 while(rs.next()) {
				 int h_code = rs.getInt("hospitalCode");
				 String h_name = rs.getString("hospitalName");
				 int area_code = rs.getInt("areaCode");
				 int city_code = rs.getInt("cityCode");
				 Hospital h = new Hospital(h_code,h_name,area_code,city_code);
				 all_hospitals.add(h);
			 }

			
			 
		 }
		 catch(SQLException e) {
		     System.out.println("Not found");
		     e.printStackTrace();
		 }
	 }
	   
	   void area_hospitals(Donor d) { //pass donor area to this function
		   try {
				 /*String q = "select areaCode from Area where areaName = (?)";
				 PreparedStatement preparedStmt1;
				 preparedStmt1 = con.prepareStatement(q);
				 preparedStmt1.setString(1, d.getAreaOfDonor().getAreaName());
				 */
			     String query = "select * from Hospital where areaCode = ?";
			     PreparedStatement preparedStmt1;
				 preparedStmt1 = con.prepareStatement(query);
				 preparedStmt1.setInt(1, d.getAreaOfDonor().getAreaCode());
				 
				 ResultSet rs = preparedStmt1.executeQuery(query);

				 while(rs.next()) {
					 int h_code = rs.getInt("hospitalCode");
					 String h_name = rs.getString("hospitalName");
					 int area_code = rs.getInt("areaCode");
					 int city_code = rs.getInt("cityCode");
					 Hospital h = new Hospital(h_code,h_name,area_code,city_code);
					 d.areawise_hospitals.add(h);
				 }
				 
			 }
			 catch(SQLException e) {
			     System.out.println("Not found");
			     e.printStackTrace();
			 }
	   }
	   //for 
	   
	   void arraylist_receivers(Hospital h) {
		   try {
			   PreparedStatement preparedStmt1;
				String hosp_name = h.getHospitalName();
				int hosp_code = h.getHospitalCode();
				
				String query = "select * from Receiver where hospital_reg = ?";
				preparedStmt1 = con.prepareStatement(query);
				preparedStmt1.setInt(1, hosp_code);
				ResultSet rs = preparedStmt1.executeQuery();
				//receiverUserID | receiverName   | receiverBloodGroup | birthDate  | gender | weight | organName | receiverAddress | mobileNo   | approvalStaus | hospital_reg |
				while(rs.next()) {
					Receiver r = new Receiver();
					r.setReceiverName(rs.getString("receiverName"));
					r.setReceiverBloodGroup(rs.getString("receiverBloodGroup"));
					r.setGender(rs.getString("gender").charAt(0));
					r.setWeight(rs.getFloat("weight"));
					r.setorganName(rs.getString("organName"));
					r.setContactNum(rs.getLong("mobileNo"));
					r.setEmergency(rs.getInt("emergency"));
					r.sethospital(hosp_name);
					r.setAllotmentStatus(rs.getString("allotmentStatus"));
					r.setDonarAlloted(rs.getString("donorAlloted"));
					h.all_receivers.add(r);
					
				}
		   }
		   catch(SQLException e) {
			     e.printStackTrace();
			 }
	   }
	   void elligible_hospitals() { //hospitals having at least one receiver
		   try {
				 String query = "select count(Hospital_reg),hospital_reg from Receiver group by Hospital_reg";
				 PreparedStatement preparedStmt1;
				 preparedStmt1 = con.prepareStatement(query);
				 ResultSet rs = preparedStmt1.executeQuery(query);

				 while(rs.next()) {
					 int h_code = rs.getInt("Hospital_reg");
					 elligible_hospitals.add(h_code);
				 }
				 
			 }
			 catch(SQLException e) {
			     e.printStackTrace();
			 }
	   }
	   int[] nearestHospitalList(Hospital h){
	        int[] distance = new int[n];
	        for (int i = 0; i < n; i++) {
	            distance[i] = Integer.MAX_VALUE;
	        }
	        PriorityQueue<hospital_node> pq = new PriorityQueue<>(
	                (v1, v2) -> v1.dist - v2.dist);
	        pq.add(new hospital_node(0,h));
	        while (pq.size() > 0) {
	            hospital_node current = pq.poll();

	            for (int n = 0; n< head.size(); n++) {
	                if (distance[current.reference]
	                        + head.get(n).dist
	                        < distance[head.get(n).reference]) {
	                    distance[head.get(n).reference]
	                            = head.get(n).dist
	                            + distance[current.reference];
	                    pq.add(new hospital_node(
	                            head.get(n).reference,
	                            head.get(n).h));
	                }
	            }

	        }
	        return distance;
	    }
	   public static void main(String[] args) {
		   General_info g = new General_info();
		   g.establish_connection();
		   g.extract_allhospital();
		   Hospital h;
		   int i = 0;
		   for(i=0;i<g.all_hospitals.size();i++) {
			   
			   h = g.all_hospitals.get(i);
			   System.out.println("\nHospital name :"+h.getHospitalName());
			   System.out.println("Hospital code :"+h.getHospitalCode());
			   g.arraylist_receivers(h);
			   
			   Iterator value =  h.addToQueue().iterator();
			   
		        // Displaying the values after iterating through the queue
		       System.out.println("The iterator values are: ");
		       while (value.hasNext()) {
		           // System.out.println(((Receiver) value.next()).getReceiverName());
		            System.out.println(((Receiver) value.next()).getEmergency());
		            System.out.println(((Receiver) value.next()).getEmergency());
		        }
			   
		   }
	   }
}
