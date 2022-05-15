import java.lang.*;
import java.util.Scanner;

public class Graph1
{

    // method to find the index of input city from cityName Array
    public static int findIndex(String[] arr, String t) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(t)) {
                return i;
            }
        }
        return -1;
    }


    static final int totalCities = 6;

    // Dijkstra Algorithm to find the minimum distance between 2 cities
    // graph is represented using the adjacency matrix representation
    int dijkstra(int[][] graph, int s, int d)
    {
        int[] distance = new int[totalCities];

        // spSet[j] will be true if vertex j is included in the shortest
        // path tree or the shortest distance from the source s to j is finalized
        Boolean[] visitedCities = new Boolean[totalCities];

        // Initializing all the distances as INFINITE and spSet[] as false
        for (int j = 0; j < totalCities; j++)
        {
            distance[j] = Integer.MAX_VALUE;
            visitedCities[j] = false;
        }

        // Distance from the source vertex to itself is always 0
        distance[s] = 0;

        // compute the shortest path for all the given vertices
        for (int cnt = 0; cnt < totalCities - 1; cnt++) {
            int ux = minimumDistance(distance, visitedCities);
            visitedCities[ux] = true;

            // Updating the distance value of the neighboring vertices of the chose vertex
            for (int vertex = 0; vertex < totalCities; vertex++)
                if (!visitedCities[vertex] && graph[ux][vertex] != -1 && distance[ux] != Integer.MAX_VALUE && distance[ux] + graph[ux][vertex] < distance[vertex]) {
                    distance[vertex] = distance[ux] + graph[ux][vertex];
                }
        }


        return distance[d];
    }


    // A utility method to compute the vertex with the distance value, which is minimum
    // from the group of vertices that has not been included yet
    //boolean array sptSet[] represents the set of vertices included in SPT(shortest path tree)
    int minimumDistance(int[] distance, Boolean[] spSet)
    {
        int m = Integer.MAX_VALUE, m_index = -1;
        for (int Vertex = 0; Vertex < totalCities; Vertex++)
        {
            if (!spSet[Vertex] && distance[Vertex] <= m)
            {
                m = distance[Vertex];
                m_index = Vertex;
            }
        }
        return m_index;
    }

