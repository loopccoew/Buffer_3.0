#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <windows.h>
int i,j;
int main_exit;
   void menu();
  void new_acc();
    void edit();
    void see();   
    void close();
 struct date{
    int month,day,year;
    };
 struct {
    char name[60];
    int usn_no,age;
    char namevaccine[60];
    char numvaccine[15];   
    struct date dob;
    struct date vacc;
    }add,upd,check;

 void fordelay(int j)
{   int i,k;
    for(i=0;i<j;i++)
         k=i;
 }
void menu()
{   int choice;
    system("cls");
    system("color 8");
    printf("\n\n\t\t\t\tMY VACCINE MY SHIELD");
    printf("\n\n\n\t\t\t\xB2\xB2\xB2\xB2\xB2\xB2\xB2 WELCOME TO THE MAIN MENU \xB2\xB2\xB2\xB2\xB2\xB2\xB2");
    printf("\n\n\t\t1.Create new account\n\t\t2.Update information of existing account\n\t\t3.Check the details of existing account\n\t\t4.Exit\n\n\n\n\n\t\t Enter your choice:");
    scanf("%d",&choice);

    system("cls");
    switch(choice)
    {
        case 1:
        new_acc();
        break;
        case 2:
        edit();
        break;
        case 3:
        see();
        break;
        case 4:
        close();
        break;
     
        

    }
}
void new_acc()

