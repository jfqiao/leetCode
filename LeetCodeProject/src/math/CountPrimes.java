package math;

/**
 * Description:
 * 
 * Count the number of prime numbers less than a non-negative number, n.
 * @author jfqiao
 *
 */

import java.util.List;
import java.util.ArrayList;

public class CountPrimes {
	
	public static void main(String[] args) {
		CountPrimes cp = new CountPrimes();
//		System.out.println(cp.countPrimes(299979));
		System.out.println(cp.countPrimes2(3));
	}
	
	// time complexity too high 
	public int countPrimes(int n) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i < n; i++) {
			boolean isPrime = true;
			for (int j = 0; j < list.size(); j++) {
				if (i % list.get(j) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				list.add(i);
			}
		}
		return list.size();
    }
	
	// 用空间换时间。AC。 
	public int countPrimes2(int n) {
		byte[] flags = new byte[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (flags[i] == 0) 
				count++;
			else
				continue;
			int j = 1;
			while (true) {
				int pos = i * j;
				if (pos < n) {
					flags[pos] = 1;
					j++;
				}
				else
					break;
			}
		}
		return count;
	}
}
