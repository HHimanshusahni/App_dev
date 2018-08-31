import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class MyClass {


	
	public static void main(String args[]) {

				// Method 1
		
/*//		----- Spliting another string-----
		String river = "Mississippi";
		String [] splitriver = river.split("s");
		
		System.out.println(Arrays.toString(splitriver));
				// o/p [Mi, , i, , ippi]
*/		
		
		
		
		// 			Method 2
		
/*//		----------Using substring function----------
		String river = "Mississippi";
//		String riverPart = river.substring(2,5); // o/p       ssi
		
		String riverPart = river.substring(4,8); //o/p       issi
		
		System.out.println(riverPart);
*/		
		
		
		
		
		//  		Method 3
	   //     JAVA REGEX  : Regular expressions
		//  we create a pattern in this method
		
//		String river = "Mississippi";   // o/p ssissip
		
		String river = "MississippiMississippi"; 
		
		Pattern p  = Pattern.compile("Mi(.*?)pi");
		
		Matcher m = p.matcher(river);
		
		while(m.find()) {
			System.out.println(m.group(1));
		}
		
		
		
		
		
		
		
		
		
	}
}
