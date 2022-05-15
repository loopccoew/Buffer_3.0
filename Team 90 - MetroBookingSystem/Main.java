import java.util.Scanner;
import java.util.Arrays;
import java.util.Date;

class Stations {               //Class for node of station number
    int dist, ticket;
    int source, station;
    int destination;
    Stations next;

    public Stations(int s, int distance, int rs) {
        next = null;
        station = s;
        dist = distance;
        ticket = rs;
    }

}

class Path{
    public int src, dest;
    public int metroIndex;
    public int cost;
    public int dist;
   
    public Path(int src, int dest, int metroIndex){
        this.src = src;
        this.dest = dest;
        this.metroIndex = metroIndex;
    }
}
class Network {
    int s;
    int route;
    int metro_chosen;
    String name;
    String pass;
   
    Stations Metro_no[] = new Stations[4];
    int[] seats = new int[20];
    Stations node;
    Scanner sc = new Scanner(System.in);
    
    void Metro_1() {                                 //function to create metro routes
        Stations s1 = new Stations(1, 0, 0);         //station number, distance and ticket amount are passed as parameters 
        Metro_no[0] = s1;
        Stations s2 = new Stations(2, 3, 20);
        s1.next = s2;
        Stations s3 = new Stations(3, 4, 40);
        s2.next = s3;
        Stations s4 = new Stations(4, 2, 60);
        s3.next = s4;
        Stations s5 = new Stations(5, 5, 80);
        s4.next = s5;
        Stations s6 = new Stations(6, 6, 100);
        s5.next = s6;
        Stations ptr = Metro_no[0];
        System.out.println("Metro 1");
        while (ptr != null) {                    //display metro stations.

            System.out.print(ptr.station + "->");
            ptr = ptr.next;
        }
        System.out.println();
    }
   void Metro_2() {
        Stations s1 = new Stations(2, 0, 0);
        Metro_no[1] = s1;
        Stations s2 = new Stations(1, 3, 20);
        s1.next = s2;
        Stations s3 = new Stations(3, 4, 40);
        s2.next = s3;
        Stations s4 = new Stations(5, 6, 60);
        s3.next = s4;
        Stations s5 = new Stations(6, 6, 80);
        s4.next = s5;

        Stations ptr = Metro_no[1];
        System.out.println("Metro 2");
        while (ptr != null) {
            System.out.print(ptr.station + "->");
            ptr = ptr.next;
        }
        System.out.println();
    }


    void Metro_3() {
        Stations s1 = new Stations(3, 0, 0);
        Metro_no[2] = s1;
        Stations s2 = new Stations(5, 6, 20);
        s1.next = s2;
        Stations s3 = new Stations(2, 5, 40);
        s2.next = s3;
        Stations s4 = new Stations(4, 4, 60);
        s3.next = s4;

        Stations ptr = Metro_no[2];
        System.out.println("Metro 3");

        while (ptr != null) {
            System.out.print(ptr.station + "->");
            ptr = ptr.next;
        }
        System.out.println();
    }
    void Metro_4() {
        Stations s1 = new Stations(4, 0, 0);
        Metro_no[3] = s1;
        Stations s2 = new Stations(5, 5, 20);
        s1.next = s2;
        Stations s3 = new Stations(6, 6, 40);
        s2.next = s3;
        Stations s4 = new Stations(3, 4, 60);
        s3.next = s4;
        Stations s5 = new Stations(1, 4, 80);
        s4.next = s5;

        Stations ptr = Metro_no[3];
        System.out.println("Metro 4");

        while (ptr != null) {
            System.out.print(ptr.station + "->");
            ptr = ptr.next;
        }
    }
     void book(){
	
		System.out.println("_________Welcome to the Metro reservation system!__________");
		System.out.println();
		for (int i = 0; i < 20; i++) {
			seats[i] = 0;//make seats 0 as initially metro is empty
		}

		Scanner s = new Scanner(System.in);
		int choice = 1;
	
		System.out.println("-------------Please enter---------- \n1- Women Coach\n2-General Coach\n0-exit(Not booking a seat): ");
		choice = s.nextInt();
	
		while (choice != 0) {
		   int seatnumber = 0;

           if (choice == 1) {
				seatnumber = bookWomenCoach();

           if (seatnumber == -1) {
					seatnumber = bookGeneralCoach();
				
					if (seatnumber != -1) {
						System.out.println("Sorry, we were not able to book in a seat in women coach. But you do have a seat in general coach.");
						printBoardingPass(seatnumber);
					}
				}
				else {
					
					System.out.println("You are in luck, we have a seat in women coach !");
					printBoardingPass(seatnumber);
				}
			}
			else if (choice == 2) {

				seatnumber = bookGeneralCoach();
				if (seatnumber == -1) {
					seatnumber = bookWomenCoach();

					if (seatnumber != -1) {
						System.out.println("Sorry, we were not able to book a seat in General coach. But do have a seat in women coach.");
						printBoardingPass(seatnumber);
					}
				}
				else {
					
					System.out.println("You are in luck, we have a seat available in general coach!");
					printBoardingPass(seatnumber);
				}
			}
			else {
				
				System.out.println("**********Invalid choice made. Please try again!***********");
				choice = 0;
			}

			if (seatnumber == -1) {
				System.out.println("***********We are sorry, there are no seats available in either of the coaches.******************");
				System.out.println();
			}
			System.out.print("Please enter 1 for a seat in women coach, 2 for a seat in general coach, or 0 to exit if you don't want to book more tickets!!: ");
			choice = s.nextInt();
		}
     }
			
	

