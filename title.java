// This function is used to parse the problem title into standard format
import java.util.*;

public class title {

	public static void main(String[] args){
		String s = args[0];
		try{
			s = s.replace(". ", "_");
			s = s.replace(" ", "_");
			System.out.println(s);
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}