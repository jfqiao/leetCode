package string;

/**
 * Given a string, determine if it is a palindrome (回文）, considering only alphanumeric
 * characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * @author jfqiao
 *
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome("aA"));
	}
	
	//考虑问题不全面，对于大小写要弄清楚。
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] sc = s.toCharArray();
        while (j > i) {
        	while (i < sc.length && !isAlphanumeric(sc[i]))
        		i++;
        	while (j > -1 && !isAlphanumeric(sc[j]))
        		j--;
        	if (i >= sc.length || j < 0)
        		break;
        	if (Character.toLowerCase(sc[i]) != Character.toLowerCase(sc[j]))
        		return false;
        	i++;
        	j--;
        }
        return true;
    }
    
    public boolean isAlphanumeric(char c) {
    	return (48 <= c && c <= 57) ||
    			(65 <= c && c <= 90) ||
    			(97 <= c && c <= 122);
    }
}
