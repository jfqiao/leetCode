package algorithm;

import java.util.HashMap;
import java.util.Map;

public class CharMap {
	private static final int[] PRIME_NUMBER = {
		2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
		31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
		73, 79, 83, 89, 97, 101,
	};
	
	private static final Map<Character, Integer> map = new HashMap<Character, Integer>();
	
	static {
		for (int i = 0; i < PRIME_NUMBER.length; i++) {
			map.put((char) (i + 97), PRIME_NUMBER[i]);
		}
	}
	
	public static void main(String[] args) {
//		getPrimeNumber();
		String s1 = "agfedaaaaaaaaaaaaaaaaaaaaaab";
		String s2 = "fdgaeaaaaaaaaaaaaaaaaaaaaaab";
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		int hashVal1 = hashString(s1, map);
		int hashVal2 = hashString(s2, map);
		System.out.println(hashVal1);
		System.out.println(hashVal2);
	}
	
	public static int hashString(String str, Map<Character, Integer> map) {
		int hash = 1;
		char[] chs = str.toCharArray();
		for (Character c : chs) {
			hash *= map.get(c);
		}
		return hash;
	}
	
	public static void getPrimeNumber() {
		boolean isPrimeNumber;
		int val = 2;
		int primeNumber = 2;
		while (val <= Integer.MAX_VALUE) {
			isPrimeNumber = true;
			for (int i = 1; i <= Math.sqrt(val); i++) {
				if (val % i == 0 && i != 1) {
					isPrimeNumber = false;
					break;
				}
			}
			if (isPrimeNumber) {
				primeNumber = val;
			}
		}
		System.out.println(primeNumber);
	}
}
