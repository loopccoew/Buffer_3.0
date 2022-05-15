# Buffer_3.0
Buffer 3.0 Repository to submit your projects
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    struct new_entries
    {
        char name_place[100];
        float amt_paid;
        char day[20];
        char date[20];
    };
    int n, del_user, del_comp = 0;
    printf("****^^^^WELCOME TO THE VIRTUAL WALLET^^^^****");
    printf("\n enter the no.of entries: \n");
    scanf("%d", &n);

    struct new_entries first[n];
    int i, j, cont;
    do
    {
        printf("\n what would you like to do?");

        printf("\n\n1.Accept Entries \n2. Delete Entries\n");
        printf("3. Paying History\n");

        printf("\n\nEnter one of the above : ");
        scanf("%d", &j);

        switch (j)
        {
        case 1:

            for (i = 0; i < n; i++)

            {
                printf("*******ENTRY NO.=%d******", i + 1);
                printf("\n enter the amount spent:\n");
                scanf("%f", &first[i].amt_paid);
                fflush(stdin);
                printf("\nenter the place where u spent:\n");
                gets(first[i].name_place);
                fflush(stdin);
                printf("enter the day:\n");
                gets(first[i].day);
                fflush(stdin);
                printf("enter the date:\n");
                gets(first[i].date);
                fflush(stdin);
            }
            for (i = 0; i < n; i++)
            {
                printf("** FOR ENTRY NO. %d** \n ", i + 1);
                printf("place : %s\n", first[i].name_place);
                printf("amount spent : %f\n", first[i].amt_paid);
                printf("day :%s\n", first[i].day);
                printf("date :%s\n", first[i].date);
            }
            break;
        case 2:
            printf("to delete the last entry enter 1;"); 
            scanf("%d", &del_user);                      
            del_comp = del_user - 1;

            for (int i = del_comp; i < n; i++)
            {
                first[i].name_place == first[i + 1].name_place;
                first[i].day == first[i + 1].day;
                first[i].date == first[i + 1].date;
            }
            n--;
            printf("\n for seeing entries remaining after deletion press 1 and then 3");
            break;

        case 3:
            printf("on deleting the entries are: \n");
            for (i = 0; i < n; i++)
            {
                printf("\n ^^^^^for entry %d^^^^^", i);
                printf("place : %s\n", first[i].name_place);
                printf("amount spent : %f\n", first[i].amt_paid);
                printf("day :%s\n", first[i].day);
                printf("date :%s\n", first[i].date);
            }
            break;
            

        default:
            printf("Wrong input choice");
        }
        printf("\nEnter 1 to continue or 0 to end");
        scanf("%d", &cont);
    } while (cont == 1);
}
