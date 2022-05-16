package loop;

public class Doctor {
	
	//Deceleration of Variables
	private String Id;
	private String Name;
	private String Speciality;
	private int fees;
	
	
	//Parameterized Constructor
	public Doctor(String Id, String Name, String Speciality, int fees) {
		this.Id = Id;
		this.Name = Name;
		this.Speciality = Speciality;
		this.fees = fees;
	}
	
    // Getter Setter...
	public String getId()
	{
		return Id;
	}

	public void setId(String Id)
	{
		this.Id = Id;
	}

	public String getName() 
	{
		return Name;
	}

	public void setName(String Name) 
	{
		this.Name = Name;
	}

	public String getSpeciality()
	{
		return Speciality;
	}

	public void setSpeciality(String Speciality)
	{
		this.Speciality = Speciality;
	}

	public int getFees() 
	{
		return fees;
	}

	public void setFees(int fees)
	{
		this.fees = fees;
	}

	@Override
	public String toString()
	{
		return "Doctor [Id=" + Id + ", Name=" + Name + ", Speciality=" + Speciality + ", fees=" + fees + "]";
	}
	

}
