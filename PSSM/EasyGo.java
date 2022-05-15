//https://github.com/mrunalcomp/bufferdsa.git
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
class node implements Comparator<node> { //node class
	node next;
	int location;
	double weight;
	char cab_p;
	String city_name;
	List<List<node> > adj;
	Set<Integer> settled;
	public node() {}
	public node(int location,double weight) {//parameterized constructor
		this.location=location;
		this.weight=weight;
		next=null;
		settled = new HashSet<Integer>();
	}
	int getVertex() { return location; }
	double getWeight() { return weight; }

	@Override
	public int compare(node node1, node node2)
	{//comparator interface

		if (node1.weight < node2.weight)
			return -1;

		if (node1.weight > node2.weight)
			return 1;

		return 0;
	}
}

class CabService extends JFrame {//GUI frame
	int first;
	JFrame f;
	JFrame f1;
	JFrame f2;
	JFrame f3;
	//label declaration
	JLabel j8,j7,j9,j10,j11,j12,j13,j98;
	JLabel j15,j16,j17,j18,j19,j20,j21,j22;
	JLabel j23,j24,j25,j26,j27,j28,j29,j30,j33,j34,j35;
	JTextField t=null,t1=null,t2,t3;
	JButton b2;
	Graphics g;
	int V;
	int l;
	int position;
	private double dist[];
	private Set<Integer> settled;//declaration of hashset
	private PriorityQueue<node> pq;

	List<List<node> > adj;//storing list of nodes in list
	int flag=0;
	boolean cab=false;
	String name;
	String cab_driver_name;
	String auto_driver_name;
	boolean auto=false;
	String auto_ph_no;
	String cab_ph_no;
	String auto_no;
	String cab_no;

	CabService(){
		f=new JFrame();
		dist = new double[12];
		settled = new HashSet<Integer>();
		pq = new PriorityQueue<node>(12, new node());
	}
	//parameterized constructor
	CabService(String name,boolean auto,boolean cab,String auto_driver_name,String cab_driver_name,String auto_ph_no,String cab_ph_no,String auto_no,String cab_no){
		this.name=name;
		this.auto=auto;
		this.cab=cab;
		this.cab_driver_name=cab_driver_name;
		this.auto_driver_name=auto_driver_name;
		this.auto_ph_no=auto_ph_no;
		this.cab_ph_no=cab_ph_no;
		this.auto_no=auto_no;
		this.cab_no=cab_no;
	}
	Scanner sc=new Scanner(System.in);
	String source;
	String destination;
	double cab_fare;
	double auto_fare;

	int city_no=12;
	int road_no=21;
	node[] head =new node[20];//array stored in the nodes
	CabService[] arr =new CabService[12];


	void details() {//cab details
		arr[0]=new CabService("Saras Baugh",true,true,"Sunil Shinde","Anil Chavan","9021233445","9021267555","MH12 CD1256","MH12 AB2003");
		arr[1]=new CabService("Cummins",false,false,null,null,null,null,null,null);
		arr[2]=new CabService("Viman Nagar",true,true,"Nitin Sane","Prakash Salve","7766334522","78675576678","MH12 DK2276","MH12 CD2003");
		arr[3]=new CabService("JM Road",true,true,"Kartik Kasane","Pradip Patil","9091807567","89886517918","MH12 JK3276","MHEF2003");
		arr[4]=new CabService("FC road",true,true,"Gopi Warale","Suresh Wetal","8822323893","9544331565","MH12 LS8856","MH12 GH2003");
		arr[5]=new CabService("Dagduseth Halwai",true,true,"Sanjan Kolhe","Rajesh Yeole","9123345712","9563424354","MH12 MS3457","MH12 IJ2003");
		arr[6]=new CabService("Parvati",false,false,null,null,null,null,null,null);
		arr[7]=new CabService("Railway Station",true,true,"Vishal Admane","Adhirat Gade","7890212334","9782826268","MH12 CQ3426","MH12 KL2003");
		arr[8]=new CabService("Shaniwar wada",true,true,"Alpesh Sathe","Aditya Ghule","7721345678","9876543210","MH12 BH6576","MH12 MN2003");
		arr[9]=new CabService("Deccan",true,true,"Kedar Akle","Nitin Lahane","8890564789","9123456783","MH12 BN8967","MH12 OP2003");
		arr[10]=new CabService("Swargate",false,false,null,null,null,null,null,null);
		arr[11]=new CabService("Shivaji Nagar",true,true,"Kalpesh Yadav","Satish More","8765235487","6789454532","MH12 ND3456","MH12 QR2003");
	}

