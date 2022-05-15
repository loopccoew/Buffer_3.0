import csv
import pandas as pd

def verify(usrid,pwrd):         #creating function verify for checking correct userid and password.
    a=False                       
    if ((usrid=="panacea123") and (pwrd=="pan@119")):
        a=True
    return (a)
    
'''    
class cust:
    name=""     #creating a class named cust to store customer details.
    Cnum=""
    Cmail=""
'''    
#----------------------------------------------------------------------------    
    
print("-"*27,"WELCOME TO PANACEA","-"*27)
ver = False
while (not ver):
    uid=input("Enter user id: ")  #Taking inputs for user id and password.
    pwd=input("Enter password: ")
    ver=verify(uid,pwd)  # calling of function.
    if ver==False:
        print("Invalid User name or password") #message printed if either of password or user id is worng.

#while (ver):
class bst: # using the concept of binary search tree to sort the data
    def __init__(self,val):
        self.val=val
        self.lc=None  
        self.rc=None 
    def addc(self,val):
        if val==self.val:
            return 
        elif val<self.val:
            if self.lc!=None:
                self.lc.addc(val) 
            else:
                self.lc=bst(val)
        else:
            if self.rc!=None:
                self.rc.addc(val)
            else:
                self.rc=bst(val)
    def order(self): # orders the given data
        l=[]
        if self.lc!=None:
            l+=self.lc.order()
        l.append(self.val)
        if self.rc!=None:
            l+=self.rc.order()
        return l
    def search(self,x): # searches the required data from the set of data
        if self.val==x:
            return True
        elif x<self.val:
            if self.lc!=None:
                return self.lc.search(x)
            else:
                print("Medicine Not Found")
        else:
            if self.rc!=None:
                return self.rc.search(x)
            else:
                print("Medicine Not Found")
def tree(l):
    root=bst(l[0])
    for i in range(1,len(l)):
        root.addc(l[i])
    return root
csvdf=pd.DataFrame()
df1=pd.DataFrame()
t=0
def first_input():
    print("\n\nPANACEA Medical Application\n\n")
    print("ENTER 1 - FOR NEW ORDER")
    print("ENTER 2 - FOR MODIFYING ITEM QUANTITY IN INVENTORY")  # creating a function first_input to print menu.
    print("ENTER 3 - TO ENTER NEW DATA IN INVENTORY")
    print("ENTER 4 - TO DISPLAY ALL MEDICINES FROM THE INVENTORY")
    print("ENTER 5 - TO DELETE A DATA FROM INVENTORY")
    print("ENTER 6 - FOR EXIT")
    c=int(input("Enter choice : ")) #Taking input of choice for the menu displayed.
    print("\n\n")
    if(c==1):                       #if entered choice is 1.
        global df1                  #creating a global dataframe df1.
        Cname=input("Enter name:")
        Cnum=int(input("Enter phone number:"))  #Taking inputs for customer's name,phone number and email.
        Cmail=input("Enter mailid:")
        df3=pd.DataFrame([[Cname,Cmail,Cnum,None,None,None,None,None]])  #creating dataframe df3 
        df1=pd.concat([df1,df3],ignore_index=True)         #concatinating dataframe df1 and df3.

#SONIA------------------------------------------------------------------
        
        def med():
            global csvdf
            csvdf=pd.read_csv("C:\Sonia\Cummins Assignments\loop.csv") # import data from csv
            medicines=csvdf["0"].tolist()
            val=csvdf.values
            medicine2=val.tolist()
            mt=tree(medicines)
            ordered_list=mt.order() # order the data using bst
            mt2=tree(medicine2)
            ordered_list2=mt2.order()
            y=input("Medicine Name : ")
            y=y.lower()
            z=mt.search(y) # search the data using bst
            if z==True:
                ind=ordered_list.index(y)
                ordernum=csvdf.iloc[ind,5]
                print("Medicine available. Quantity =",ordernum) # shows quntity of medicines available 
                order=int(input("Enter the amount to be ordered : "))
                if order>ordernum: # checking if amount of medicines available is more than oredered number of medicines
                    print("Number of medicines is insufficient!!")
                    med()
                else:
                    ordernum-=order
                    mrp_price=order*ordered_list2[ind][3]
                    totalprice=order*ordered_list2[ind][4]
                    csvdf.iloc[ind,5]=ordernum
                    df2=pd.DataFrame([[ordered_list2[ind][0],ordered_list2[ind][1],ordered_list2[ind][2],ordered_list2[ind][3],ordered_list2[ind][4],order,mrp_price,totalprice]])
                    global df1,t
                    df1=pd.concat([df1,df2],ignore_index=True)
                    t+=1
                    def optsel():
                        opt=int(input("Enter 1-To order more medicines\n2-To final the order : "))
                        if opt==1:
                            med()
                        elif opt==2:
                            print("")
                        else:  # Checks if the option selected exists
                            print("Wrong option selected. Re-enter option\n")
                            optsel()
                    optsel()
            else:
                print("This medicine is not present in the inventory. Re-enter the medicine name")
                med()
        med()
        x1=0
        x2=1
        final_price=0
        discount_price=0
        while(x2<=t):
            final_price+=df1.iloc[x2,7]
            x2+=1
        bfinal_price=final_price
        if final_price>1000:
            final_price=0.9*final_price
        sgst=0.18*final_price
        cgst=0.09*final_price
        final_price=final_price+sgst+cgst
        global csvdf
        csvdf.to_csv("C:\Sonia\Cummins Assignments\loop.csv",index=False)
                        