   int  bookWomenCoach(){
		for (int i = 0; i < 10; i++) {
			if (seats[i] != 10) {
				seats[i] = 1;
				return i + 1;
			}
		}
		return -1;
	}

	 int bookGeneralCoach() {
		for (int i = 10; i < 20; i++) {
			if (seats[i] == 0) {
				seats[i] = 1;
				return i + 1;
			}
    }
		return -1;
   }
	 void pass_status(String status)
		{
			pass=status;
		}
	 
     void printBoardingPass(int seatnumber) {
		Date timenow = new Date();
		System.out.println("\n________________________Here is your boarding pass.__________________________________________________________\n");
		System.out.print("\t\t\tDATE:" );
		System.out.print("\t\t\t\tSEAT NUMBER\tMETRO NO\tPASS HOLDER\n");
		
		System.out.println("\t\t\t"+timenow.toString()+"\t\t"+seatnumber+"\t "+metro_chosen+"\t\t "+ pass);
	   
		System.out.println("\n\t\t***This ticket is non-refundable.\n\t\t***Please wear mask at all times and maintain Covid guidelines");
		System.out.println("__________________________________________________________________________________________________________________");
		System.out.println();
	}

  void Board() {
        //Q for stations
        System.out.println("     Enter your boarding station: ");
        int src = sc.nextInt();
        System.out.println("     Enter your destination station: ");
        int dest = sc.nextInt();
       if(src>6||dest>6)
    	   System.out.println("Such stations are not present in routes of metro!!!!!!");
       else 
       {
        // getting all valid paths
        Path[] all_paths = get_all_metro_paths(src, dest);

        // printing all paths sorted according to cost
        System.out.println("We are providing a suitable metro according to cost ant your time.You may chose any one of them!!");
        System.out.println("Best metro according to minimum ticket cost is ");
        //System.out.println("Sorted by cost=");
        Path[] paths = sort_paths_by_cost(all_paths);
        for (int i = 0; i < paths.length; i++)
            display_path(paths[i]);
        System.out.println();

        // printing all paths sorted according to distance
        System.out.println("Best metro acording to minimum distance is Sorted by distance");
        paths = sort_paths_by_dist(all_paths);
        for (int i = 0; i < paths.length; i++)
            display_path(paths[i]);
        System.out.println("So which metro do you want to choose for travelling? Please specify it for booking ticket!!");
        metro_chosen=sc.nextInt();
        System.out.println("Please head towards ticket booking counter now!!"
        		+ "\nThankyou!!");
    }
  }

