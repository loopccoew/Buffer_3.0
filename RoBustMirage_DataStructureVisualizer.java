import java.io.*;
import java.util.*;

class Queue { 
    int element;
    Queue(int p) { 
        this.element = p;
    }
}

class Queue_Visualizer { 

    int front, rear, MAXSIZE;
    Queue obj[];

    public Queue_Visualizer(int MAXSIZE) { 
        front = 0; 
        rear = 0;
        MAXSIZE = 50;
        obj = new Queue[MAXSIZE];
    }

    boolean isFull() { 
        if (rear == MAXSIZE - 1)
            return true; 
        else
            return false; 
    }

    boolean isEmpty() { 
        if (front == rear)
            return true; 
        else
            return false; 
    }

    void enqueue() { 
        Queue item;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any Element in queue"); 
        item = new Queue(sc.nextInt());

        if (isFull() == true) { 
            System.out.print("Queue is full!");
        } else { 
            obj[rear] = item;
            rear = rear + 1; 
        }
    }

    void dequeue() { 
        if (isEmpty()) { 
            System.out.print("Sorry..The queue is empty!!"); 
        } else {

            front = front + 1; 
        }
    }

    void display() 
    {
        if (front != rear) { 

            System.out.println(" front");
            System.out.println("  |");
            System.out.println("  V");

            for (int i = front; i < rear; i++) {

                System.out.print(" | " + obj[i].element);

            }
            System.out.print(" | ---> rear ");


        } else {
            System.out.println("Oops..Queue is empty!!");
        }
    }
}


class Sort {
    BufferedReader in ;
    int num;
    int arr[] = null;
    int arr1[] = null;
    Sort() { in = new BufferedReader(new InputStreamReader(System.in));
    }
    void getEle() throws Exception {
        System.out.print("Enter the no. of elements : ");
        num = Integer.parseInt( in .readLine());
        arr = new int[num];
        arr1 = new int[num];
        System.out.println("Enter the Array elements : ");
        for (int i = 0; i < num; i++) {
            int ele = Integer.parseInt( in .readLine());
            arr[i] = ele;
            arr1[i] = ele;
        }
    }

    void bubbleSort() {
        for (int i = 0; i < num - 1; i++) {
            for (int j = 0; j < num - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    System.out.println("\n" + arr[j] + " > " + arr[j + 1] + "  So swapping happens.");
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    show(arr);
                } else if (arr[j] < arr[j + 1]) {
                    System.out.println("\n" + arr[j] + " < " + arr[j + 1] + "  So swapping Not happens.");
                    show(arr);
                }
            }
            System.out.println("\nAfter " + (i + 1) + " th pass Array is : ");
            show(arr);
            System.out.println();
        }
        System.out.println("\nAfter Sorting Array, Array is as Follows : ");
        show(arr);
    }
    void show(int arr[]) {
        System.out.print("| ");
        for (int i = 0; i < num; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }

    void insertion() {
        int i, j, temp;
        for (i = 1; i <= num - 1; i++) {
            temp = arr1[i];
            j = i - 1;
            while ((j >= 0) && (arr1[j] > temp)) {
                arr1[j + 1] = arr1[j];
                j = j - 1;
            }
            arr1[j + 1] = temp;
            System.out.println("After " + (i) + " pass " + arr1[i - 1] + " is inserted at correct position.\n");
            show(arr1);
        }
        System.out.println("\nAfter Sorting array, Array is as Follows : ");
        show(arr1);
    }
}

