package pkg1;

public class Bus_Railway_Routes 
{
	Node[] arr_routes = new Node[9];
	
	public Bus_Railway_Routes()
	{
		Node ptr;
		
		arr_routes[0] = new Node("Mumbai","All","12:00 pm",0);
		ptr = arr_routes[0];
		ptr.next = new Node("Thane","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Raigad","All","2:00 pm",200);
		ptr= ptr.next;
		ptr.next = new Node("Ratnagiri","All","3:00 pm",300);
		ptr= ptr.next;
		ptr.next = new Node("Sindhudurg","All","4:00 pm",400);
		
		arr_routes[1] = new Node("Mumbai","All","12:00 pm",0);
		ptr = arr_routes[1];
		ptr.next = new Node("Thane","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Palghar","All","2:00 pm",200);
		
		arr_routes[2] = new Node("Mumbai","All","12:00 pm",0);
		ptr = arr_routes[2];
		ptr.next = new Node("Thane","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Pune","All","2:00 pm",200);
		ptr= ptr.next;
		ptr.next = new Node("Satara","All","3:00 pm",300);
		ptr= ptr.next;
		ptr.next = new Node("Sangli","All","4:00 pm",400);
		ptr= ptr.next;
		ptr.next = new Node("Kolhapur","All","5:00 pm",500);
		
		arr_routes[3] = new Node("Pune","All","12:00 pm",0);
		ptr = arr_routes[3];
		ptr.next = new Node("Solapur","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Osmanabad","All","2:00 pm",200);
		ptr= ptr.next;
		ptr.next = new Node("Latur","All","3:00 pm",300);
		
		arr_routes[4] = new Node("Palghar","All","12:00 pm",0);
		ptr = arr_routes[4];
		ptr.next = new Node("Nashik","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Dhule","All","2:00 pm",200);
		ptr= ptr.next;
		ptr.next = new Node("Jalgaon","All","3:00 pm",300);
		
		arr_routes[5] = new Node("Nandurbar","All","12:00 pm",0);
		ptr = arr_routes[5];
		ptr.next = new Node("Dhule","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Jalgaon","All","2:00 pm",200);
		ptr= ptr.next;
		ptr.next = new Node("Buldhana","All","3:00 pm",300);
		ptr= ptr.next;
		ptr.next = new Node("Akola","All","4:00 pm",400);
		ptr= ptr.next;
		ptr.next = new Node("Amaravati","All","5:00 pm",500);
		ptr= ptr.next;
		ptr.next = new Node("Wardha","All","6:00 pm",600);
		ptr= ptr.next;
		ptr.next = new Node("Nagpur","All","7:00 pm",700);
		ptr= ptr.next;
		ptr.next = new Node("Bhandara","All","8:00 pm",800);
		ptr= ptr.next;
		ptr.next = new Node("Gondia","All","9:00 pm",900);
		
		arr_routes[6] = new Node("Ahmadnagar","All","12:00 pm",0);
		ptr = arr_routes[6];
		ptr.next = new Node("Beed","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Parbhani","All","2:00 pm",200);
		ptr= ptr.next;
		ptr.next = new Node("Latur","All","3:00 pm",300);
		
		arr_routes[7] = new Node("Aurangabad","All","12:00 pm",0);
		ptr = arr_routes[7];
		ptr.next = new Node("Buldhana","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Washim","All","2:00 pm",200);
		ptr= ptr.next;
		ptr.next = new Node("Hingoli","All","3:00 pm",300);
		ptr= ptr.next;
		ptr.next = new Node("Yavatmal","All","4:00 pm",400);
		
		arr_routes[8] = new Node("Nagpur","All","12:00 pm",0);
		ptr = arr_routes[8];
		ptr.next = new Node("Chandrapur","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Gadchiroli","All","2:00 pm",200);
		
		/*
		for(int i=0;i<9;i++)
		{
			Node curr= arr_routes[i];
			while(curr!=null)
			{
				if(curr.next!=null)
					System.out.print(curr.name+" ---> ");
				else
				 System.out.print(curr.name);
				curr=curr.next;
			}
			System.out.println("\n");
		}*/
	}
}