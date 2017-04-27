package code;

/**problem describe:
 *  Given�? an  arbitrary�? ransom�? note�? string  and  another  string  containing
 *  letters from�? all  the  magazines,�? write  a  function  that  will  return
 *  true  if  the  ransom �? note  can  be  constructed  from  the  magazines ;
 *  otherwise,  it  will  return  false.  �??
 * 
 * Each  letter�? in�? the�? magazine  string  can�? only  be�? used  once�? in�? your
 *  ransom�? note.
 * 
 * Example:
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] rcharNum = new int[26];
		int[] mcharNum = new int[26];
		char[] rchar = ransomNote.toCharArray();
		char[] mchar = magazine.toCharArray();
		for (int i = 0; i < ransomNote.length(); i++) {
			rcharNum[rchar[i] - 97]++;
		}
		for (int i = 0; i < magazine.length(); i++) {
			mcharNum[mchar[i] - 97]++;
		}
		boolean result = true;
		for (int i = 0; i < 26; i++) {
			if (rcharNum[i] > mcharNum[i]) {
				result = false;
				break;
			}
		}
		return result;
	}
}
