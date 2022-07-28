import java.util.*;
import java.io.*;
import java.util.regex.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PizzaParlour {
    public static boolean isValid(String s)
    {

        Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(s);
        return (m.matches());
    }
    public String encrypt(String input) throws NoSuchAlgorithmException , IOException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger BigInt = new BigInteger(1,messageDigest);
        return BigInt.toString(16);

    }
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        PizzaParlour encryptor = new PizzaParlour();
        String password = "Admin123";


        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        //this portal is for customer and User also so 1. choice for
        Menu m = new Menu();
        Pizza p2=new Pizza("V_MARGHERITA","Cheesy classic",99,199,395);
        Pizza p1=new Pizza("V_FARMHOUSE","Onion, Capsicum, Grilled Mushroom & Tomato",215,395,595);
        Pizza p3=new Pizza("N_CHICKEN GOLDEN DELIGHT","Barbeque chicken, golden corn",235,450,695);
        Pizza p4 = new Pizza("V_CHEESE & CORN","Cheese & Juicy Tomato",165,305,495);
        Pizza p5 = new Pizza("V_FRESH VEGGIE","Onion &Capsicum",185,335,535);
        m.create(p5);
        Pizza p6 = new Pizza("V_PEPPY PANNER","Panner, Capsicum & Red Paprika",215,395,595);
        m.create(p6);
        Pizza p7 = new Pizza("N_CHICKEN SAUSAGE","Chicken Sausage & Cheese",165,305,495);
        m.create(p7);
        Pizza p8 = new Pizza("N_PEPPER BARBEQUE CHICKEN","Pepper Barbeque Chicken & Onion",215,395,595);
        m.create(p8);
        m.create(p1);
        m.create(p2);
        m.create(p3);
        m.create(p4);
        Pizza p9 = new Pizza("N_INDI CHICKEN TIKKA","Chicken Tikka, Onion, Red Paprika, Makhani Sauce",305,570,835);
        m.create(p9);
        Pizza p10 = new Pizza("N_NON VEG SUPREME","Black Olive,Onion,Capsicum,Grilled Mushroom",305,570,835);
        m.create(p10);
        Pizza p11 = new Pizza("V_DELUX VEGGIE","Onion,Capsicum,Grilled Mushroom & Golden Corn",235,450,695);
        m.create(p11);
        //CustomerList cust = new CustomerList();
        //Order o = new Order();
        OrderInfo custorder = new OrderInfo();
        int choice = 0;
        int ch=0;
        int ordernumber =0;
        int c2=0;

        do {
            System.out.println(ConsoleColors.BLUE_BRIGHT+"Please select appropriate choice: \n\t\t1.Company Employee\n\t\t2.Customer\n\t\t3.Exit"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW_BRIGHT+"Enter your choice: "+ConsoleColors.RESET);
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    String ID="Admin";
                    String Pass = "Admin123";
                    //sc.nextLine();
                    System.out.println(ConsoleColors.YELLOW_ITALIC+"Enter your Id:");
                    String id = sc.next();
                    System.out.println("Enter your Password:"+ConsoleColors.RESET);
                    String pas =sc.next();

                        if(ID.equals(id) && Pass.equals(pas)) {
                            do {
                                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"---Login successful---"+ConsoleColors.RESET);
                                System.out.println(ConsoleColors.BLUE_BRIGHT+"\t\t0.Exit\n\t\t1.Add new pizza \n\t\t2.display menu\n\t\t3.display all orders\n\t\t4.display all deliverd orders"+ConsoleColors.RESET );
                                ch = sc.nextInt();
                                switch(ch) {
                                    case 1:
                                        m.accept();
                                        System.out.println("Pizza details are added");
                                        break;

                                    case 2:
                                        System.out.println(ConsoleColors.BOXING+"PIZZA \t\t\t\t\t\t\tRegular \t Mediumm \t Large"+ConsoleColors.RESET);
                                        m.display(m.root);
                                        break;
                                    case 3:
                                        custorder.AllOrders();
                                        break;
                                    case 4:
                                        custorder.view_Ex_Orders();
                                        break;
                                }
                            }while(ch!=0);

                        }else {
                            System.out.println(ConsoleColors.RED_ITALIC+"----Invalid ID/Password -----"+ConsoleColors.RESET);
                        }



