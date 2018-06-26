package math;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem description: Given a list of non negative integers, arrange them such
 * that they form the largest number.
 * 
 * Example 1:
 * 
 * Input: [10,2] Output: "210"
 * 
 * Example 2:
 * 
 * Input: [3,30,34,5,9] Output: "9534330" Note: The result may be very large, so
 * you need to return a string instead of an integer.
 * 
 * @author jfqiao
 *
 */

public class LargestNumber {

	// idea：大的数字要放在高位，根据这个要求，第一位越大的数字越靠近左侧，例如： 91 比 89靠前
	// 最高位相同则比较下一位，（两个数比较位数不够时，以最高位补足比较）
	// 以此规则将数组排序即可。
	public String largestNumber(int[] nums) {
		boolean flag = true;
		Integer[] num = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			num[i] = new Integer(nums[i]);
			if (nums[i] != 0)
				flag = false;
		}
		if (flag)
			return "0";
		Arrays.sort(num, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return compareWithBit(o1, o2);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = num.length - 1; i > -1; i--) {
			sb.append(num[i]);
		}
		return sb.toString();
	}

	public int compareWithBit(int x, int y) {
		if (x == y)
			return 0;
		int tmpX = x, tmpY = y;
		int xBitsNum = getBitsNum(x);
		int yBitsNum = getBitsNum(y);
		int tmpXBitsNum = xBitsNum;
		int tmpYBitsNum = yBitsNum;
		int xLeftBit = x / (int) Math.pow(10, xBitsNum);
		int yLeftBit = y / (int) Math.pow(10, yBitsNum);
		
		while (true) {
			int xMaxBit, yMaxBit;
			if (xBitsNum < 0) {
				xMaxBit = xLeftBit;
				xBitsNum = -1;
			} else {
				xMaxBit = x / (int) Math.pow(10, xBitsNum);
				x %= (int) Math.pow(10, xBitsNum);
				xBitsNum--;
			}
			if (yBitsNum < 0) {
				yMaxBit = yLeftBit;
				yBitsNum = -1;
			} else {
				yMaxBit = y / (int) Math.pow(10, yBitsNum);
				y %= (int) Math.pow(10, yBitsNum);
				yBitsNum--;
			}
			if (xMaxBit > yMaxBit)
				return 1;
			else if (xMaxBit < yMaxBit)
				return -1;
			if (xBitsNum == -1 || yBitsNum == -1)
				break;
		}
		int base = (int)Math.pow(10, Math.abs(tmpXBitsNum - tmpYBitsNum));
		if (tmpX > tmpY) {
			tmpX %= base;
			if (tmpX < base / 10)
				return -1;
			
		} else {
			tmpY %= base;
			if (tmpY < base / 10)
				return 1;
		}
		return compareWithBit(tmpX, tmpY);
	}

	public int getBitsNum(int x) {
		int bitsNum = 0;
		while (true) {
			if (x / 10 != 0)
				bitsNum++;
			else
				break;
			x /= 10;
		}
		return bitsNum;
	}

	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		int[] nums = {216, 2, 2060, 213};
		System.out.println(ln.largestNumber(nums));
	}
}
