package math;
/*
 *Problem Description:
 *Write a program to find the n-th ugly number.
 *Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 *ugly number.
 *Note that 1 is typically treated as an ugly number, and n does not exceed 1690. *
 *@author jfq
 */

public class UglyNumberII {
	public static void main(String[] args) {
		UglyNumberII unii = new UglyNumberII();
		int n = 123;
		System.out.println(unii.nthUglyNumber(n));
	}

	public int nthUglyNumber(int n) {
		int[] uglyNumbers = new int[n];
		uglyNumbers[0] = 1;
		int twoNum = 0;
		int threeNum = 0;
		int fiveNum = 0;
		for (int i = 1; i < n; i++) {
			uglyNumbers[i] = Math.min(uglyNumbers[twoNum] * 2,
					Math.min(uglyNumbers[threeNum] * 3, uglyNumbers[fiveNum] * 5));
			if (uglyNumbers[i] / uglyNumbers[twoNum] == 2)
				twoNum++;
			if (uglyNumbers[i] / uglyNumbers[threeNum] == 3)
				threeNum++;
			if (uglyNumbers[i] / uglyNumbers[fiveNum] == 5)
				fiveNum++;
		}
		return uglyNumbers[n - 1];
	}

}