//C program to make a calendar 

#include<stdio.h>

//declaring functions
int inputyear ();
int determinedaycode ();
void determineleapyear ();
void calendar ();


//declaring arrays for days and months
int days_in_month[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

char *months[] = { "\n\n January", "\n\n February", "\n\n March", "\n\n April", "\n\n May", "\n\n June","\n\n July", "\n\n August", 
                  "\n\n September","\n\n October", "\n\n November", "\n\n December"};


int inputyear ()
{
  int year;
  printf ("Enter any year from 1800 (example:2001): ");
  scanf ("%d", &year);
  return year;
}

int determinedaycode (int year)
{
  int daycode;
  daycode = (year + (year - 1) / 4 -(year - 1) / 100 + (year - 1) / 400) % 7;
  return daycode;
}

void determineleapyear (int year)
{
  if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
    {
      days_in_month[1] = 29;
    }
}

void calendar (int year, int daycode)
{
  int month, day;
  for (month = 0; month < 12; month++)
    {
      printf ("%s", months[month]);
      printf ("\n\nSun  Mon  Tue  Wed  Thu  Fri  Sat\n");

      for (day = 1; day <= 1 + daycode * 5; day++)       // Correct the position for the first date
	{
	  printf (" ");
	}
     
      for (day = 1; day <= days_in_month[month]; day++)      // Print all the dates for one month
	{
	  printf ("%2d", day);

	  if ((day + daycode) % 7 > 0)
	    printf ("   ");
	  else
	    printf ("\n ");
	}
      daycode = (daycode + days_in_month[month]) % 7;
    }
}

int main ()
{
  int year, daycode ;
   year = inputyear ();
   if (1800 > year )
  {
    printf("Invalid year!!\nTry again..");
  }
  else
  {
  daycode = determinedaycode (year);
  determineleapyear (year);
  calendar (year, daycode);
  }
  return 0;
}
