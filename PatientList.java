package loop;

class PNode
{
	Patient Patient ;
	PNode next,prev;
	
	//Constructor
	public PNode()
	{
		
	}

	public PNode(Patient Patient) {
		this.Patient = Patient;
		next=null;
		prev=null;
	}
	
}
public class PatientList {
	PNode head,tail;
	public PatientList()
	{
		head=null;
		tail=null;
	}
	public void Insert(Patient Patient)
	{
		PNode node=new PNode(Patient);
		
		if(head==null || tail==null)
		{
			head=node;
			tail=node;
		}
		else
		{
			head.next=node;
	 		node.prev=head;
			head=node;
		}
	}
	
	public Patient searchById(String Id)
	{
		PNode temp=head;
		while(temp!=null)
		{
			if(temp.Patient.getId().equals(Id))
			{
				return temp.Patient;
			}
			temp=temp.prev;
		}
		return null;
	}
	public void searchByName(String Name)
	{
		boolean b = false;
	    PNode temp=head;
	    while(temp!=null)
	    {
	        if(temp.Patient.getName().equals(Name))
	        {
	        	
	            System.out.println(temp.Patient);
	            b=true;
	        }
	        temp=temp.prev;
	    }
	    if(b==false)
		{
			System.out.println("Patient with this name is not available");
		}
		
	    
	}
	
	public int Size()
	{
		PNode temp=head;
		int count=0;
		while(temp!=null)
		{
			count++;
			temp=temp.prev;
		}
		return count;
	}
	
	public void PrintData()
	{
		
		PNode temp=head;
		
		int count=0;
		
		
		while(temp!=null)
		{
			count++;
			System.out.println(count+":  "+temp.Patient.toString());
			temp=temp.prev;
		}
	}
	
	}


