import java.util.*;
import java.lang.*;
import java.io.*;

public class Food
{
static int count; 
String fname; 
float Price; 
Scanner sc;
FileInputStream fin;
public Food()
{
	sc = new Scanner(System.in);
}


//FUNCTION FOR FOOD MENU
public void foodMenu()
{
String str ; 
int c; 
try
{
	fin = new FileInputStream("d:\\Final_HMS\\FoodItem.txt");
	BufferedReader br = new BufferedReader( new InputStreamReader(fin));
do
{
System.out.println("S.N. \t ITEM NAME \t PRICE");
while((str=br.readLine())!=null)
{
System.out.println(str);
}
br.close();
System.out.println("PRESS 1 TO GO BACK TO FOOD SECTION :");
c = sc.nextInt();
if(c==1)
{
food_details();
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

//FUNCTION TO APPEND FOOD MENU
public void appendMenu()
{
char ch; 
try
{
FileWriter fw= new FileWriter("d:\\Final_HMS\\FoodItem.txt",true);
System.out.println("ENTER ITEM NAME :");
fname = sc.next();
System.out.println("ENTER PRICE :");
Price = sc.nextFloat();
count++;
fw.write(count +"\t" + fname +"\t" + Price); 
fw.write(System.getProperty( "line.separator" ));
fw.close();
System.out.println("ITEM ADDED");
System.out.println("NO. OF ITEMS :"+count);
food_details();
}
catch(Exception e) 
{
System.out.println(e);
}
}

//FUNCTION TO DELETE ALL ITEMS
public void deleteAll()
{
int c; 
try
{
PrintWriter p = new PrintWriter("d:\\Final_HMS\\FoodItem.txt");
System.out.println("TOTAL NO. OF ITEMS:"+count); 
count = 0;
p.print("");
p.close();
System.out.println("ITEMS SUCCESSFULLY DELETED");
System.out.println("TOTAL NO. OF ITEMS :" +count);
}
catch(Exception e) 
{
System.out.println(e);
}
food_details();
}

//FUNCTION FOR FOOD BILL
public void foodBill()
{
int c; 
double bill = -1;
String tname = new String();
String cname = new String();
String str = null; 
int quantity,price; 

System.out.println("ENTER CUSTOMER NAME:");
cname = sc.next();
System.out.println("ENTER FOOD ITEM :");
tname = sc.next();
System.out.println();
System.out.println("ENTER QUANTITY :");
quantity = sc.nextInt();
System.out.println();
System.out.println("ENTER ITEM PRICE :");
price = sc.nextInt();

bill = quantity * price; 
if(bill == -1)
{
System.out.println("ITEM DOES NOT EXIST!! ");
}
else
{
System.out.println("\n\n*********************FOOD BILL***************************");
System.out.println("\n\nCUSTOMER \t ITEM \t QUANTITY \t PRICE \t BILL");
System.out.println("\n"+cname +"\t\t" +tname +"\t\t" +quantity +"\t\t" +price +"\t\t"+bill);
System.out.println("\n\n*********************************************************");
food_details();
}
}

//FUNCTION FOR FOOD DETAILS
public void food_details()
{
	int ch; 
try
{
do
{
System.out.println("******************************************");
System.out.println("\t WELCOME TO FOOD SECTION");
System.out.println("******************************************");
System.out.println();
System.out.println("1. DISPLAY FOOD MENU");
System.out.println("2. APPEND FOOD MENU");
System.out.println("3. FOOD BILL");
System.out.println("4. DELETE MENU");
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
foodMenu();
break; 

case 2:
appendMenu(); 
break; 

case 3:
foodBill();
break; 

case 4:
deleteAll();
break; 

case 5:
c.mainMenu();
break; 
//For invalid choice
default:
System.out.println("INVALID CHOICE");
}
}

}






    
