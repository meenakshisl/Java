package Generics;

public class PrintGenericTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
	      PrintGeneric.printAnyType(new Integer(10));   // Print an integer
	      PrintGeneric.printAnyType(new Double(10.5));  // Print a double
	      PrintGeneric.printAnyType(new Character('c')); // Print a character
	      PrintGeneric.printAnyType(new String("generics")); // Print a string
		
	}

}