	void insert(int v1,int v2,double w){ //insert function
		node new_node=new node(v2,w);//passing second vertex to node
		if(head[v1]==null) {     //insert at start
			head[v1] = new_node;
		}
		else{
			node ptr=head[v1];
			while(ptr.next!=null) {  //traversing and adding nodes
				ptr = ptr.next;
			}
			ptr.next = new_node;
		}
	}
	void createUsingAdjList(){      //creation using adjacency list
		insert(0,1,5);
		insert(1,0,5);
		insert(0,8,2);
		insert(8,0,2);
		insert(0,2,11.8);
		insert(2,0,11.8);
		insert(0,6,1.2);
		insert(6,0,1.2);
		insert(0,5,2);
		insert(5,0,2);
		insert(0,4,3);
		insert(4,0,3);
		insert(1,11,8.5);
		insert(11,1,8.5);
		insert(1,10,6.2);
		insert(10,1,6.2);
		insert(1,9,5);
		insert(9,1,5);
		insert(1,8,6);
		insert(8,1,6);
		insert(1,3,8);
		insert(3,1,8);
		insert(2,9,13.2);
		insert(9,2,13.2);
		insert(2,8,10.2);
		insert(8,2,10.2);
		insert(2,6,14.6);
		insert(6,2,14.6);
		insert(2,7,7.2);
		insert(7,2,7.2);
		insert(3,11,2.5);
		insert(11,3,2.5);
		insert(3,4,1);
		insert(4,3,1);
		insert(4,5,2.6);
		insert(5,4,2.6);
		insert(5,7,2.9);
		insert(7,5,2.9);
		insert(6,7,6);
		insert(7,6,6);
		insert(9,10,2.3);
		insert(10,9,2.3);
	}

