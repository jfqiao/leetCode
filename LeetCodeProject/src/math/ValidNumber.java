package math;

/**
 * Problem description: Validate if a given string is numeric.
 * 
 * Some examples: 
 * "0" => true  
 * " 0.1 " => true 
 * "abc" => false 
 * "1 a" => false
 * "2e10" => true 
 * Note: It is intended for the problem statement to be
 * ambiguous. You should gather all requirements up front before implementing
 * one.
 * 
 * @author hgf
 *
 */
public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "959440.94f";
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isNumber(s));
	}
	
	public boolean isNumber(String s) {
		
		return false;
	}
}
