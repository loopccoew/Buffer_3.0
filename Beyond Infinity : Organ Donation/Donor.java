import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;
public class Donor {
	
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/OrganDonation";
	static final String USER = "root";
	static final String PASS = "priyanka2240";
	Connection con;
	
	
	private String donorName;
	private String donorBloodGroup;
	private String  birthDate;
	private char gender;
	private double weight;
	private Area areaOfDonor;
	private String organ;
	private long contactNo;
	ArrayList<Hospital> areawise_hospitals = new ArrayList<Hospital>();
	public Donor(String donorName, String donorBloodGroup, String birthDate, char gender, double weight, String org,
			Area areaOfDonor, long contactNo) {
		this.donorName = donorName;
		this.donorBloodGroup = donorBloodGroup;
		this.birthDate = birthDate;
		this.gender = gender;
		this.weight = weight;
		this.organ = org;
		this.areaOfDonor = areaOfDonor;
		this.contactNo = contactNo;
		
		
	}
	 void area_hospitals(Donor d) { //pass donor area to this function
		   try {
				 /*String q = "select areaCode from Area where areaName = (?)";
				 PreparedStatement preparedStmt1;
				 preparedStmt1 = con.prepareStatement(q);
				 preparedStmt1.setString(1, d.getAreaOfDonor().getAreaName());
				 */
			     con=DriverManager.getConnection(DB_URL,USER,PASS);
			     String query = "select * from Hospital where areaCode = ?;";
			     PreparedStatement preparedStmt1;
				 preparedStmt1 = con.prepareStatement(query);
				 preparedStmt1.setInt(1, d.getAreaOfDonor().getAreaCode());
				 
				 ResultSet rs = preparedStmt1.executeQuery();

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
	
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getDonorBloodGroup() {
		return donorBloodGroup;
	}
	public void setDonorBloodGroup(String donorBloodGroup) {
		this.donorBloodGroup = donorBloodGroup;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Area getAreaOfDonor() {
		return areaOfDonor;
	}
	public String getorgan() {
		return this.organ;
	}
	public void setAreaOfDonor(Area areaOfDonor) {
		this.areaOfDonor = areaOfDonor;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	


}