//                    System.out.println(ID);


                    break;

                case 2:
                    do{
                        System.out.println(ConsoleColors.BLUE_BRIGHT+"\t\t0.Exit \n\t\t1.Display Menu\n\t\t2.Place order\n\t\t3.Deliver order\n\t\t4.view order "+ConsoleColors.RESET);
                        ch = sc.nextInt();

                        switch(ch) {
                            case 1:
                                System.out.println(ConsoleColors.BOXING+"PIZZA \t\t\t\t\t\t\t\tRegular \t Mediumm \t Large"+ConsoleColors.RESET);
                                m.display(m.root);

                                break;
                            case 2:
                                int ch1 = 0;

                                System.out.println(ConsoleColors.YELLOW+"Enter your name:");
                                sc.nextLine();
                                String nm=sc.nextLine();
                                System.out.println("Enter your mobile number:"+ConsoleColors.RESET);
                                String num=sc.nextLine();

                                if(isValid(num)==true){

                                }
                                else{
                                    while(isValid(num)!=true){
                                        System.out.println(ConsoleColors.RED_ITALIC+"Please Enter a valid number"+ConsoleColors.RESET);
                                        num=sc.nextLine();
                                    }

                                }
//                                num.matches("[0-9]+") && num.length() == 10

                                System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+"* Welcome "+nm+" *"+ConsoleColors.RESET);
                                //PizzaList[] Npizza=new PizzaList[];
                                ArrayList<PizzaList> Npizza=new ArrayList<>();

                                System.out.println(ConsoleColors.YELLOW+"Enter pizza name: ");
                                String pname = sc.nextLine();
                                Pizza temp =m.search(pname);
                                custorder.placeOrder(pname ,temp,nm,num,Npizza);
                                do{
                                    System.out.println(ConsoleColors.WHITE_ITALIC+"Do you want to add more pizza to your crate yes(1) and No(0):"+ConsoleColors.RESET);
                                    c2= sc.nextInt();
                                    sc.nextLine();
                                    if(c2==0){
                                        break;
                                    }
                                    System.out.println(ConsoleColors.YELLOW+"Enter pizza name: ");
                                    pname = sc.nextLine();
                                    temp = m.search(pname);
                                    custorder.addpizza(pname, temp, Npizza);
                                }while(c2==1);
                                int review;
                                System.out.println(ConsoleColors.CYAN_BOLD+"Enter your review:\n1 for 1 star and so on..."+ConsoleColors.RESET);
                                review=sc.nextInt();
                                if(review==1)
                                {
                                    System.out.println("\u263A");

                                    System.out.println(ConsoleColors.CYAN_BOLD+ "Thankyou for your review :)"+ConsoleColors.RESET);
                                }
                                else if(review==2)
                                {
                                    System.out.println("\u263A \u263A");
                                    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Thankyou for your review :)"+ConsoleColors.RESET);
                                }
                                else if(review==3)
                                {
                                    System.out.println("\u263A \u263A \u263A");
                                    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Thankyou for your review :)"+ConsoleColors.RESET);
                                }
                                else if(review==4)
                                {
                                    System.out.println("\u263A \u263A \u263A \u263A");
                                    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Thankyou for your review :)"+ConsoleColors.RESET);
                                }
                                else if(review==5)
                                {
                                    System.out.println("\u263A \u263A \u263A \u263A \u263A");
                                    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Thankyou for your review :)"+ConsoleColors.RESET);
                                }
                                else
                                {
                                    System.out.println(ConsoleColors.RED+"invalid"+ConsoleColors.RESET);
                                }
                                break;



                            case 3:
                                custorder.deliverOrder();
                                break;
                            case 4:
                                custorder.viewOrder();
                                break;

                        }
                    }while(ch!=0);
                    break;
            }
        }while(choice !=3);


    }



}