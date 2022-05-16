#include<iostream>
#include<cstdlib>
#include <string>
using namespace std;

class Burger
{
        int front,rear, f, r,q[5];
        char o[5];
        public:
                Burger()
                {    
  	                front=-1;
  	                rear=-1;
  	                f=-1;
  	                r=-1;
                }
 
                int isfull()
                {
                        if((front==0&&rear==4)||front==rear+1)
                        {
  		                return 1;
                        }
                        else
                        {
   		                return 0;
                        }
                }      
                
                int isfull2()
                {
                        if((f==0&&r==4)||f==r+1)
                        {
  		                return 1;
                        }
                        else
                        {
   		                return 0;
                        }
                }      
 
                int isempty()
                {
                        if(front==-1&&rear==-1)
                        {
   	                        return 1;
                        }
                        else
                        {
   	                        return 0;
                        }
                }
                
                int isempty2()
                {
                        if(f==-1&&r==-1)
                        {
   	                        return 1;
                        }
                        else
                        {
   	                        return 0;
                        }
                }
 
                void add()
                {
  	                if(isfull()==0 && isfull2()==0)
  	                {
  	                	cout<<"\n\n a. Veg Burger b. Chicken Burger c. Paneer Burger d. Special Veg Burger";
  	 	                cout<<"\n Enter the Burger ID and items: ";
  	 	                if(front==-1&&rear==-1&&f==-1&&r==-1)
  	 	                {
  	 	                	f=0;
  	 	                	r=0;
  	  		                front=0;
  	  		                rear=0;
  	  		                cin>>q[rear];
  	  		                cin>>o[r];
  	  		                cout<<o[r];
  	 	                }
  	 	                else
  	 	                {
  	   		                rear=(rear+1)%5;
  	   		                r=(r+1)%5;
								 cin>>q[rear];
								 cin>>o[r];
  	 	                }
  	 	               
  	 	            	  char c;
 		                cout<<" Do you want to add another order ? ";
   		                cin>>c;
   		                if(c=='y'||c=='Y')
  	 	                add(); 
  	                }
  	                else
  	                {
  	 	                cout<<"\n Orders are full ";
  	                }
  	               
  	
                }
 
                void serve()
                {
  	                if(isempty()==0 && isempty2()==0)
  	                {
  	 	                if(front==rear)
  	 	                {
  	 	 	                cout<<"\n Order served is : "<<q[front]<<o[f];
  	 	 	                f=-1;
  	 	 	                r=-1;
  	 	 	                front=-1;
  	 	 	                rear=-1;
  	 	                }
  	 	                else
  	 	                {
  	 	 	                cout<<"\n Order id and item served is : "<<q[front]<<o[f];;
  	 	 	                front=(front+1)%5;
  	 	 	                f=(f+1)%5;
  	 	                }
  	                }
  	                else
  	                {
  	                	cout<<"no orders to serve";
					  }
                }
 
                void display()
                {
  	                if(isempty()==0)
  	                {
  	                        for(int i=front;i!=rear;i=(i+1)%5)
  	                        {
  	  	                        cout<<q[i]<<" <- ";
								cout<<o[i]<<" <- ";  	  	                        
  	                        }
  	 	                cout<<q[rear];
						cout<<o[r];  	 	              
  	                }
  	                else
  	                {
 	 	                cout<<"\n Orders are empty";
 	                }
                }
 
                void check()
                {
                        int ch;
                        cout<<"\n\n Welcome to Burger Shack !\n\n";
                        cout<<"\n 1. Add a Burger in Queue \n 2. Display the Orders \n 3. Serve a Burger \n 4. Exit \n Enter your choice : ";
                        cin>>ch;
                        switch(ch)
                        {             
                                case 1:
                                        add();
                                        break;
   
                                case 2:
                                        display();
                                        break;
   
                                case 3:
                                        serve();
                                        break;
   
                                case 4:
                                        exit(0);
   
                                default:
                                        cout<<" Invalid choice ";
                                        check();
                        }
                        char ch1;
                        cout<<"\n Do you want to continue? ";
                        cin>>ch1;
                        if(ch1=='y'||ch1=='Y')
                        check();
               }
};
 
 int main()
 {
       Burger b1;
        b1.check();
        return 0;
 }