	void displayAdjList() //to display adjacency list
	{
		System.out.println("\nDisplayed adjacency list: ");
		for(int i=0;i<12;i++)
		{
			if(head[i]==null) {   //if doesn't have any edge,print only that i
				System.out.println(i);
			}
			else
			{
				System.out.println("__");
				node ptr=head[i];
				System.out.print(arr[i].name);
				while(ptr!=null)   //traversing all nodes till ptr is not equal to null
				{
					System.out.print(" -> "+arr[ptr.location].name+" "+ptr.weight);
					ptr=ptr.next;
				}
				System.out.println();
			}
		}
	}
	String toString(char[] otp) {
		//to convert character array to string
		String str=new String(otp);

		return str;
	}
	void map_details() {
		ArrayList<ArrayList<node> > graph= new ArrayList<>();//initializing the arraylist
		int i,j;
		int pos=0;
		int pos1=0;
		double min = 0;
		boolean b=false;

		for (int k = 0; k < 12; k++) {
			//adding all the vertices in the arraylist
			graph.add(new ArrayList<>());
		}
		String Loc=t2.getText();
		String des =t3.getText();

		for(int s=0;s<12;s++) {
			for(int r=0;r<12;r++) {
				//to ignore the case-sensitivity of input
				if(arr[s].name.equalsIgnoreCase(Loc) && arr[r].name.equalsIgnoreCase(des)) {
					b=true;
				}
			}
		}
		if(b) {
			if(j98!=null) {
				f1.remove(j98);
			}

			for(i=0;i<12;i++) {

				if(arr[i].name.equalsIgnoreCase(Loc)) {
					pos=i;
					break;
				}
			}
			for(j=0;j<12;j++) {
				if(arr[j].name.equalsIgnoreCase(des)) {
					pos1=j;
					break;
				}
			}
			List<List<node> > adj
			= new ArrayList<List<node> >();
			// Initialize list for every node
			for (int m = 0; m< 12; m++) {
				List<node> item = new ArrayList<node>();
				adj.add(item);
			}
			//assigning weights to the edges
			adj.get(0).add(new node(1,5));
			adj.get(0).add(new node(4,3));
			adj.get(0).add(new node(5,2));
			adj.get(0).add(new node(6,1.2));
			adj.get(0).add(new node(2,11.8));
			adj.get(0).add(new node(8,2));
			adj.get(1).add(new node(0,5));
			adj.get(1).add(new node(8,6));
			adj.get(1).add(new node(9,5));
			adj.get(1).add(new node(3,8));
			adj.get(1).add(new node(11,8.5));
			adj.get(1).add(new node(10,6.2));
			adj.get(2).add(new node(9,13.2));
			adj.get(2).add(new node(8,10.2));
			adj.get(2).add(new node(0,11.8));
			adj.get(2).add(new node(6,14.6));
			adj.get(2).add(new node(7,7.2));
			adj.get(3).add(new node(4,1));
			adj.get(3).add(new node(1,8));
			adj.get(3).add(new node(11,2.5));
			adj.get(4).add(new node(3,1));
			adj.get(4).add(new node(0,3));
			adj.get(4).add(new node(5,2.6));
			adj.get(5).add(new node(4,2.6));
			adj.get(5).add(new node(0,2));
			adj.get(5).add(new node(7,2.9));
			adj.get(6).add(new node(7,6));
			adj.get(6).add(new node(0,1.2));
			adj.get(6).add(new node(2,14.6));
			adj.get(7).add(new node(6,6));
			adj.get(7).add(new node(5,2.9));
			adj.get(7).add(new node(2,7.2));
			adj.get(8).add(new node(2,10.2));
			adj.get(8).add(new node(1,6));
			adj.get(8).add(new node(0,2));
			adj.get(9).add(new node(10,4.3));
			adj.get(9).add(new node(1,5));
			adj.get(9).add(new node(2,13.2));
			adj.get(10).add(new node(9,4.3));
			adj.get(10).add(new node(1,6.2));
			adj.get(11).add(new node(1,8.5));
			adj.get(11).add(new node(3,2.5));
			dijkstra(adj, pos);

			j7=new JLabel("The shortest distance from "+arr[pos].name + " to " + arr[pos1].name + " is " + dist[pos1]);
			cab_fare=dist[pos1]*15;//calculation of cab/auto fare
			auto_fare=dist[pos1]*10;
			min=dist[0];
			for(int l=0;l<dist.length;l++){
				if(min>dist[l] && arr[l].cab){
					System.out.println("*");
					min=dist[l];
				}
			}
			for(int s=0;s<12;s++){
				if (dist[s]==min){
					position=s;
				}
			}
			System.out.println();
			System.out.println();
			j10=new JLabel("Rs."+auto_fare);
			j11=new JLabel("Rs."+cab_fare);
			System.out.println();
			j12=new JLabel("Kindly select your option");
			System.out.println();
			j13=new JLabel("To book an auto,press 1\nTo book a cab press 2");
			action1();
			char[] otp=generateOTP(4);

			j15=new JLabel("Cab from the nearest location has been booked for you,Here are your cab details");
			j16=new JLabel("Driver Name: "+arr[position].auto_driver_name);
			j17=new JLabel("Phone No.:"+arr[position].auto_ph_no);
			j18=new JLabel("Cab No.: "+arr[position].auto_no);
			j19=new JLabel("Your OTP for this ride:    "+toString(otp));
			j20=new JLabel("Total fare for your ride is: "+auto_fare);
			j21=new JLabel("Have a safe Journey!!!");
			j33=new JLabel("Hello , "+t.getText());
			j23=new JLabel("Cab from the nearest location has been booked for you,Here are your cab details");
			j24=new JLabel("Driver Name: "+arr[position].cab_driver_name);
			j25=new JLabel("Phone No.:"+arr[position].cab_ph_no);
			j26=new JLabel("Cab No.: "+arr[position].cab_no);
			j27=new JLabel("Your OTP for this ride:    "+toString(otp));

			j28=new JLabel("Total fare for your ride is: "+cab_fare);
			j29=new JLabel("Have a safe Journey!!!");

		}else {
			j98=new JLabel("*PLEASE ENTER THE VALID LOCATION AND DESTINATION!");
			j98.setBounds(200,420,600,40);
			j98.setFont(new Font(Font.SERIF,Font.BOLD,17));
			j98.setForeground(Color.red);
			j98.setVisible(true);
			f1.add(j98);
		}
	}

