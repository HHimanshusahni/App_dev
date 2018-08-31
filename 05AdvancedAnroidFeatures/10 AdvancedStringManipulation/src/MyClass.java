import java.util.Arrays;

public class MyClass {

	// Split single big string into no of smaller strings
	
	public static void main(String args[]) {
		
		String myString = "Ram x Rohan x Mohit";
//		String[] splitString = myString.split("x");
//		Output[Ram ,  Rohan ,  Mohit]
		
		String[] splitString = myString.split(" x ");
			
		System.out.println(Arrays.toString(splitString));

		
		
		
	}
}
