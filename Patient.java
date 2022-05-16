package loop;

public class Patient {
	
	
	//Veritable Declaration
	private String Id;
	private String Name;
	private String Age;
	private String ContNo;
	private String BloodGrp;
	
	//Parameterized Constructor
	public Patient(String Id, String Name, String Age, String ContNo, String BloodGrp) {
		
		this.Id = Id;
		this.Name = Name;
		this.Age = Age;
		this.ContNo =ContNo;
		this.BloodGrp = BloodGrp;
	}



	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String Age) {
		this.Age = Age;
	}

	public String getContNo() {
		return ContNo;
	}

	public void setContNo(String ContNo) {
		this.ContNo = ContNo;
	}

	public String getBloodGrp() {
		return BloodGrp;
	}

	public void setBloodGrp(String BloodGrp) {
		this.BloodGrp = BloodGrp;
	}

	@Override
	public String toString() {
		return "Patient :  [Id=" + Id + ", Name=" + Name + ", Age=" + Age + ", ContNo=" + ContNo + ", BloodGrp=" + BloodGrp
				+ "]";
	}
	
	
	
	
	

}