	char[] generateOTP(int length){//auto OTP generation
		String number= "12345678900";
		Random random=new Random();
		char []otp =new char[length];
		for (int x=0;x<length;x++){
			otp[x]=number.charAt(random.nextInt(number.length()));

		}
		return otp;
	}
	// function to find  shortest distance of all
	// vertices from source vertex S.
	public void dijkstra(List<List<node>> adj, int src){
		// Number of vertices
		pq = new PriorityQueue<node>(12, new node());
		this.adj = adj;
		for (int i = 0; i < 12; i++)
			dist[i] = Integer.MAX_VALUE;

		// add source node to priority queue
		pq.add(new node(src, 0));

		// distance from source to source is 0
		dist[src] = 0;

		while (settled.size() != 12) {

			// Terminating condition when priority queue is empty
			if (pq.isEmpty())
				return;

			// Removing minimum distance node
			int u = pq.remove().location;

			// Adding node whose distance is final
			if (settled.contains(u))

				continue;

			// no need to call e_Neighbors(u) if u is already present in settled set.
			settled.add(u);
			e_Neighbours(u);

		}

	}

	// To process all the neighbors of present node
	private void e_Neighbours(int u)
	{
		double edgeDistance = -1;
		double newDistance = -1;
		// all neighbors of v
		for (int i = 0; i < adj.get(u).size(); i++) {
			node v = adj.get(u).get(i);

			// If current node hasn't already been processed
			if (!settled.contains(v.location)) {
				edgeDistance = v.weight;
				newDistance = dist[u] + edgeDistance;

				// If new distance is cheaper in cost
				if (newDistance < dist[v.location])

					dist[v.location] = newDistance;
				settled.remove(v);
				// Add the current node to the queue
				pq.add(new node(v.location, dist[v.location]));
			}
		}
	}