#NANDINI-------------------------------------------------------------------
        print("-"*85)#printing of E-BILL.
        print("\t\t\t E-BILL GENERATED \t\t\t")
        print("-"*85)
        import datetime as dt
        dt_India = dt.datetime.utcnow() + dt.timedelta(hours=5, minutes=30)
        Indian_time = dt_India.strftime('%d-%b-%y %H:%M:%S')
        max_len = len(max(['Indian Time'], key=len))
        print(Indian_time)#printing date and time of purchasing.
        print("NAME :",Cname,"\t\t\t PhNo :",Cnum)#printing name,phone number and email of customer.
        print("EMAIL ID :",Cmail)
        print("-"*85)
        df1.rename(columns={0:'|    ITEM    |',1:1,2:2,3:'|  MRP  |',4:'|  BEST_PRICE  |',5:'|  QUANTITY  |',6:6,7:7},inplace=True)
        print(df1.loc[1:,['|    ITEM    |','|  QUANTITY  |','|  MRP  |','|  BEST_PRICE  |']].to_markdown()) #printing items,quantity,price of the items purchased.
        print("-"*85)
        print("<","-"*22,"AMOUNT IN INR","-"*20,">")
        print("TOTAL AMOUNT : {:.2f}".format(bfinal_price))#printing total price,discount price and final price(by adding sgst and cgst).
        if discount_price!=0:
            print("DISCOUNT(10%): {:.2f}".format(discount_price))
        print("CGST(9%) : {:.2f}".format(cgst))
        print("SGST(18%): {:.2f}".format(sgst))
        print("FINAL AMOUNT(INCLUDING TAXES): {:.2f}".format(final_price))
        print("-"*85)
        print("PAYMENT OPTIONS :")# payment options-later or now.
        print("ENTER 1 FOR : LATER OPTION")
        print("ENTER 2 FOR : NOW OPTION")
        ch=int(input("PLEASE ENTER THE ABOVE CHOICE :"))
        pay=""
        if ch==1 :
            print("YOUR AMOUNT WILL BE STORED FOR LATER PAY")
        else :
            print("PAYMENT OPTIONS")# options for now payment.
            print("ENTER\n1 FOR: CASH\n2 FOR: DEBIT/CREDIT CARD\n3 FOR: GOOGLE PAY\PAYTM\PHONE PAY\n4 FOR: ANY OTHER OPTION")
            pay=int(input("ENTER YOUR PAYMENT MODE: "))
