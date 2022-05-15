import java.util.*;
public class Menu {
    Scanner sc= new Scanner(System.in);
    Pizza root;
    Pizza parent;

    public void accept() {
        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT+"Enter Pizza name with tag as V or N: "+ConsoleColors.RESET);
        String pname = sc.next();
        pname += sc.nextLine();
        System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter details: "+ConsoleColors.RESET);
        String details = sc.next();
        details +=sc.nextLine();
        System.out.println(ConsoleColors.YELLOW_BOLD+"Enter price for small size pizza: "+ConsoleColors.RESET);
        int sprice = sc.nextInt();
        System.out.println(ConsoleColors.YELLOW+"Enter price for medium size pizza: "+ConsoleColors.RESET);
        int mprice = sc.nextInt();
        System.out.println(ConsoleColors.YELLOW_ITALIC+"Enter price for large size pizza: "+ConsoleColors.RESET);
        int lprice = sc.nextInt();
        Pizza p = new Pizza(pname.toUpperCase(), details, sprice, mprice, lprice);
        create(p);
    }

    public void create(Pizza new_Pizza) {

        if(root==null) {
            root=new_Pizza;
            //System.out.println("root pizza is added");
        }else {
            Pizza ptr=root;
            while(ptr!=null) {
                if(ptr.name.compareTo(new_Pizza.name)<0) {
                    if(ptr.right==null) {
                        ptr.right=new_Pizza;
                        //System.out.println("Pizza is added to right");
                        break;
                    }else {
                        ptr=ptr.right;
                    }
                }else if(ptr.name.compareTo(new_Pizza.name)>0) {
                    if(ptr.left==null) {
                        ptr.left=new_Pizza;
                        // System.out.println("Pizza is added to left");
                        break;
                    }else {
                        ptr=ptr.left;
                    }
                }
            }
        }
    }

    public Pizza search(String key) {
        int flag=0;
        if(root == null) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Sorry...Stock is Empty"+ConsoleColors.RESET);
            return null;
        }
        else {
            Pizza ptr = root;
            while(ptr!=null) {
                if(ptr.name.compareTo(key)<0) {
                    parent=ptr;
                    ptr=ptr.right;
                }
                else if(ptr.name.compareTo(key)>0) {
                    parent=ptr;
                    ptr=ptr.left;
                }else {
                    flag=1;
                    //System.out.println("\nPIZZA \t\t\t\t Regular \t Medium \t Large");
                    //System.out.println("\nPizza Name"+ptr.name);
                    //System.out.print("\tRegular("+ptr.S_price+")"+" "+"Medium("+ptr.M_price+")"+"Large("+ptr.L_price+")");
                    //System.out.println("Pizza Details:" + ptr.details);
                    System.out.println(ConsoleColors.BOXING+"PIZZA \t\t\t\t\t\t\t\t\tRegular \t Medium \t Large"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+"\n"+ptr.name+"\n"+ptr.details+ConsoleColors.RESET);//
                    System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+" \t\t\t\t\t\t\t\t\t  "        +ptr.S_price+ " \t \t \t " + ptr.M_price+ " \t \t  " + ptr.L_price+"\n"+ConsoleColors.RESET);
                    break;
                }
            }

            if(flag==0) {
                System.out.println(ConsoleColors.RED+"Sorry...This Pizza is not available"+ConsoleColors.RESET);
                return null;
            }else {
                return ptr;
            }
        }
    }
    public void display(Pizza localRoot) {
        if(localRoot!=null) {

            display(localRoot.left);
//	       System.out.println("Pizza Name"+localRoot.name);
//	       System.out.println("\nRegular("+localRoot.S_price+")"+" "+"Medium("+localRoot.M_price+")"+"Large("+localRoot.L_price+")");
//	       System.out.println("Pizza Details:" + localRoot.details);
            System.out.println("\n"+localRoot.name+"\n"+localRoot.details);//
            System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT+" \t\t\t\t\t\t\t\t  " +localRoot.S_price+ " \t \t  " + localRoot.M_price+ " \t \t  " + localRoot.L_price+"\n"+ConsoleColors.RESET);
            //System.out.println(localRoot.details);
            display(localRoot.right);
        }
    }
}