	void action1() {//for second window to book cab/auto after clicking next
		j7.setBounds(550,440,500,40);
		j7.setFont(new Font(Font.SERIF,Font.PLAIN,18));
		j10.setBounds(620,700,100,40);
		j10.setFont(new Font(Font.SERIF,Font.PLAIN,18));
		j11.setBounds(820,700,100,40);
		j12.setBounds(640,540,460,40);
		j11.setFont(new Font(Font.SERIF,Font.PLAIN,18));
		j12.setFont(new Font(Font.SERIF,Font.BOLD,18));
		f1.add(j7);
		f1.add(j10);
		f1.add(j11);
		f1.add(j12);
		b2=new JButton();
		b2.setText("AUTO");
		b2.setBounds(600,630,90,40);
		f1.add(b2);
		b2.addActionListener(e -> action2());
		JButton b3=new JButton();
		b3.setText("CAB");
		b3.setBounds(800,630,90,40);
		f1.add(b3);
		b3.addActionListener(e -> action3());
		JButton b5=new JButton();
		b5.setText("BACK");
		b5.setBounds(1400,630,90,40);
		f1.add(b5);
		b5.addActionListener(e -> f1.setVisible(false));
	}
	void action2() {  //window to show the AUTO details after booking
		f1.setVisible(false);
		ImageIcon login3;
		login3=new ImageIcon(getClass().getResource("city_maps.jpg"));
		JLabel im3=new JLabel(login3);
		im3.setBounds(900,0,610,850);
		f2=new JFrame();
		JLabel j14=new JLabel("----------------------------YOUR AUTO DETAILS ----------------------------");
		j14.setBounds(0, 190, 700, 20);
		j14.setFont(new Font(Font.SANS_SERIF,Font.ROMAN_BASELINE,20));
		f2.add(j14);
		j33.setBounds(100,240,600,40);
		j33.setFont(new Font(Font.SERIF,Font.BOLD,22));
		f2.add(j33);
		j15.setBounds(100,270,1000,40);
		j15.setFont(new Font(Font.SERIF,Font.PLAIN,22));
		j16.setBounds(100,300,460,40);
		j16.setFont(new Font(Font.SERIF,Font.PLAIN,22));
		j17.setBounds(100,330,460,40);
		j17.setFont(new Font(Font.SERIF,Font.PLAIN,22));
		j18.setBounds(100,360,460,40);
		j18.setFont(new Font(Font.SERIF,Font.PLAIN,22));
		j19.setBounds(100,390,460,40);
		j19.setFont(new Font(Font.SERIF,Font.PLAIN,22));
		j20.setBounds(100,420,460,40);
		j20.setFont(new Font(Font.SERIF,Font.PLAIN,22));
		j21.setBounds(100,450,460,40);
		j21.setFont(new Font(Font.SERIF,Font.PLAIN,22));
		JLabel jj=new JLabel("IF YOU WANT TO CANCEL RIDE CLICK ON CANCEL");
		jj.setBounds(100,550,700,40);
		jj.setFont(new Font(Font.SERIF,Font.PLAIN,20));
		f2.add(jj);
		JButton b4=new JButton();
		b4.setText("CANCEL");
		b4.setBounds(100,600,250,40);
		f2.add(b4);
		b4.addActionListener(e -> f2.setVisible(false));
		f2.add(im3);
		f2.add(j15);
		f2.add(j16);
		f2.add(j17);
		f2.add(j18);
		f2.add(j19);
		f2.add(j20);
		f2.add(j21);
		f2.setLayout(null);
		f2.setSize(1600,850);
		f2.setVisible(true);
	}
	void action3() {  //window to show the CAB details after booking
		f1.setVisible(false);
		ImageIcon login4;
		login4=new ImageIcon(getClass().getResource("city_maps.jpg"));
		JLabel im4=new JLabel(login4);
		im4.setBounds(900,0,610,850);

		f2=new JFrame();
		JLabel j31=new JLabel("----------------------------YOUR CAB DETAILS ----------------------------");
		j31.setBounds(0, 190, 700, 20);
		j31.setFont(new Font(Font.SANS_SERIF,Font.ROMAN_BASELINE,20));
		f2.add(j31);
		j33.setBounds(100,240,600,40);
		j33.setFont(new Font(Font.SERIF,Font.BOLD,22));
		f2.add(j33);
		j23.setBounds(100,270,1000,40);
		j23.setFont(new Font(Font.SERIF,Font.PLAIN,22));
		j24.setBounds(100,300,460,40);
		j24.setFont(new Font(Font.SERIF,Font.PLAIN,22));
		j25.setBounds(100,330,460,40);
		j25.setFont(new Font(Font.SERIF,Font.PLAIN,22));
		j26.setBounds(100,360,460,40);
		j26.setFont(new Font(Font.SERIF,Font.PLAIN,22));
		j27.setBounds(100,390,460,40);
		j27.setFont(new Font(Font.SERIF,Font.PLAIN,22));
		j28.setBounds(100,420,460,40);
		j28.setFont(new Font(Font.SERIF,Font.PLAIN,22));
		j29.setBounds(100,450,460,40);
		j29.setFont(new Font(Font.SERIF,Font.PLAIN,22));
		JButton b3=new JButton();
		JLabel jj=new JLabel("IF YOU WANT TO CANCEL RIDE CLICK ON CANCEL");
		jj.setBounds(100,550,700,40);
		jj.setFont(new Font(Font.SERIF,Font.PLAIN,20));
		f2.add(jj);
		b3.setText("CANCEL");
		b3.setBounds(100,600,250,40);
		f2.add(b3);
		b3.addActionListener(e -> f2.setVisible(false));
		f2.add(im4);
		f2.add(j23);
		f2.add(j24);
		f2.add(j25);
		f2.add(j26);
		f2.add(j27);
		f2.add(j28);
		f2.add(j29);
		f2.setLayout(null);
		f2.setSize(1600,850);
		f2.setVisible(true);
	}
	void action() {//to choose the destination and location which is second window
		String str2=t1.getText();
		String str3=t.getText();
		if(!str2.isEmpty() && !str3.isEmpty() ) {
			f.setVisible(false);
			f1=new JFrame();
			JLabel j100=new JLabel("SELECT LOCATION FROM BELOW :");
			j100.setFont(new Font(Font.SERIF,Font.BOLD,18));
			j100.setBounds(100,10,700,150);
			j100.setForeground(Color.ORANGE);
			f1.add(j100);
			JLabel j3=new JLabel("1.Saras Baugh      2.Cummins      3.Viman Nagar      4.JM Road      5.FC road      6.Dagduseth Halwai");
			j3.setFont(new Font(Font.SERIF,Font.PLAIN,18));
			j3.setBounds(400,100,800,50);
			f1.add(j3);
			JLabel j4=new JLabel("7.Parvati     8.Railway Station      9.Shaniwar wada      10.Shivaji Nagar      11.Deccan      12.Swargate");
			j4.setFont(new Font(Font.SERIF,Font.PLAIN,18));
			j4.setBounds(400,100,800,150);
			f1.add(j4);
			JLabel j5=new JLabel("Location: ");
			j5.setBounds(600,200,100,150);
			j5.setFont(new Font(Font.SERIF,Font.PLAIN,20));
			f1.add(j5);
			t2=new JTextField(15);
			t2.setBounds(700,260,150,30);
			f1.add(t2);
			JLabel j6=new JLabel("Destination: ");
			j6.setBounds(590,260,150,150);
			j6.setFont(new Font(Font.SERIF,Font.PLAIN,20));
			f1.add(j6);
			t3=new JTextField(15);
			t3.setBounds(700,320,150,30);
			f1.add(t3);
			JButton b1=new JButton();
			b1.setText("Next");
			b1.setBounds(700,370,120,40);
			f1.add(b1);
			b1.addActionListener(e -> map_details());
			f1.setLayout(null);
			f1.setSize(1600,800);
			f1.setVisible(true);
		}
		else {
			JLabel j99=new JLabel("*enter username and phone number");//to display the warning
			j99.setBounds(620,450,500,150);
			j99.setFont(new Font(Font.SERIF,Font.BOLD,17));
			j99.setForeground(Color.red);
			f.add(j99);
		}
	}
	void user(){//log in window foe the user(main)
		JLabel label=new JLabel();
		JLabel j1=new JLabel("UserName: ");
		j1.setBounds(600,220,200,150);
		j1.setFont(new Font(Font.SERIF,Font.BOLD,25));
		j1.setForeground(Color.black);
		f.add(j1);
		t=new JTextField(15);
		t.setBounds(730,280,150,30);
		f.add(t);
		JLabel j2=new JLabel("Phone No: ");
		j2.setBounds(600,300,200,150);
		j2.setFont(new Font(Font.SERIF,Font.BOLD,25));
		f.add(j2);
		t1=new JTextField(10);
		t1.setBounds(730,360,150,30);
		f.add(t1);
		JButton b=new JButton();
		b.setText("Next");
		b.setBounds(700,450,100,50);
		f.add(b);
		t1.addKeyListener(new KeyAdapter() {//adding restriction to the input
			public void keyPressed(KeyEvent ke) {
				String value = t1.getText();
				int l = value.length();
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					if(l<10) {
						t1.setEditable(true);
						label.setText("");
					}else {
						t1.setEditable(false);
					}
				} else {
					//to enable the use of backspace button and delete button
					if(ke.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || ke.getExtendedKeyCode()==KeyEvent.VK_DELETE ) {
						t1.setEditable(true);
					}
					else {
						t1.setEditable(false);
						label.setText("* Enter only numeric digits(0-9)");
					}
				}
			}
		});
		b.addActionListener(e -> action());
	}
}
public class EasyGo {//main class of our project
	EasyGo(){
		ImageIcon login;
		CabService CS=new CabService();
		login=new ImageIcon(getClass().getResource("logo_2.jpg"));
		JLabel im=new JLabel(login);
		im.setBounds(0,0,1600,150);
		JLabel ss =new JLabel("EasyGo...!!");
		ss.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,50));
		ss.setForeground(Color.BLACK);
		CS.f.add(im);
		ss.setBounds(620,150,550,120);
		CS.f.add(ss);
		CS.user();
		CS.f.setSize(1600,850);
		CS.f.setLayout(null);
		CS.f.setVisible(true);
		CS.details();
		CS.createUsingAdjList();
		CS.displayAdjList();
	}
	public static void main(String[] args) {//main function
		EasyGo i=new EasyGo();
	}

}