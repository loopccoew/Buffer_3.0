package loop;

 class CheckNode {
	Checkup cp;
	CheckNode next,prev;
	public CheckNode(Checkup cp)
	{
		next=prev=null;
		this.cp=cp;
	}

}
 public class CheckUpList{
	CheckNode head,tail;
	public CheckUpList()
	{
		head=null;
		tail=null;
	}
	
	public void Enqueue(Checkup cp)
	{
		CheckNode node=new CheckNode(cp);
		
		if(head==null || tail==null)
		{
			head=node;
			tail=node;
		}
		else if(head.cp.getPriority()<cp.getPriority())
		{
			head.next=node;
			node.prev=head;
			head=node;
			
		}
		else if(tail.cp.getPriority()>=cp.getPriority())
		{
			tail.prev=node;
			node.next=tail;
			tail=node;
		}
		else
		{
			CheckNode temp=tail;
			while(temp!=null)
			{
				if(temp.cp.getPriority()>=cp.getPriority())
				{
					break;
				}
				temp=temp.next;
			}
			node.next=temp;
			node.prev=temp.prev;
			temp.prev.next=node;
			temp.prev=node;
		}
	}
	
	public Checkup Dequeue()
	{
		if(head==null)
		{
			return null;
		}
		CheckNode checkup=head;
		head=head.next;
		return checkup.cp;
	}
	

	
	public Patient getPatient(int index)
	{
		CheckNode temp=head;
		int i=0;
		while(temp!=null)
		{
			if(index==1)
			{
				break;
			}
			i++;
			temp=temp.prev;
		}
		return temp.cp.getPatient();
		
	}
	
	public void print()
	{
		CheckNode temp=head;
		while(temp!=null)
		{
			System.out.println(temp.cp.getPriority()+"  "+temp.cp.getRecomendation());
			temp=temp.prev;
		}
			
	}

	

}
 
