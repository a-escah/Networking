import java.util.*;
public class Calculator {
	private String name;
	
	public Calculator() {}
	
	public Float addition(Float A , Float B) { return Float.sum(A,B); }
	public Float subtraction(Float A , Float B) { return Float.sum(A,-B); }
	public Float multiplication(Float A , Float B) {return A * B;}
	public String getname() { return name; }
	public void setname(String name) { this.name = name;  }
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		Calculator mycalc = new Calculator(); 
		mycalc.setname("Group 8");
		while(true) {
			System.out.println("Welcome to the calculator designed by: " + mycalc.getname());
			System.out.println("Enter A to Add, S to Subtract, M to Multiply, Q to Quit");
			String operation = sc.nextLine();
			if(operation.equals("A") || operation.equals("a")) {
				System.out.println("Enter Argument 1");
				String Argument1 = sc.nextLine();
				System.out.println("Enter Argument 2");
				String Argument2 = sc.nextLine();
				Float A = Float.parseFloat(Argument1);
				Float B = Float.parseFloat(Argument2);
				System.out.println("The sum of "+ Argument1 + " and " + Argument2 + " is: "+ mycalc.addition(A, B));
			}
			else if(operation.equals("S") || operation.equals("s")) {
				System.out.println("Enter Argument 1");
				String Argument1 = sc.nextLine();
				System.out.println("Enter Argument 2");
				String Argument2 = sc.nextLine();
				Float A = Float.parseFloat(Argument1);
				Float B = Float.parseFloat(Argument2);
				System.out.println("The difference of "+ Argument1 + " and " + Argument2 + " is: "+ mycalc.subtraction(A, B));
			}
			else if(operation.equals("M") || operation.equals("m")) {
				System.out.println("Enter Argument 1");
				String Argument1 = sc.nextLine();
				System.out.println("Enter Argument 2");
				String Argument2 = sc.nextLine();
				Float A = Float.parseFloat(Argument1);
				Float B = Float.parseFloat(Argument2);
				System.out.println("The product of "+ Argument1 + " and " + Argument2 + " is: "+ mycalc.multiplication(A, B));
			}
			else if(operation.equals("Q") || operation.equals("q")) {return;}
		}
	}
}
