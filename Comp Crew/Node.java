package pkg1;

public class Node 
{
	String name;
	Node next;
	String day;
	String time;
	double price;
	
	public Node(String name, String day, String time,double price)
	{
		this.name=name;
		this.day=day;
		this.time=time;
		this.price=price;
		next=null;
	}
}