{
    int choice;
    FILE *ptr;

    ptr=fopen("quadclan.dat","a+");
    usn_no:
    system("cls");
    printf("\t\t\t\xB2\xB2\xB2 ADD RECORD  \xB2\xB2\xB2\xB2");
    printf("\n\n\nEnter today's date(dd/mm/yyyy):");
    scanf("%d/%d/%d",&add.vacc.month,&add.vacc.day,&add.vacc.year);
    printf("\nEnter the your USN number:");
    scanf("%d",&check.usn_no);
    while(fscanf(ptr,"%d %s %d/%d/%d %d %s %s\n",&add.usn_no,add.name,&add.dob.month,&add.dob.day,&add.dob.year,&add.age,add.namevaccine,add.numvaccine)!=EOF)
    {
        if (check.usn_no==add.usn_no)
            {printf("You have already registered !");
            fordelay(1000000000);
                goto usn_no;

            }
    }
    add.usn_no=check.usn_no;
        printf("\nEnter the name:");
    scanf("%s",add.name);
    printf("\nEnter the date of vaccine(dd/mm/yyyy):");
    scanf("%d/%d/%d",&add.dob.month,&add.dob.day,&add.dob.year);
    printf("\nEnter the age criteria :");
    scanf("%d",&add.age);
    printf("\nEnter the name of vaccine :");
    scanf("%s",add.namevaccine);
    printf("\nEnter the number of vaccines you have taken :");
    scanf("%s",add.numvaccine);
    fprintf(ptr,"%d %s %d/%d/%d %d %s %s \n",add.usn_no,add.name,add.dob.month,add.dob.day,add.dob.year,add.age,add.namevaccine,add.numvaccine);


    fclose(ptr);
    printf("\nAccount created successfully!");
    add_invalid:
    printf("\n\n\n\t\tEnter 1 to go to the main menu and 0 to exit:");
    scanf("%d",&main_exit);
    system("cls");
    if (main_exit==1)
        menu();
    else if(main_exit==0)
            close();
    else
        {
            printf("\nInvalid!\a");
            goto add_invalid;
        }
}
void edit()
{
 char ch;
    int choice,test=0;
    FILE *old,*newrec;
  old= fopen("quadclan.dat","rb+");
   newrec=fopen("new.dat","w");

    printf("\nEnter the USN no. of the customer whose info you want to update :");
    scanf("%d",&upd.usn_no);
    while(fscanf(old,"%d %s %d/%d/%d %d %s %s ",&add.usn_no,add.name,&add.dob.month,&add.dob.day,&add.dob.year,&add.age,add.namevaccine,add.numvaccine)!=EOF)
    {
        if (add.usn_no==upd.usn_no)
        {   
         test=1;
         fseek(old,0,SEEK_SET);
            printf("\nWhich information do you want to change?\n1.Number of vaccines taken\n2. Date of vaccination\n\nEnter your choice(1 for number of vaccins taken and 2 for date of vaccination):");
            scanf("%d",&choice);
            system("cls");
            if(choice==1)
                {printf("Enter the number of vaccines taken :");
                scanf("%s",upd.numvaccine);
                fprintf(old,"%d %s %d/%d/%d %d %s %s \n",add.usn_no,add.name,add.dob.month,add.dob.day,add.dob.year,add.age,add.namevaccine,upd.numvaccine);
                remove("quadclan.dat");
                rename("new.dat","quadclan.dat");
                fclose(old);
                fclose(newrec);
                printf("Changes saved!");
                printf("\n\n\nEnter 1 to go to the main menu and 0 to exit:");
            scanf("%d",&main_exit);
            system("cls");
            if (main_exit==1)
            menu();
            else
             close();
             
            
                }
             if(choice==2)
             {   printf("\nEnter the date of vaccine(mm/dd/yyyy):");
                scanf("%d/%d/%d",&upd.dob.month,&upd.dob.day,&upd.dob.year);
                fprintf(old,"%d %s %d/%d/%d %d %s %s \n",add.usn_no,add.name,upd.dob.month,upd.dob.day,upd.dob.year,add.age,add.namevaccine,add.numvaccine);
                remove("quadclan.dat");
                  rename("new.dat","quadclan.dat");
                 fclose(old);
                fclose(newrec);
                system("cls");
                printf("Changes saved!");
                printf("\n\n\nEnter 1 to go to the main menu and 0 to exit:");
                scanf("%d",&main_exit);
                system("cls");
                if (main_exit==1)
                    menu();
                else
                    close();
                 
                }

        }
        else
            fprintf(newrec,"%d %s %d/%d/%d %d %s %s \n",add.usn_no,add.name,add.dob.month,add.dob.day,add.dob.year,add.age,add.namevaccine,add.numvaccine);
    }
     
if(test!=1)
        {   system("cls");
            printf("\nRecord not found!!\a\a\a");
            edit_invalid:
              printf("\nEnter 0 to try again,1 to return to main menu and 2 to exit:");
              scanf("%d",&main_exit);
              system("cls");
                 if (main_exit==1)

                    menu();
                else if (main_exit==2)
                    close();
                else if(main_exit==0)
                    edit();
                else
                    {printf("\nInvalid!\a");
                    goto edit_invalid;}
        }
 /*   else
        {printf("\n\n\nEnter 1 to go to the main menu and 0 to exit:");
        scanf("%d",&main_exit);
        system("cls");
        if (main_exit==1)
            menu();
        else
            close();
        }*/
}
void see()
{
    FILE *ptr;
    int test=0,rate;
    int choice;
    ptr=fopen("quadclan.dat","r");
    printf("Do you want to check by\n1.USN no\n2.Name\nEnter your choice:");
    scanf("%d",&choice);
    if (choice==1)
    {   printf("Enter your USN number:");
        scanf("%d",&check.usn_no);

        while (fscanf(ptr,"%d %s %d/%d/%d %d %s %s ",&add.usn_no,add.name,&add.dob.month,&add.dob.day,&add.dob.year,&add.age,add.namevaccine,add.numvaccine)!=EOF)
        {
            if(add.usn_no==check.usn_no)
            {   system("cls");
                test=1;

                printf("\nUSN NO.:%d\nName:%s \nDate of vaccine:%d/%d/%d \nAge criteria :%d \nName of vaccine :%s \nNumber of vaccines taken :%s\n\n",add.usn_no,add.name,add.dob.month,add.dob.day,add.dob.year,add.age,add.namevaccine,add.numvaccine);
                printf("\nEnter 1 to go to the main menu and 0 to exit:");
                scanf("%d",&main_exit);
                if (main_exit==1)
        {
            system("cls");
            menu();
            break;
        }

        if(main_exit==0)
           {

            system("cls");
            close();
            break;
            }
               
            }
        }
    }
    else if (choice==2)
    {   printf("Enter the name:");
        scanf("%s",&check.name);
        while (fscanf(ptr,"%d %s %d/%d/%d %d %s %s ",&add.usn_no,add.name,&add.dob.month,&add.dob.day,&add.dob.year,&add.age,add.namevaccine,add.numvaccine)!=EOF)
        {
            if(strcmpi(add.name,check.name)==0)
            {   system("cls");
                test=1;
                printf("\nUSN No.:%d\nName:%s \nDate of vaccine taken :%d/%d/%d \nAge criteria :%d \nName of vaccine :%s \nNumber of vaccines taken :%s\n\n",add.usn_no,add.name,add.dob.month,add.dob.day,add.dob.year,add.age,add.namevaccine,add.numvaccine);
                printf("\nEnter 1 to go to the main menu and 0 to exit:");
                scanf("%d",&main_exit);
        if (main_exit==1)
        {
            system("cls");
            menu();
        }

        if(main_exit==0)
           {

             system("cls");
            close();
            }

            }
        }
    }


    fclose(ptr);
     if(test!=1)
        {   system("cls");
            printf("\nRecord not found!!\a\a\a");
            see_invalid:
              printf("\nEnter 0 to try again,1 to return to main menu and 2 to exit:");
              scanf("%d",&main_exit);
              system("cls");
                 if (main_exit==1)
                    menu();
                else if (main_exit==2)
                    close();
                else if(main_exit==0)
                    see();
                else
                    {
                        system("cls");
                        printf("\nInvalid!\a");
                        goto see_invalid;}
        }
   /* else
        {printf("\nEnter 1 to go to the main menu and 0 to exit:");
        scanf("%d",&main_exit);}
        if (main_exit==1)
        {
            system("cls");
            menu();
        }

        else
        {

            system("cls");
            close();
        }*/
}

 
void close()
{
    printf("\n\n\n\nThis C Mini Project is developed by QuadClan team!");

    }

int main()
{
    menu();
    return 0;
}