import java.util.Scanner;
import java.util.*;
public class Restaurant {
public static void main(String args[])
{
	int ch;
	String name;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("    *****   'The Hunger Smashers'   *****\n\n");
	
	do {
	System.out.println("MENU");
	System.out.println("1.Book Table");
	System.out.println("2.Take an Order");
	ch = sc.nextInt();
	switch(ch)
	{
	
	case 1: 
		Scanner sc1=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);
		
		int cusno,tabno,a,a4,i=1;
		
		Map<Integer,Customer> map=new HashMap<Integer,Customer>();
		do{
		System.out.println("\n\t ***** \n\t 1)Book A Table \n\t 2)Remove Booking \n\t ***** ");
		ch=sc1.nextInt();
		switch(ch){
		case 1:	
		System.out.println("Customer"+i+"__________");
		System.out.println("Enter Customer Name:");
		name=sc2.nextLine();
		System.out.println("Enter Number of customers:");
		cusno=sc1.nextInt();
		System.out.println("Enter Table Number:");
		tabno=sc1.nextInt();
		Customer s1=new Customer(name,cusno);
		map.put(tabno,s1);
		System.out.println(".....................................");
		System.out.println(map);
		System.out.println(".....................................");
		i++;
		
		break;
		case 2:
			System.out.println("Tabel Number Being Empty:");
			a=sc1.nextInt();
			map.remove(a);
			System.out.println(".....................................");
			System.out.println("Current Status:");
			System.out.println(map);
			System.out.println(".....................................");
			break;
			}
			System.out.println("To Continue Press 1 .......");
			a4=sc1.nextInt();
	}while(a4==1);
		break;
		
		
	case 2: TakeOrder t = new TakeOrder();
	t.menu();
	
	break;
	default: System.out.println("Please enter a valid choice");
	break;
	}
	}while(ch<3);
	
}
}
