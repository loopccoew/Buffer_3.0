package pkg1;

public class Bus_Routes 
{
	Node[] arr_routes = new Node[35];
	
	public Bus_Routes()
	{
		Node ptr;
		
		arr_routes[0] = new Node("Ahmadnagar","All","",0.0);
		ptr = arr_routes[0];
		ptr.next = new Node("Pune","All","3:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Thane","All","3:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Nashik","All","3:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Aurangabad","All","3:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Beed","All","3:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Solapur","All","3:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Osmanabad","All","3:00 pm",100);
		
		arr_routes[1] = new Node("Akola","All","",0);
		ptr = arr_routes[1];
		ptr.next = new Node("Buldhana","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Amravati","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Washim","All","1:00 pm",100);
		
		arr_routes[2] = new Node("Amravati","All","",0);
		ptr = arr_routes[2];
		ptr.next = new Node("Akola","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Washim","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Wardha","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Yavatmal","All","1:00 pm",100);
		
		arr_routes[3] = new Node("Aurangabad","All","",0);
		ptr = arr_routes[3];
		ptr.next = new Node("Nashik","All","2:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Jalgaon","All","2:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Jalna","All","2:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Ahmadnagar","All","2:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Beed","All","2:00 pm",100);
		
		arr_routes[4] = new Node("Beed","All","",0);
		ptr = arr_routes[4];
		ptr.next = new Node("Osmanabad","All","4:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Latur","All","4:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Ahmadnagar","All","4:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Jalna","All","4:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Parbhani","All","4:00 pm",100);
		
		arr_routes[5] = new Node("Bhandara","All","",0);
		ptr = arr_routes[5];
		ptr.next = new Node("Nagpur","All","4:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Gondia","All","4:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Chandrapur","All","4:00 pm",100);
		
		arr_routes[6] = new Node("Buldhana","All","",0);
		ptr = arr_routes[6];
		ptr.next = new Node("Jalgaon","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Jalana","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Washim","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Akola","All","5:00 pm",100);
		
		arr_routes[7] = new Node("Chandrapur","All","",0);
		ptr = arr_routes[7];
		ptr.next = new Node("Yavatmal","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Wardha","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Bhandara","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Gadchiroli","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Nagpur","All","5:00 pm",100);
		
		arr_routes[8] = new Node("Dhule","All","",0);
		ptr = arr_routes[8];
		ptr.next = new Node("Nandurbar","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Nashik","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Jalgaon","All","5:00 pm",100);
		
		arr_routes[9] = new Node("Gadchiroli","All","",0);
		ptr = arr_routes[9];
		ptr.next = new Node("Chandrapur","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Gondia","All","5:00 pm",100);
		
		arr_routes[10] = new Node("Gondia","All","",0);
		ptr = arr_routes[10];
		ptr.next = new Node("Bhandara","All","6:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Gadchiroli","All","6:00 pm",100);
		
		arr_routes[11] = new Node("Hingoli","All","",0);
		ptr = arr_routes[11];
		ptr.next = new Node("Parbhani","All","6:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Washim","All","6:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Yavatmal","All","6:00 pm",100);
		
		arr_routes[12] = new Node("jalana","All","",0);
		ptr = arr_routes[12];
		ptr.next = new Node("Aurangabad","All","6:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Buldhana","All","6:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Parbhani","All","6:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Beed","All","6:00 pm",100);
		
		arr_routes[13] = new Node("Jalgaon","All","",0);
		ptr = arr_routes[13];
		ptr.next = new Node("Buldhana","All","7:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Aurangabad","All","7:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Dhule","All","7:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Nashik","All","7:00 pm",100);
		
		arr_routes[14] = new Node("Kolhapur","All","",0);
		ptr = arr_routes[14];
		ptr.next = new Node("Sangali","All","8:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Ratnagiri","All","8:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Sindhudurg","All","8:00 pm",100);
		
		arr_routes[15] = new Node("Latur","All","",0);
		ptr = arr_routes[15];
		ptr.next = new Node("Parbhani","All","8:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Beed","All","8:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Osmanabad","All","8:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Nanded","All","8:00 pm",100);
		
		arr_routes[16] = new Node("Mumbai","All","",0);
		ptr = arr_routes[16];
		ptr.next = new Node("Thane","All","8:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Palghar","All","8:00 pm",100);
		
		arr_routes[17] = new Node("Nagpur","All","",0);
		ptr = arr_routes[17];
		ptr.next = new Node("Bhandara","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Wardha","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Chandrapur","All","9:00 pm",100);
		
		arr_routes[18] = new Node("Nanded","All","",0);
		ptr = arr_routes[18];
		ptr.next = new Node("Latur","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Parbhani","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Hingoli","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Yavatmal","All","9:00 pm",100);
		
		arr_routes[19] = new Node("Nandurbar","All","",0);
		ptr = arr_routes[19];
		ptr.next = new Node("Dhule","All","9:00 pm",100);
		
		arr_routes[20] = new Node("Nashik","All","",0);
		ptr = arr_routes[20];
		ptr.next = new Node("Ahmadnagar","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Aurangabad","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Jalgaon","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Dhule","All","9:00 pm",100);
		
		arr_routes[21] = new Node("Osmanabad","All","",0);
		ptr = arr_routes[21];
		ptr.next = new Node("Solapur","All","10:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Beed","All","10:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Latur","All","10:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Ahmadnagar","All","10:00 pm",100);
		
		arr_routes[22] = new Node("Palghar","All","",0);
		ptr = arr_routes[22];
		ptr.next = new Node("Nashik","All","10:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Thane","All","10:00 pm",100);
		
		arr_routes[23] = new Node("Parbhani","All","",0);
		ptr = arr_routes[23];
		ptr.next = new Node("Beed","All","11:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Latur","All","11:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Hingoli","All","11:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Jalana","All","11:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Nanded","All","11:00 pm",100);
		
		arr_routes[24] = new Node("Pune","All","",0);
		ptr = arr_routes[24];
		ptr.next = new Node("Raigad","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Satara","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Thane","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Solapur","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Ahmadnagar","All","1:00 pm",100);
		
		arr_routes[25] = new Node("Raigad","All","",0);
		ptr = arr_routes[25];
		ptr.next = new Node("Pune","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Thane","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Satara","All","1:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Ratnagiri","All","1:00 pm",100);
		
		arr_routes[26] = new Node("Ratnagiri","All","",0);
		ptr = arr_routes[26];
		ptr.next = new Node("Raigad","All","3:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Satara","All","3:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Kolhapur","All","3:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Singhudurg","All","3:00 pm",100);
		
		arr_routes[27] = new Node("Sangli","All","",0);
		ptr = arr_routes[27];
		ptr.next = new Node("Solapur","All","3:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Satara","All","3:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Kolhapur","All","3:00 pm",100);
		
		arr_routes[28] = new Node("Satara","All","",0);
		ptr = arr_routes[28];
		ptr.next = new Node("Raigad","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Pune","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Ratnagiri","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Solapur","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Sangli","All","5:00 pm",100);
		
		arr_routes[29] = new Node("Sindhudurg","All","",0);
		ptr = arr_routes[29];
		ptr.next = new Node("Ratnagiri","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Kolhapur","All","5:00 pm",100);
		
		arr_routes[30] = new Node("Solapur","All","",0);
		ptr = arr_routes[30];
		ptr.next = new Node("Sangli","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Satara","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Pune","All","5:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Ahmadnagar","All","5:00 pm",100);
		ptr = ptr.next;
		ptr.next = new Node("Osmanabad","All","5:00 pm",100);
		
		arr_routes[31] = new Node("Thane","All","",0);
		ptr = arr_routes[31];
		ptr.next = new Node("Mumbai","All","7:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Raigad","All","7:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Pune","All","7:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Ahmadnagar","All","7:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Nashik","All","7:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Palghar","All","7:00 pm",100);
		
		arr_routes[32] = new Node("Wardha","All","",0);
		ptr = arr_routes[32];
		ptr.next = new Node("Amravati","All","7:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Chandrapur","All","7:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Nagpur","All","7:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Yavatmal","All","7:00 pm",100);
		
		arr_routes[33] = new Node("Washim","All","",0);
		ptr = arr_routes[33];
		ptr.next = new Node("Buldhana","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Akola","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Hingoli","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Yavatmal","All","9:00 pm",100);
		
		arr_routes[34] = new Node("Yavatmal","All","",0);
		ptr = arr_routes[34];
		ptr.next = new Node("Amravati","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Washim","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Hingoli","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Nanded","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Wardha","All","9:00 pm",100);
		ptr= ptr.next;
		ptr.next = new Node("Chandrapur","All","9:00 pm",100);
		
		/*
		for(int i=0;i<35;i++)
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