class Stack {
    int maxSize = 10;
    int arr[] = new int[maxSize];
    int top = 0;
    BufferedReader in ;
    Stack() { in = new BufferedReader(new InputStreamReader(System.in));
    }
    boolean isFull() {
        if (top == maxSize - 1) {
            return true;
        }
        return false;
    }
    boolean isEmpty() {
        if (top == 0) {
            return true;
        }
        return false;
    }
    void push(int element) {
        if (!isFull()) {
            arr[top] = element;
            top++;
            print();
        } else {
            System.out.println("Stack is Full.........");
            print();
        }
    }
    int pop() {
        int element;
        if (!isEmpty()) {
            element = arr[top - 1];
            top--;
            System.out.println("The element " + element + " is popped.");
            if(top !=0) {
            print();
            }else {
            System.out.println("top : 0");
            }
            return element;
        } else {
            System.out.println("Stack is Empty........");
            return -1;
        }
    }
    void print() {
        for (int i = 0; i < top - 1; i++) {
            System.out.print("    ");
        }
        System.out.println(" top");
        for (int i = 0; i < top - 1; i++) {
            System.out.print("    ");
        }
        System.out.println("  ↓");

        System.out.print("| ");
        for (int i = 0; i < top; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }
}


class Node {
    Node next;
    int data;
    Node(int data) {
        this.data = data;
        next = null;
    }
}
class Operation {
    BufferedReader in ;
    int count = 0;
    Operation() { in = new BufferedReader(new InputStreamReader(System.in));
    }
    Node head = null;
    void create() throws Exception {
        int ch;
        do {
            System.out.print("Enter the data : ");
            int data = Integer.parseInt( in .readLine());
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                System.out.println("Head");
                System.out.println("↓");
                System.out.print(head.data);
                count++;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                count++;
                display();
            }
            System.out.print("\nDo you want to add another node (1.Yes & 2.No) : ");
            ch = Integer.parseInt( in .readLine());
        } while (ch != 2);
        System.out.println("Created Linklist is as follows : ");
        show();
        System.out.println("\n");
    }