#print("pay value",pay)
        if pay==1:
            payment="CASH"
        elif pay==2:
            payment="DEBIT/CREDIT CARD"      
        elif pay==3:
            payment="GOOGLE PAY\PAYTM\PHONE PAY"
        elif pay==4:
            payment="ANY OTHER OPTION"
        else :
            payment="LATER OPTION"
        import smtplib
        df=df1.loc[1:,['|    ITEM    |','|  QUANTITY  |','|  MRP  |','|  BEST_PRICE  |']] #sending email to buyer regarding their purchased items and payment status using smtplib library.
        s=smtplib.SMTP_SSL("smtp.gmail.com",465)
        s.login("medipanacea@gmail.com","loop@3004")
        subject="YOUR PANACEA ORDER CONFIRMATION AND PAYMENT DETAILS"
        if payment=="LATER OPTION" :                                  #message-if payment option selected is later.
            Text="Hello,\nThanks for confirming your order with PANACEA of medicines.\nYour order summary :\n{}\nTotal Payable Amount:{:.2f}\nPAYMENT STATUS :{}\nPlease pay your bill within 30 days ".format(df.to_string(),final_price,payment)
        else :                                                        #message-if payment option selected is now.
            Text="Hello,\nThanks for confirming your order with PANACEA of medicines\nYour order summary\n{}\nTotal Payable Amount:{:.2f}\nPAYMENT STATUS :{}".format(df.to_string(),final_price,payment)    
        message='Subject: {}\n\n{}'.format(subject,Text)
        s.sendmail("medipanacea@gmail.com",Cmail,message)
        s.quit()
        first_input()   #calling of function first_input to diaplay menu and enter choice.
        
    elif (c==2):  # if choice entered is 2.
        def med_add():  #creating a function med_add to  MODIFYING ITEM QUANTITY IN INVENTORY.
            csvdf=pd.read_csv("C:\Sonia\Cummins Assignments\loop.csv") 
            medicines=csvdf["0"].tolist()
            val=csvdf.values
            medicine2=val.tolist()
            mt=tree(medicines)
            ordered_list=mt.order()
            mt2=tree(medicine2)
            ordered_list2=mt2.order()
            y=input("Medicine Name : ")
            y=y.lower()
            z=mt.search(y)
            if z==True:
                ind=ordered_list.index(y)
                ordernum=csvdf.iloc[ind,5]
                order=int(input("Enter the amount to be added : "))
                ordernum+=order # Adds more medidine in the inventory
                csvdf.iloc[ind,5]=ordernum
                print("QUANTITY AFTER ADDITION OF MORE MEDICINES IS",ordernum)
                csvdf.to_csv("C:\Sonia\Cummins Assignments\loop.csv",index=False)
            else:
                print("\nNo medicine with such name found")
                med_add()
            def optsel():
                opt=int(input("Enter 1-To add quantity of more medicines\n2-To go to menu : "))
                if opt==1:
                    med_add()
                elif opt==2:
                    first_input()
                else:
                    print("Wrong option selected. Re-enter option\n")
                    optsel()
            optsel()
        med_add()
    elif c==3: #if choice entered is 3.
        def new_item(): #creating a function new_item() to add new medicines in inventory. 
            med_name=input("New Medicine Name : ")
            med_name=med_name.lower()
            med_content=input("New Medicine Content : ")
            med_e=input("What is the medicine used for : ")
            med_mrp=int(input("Medicine mrp : "))
            med_bp=int(input("Medicine best price : "))
            med_qty=int(input("Medicine quantity : "))
            l=[med_name,med_content,med_e,med_mrp,med_bp,med_qty]
            csvdf=pd.read_csv("C:\Sonia\Cummins Assignments\loop.csv")
            val=csvdf.values
            medicine2=val.tolist()
            medicine2.append(l)
            mt2=tree(medicine2)
            ordered_list2=mt2.order()
            df=pd.DataFrame(ordered_list2)
            df.to_csv("C:\Sonia\Cummins Assignments\loop.csv",index=False)
            def optsel():
                opt=int(input("Enter 1-To add more medicines\n2-To go to menu : "))
                if opt==1:
                    new_item()
                elif opt==2:
                    first_input()
                else:
                    print("Wrong option selected. Re-enter option\n")
                    optsel()
            optsel()
        new_item()
    elif c==4: #if choice entered is 4.
        csvdf=pd.read_csv("C:\Sonia\Cummins Assignments\loop.csv")
        print(csvdf) #printing of mediciens present in inventory.
        first_input()  #calling of function first_input to diaplay menu and enter choice.
    elif c==5:      #if choice entered is 5.
        def del_item():    # creating function del_item to delete data from inventory.
            csvdf=pd.read_csv("C:\Sonia\Cummins Assignments\loop.csv")
            medicines=csvdf["0"].tolist()
            val=csvdf.values
            medicine2=val.tolist()
            mt=tree(medicines)
            ordered_list=mt.order()
            mt2=tree(medicine2)
            ordered_list2=mt2.order()
            y=input("Medicine Name : ")
            y=y.lower()
            z=mt.search(y)
            if z==True:
                n=ordered_list.index(y)
                csvdf=csvdf.drop(n)
                val=csvdf.values
                medicine2=val.tolist()
                mt2=tree(medicine2)
                ordered_list2=mt2.order()
                df11=pd.DataFrame(ordered_list2)
                df11.to_csv("C:\Sonia\Cummins Assignments\loop.csv",index=False)
                print("\nMedicine data deleted.\n")
            else:
                print("\nNo medicine with such name found")
                del_item()
            def optsel():
                opt=int(input("Enter 1-To delete more medicines\n2-To go to menu : "))
                if opt==1:
                    del_item()
                elif opt==2:
                    first_input()
                else:
                    print("Wrong option selected. Re-enter option\n")
                    optsel()
            optsel()
        del_item()
    elif c==6: #if choice entered is 6.
        exit   #program will get terminated.
    else:
        print("\nWrong option selected. Re-enter option")   # if the enetered choice is invalid it will display this message.
        first_input()  #calling of function first_input to diaplay menu and enter choice.
        
first_input()
