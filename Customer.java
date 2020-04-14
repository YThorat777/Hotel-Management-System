import java.util.*;
import java.lang.*;
import java.io.*;

public class Customer 
{
static int count; 
String name; 
long id; 
String room; 
String date;
Scanner sc;
FileInputStream fin;
public Customer()
{
	 sc = new Scanner(System.in);
}
//FUNCTION FOR CUSTOMER DETAILS
public void custDetail()
{
	int ch; 
try
{
do
{
System.out.println("*****************************");
System.out.println("\t WELCOME TO CUSTOMER SECTION ");
System.out.println("*****************************");
System.out.println();
System.out.println("1. DISPLAY CUSTOMER LIST");
System.out.println("2. ADD CUSTOMER");
System.out.println("3. ROOM BILL");
System.out.println("4. DELETE LIST");
System.out.println("5. BACK TO MAIN MENU");
System.out.println();
System.out.println("ENTER YOUR CHOICE :");
ch = sc.nextInt();
choose(ch);
}while(ch!=5);
}
catch(Exception e) 
{
System.out.println(e);
}
}



//FUNCTION FOR CHOOSING OPTION
public void choose(int ch) 
{
Control c = new Control();
switch(ch)
{
case 1:
custDisplay();
break; 

case 2:
appendCust();
break; 

case 3:
roomBill();
break; 

case 4:
delete();
break; 

case 5:
c.mainMenu();
break; 

default:
System.out.println("INVALID CHOICE");
}
}



//FUNCTION FOR DISPLAYING CUSTOMER
public void custDisplay()
{
String str ; 
int c; 

try
{
	fin = new FileInputStream("d:\\Final_HMS\\CustInfo.txt");
	BufferedReader br = new BufferedReader( new InputStreamReader(fin));
do
{
System.out.println("CUST ID \t CUST NAME \t DATE OF ARRIVAL \t ROOM TYPE");
while((str=br.readLine())!=null)
{
System.out.println(str);
}
/*if((str=br.readLine())==null) 
{
System.out.println("CUSTOMER LIST IS EMPTY!! ");
System.out.println();
*/
System.out.println("PRESS 1 TO GO BACK TO CUSTOMER SECTION:");
c = sc.nextInt();
if(c==1)
{
custDetail();
}
else
{
System.out.println("INVALID CHOICE ");
}
}while(c!=1);
}
catch(Exception e)
{
	System.out.println(e);
}
}



//FUNCTION TO APPEND CUSTOMER LIST
public void appendCust()
{
char ch; 
try
{
FileWriter fw = new FileWriter("d:\\Final_HMS\\CustInfo.txt",true);
System.out.println("ENTER CUSTOMER ID :");
id = sc.nextLong();
System.out.println("ENTER CUSTOMER NAME :");
name = sc.next();
System.out.println("ENTER ROOM TYPE:");
room = sc.next();
System.out.println("ENTER DATE OF ARRIVAL(DD/MM/YY):");
date = sc.next();
count++;
fw.write(id +"\t" + name +"\t" + date+"\t" + room); 
fw.write(System.getProperty( "line.separator" ));
fw.close();
System.out.println();
System.out.println("CUSTOMER INFORMATION ADDED");
System.out.println("NO. OF CUSTOMERS :"+count);
System.out.println();
custDetail(); 
}
catch(Exception e) 
{
System.out.println(e);
}
}



//FUNCTION TO DELETE ALL ITEMS
public void delete()
{
int c; 
try
{
PrintWriter p = new PrintWriter("d:\\Final_HMS\\CustInfo.txt");
System.out.println("TOTAL NO. OF CUSTOMERS :"+count); 
count = 0;
p.print("");
p.close();
System.out.println("CUSTOMER LIST SUCCESSFULLY DELETED");
System.out.println("TOTAL NO. OF CUSTOMERS :" +count);
}
catch(Exception e) 
{
System.out.println(e);
}
custDetail();
}


//FUNCTION FOR ROOM BILL
public void roomBill()
{
int c; 
double bill = -1;
String tname = new String();
String troom = new String();
String str = null; 
int id,price=0,days; 


System.out.println("ENTER CUSTOMER ID:");
id = sc.nextInt();

System.out.println("ENTER CUSTOMER NAME:");
tname = sc.next();
System.out.println("ENTER ROOM TYPE:");
troom = sc.next();
System.out.println();
System.out.println("ENTER NUMBER OF DAYS:");
days = sc.nextInt();
System.out.println();
if(troom.equals("Deluxe"))
{
price = 2000;
bill = price * days; 
}
else if(troom.equals("Casual"))
{
price = 1000;
bill = price * days; 
}
else if(troom.equals("Special"))
{
price = 5000;
bill = price * days; 
}
else
{
System.out.println("INVALID CHOICE");
}
if(bill == -1)
{
System.out.println("OOPS! SOMETHING WENT WRONG !! ");
}
else
{
System.out.println("\n\n*********************ROOM BILL***************************");
System.out.println("\n\nCUST ID \t CUST NAME \t ROOM TYPE \t PRICE \t BILL");
System.out.println("\n"+id +"\t\t" +tname +"\t\t" +troom +"\t\t" +price +"\t\t" + bill);
System.out.println("\n\n*********************************************************");
custDetail();
}
}

}