     void display_path(Path p){
        Stations metro = Metro_no[p.metroIndex];
        boolean printPath = false;
        System.out.println("___________________________________________________________________________________________________________");
        System.out.println("Metro number\tboarding station\tDestination" );//+ (p.metroIndex + 1));
       // System.out.print("Path:");
        System.out.print("\t"+(p.metroIndex+1)+"\t\t" + p.src + "\t\t" + p.dest);
        System.out.println("\nPath:");
       
        while (metro != null){
            if (metro.station == p.src)
                printPath = true;

            if (printPath)
                System.out.print(" " + metro.station + " ");

            if (printPath && (metro.station != p.dest))
                System.out.print("->");

            metro = metro.next;
        }

        System.out.println();
        System.out.println("Total ticket Cost for this metro is : " + p.cost);
        System.out.println("Total Distance: " + p.dist +"km");
        System.out.println("_______________________________________________________________________________________________________");
    }

   //Sort all paths of metro routes by bubble sort to get minimum ticket travelling metro.
     Path[] sort_paths_by_cost(Path[] paths){
        for (int i = 0; i < paths.length; i++){
            for (int j = 0; j < paths.length - i - 1; j++){
                if (paths[j].cost > paths[j + 1].cost){
                    Path temp = paths[j];
                    paths[j] = paths[j + 1];
                    paths[j + 1] = temp;
                }
            }
        }

        return paths ;
    }
//Sort all paths of metro routes by bubble sort to get minimum distance travelling metro.
    Path[] sort_paths_by_dist(Path[] paths){
        for (int i = 0; i < paths.length - 1; i++){
            for (int j = 0; j < paths.length - i - 1; j++){
                if (paths[j].dist > paths[j + 1].dist){
                    Path temp = paths[j];
                    paths[j] = paths[j + 1];
                    paths[j + 1] = temp;
                }
            }
        }
        return paths;
    }

//Finds distance and cost of metros wheere source and destination is present.
    Path[] get_all_metro_paths(int src, int dest) {
        Path[] all_paths = new Path[Metro_no.length];
        int totalPaths = 0;
        
        for (int i = 0; i < Metro_no.length; i++) {
            Stations metro = Metro_no[i];
            int tempDist = 0;
            int cost = 0;
            boolean foundSrc = false, foundDest = false;
            while (metro != null) {
                if (metro.station == src)
                    foundSrc = true;

                if (foundSrc && metro.station != src){
                    tempDist += metro.dist;
                    cost += metro.ticket;
                }

                if (metro.station == dest)
                    if (foundSrc) {
                        foundDest = true;
                        break;
                    }
                else
                    break;

                metro = metro.next;
            }

            if (foundSrc && foundDest) {
                Path newPath = new Path(src, dest, i);
                newPath.cost = cost;
                newPath.dist = tempDist;

                all_paths[totalPaths++] = newPath;
            }
        }

        // reshaping the all_paths array to fit the total number of paths discovered.
        all_paths = Arrays.copyOf(all_paths, totalPaths);
        return all_paths;
    }
}



class getPassword//class Node to declare all nodes and links
	{
	   getPassword left ,right,root;
	   int passCode,password;
	   getPassword next;
	  
	   Scanner sc = new Scanner(System.in);
	   getPassword ptr;
	   public getPassword()
	   {
		   left =right=null;
		   passCode=password=0;
		   root=null;
		   ptr=null;
	   
	   }
	  
	void create(int new_passCode,int new_password){ //to create BST
		
		getPassword temp=new getPassword();
		temp.passCode=new_passCode;
		temp.password=new_password;
		if(root==null) { //if root is null
			root=temp;
			}
		else {
			ptr=root;
			while(ptr!=null) {
			if(ptr.passCode>=(temp.passCode)) { //if new passCode is smaller than current node
				if(ptr.left==null) {
					ptr.left=temp;
					//System.out.println(root.passCode+"left"+ptr.left.passCode+ptr.passCode);
					ptr=null;
				}
				else {
					ptr=ptr.left;
				}
			}
			else if(ptr.passCode<(temp.passCode)){ //if new passCode is greater than current node
				if(ptr.right==null) {
					ptr.right=temp;
					//System.out.println(root.passCode+"right"+ptr.right.passCode+ptr.passCode);
					ptr=null;
				}
				else {
					ptr=ptr.right;
				}
			 }
		   }
		}
		
		
	}
	
	  String search(int s) { 		//to search a passcode
		  getPassword temp=null;
		  String status = null;
		  int flag=0, flag1=0;
		  int i=0;
		  ptr=root;
		  while(ptr!=null) {
				  if(ptr.passCode == s) 
				  {
//					  System.out.println(ptr.passCode+" : "+ptr.password);
					  flag=1;
					  temp=ptr;
					  ptr=null;
				  }
				  else if(ptr.passCode > s ){
					  	ptr=ptr.left;
				  }
				  else {
					  ptr=ptr.right;
				  }
			  	}
			  if (flag == 1) {
				  do{
					  System.out.println("Enter your password");
					  int inputPass = sc.nextInt();
					  if (inputPass == temp.password) 
					  {
						  System.out.println("Access Granted!!");
						  flag1=1;
						  break;
					  }
					  else 
					  {
						  System.out.println("\nINCORRECT PASSWORD !!\nTRY AGAIN: NO. OF ATTEMPTS LEFT : "+(3-(i+1)));
						  i++;
					  }
				  }while(i!=3);
					 
					 
				  if(flag1==0) {
					  System.out.println("\nSORRY CANT LOGIN! EXCESSIVE NUMBER OF ATTEMPTS. ");
				  }
			  
			  }
			  if(flag!=1) { 									//if word is not present in the dictionary
          System.out.println("Invalid Passcode");
				  
			  }
			  if (flag1==1||flag==1)
			  {
				   status = "YES";
			  }
			  else {
				  status ="NO";
			  }
			  return status;
		  	}
	}
	