    void InsertAtStart() throws Exception {
        System.out.print("Enter the data : ");
        int data = Integer.parseInt( in .readLine());
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            System.out.println("Head");
            System.out.println("↓");
            System.out.print(head.data);
            count++;

        } else {
            Node temp = head;
            head = newNode;
            head.next = temp;
            System.out.println("Head Previous head");
            System.out.println("↓     ↓");
            show();
            count++;
        }
        System.out.println("Linklist is as follows : ");
        show();
    }

    void show() {
        Node curr = head.next;
        System.out.print(head.data);
        while (curr != null) {
            System.out.print(" --> " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
    void display() {
        Node curr = head.next;
        System.out.println("Head");
        System.out.println("↓");
        System.out.print(head.data);
        while (curr != null) {
            System.out.print(" --> " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
    void InsertAtEnd() throws Exception {
        System.out.print("\nEnter the data : ");
        int data = Integer.parseInt( in .readLine());
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            System.out.println("Head");
            System.out.println("↓");
            System.out.print(head.data);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            for (int i = 0; i < count - 1; i++) {
                System.out.print("      ");
            }
            System.out.println("temp");
            for (int i = 0; i < count - 1; i++) {
                System.out.print("      ");
            }
            System.out.println("↓");
            show();
            temp.next = newNode;
            count++;
            for (int i = 0; i < count - 2; i++) {
                System.out.print("      ");
            }
            System.out.println("temp  temp.next");
            for (int i = 0; i < count - 2; i++) {
                System.out.print("      ");
            }
            System.out.println("↓     ↓");
            show();
            System.out.println("Linklist is as follows : ");
            show();
        }
    }
    void insertInBetween() throws Exception {
        System.out.print("\nEnter the data : ");
        int data = Integer.parseInt( in .readLine());
        System.out.print("Enter the position of data to insert : ");
        int position = Integer.parseInt( in .readLine());
        int cout = 0;
        Node temp = head, prev = head;
        Node newNode = new Node(data);
        while (cout != position && temp.next != null) {
            prev = temp;
            temp = temp.next;
            cout++;
            count++;
        }
        if (cout == position) {
            show();
            for (int i = 0; i < cout - 1; i++) {
                System.out.print("      ");
            }
            System.out.println("↓     ↑");
            for (int i = 0; i < cout - 1; i++) {
                System.out.print("      ");
            }
            System.out.println("----- |");
            for (int i = 0; i < cout - 1; i++) {
                System.out.print("      ");
            }
            System.out.println("| " + newNode.data + " |--");
            for (int i = 0; i < cout - 1; i++) {
                System.out.print("      ");
            }
            System.out.println("-----");
            prev.next = newNode;
            newNode.next = temp;
        }
        System.out.println("Linklist is as follows : ");
        show();
    }
    void delete() throws Exception {
        System.out.print("Enter the position of data to delete : ");
        int position = Integer.parseInt( in .readLine());
        int count = 0;
        Node temp = head, prev = head;
        if (position == 0 && temp != null) {
            head = head.next;
            show();
            return;
        }
        while (count != position && temp.next != null) {
            prev = temp;
            temp = temp.next;
            count++;
        }
        if (count == position && temp.next != null) {

            for (int i = 0; i < count - 1; i++) {
                System.out.print("      ");
            }
            System.out.println("prev  temp  temp.next");
            for (int i = 0; i < count - 1; i++) {
                System.out.print("      ");
            }
            System.out.println("↓     ↓     ↓");
            show();
            for (int i = 0; i < count - 1; i++) {
                System.out.print("      ");
            }
            System.out.println("|           ↑");
            for (int i = 0; i < count - 1; i++) {
                System.out.print("      ");
            }
            System.out.println("-------------");
            prev.next = temp.next;
        } else if (count == position && temp.next == null) {
            for (int i = 0; i < count - 1; i++) {
                System.out.print("      ");
            }
            System.out.println("prev  temp  ");
            for (int i = 0; i < count - 1; i++) {
                System.out.print("      ");
            }
            System.out.println("↓     ↓");
            show();
            for (int i = 0; i < count - 1; i++) {
                System.out.print("      ");
            }
            System.out.println("|  ");
            for (int i = 0; i < count - 1; i++) {
                System.out.print("      ");
            }
            System.out.println("------> null");
            prev.next = null;
        }
        System.out.println("Linklist is as follows : ");
        show();
    }
}

class Search {
    BufferedReader in ;
    int num;
    int arr[] = null;
    int arr1[] = null;
    Search() { in = new BufferedReader(new InputStreamReader(System.in));
    }
    void getEle() throws Exception {
        System.out.print("Enter the no. of elements : ");
        num = Integer.parseInt( in .readLine());
        arr = new int[num];
        arr1 = new int[num];
        System.out.println("Enter the Array elements : ");
        for (int i = 0; i < num; i++) {
            int ele = Integer.parseInt( in .readLine());
            arr[i] = ele;
            arr1[i] = ele;
        }
    }
    void show(int arr[]) {
        System.out.print("| ");
        for (int i = 0; i < num; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println("\n");
    }
    void linearSearch() throws Exception {
        System.out.print("Enter the elements to search : ");
        int ele = Integer.parseInt( in .readLine());
        boolean val = false;
        System.out.println("Array is : ");
        show(arr);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("     ");
            }
            System.out.print("↑");
            System.out.println();
            if (ele == arr[i]) {
                System.out.println("\n" + ele + "  = " + arr[i] + ". \nElement found at " + (i + 1) + " location");
                val = true;
                break;
            } else {
                System.out.println("\n" + ele + " != " + arr[i]);
            }
            System.out.println();
            show(arr);
        }
        if (val == false) {
            System.out.println("Element not found.....");
        }

    }
    void sort(int arr[]) {
        for (int i = 0; i < num - 1; i++) {
            for (int j = 0; j < num - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    void binarySearch() throws Exception {
        System.out.print("Enter the elements to search : ");
        int ele = Integer.parseInt( in .readLine());
        int high = num;
        int low = 0;
        System.out.println("To perform binary search array must be sorted.\nSorted arr is as follows : ");
        sort(arr1);
        show(arr1);
        boolean val = false;
        while (low < high) {
            int mid = (high + low) / 2;
            if (arr1[mid] == ele) {
                System.out.println(arr1[mid] + "  = " + ele + ".\nElement Found at location " + (mid + 1));
                val = true;
                break;
            } else if (arr1[mid] != ele) {
                System.out.println(arr1[mid] + " != " + ele + ".");
                val = false;
            }
            if (ele > arr1[mid]) {
                low = mid + 1;
            } else if (ele < arr1[mid]) {
                high = mid;
            }
        }
        if (val == false) {
            System.out.println("Element not found.....");
        }
    }
}


public class RoBustMirage_DataStructureVisualizer
 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int exit = 0;
        System.out.print("***** DATA STRUCTURE VISUALISATION *****.");
        do {
            System.out.print("\n----- Available Operations -----\n1.Searching\n2.Sorting.\n3.Stack.\n4.Queue.\n5.Linkedlist.\n6.Exit.\nEnter your choice : ");
            int CHOICE = Integer.parseInt( in .readLine());
            switch (CHOICE) {
                case 1:
                    System.out.print("*****| Searching Visualization  |*****\n");
                    Search srch = new Search();
                    srch.getEle();
                    int choice = 0;
                    int z = 0;
                    do {
                        System.out.print("\n---- Available Oprations ----.\n1.Linear Search.\n2.Binary Search.\n3.Exit\nEnter your choice : ");
                        choice = Integer.parseInt( in .readLine());
                        switch (choice) {
                            case 1:
                                srch.linearSearch();
                                break;
                            case 2:
                                srch.binarySearch();
                                break;
                            case 3:
                                z = 3;
                                break;
                        }
                    } while (z != 3);
                    break;
                case 2:
                    System.out.print("*****| Sorting Visualization  |*****\n");
                    Sort sort = new Sort();
                    sort.getEle();
                    choice = 0;
                    do {
                        System.out.print("\n---- Available Oprations ----.\n1.Bubbe Sort.\n2.Insertion Sort.\n3.Exit\nEnter your choice : ");
                        choice = Integer.parseInt( in .readLine());
                        switch (choice) {
                            case 1:
                                sort.bubbleSort();
                                break;
                            case 2:
                                sort.insertion();
                                break;
                        }
                    } while (choice != 3);
                    break;
                case 3:
                    System.out.print("*****| Stack Visualization  |*****\n");
                    Stack st = new Stack();
                    int x = 0;
                    do {
                        choice = 0;
                        System.out.print("\n----- Available Operations ------\n1.Push\n2.Pop.\n3.Exit\nEnter your choice : ");
                        choice = Integer.parseInt( in .readLine());
                        switch (choice) {
                            case 1:
                                System.out.print("Enter element to push : ");
                                int element = Integer.parseInt( in .readLine());
                                st.push(element);
                                break;
                            case 2:
                                st.pop();
                                break;
                            case 3:
                                x = 3;
                                break;
                        }
                    } while (x != 3);
                    break;
                case 4:
                    System.out.print("*****| Queue Visualization  |*****\n");
                    choice = 0;
                    int MAXSIZE = 50;
                    Scanner sc = new Scanner(System.in);
                    Queue_Visualizer p1 = new Queue_Visualizer(MAXSIZE);
                    int s = 0;
                    do {
                        System.out.print("\n"); 
                        System.out.print("\n----- Available Operations --------\n1.Enqueue.\n2.Dequeue.\n3.Display.\n4.Exit.\nEnter your choice : ");
                        choice = sc.nextInt(); 
                        switch (choice) {
                            case 1:
                                p1.enqueue();
                                break;
                            case 2:
                                p1.dequeue();
                                break;
                            case 3:
                                p1.display();
                                break;
                            case 4:
                                s = 4;
                                break;
                        }
                    } while (s != 4);
                    break;
                case 5:
                    System.out.print("*****| LinkedList Visualization  |*****\n");
                    Operation op = new Operation();
                    int ch;
                    int y = 0;
                    do {
                        choice = 0;
                        System.out.print("\n----- Available Operation ------\n1.Create\n2.Insert.\n3.Delete.\n4.Exit\nEnter your choice : ");
                        choice = Integer.parseInt( in .readLine());
                        switch (choice) {
                            case 1:
                                op.create();
                                break;
                            case 2:
                                do {
                                    System.out.print("\n1.At Start\n2.At End.\n3.In beetween.\n4.Exit\nEnter your choice : ");
                                    ch = Integer.parseInt( in .readLine());
                                    switch (ch) {
                                        case 1:
                                            op.InsertAtStart();
                                            break;
                                        case 2:
                                            op.InsertAtEnd();
                                            break;
                                        case 3:
                                            op.insertInBetween();
                                            break;
                                    }
                                } while (ch != 4);
                                break;

                            case 3:
                                op.delete();
                                break;
                            case 4:
                                y = 4;
                        }
                    } while (y != 4);
                    break;
                case 6:

                System.out.println("Do you want to Exit this Application ?(1 for yes 0 for No)");
                     exit = Integer.parseInt(in.readLine());
                     if (exit ==1) {
                         // asking feed back from author
                         System.out.println("1)\uD83D\uDE20 \t2)\u2639\uFE0F \t3)\uD83D\uDE11 \t4)\uD83E\uDD17 \t5)\uD83D\uDE07");
                         System.out.print("How much this App is useful for you? ");
                         int emoji = Integer.parseInt( in .readLine());
                         if (emoji > 3) {
                             System.out.println("Thank you for using this application.\uD83E\uDD17");
                             System.out.println("Happy Learning!!");
                         } else {
                             System.out.println("Sorry For the inconvenience, we will try to better your experience.\uD83D\uDE1E");
                             System.out.println("Thank you for using this application.");
                         }
                  }
           }
      }while (exit != 1);
   }
}
