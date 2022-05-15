import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class TakeOrder {
	
	void menu(){
		Scanner c=new Scanner(System.in);
		Scanner c1=new Scanner(System.in);
	int i,n,total;
	String s1="instant50";
	String s2="instant30";
	String s3="instant20";
	String s4="luckyday";
	String s5="friend";
	String code;
	int ch;
	Dish[] arr;
	arr=new Dish[100];
	List<Dish> order= new ArrayList<Dish>();
	
				System.out.println("SrNo Dish Price");
				arr[0]=new Dish(100	,"1] Black Coffee			");
				arr[1]=new Dish(100	,"2] Coppuccino			");
				arr[2]=new Dish(100 ,"3] Latte			");
				arr[3]=new Dish(100 ,"4] Hot Choclate			");
				arr[4]=new Dish(120 ,"5] Irish Choclate		");
				
				arr[5]=new Dish(100	,"6] Classic Lemonades		");
				arr[6]=new Dish(120	,"7] Kiwi Lemonades		");
				arr[7]=new Dish(120	,"8] Watermelon Lemonades		");
				arr[8]=new Dish(120	,"9] Ocean Lemonades		");
				arr[9]=new Dish(120	,"10]Masala Lemonades		");
				
				arr[10]=new Dish(100 ,"11]Cold Coffee			");
				arr[11]=new Dish(120 ,"12]Irish Delight		");
				arr[12]=new Dish(120 ,"13]Mocha Shake			");
				arr[13]=new Dish(120 ,"14]Rich coffee			");
				arr[14]=new Dish(120 ,"15]Kitkat shake			");

	System.out.println("**Hot Beverages**");
	for(i=0;i<5;i++){
	arr[i].display();
	}
	System.out.println("**Lemonades**");
	for(i=5;i<10;i++){
	arr[i].display();
	}
	System.out.println("**Cafe Frappers**");
	for(i=10;i<15;i++){
	arr[i].display();
	}

	total=0;
	do{
	System.out.println("__________________");
	System.out.println(" * Item added *");
	n=c.nextInt();
	arr[n-1].display();
	order.add(arr[n-1]);
	total=total+arr[n-1].price;
	
	System.out.println("Press 1 for next order");
	ch=c.nextInt();
	}while(ch==1);
	System.out.println("_____________________________________");
	System.out.println("\t\t---Final Order---");
	System.out.println(order);
	System.out.println("__________________" );
	System.out.println(" Grand Total :"+total);
	System.out.println("__________________");
	System.out.println("\n\t Enter coupon code if any : ");
	code=c1.nextLine();
	if(code.equals(s1)){
		System.out.println("50% discount availed ");
		total=total/2;
		System.out.println("__________________\n" );
		System.out.println(" Grand Total :"+total);
		System.out.println("__________________\n" );
	}
	else
	if(code.equals(s2)){
		System.out.println("30% discount availed  ");
		total=total-(total*30)/100;
		System.out.println("__________________\n" );
		System.out.println(" Grand Total :"+total);
		System.out.println("__________________\n" );
	}else
		if(code.equals(s3)){
		System.out.println("20% discount availed  ");
		total=total-(total*20)/100;
		System.out.println("__________________\n" );
		System.out.println(" Grand Total :"+total);
		System.out.println("__________________\n" );
	}else
		if(code.equals(s4)){
		System.out.println("Rs.50  discount availed");
		total=total-50;
		System.out.println("__________________\n" );
		System.out.println(" Grand Total :"+total);
		System.out.println("__________________\n" );
	}else
		if(code.equals(s5)){
		System.out.println("Rs.70 discount availed ");
		System.out.println("__________________\n" );
		total=total-70;
		System.out.println(" Grand Total :"+total);
		System.out.println("__________________\n" );
	}else
	{	
		System.out.println("\n\t No promo code applied.\n ");
		System.out.println("__________________\n" );
		System.out.println(" Grand Total :"+total);
		System.out.println("\n__________________" );
	}
	
	}
	}