//mode of transport
    static void Transport_Options(double distance){
        double train_cost = distance* 2;
        double road_cost = distance* 5;

        double Aplane_cost = distance* 10 + 1500;
        double Atrain_cost = distance* 2 + 1000;
        double Aroad_cost = distance* 5+ 500;

        double plane_time = Math.round(distance/600);
        double train_time = Math.round(distance/43.5);
        double road_time = Math.round(distance/35);
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("                   AEROPLANE         TRAIN              BUS    ");
        System.out.println("COST(Non A/C):    ---N/A---        Rs "+train_cost+"         Rs "+road_cost);
        System.out.println("COST(A/C):        Rs "+Aplane_cost+"       Rs "+Atrain_cost+"         Rs "+Aroad_cost);
        System.out.println("TIME:              "+plane_time+" hr           "+train_time+" hr           "+road_time+" hr");
        System.out.println("--------------------------------------------------------------------------------------");

    }
    //AC services
    public static char AC_Non_AC(){
        char choice;
        Scanner ch = new Scanner(System.in);
        System.out.println("❄️Do you prefer AC ?");
        System.out.println("    ->Enter Y/y for Yes");
        System.out.println("    ->Enter N/n for No");
        System.out.print("Your choice: ");
        choice = ch.next().charAt(0);

        return choice;
    }

    //Meals
    public static char meals(){
        char choice;
        Scanner ch = new Scanner(System.in);
        System.out.println("🍜   Do you want meals to be served during your ride ?");
        System.out.println("    ->Enter Y/y for Yes");
        System.out.println("    ->Enter N/n for No");
        System.out.print("Your choice: ");
        choice = ch.next().charAt(0);

        return choice;
    }
    // main method
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //initialize to -1
        int s;
        int d;

        String[] citiesName= {"Mumbai","Delhi","Bangalore","Hyderabad","Bhubaneswar","Assam" };
        /// arr[x][y] = - 1 means, there is no edge that connects the nodes x and y directly
        int[][] grph = new int[][]{
                {-1,1415,984,-1,-1,-1},
                {1415,-1,2174,1583,-1,2085},
                {984,2174,-1,576,-1,-1},
                {-1,1583,576,-1,1046,2549},
                {-1,-1,-1,1046,-1,1579},
                {-1,2085,-1,2549,1579,-1},
        };



        Graph1 obj = new Graph1();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Welcome to Just-Java Tour Services ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("                                💥💥💥 Traveling is the spice of life 💥💥💥");
        System.out.println("""
                🌐 Choose from an array of travelling packages in India that span across the length and breadth
                  of the  country, taking you into breathtaking tea estates, hill resorts to splendid backwater retreats.
                🌐 By booking your India tour with Just-Java you get to customise your holiday to suit your requirement, and  more
                  importantly can avail some attractive discounts and offers from time to time!!
                🌐 We provide services needed for the holiday, accommodation, transport, guides, tour leaders or resort  reps.""".indent(3));
        System.out.println("\nFollowing are the cities where our services are available: ");
        for(int i=0;i<6;i++){
            System.out.println("📌 "+citiesName[i]);
        }
        System.out.println("Enter start city: ");
        String start = sc.next();
        s = findIndex(citiesName,start);
        while (s == -1) {
            System.out.println("Please enter valid city name !");
            start = sc.next();
            s = findIndex(citiesName, start);
        }

        System.out.println("Enter destination city: ");
        String dest = sc.next();
        d = findIndex(citiesName,dest);
        while (d == -1) {
            System.out.println("Please enter valid city name !");
            dest = sc.next();
            d = findIndex(citiesName, dest);
        }

        int dist = obj.dijkstra(grph,s,d);
        System.out.println("\nThe shortest distance from "+start +" to "+ dest+" is : "+dist+" Km");
        System.out.println();

        System.out.print("Enter the number of people you want to book the tickets for: ");
        int no_of_people = sc.nextInt();
        System.out.println();
        Transport_Options(dist);
        System.out.println("\nEnter your preferable mode of transport: \n     ✈ Aeroplane \n     🚂 Train \n     🚍 Bus");
        System.out.print("Your choice: ");
        String mode=sc.next();
        System.out.println();
        switch (mode) {
            case "Bus", "bus" -> {
                System.out.println("By Bus ~~~");
                System.out.println("The total time required to reach your destination by bus is " + Math.round(dist / 35) + " Hrs");
                System.out.println();
                int cost2 = dist * 9;
                switch (AC_Non_AC()) {
                    case 'Y':
                    case 'y':
                        cost2 = cost2 + 2000;
                        break;
                    case 'n':
                    case 'N':
                        break;
                }
                System.out.println();
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("Your total bill is Rs " + cost2*no_of_people);
                System.out.println("--------------------------------------------------------------------------------------");
            }
            case "Aeroplane", "aeroplane" -> {
                System.out.println("By Aeroplane ~~~");
                System.out.println("The total time required to reach your destination by aeroplane is " + Math.round(dist / 600) + " Hrs");
                System.out.println();
                int cost1 = dist * 10 + 2250;
                switch (meals()) {
                    case 'n':
                    case 'N':
                        break;
                    case 'Y':
                    case 'y':
                        cost1 = cost1 + 900;
                        break;
                }
                System.out.println();
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("Your total bill is Rs " + cost1*no_of_people);
                System.out.println("--------------------------------------------------------------------------------------");
            }
            case "train", "Train" -> {
                System.out.println("By Train ~~~");
                System.out.println("The total time required to reach your destination is " + Math.round(dist / 43.5) + " Hrs");
                int cost = dist * 2;
                switch (AC_Non_AC()) {
                    case 'Y':
                    case 'y':
                        cost = cost + 2500;
                        break;
                    case 'n':
                    case 'N':
                        break;
                }
                System.out.println();
                switch (meals()) {
                    case 'Y':
                    case 'y':
                        cost = cost + 700;
                        break;
                    case 'n':
                    case 'N':
                        break;
                }
                System.out.println();
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("Your total bill is Rs " + cost*no_of_people);
                System.out.println("--------------------------------------------------------------------------------------");
            }
            default -> {
                System.out.println("Invalid option----Please start from again");
                return;
            }
        }
        System.out.println();
        System.out.println("Confirmation for booking your trip  ");
        System.out.println("    ->Enter Y/y for Yes");
        System.out.println("    ->Enter N/n for No");
        System.out.print("Your choice: ");
        char confm = sc.next().charAt(0);
        System.out.println();
        if(confm=='y' || confm=='Y'){
            System.out.println("Your booking has been done successfully!\n🥳🥳🥳Happy Journey🥳🥳🥳");
        }
        else{
            System.out.println("No Booking done...");
        }
        System.out.println();
        System.out.println("                                 !!!!!!Thank you!!!!!!");
    }
}

