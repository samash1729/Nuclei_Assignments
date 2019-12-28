package source_Package;

import java.util.Scanner;
import java.util.ArrayList;




/**
 * 
 * @author Ashish Samanta
 * This class contains the main function which starts up the application.
 */


public class start {

	static parser ps = new parser();
	static ArrayList<item> arr = new ArrayList<>();
	static int result,quantity;
	static String name,type;
	static double price;
	
	//test_func is used only for JUnit Testing purposes
	public static item test_func(String str)
	{
		 result = ps.parse_me(str);
		 if(result==1)
		 {
			 name = ps.get_name();
			 price = ps.get_price();
			 quantity = ps.get_quantity();
			 type = ps.get_type();
			 switch(type)
			 {
			 	case "raw" : 
			 				raw r = new raw(name,price,quantity,type); 
			 				return r;
			 	case "manufactured" :
			 				manufactured mf = new manufactured(name,price,quantity,type);
			 				return mf;
			 	case "imported" :
			 				imported ip = new imported(name,price,quantity,type);
			 				return ip;
			 	default : System.out.println("Wont Ever Happen");
			 }
			 System.out.println("Inserted");
		 }
		 else
		 {
			 System.out.println("Problem with Insertion!Couldnt Insert");
		 }
		 return null;
	}
	
	
	/*Items of different types are created and saved in an array list
	The input should be of the following form :-
	 "-name laptop -price 20000 -quantity 1 -type raw"
	The elements can be interchanged among themselves the Parser Class will 
	pick up the appropriate values.
	*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans=4;
		String res;
		while(ans!=3)
		{
			System.out.println("Press 1 to Enter Record");
			System.out.println("Press 2 to View All Records");
			System.out.println("Press 3 to Exit");
			try
			{
				ans = Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid Response! Try Again");
				continue;
			}
			switch(ans)
			{
				case 1 : System.out.println("Enter Record Statement in Appropriate Form");
						 res = sc.nextLine();
						 result = ps.parse_me(res);
						 if(result==1)
						 {
							 name = ps.get_name();
							 price = ps.get_price();
							 quantity = ps.get_quantity();
							 type = ps.get_type();
							 switch(type)
							 {
							 	case "raw" : 
							 				raw r = new raw(name,price,quantity,type); 
							 				arr.add(r);
							 				break;
							 	case "manufactured" :
							 				manufactured mf = new manufactured(name,price,quantity,type);
							 				arr.add(mf);
							 				break;
							 	case "imported" :
							 				imported ip = new imported(name,price,quantity,type);
							 				arr.add(ip);
							 				break;
							 	default : System.out.println("Wont Ever Happen");
							 }
							 System.out.println("Inserted");
						 }
						 else
						 {
							 System.out.println("Problem with Insertion!Couldnt Insert");
						 }
						 break;
				case 2 : System.out.println("Printing All Objects");
						 arr.forEach((i) -> System.out.println(i.name+" "+i.price+" "+i.quantity+" "+i.type
						 +" "+i.sales_tax+" "+i.final_price));
						 break;
				case 3 : break;
				default: System.out.println("Invalid Option");
						 break;
			}
		}
		System.out.println("Deallocating Resources");
		arr.clear();
		System.out.println("Terminating");
	}

}
