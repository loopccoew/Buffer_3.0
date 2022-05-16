package loop;


class dNode
{
	Doctor Doctor ;
	dNode next;
	dNode prev;
	
	//Constructor
	
	public dNode(Doctor Doctor) {
		
		this.Doctor = Doctor ;
		next=null;
		prev=null;
	}
	
}

//Double Linked list TO insert  Doctor
public class DoctorList {
	
	
	dNode head,tail;
	public DoctorList()
	{
		head=null;
		tail=null;
	}
	public void Insert(Doctor Doctor)
	{
		
		dNode node=new dNode(Doctor);
		
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
		
	
		public void searchBySpeciality(String Speciality)
		{
			boolean b=false;
			dNode temp=head;
			while(temp!=null)
			{
				if(temp.Doctor.getSpeciality().equals(Speciality))
				{
					b=true;
					System.out.println(temp.Doctor);
					
				}
				
				temp=temp.prev;
			}
			if(b==false)
			{
				System.out.println("Doctor with this speciality is not available");
			}
			
		}
		public int Size()
		{
			dNode temp=head;
			int count=0;
			while(temp!=null)
			{
				count++;
				temp=temp.prev;
			}
			return count;
		}
		
		public void  AllDoctorInfo()
		{
			dNode temp=tail;
			while(temp!=null)
			{
				System.out.println(" DoctorId : "+temp.Doctor.getId() +" DoctorName : "+temp.Doctor.getName() +" Doctor Speciality : "+temp.Doctor.getSpeciality() +" Doctor fees : "+temp.Doctor.getFees());
				
				temp=temp.next;
			}
		}
		public void PrintData()
		{
			dNode temp =head;
			int count=0;
			while(temp!=null)
			{
				count++;
				System.out.println(count+":  "+temp.Doctor.toString());
				temp=temp.prev;
			}
		}
		public Doctor getAtIndex(int index) {
			dNode temp=head;
			for(int i=0;i<index;i++)
			{
				temp=temp.prev;
			}
			return temp.Doctor;
			
		}
}
