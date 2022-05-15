import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class OrderPizza {
    String name;
    String number;
    ArrayList<PizzaList> Orderlist;
    //PizzaList[] Orderlist;
    public OrderPizza(String name, String number, ArrayList<PizzaList> orderlist) {
        super();
        this.name = name;
        this.number = number;
        Orderlist = orderlist;
    }
}


class OrderInfo {
    Scanner sc = new Scanner(System.in);
    Menu mn = new Menu();
    int front,rear;
    int count=0;
    int maxsize;
    OrderPizza order;
    int flag=0;
    int q_size=50;
    //List to store the pizza orders
    OrderPizza order_list[]=new OrderPizza[50];

    public OrderInfo(){
        front=rear=-1;
        maxsize=order_list.length;
    }
    boolean isFull()   //Checking whether the queue is full or not
    {
        if(rear==maxsize-1){
            return true;
        }
        else{
            return false;
        }
    }
    boolean isEmpty()  //Checking whether the queue is empty or not
    {
        if(front>rear || rear==-1){
            return true;
        }else{
            return false;
        }
    }

    void PizzaOrder(String pname,Pizza temp,String nm,String num,ArrayList<PizzaList> Npizza)        //Taking information of pizza from user
    {

        System.out.println(ConsoleColors.YELLOW+"which size do you want?"+ConsoleColors.RESET);
        String s=sc.nextLine().toLowerCase();
        int pp=0;
        if(s.equals("regular")) {
            pp=temp.S_price;
        }
        else if(s.equals("medium")) {
            pp=temp.M_price;
        }
        else if(s.equals("large")) {
            pp=temp.L_price;
        }
        Npizza.add(new PizzaList(pname,pp,s));
        OrderPizza p=new OrderPizza(nm,num,Npizza);
        order_list[rear]=p;
        count=Npizza.size();
    }
    public void placeOrder(String pname,Pizza temp,String nm,String num,ArrayList<PizzaList> Npizza)            //Enqueue
    {

        if(isFull())
        {
            System.out.println(ConsoleColors.RED_BOLD+"sorry can't place the order"+ConsoleColors.RESET);
            return;
        }else if(front==-1 && rear==-1){
            front=rear=0;
            PizzaOrder( pname, temp, nm, num, Npizza);
        }else{
            this.rear = this.rear +1;
            PizzaOrder(pname, temp, nm, num, Npizza);
        }
    }

    void addpizza(String pname,Pizza temp,ArrayList<PizzaList> Npizza){
        System.out.println(ConsoleColors.YELLOW+"which size do you want?"+ConsoleColors.RESET);
        String s=sc.nextLine().toLowerCase();
        int pp=0;
        if(s.equals("regular")) {
            pp=temp.S_price;
        }
        else if(s.equals("medium")) {
            pp=temp.M_price;
        }
        else if(s.equals("large")) {
            pp=temp.L_price;
        }
        Npizza.add(new PizzaList(pname,pp,s));
        count=Npizza.size();
    }


    ArrayList<OrderPizza> Ex_Order=new ArrayList<>();
    public void deliverOrder()          //Dequeue
    {
        if(isEmpty())
        {
            System.out.println(ConsoleColors.RED+"No orders.."+ConsoleColors.RESET);
            return;
        }
        else{
            Ex_Order.add(order_list[front]);
            front=front+1;
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Order delivered successfully"+ConsoleColors.RESET);
        }
    }

    public void AllOrders()             //Display of all orders
    {
        if(!isEmpty()) {
            for(int j=front;j<=rear;j++) {
                System.out.println(ConsoleColors.RED_ITALIC+"Name:"+order_list[j].name+ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED_ITALIC+"Phone Number:"+order_list[j].number+ConsoleColors.RESET);
                System.out.println(ConsoleColors.WHITE_UNDERLINED+"Order:"+ConsoleColors.RESET);


                for(int i=0;i<order_list[j].Orderlist.size();i++) {
                    System.out.println(ConsoleColors.CYAN+order_list[j].Orderlist.get(i)+ConsoleColors.RESET);

                }
            }
        }
        else{
            System.out.println(ConsoleColors.RED+"No orders to display...."+ConsoleColors.RESET);
        }

    }



    public void viewOrder() {
        if(isEmpty()) {
            System.out.println(ConsoleColors.RED+"No order to display...."+ConsoleColors.RESET);
        }else {
            double total=0;
            System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+"Name:"+order_list[rear].name);
            System.out.println("Phone Number:"+order_list[rear].number);
            System.out.println("Order:"+ConsoleColors.RESET);
            for(int i=0;i<order_list[rear].Orderlist.size();i++) {
                System.out.println((i+1));
                System.out.println(ConsoleColors.CYAN+order_list[rear].Orderlist.get(i)+ConsoleColors.RESET);
                total += order_list[rear].Orderlist.get(i).price;
            }
            System.out.println(ConsoleColors.WHITE_UNDERLINED+total+ConsoleColors.RESET);
            calculate_bill(total);
        }


    }
    public void calculate_bill(double total) {
        double cgst=0,sgst=0,finalTotal = 0;
        cgst = total*0.025;
        sgst = total*0.025;
        finalTotal = total + cgst+sgst;
        //Bill bill = new Bill(101,total,cgst,sgst, finalTotal);
        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+"\n\t\tORDER NUMBER: "+(rear+1)+ConsoleColors.RESET);
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter formatobj =DateTimeFormatter.ofPattern("dd/MM/yyyy hh.mm");

        String formatteddate = datetime.format(formatobj);
        System.out.println(ConsoleColors.WHITE_ITALIC+formatteddate + "      "+ConsoleColors.RESET);
        System.out.println("-----------------------------------");
        for(int i=0;i<count;i++) {
            System.out.println(order_list[rear].Orderlist.size()+"  "+order_list[rear].Orderlist.get(i));
        }
        System.out.println("\t\t\t " + "---------");
        System.out.println(ConsoleColors.WHITE_UNDERLINED+"SUBTOTAL \t\t\t "+ total);
        System.out.println("CGST # 2.5% \t\t\t"+ cgst);
        System.out.println("SGST # 2.5% \t\t\t "+ sgst+ConsoleColors.RESET);
        System.out.println("------------------------------------");
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"TOTAL: \t\t\t" + finalTotal+ConsoleColors.RESET);
        System.out.println("\t\t\t" + "---------");
    }

    public void view_Ex_Orders() {
        if(!Ex_Order.isEmpty()) {
            for (int i = 0; i < Ex_Order.size(); i++) {
                System.out.println(ConsoleColors.RED_ITALIC+ "Name:" + order_list[i].name+ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED_ITALIC+"Phone Number:" + order_list[i].number+ConsoleColors.RESET);
                System.out.println(ConsoleColors.WHITE_UNDERLINED+ "Order:"+ConsoleColors.RESET);
                for (int j = 0; j < order_list[i].Orderlist.size(); j++) {
                    System.out.println((j + 1));
                    System.out.println(ConsoleColors.CYAN+order_list[i].Orderlist.get(j)+ConsoleColors.RESET);

                }
            }
        }
        else{
            System.out.println(ConsoleColors.RED+"No orders to display...."+ConsoleColors.RESET);
        }


    }
}