import java.util.*;
import java.lang.*;
import java.io.*;

public class Control 
{
	Scanner sc;
	public Control()
	{
		 sc = new Scanner(System.in);
	}

public void login()
{
String username = new String();
String password = new String();
do
{
System.out.println("ENTER USERNAME:");
username = sc.next();
System.out.println();
System.out.println("ENTER PASSWORD:");
password = sc.next();

if(username.equals("Admin"))
{
if(password.equals("Admin123"))
{
System.out.println();
System.out.println("LOGIN SUCCESSFUL");
System.out.println();
mainMenu();
}
else
{
System.out.println("PASSWORD IS INVALID");
}
}
else
{
System.out.println();
System.out.println("USERNAME IS INVALID");
}
}while(true);
}

public void mainMenu()
{
int ch; 
try
{
do
{
System.out.println("******************************************");
System.out.println("\t HOTEL MANAGEMENT SYSTEM");
System.out.println("******************************************");
System.out.println();
System.out.println("\t MAIN MENU");
System.out.println();

System.out.println("1. INFORMATION");
System.out.println("2. CUSTOMER SECTION");
System.out.println("3. FOOD SECTION");
System.out.println("4. EXIT");
System.out.println();
System.out.println("ENTER YOUR CHOICE:");
ch = sc.nextInt();
choice(ch);
}while(ch!=5);
}
catch(Exception e) 
{
System.out.println(e);
}
}

public void choice(int ch) 
{
Customer cust;
Food f;
cust = new Customer();
f = new Food();
switch(ch)
{

case 1:
info();
break; 

case 2:
cust.custDetail();
break; 

case 3:
f.food_details();
break; 

case 4:
System.exit(0);
break; 

default:
System.out.println("INVALID CHOICE");
}
}

public void info()
{
int c; 
try
{
do
{
System.out.println("###########################################################");
System.out.println("\t\t WELCOME TO INFORMATION SECTION");
System.out.println("###########################################################");
System.out.println();
System.out.println("This project is a basic version  of managing the processes in a Hotel.The system has the following features :\n\t 1.Add/Delete Customer Details \n\t 2.Add/Delete Food menu \n\t 3.Generate room and food bill ");
System.out.println();
System.out.println("PRESS  1 TO GO BACK TO MAIN MENU:");
c = sc.nextInt();
if(c==1)
{
mainMenu();
}
else
{
System.out.println("INVALID CHOICE");
}
}while(c!=1);
}
catch(Exception e) 
{
System.out.println(e);
}
}


/*public void cust_bill()
{
int ch; 
try
{
do
{
System.out.println("******************************");
System.out.println("\t BILL SECTION");

System.out.println("******************************");
System.out.println();

System.out.println("1. FOOD BILL");
System.out.println("2. ROOM BILL");
System.out.println("3. MAIN MENU");
System.out.println();
System.out.println("ENTER YOUR CHOICE:");
ch = sc.nextInt();
select(ch);
}while(ch!=3);
}
catch(Exception e) 
{
System.out.println(e);
}
}

public void select(int ch) 
{
	Customer cust1 = new Customer();
	Food f1 = new Food();
switch(ch)
{

case 1:
f1.foodBill();
break; 

case 2:
cust1.roomBill();
break; 

case 3:
mainMenu();
break;

default:
System.out.println("INVALID CHOICE");
}
}*/

}