public class metro{

    public static void main(String[] args) {
    	int choice;
    	Network n = new Network();
    	Scanner sc = new Scanner(System.in);
		int ch;
		do {
		System.out.println("\n__________________Welcome to Metro Station________________\n"
				+ "\n1.See metro routes and stations"
				+ "\n2.Board a metro"
				+ "\n3.Exit metro station"
				+ "\n__________________________________________________________");
				
		 choice=sc.nextInt();
		switch(choice)
		{
		case 1: 
			System.out.println("1-WARJE" +
		            "\n2-KARVENAGAR" +
		            "\n3-KOTHURUD" +
		            "\n4-SHIVAJINAGAR" +
		            "\n5-HINJEWADI" +
		            "\n6-AUNDH\n");
		    n.Metro_1();
	        n.Metro_2();
	        n.Metro_3();
	        n.Metro_4();
			break;
		
		case 2:
			n.Board();
			getPassword obj = new getPassword();
			obj.create(1001, 1234);
			obj.create(1002, 1234);
			obj.create(1003, 1234);
			do {
				 System.out.println("_________________________________________");
				 System.out.println("Do you have a pass?");
				 System.out.println("\n1.Yes\n2.No\n3.EXIT");
				 System.out.println("_________________________________________");
				 ch =sc.nextInt();

                 
				 switch(ch) {
				 case 1:
					 System.out.println("Enter your passcode : ");
					 int s = sc.nextInt();
					 n.pass_status(obj.search(s));
					 n.book();
	                 break;
					 
				 case 2:
					 System.out.println("Book a ticket");
					 n.pass_status("NO");
					 n.book();
					 break;
				 case 3:
					 break;
				default:
						 System.out.println("Please enter correct choice!!");
						 break;
				
				 }
		      }while(ch!=3);
			
			break;
		case 3:
			System.out.println("Thankyou!!!");
			break;
		}
			}while(choice!=3);
		
		
		
       }
    }

