# Metro Network
## Overview :
In this project, We have created a Metro Network System inspired from
real life Metro
Reservation System. We have given four choices to the passenger as
follows:
1.See metro routes and stations
2.Board a metro
3.Book ticket
4.Exit metro station
In the first choice, we can see all the metro routes from the station to its
respective destination.
The stations are as follows:
1-WARJE
2-KARVENAGAR
3-KOTHURUD
4-SHIVAJINAGAR
5-HINJEWADI
6-AUNDH
In the second choice, we ask the passenger to board a metro of their choice
by providing them
a sorted list of metros according to the cost and distance.
In the third choice, we ask the passenger if they have a pass, if yes they will
be asked for a
passcode and its password. Later, they are given a choice to book a ticket in
a women or general coach.
## Data Structures used :
In our project we have used following data structures:

##### 1. Linked List.
-> In our project , we have created 4 different metro routes and 6 different
stations of those routes. So to link metro stations one after another according
to the metro route designed, we have used a linked list. So the node of linked
list will contain station no, ticket amount and distance between consecutive
metro stations. We have hard coded these values of station no, ticket amount
and distance. Hence to link one station to another and to display the metro
route with it’s stations displayed between source and destination station ,
Linked list is an appropriate data structure.
##### 2. Binary Search Tree.
-> We have used a binary search tree to store passcode and password
values of different passengers having pass. Hence to search and store the
password of the passenger in an efficient way since every passenger will
have a different password, we have used the Binary search Tree data
structure.
##### 3. Array
-> We have used array data structure to store filled seats of metro
Also to store distances between two consecutive stations and to sort them
using bubble sorting technique , array is used.