/*OUTPUT

__________________Welcome to Metro Station________________

1.See metro routes and stations
2.Board a metro
3.Exit metro station
__________________________________________________________
1
1-WARJE
2-KARVENAGAR
3-KOTHURUD
4-SHIVAJINAGAR
5-HINJEWADI
6-AUNDH

Metro 1
1->2->3->4->5->6->
Metro 2
2->1->3->5->6->
Metro 3
3->5->2->4->
Metro 4
4->5->6->3->1->
__________________Welcome to Metro Station________________

1.See metro routes and stations
2.Board a metro
3.Exit metro station
__________________________________________________________
2
     Enter your boarding station: 
3
     Enter your destination station: 
5
We are providing a suitable metro according to cost ant your time.You may chose any one of them!!
Best metro according to minimum ticket cost is 
___________________________________________________________________________________________________________
Metro number	boarding station	Destination
	3		3		5
Path:
 3 -> 5  2 -> 4 ->
Total ticket Cost for this metro is : 20
Total Distance: 6km
_______________________________________________________________________________________________________
___________________________________________________________________________________________________________
Metro number	boarding station	Destination
	2		3		5
Path:
 3 -> 5  6 ->
Total ticket Cost for this metro is : 60
Total Distance: 6km
_______________________________________________________________________________________________________
___________________________________________________________________________________________________________
Metro number	boarding station	Destination
	1		3		5
Path:
 3 -> 4 -> 5  6 ->
Total ticket Cost for this metro is : 140
Total Distance: 7km
_______________________________________________________________________________________________________

Best metro acording to minimum distance is Sorted by distance
___________________________________________________________________________________________________________
Metro number	boarding station	Destination
	3		3		5
Path:
 3 -> 5  2 -> 4 ->
Total ticket Cost for this metro is : 20
Total Distance: 6km
_______________________________________________________________________________________________________
___________________________________________________________________________________________________________
Metro number	boarding station	Destination
	2		3		5
Path:
 3 -> 5  6 ->
Total ticket Cost for this metro is : 60
Total Distance: 6km
_______________________________________________________________________________________________________
___________________________________________________________________________________________________________
Metro number	boarding station	Destination
	1		3		5
Path:
 3 -> 4 -> 5  6 ->
Total ticket Cost for this metro is : 140
Total Distance: 7km
_______________________________________________________________________________________________________
So which metro do you want to choose for travelling? Please specify it for booking ticket!!
3
Please head towards ticket booking counter now!!
Thankyou!!
_________________________________________
Do you have a pass?

1.Yes
2.No
3.EXIT
_________________________________________
1
Enter your passcode : 
1001
Enter your password
1234
Access Granted!!
_________Welcome to the Metro reservation system!__________

-------------Please enter---------- 
1- Women Coach
2-General Coach
0-exit(Not booking a seat): 
1
You are in luck, we have a seat in women coach !

________________________Here is your boarding pass.__________________________________________________________

			DATE:				SEAT NUMBER	METRO NO	PASS HOLDER
			Sun May 15 23:31:49 IST 2022		1	 3		 YES

		***This ticket is non-refundable.
		***Please wear mask at all times and maintain Covid guidelines
__________________________________________________________________________________________________________________

Please enter 1 for a seat in women coach, 2 for a seat in general coach, or 0 to exit if you don't want to book more tickets!!: 0
_________________________________________
Do you have a pass?

1.Yes
2.No
3.EXIT
_________________________________________
1
Enter your passcode : 
123
Invalid Passcode
_________Welcome to the Metro reservation system!__________

-------------Please enter---------- 
1- Women Coach
2-General Coach
0-exit(Not booking a seat): 
1
You are in luck, we have a seat in women coach !

________________________Here is your boarding pass.__________________________________________________________

			DATE:				SEAT NUMBER	METRO NO	PASS HOLDER
			Sun May 15 23:32:11 IST 2022		1	 3		 NO

		***This ticket is non-refundable.
		***Please wear mask at all times and maintain Covid guidelines
__________________________________________________________________________________________________________________

Please enter 1 for a seat in women coach, 2 for a seat in general coach, or 0 to exit if you don't want to book more tickets!!: 0
_________________________________________
Do you have a pass?

1.Yes
2.No
3.EXIT
_________________________________________
2
Book a ticket
_________Welcome to the Metro reservation system!__________

-------------Please enter---------- 
1- Women Coach
2-General Coach
0-exit(Not booking a seat): 
1
You are in luck, we have a seat in women coach !

________________________Here is your boarding pass.__________________________________________________________

			DATE:				SEAT NUMBER	METRO NO	PASS HOLDER
			Sun May 15 23:32:50 IST 2022		1	 3		 NO

		***This ticket is non-refundable.
		***Please wear mask at all times and maintain Covid guidelines
__________________________________________________________________________________________________________________

Please enter 1 for a seat in women coach, 2 for a seat in general coach, or 0 to exit if you don't want to book more tickets!!: 0
_________________________________________
Do you have a pass?

1.Yes
2.No
3.EXIT
_________________________________________
3

__________________Welcome to Metro Station________________

1.See metro routes and stations
2.Board a metro
3.Exit metro station
__________________________________________________________
3
Thankyou!!!
*/