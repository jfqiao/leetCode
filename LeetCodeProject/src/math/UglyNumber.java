package math;

/**
 *Problem description:
 *Write a program to check whether a given number is ugly number
 *Ugly numbers are positive numbers whoser prime factors only include 
 *<code>2, 3, 5</code>.For example, 6, 8 are ugly while 14 is not ugly
 *since it includes another prime factor 7.Note that 1 is typically 
 *treated as an ugly number.
 */

public class UglyNumber {
    public static void main(String[] args) {
        UglyNumber un = new UglyNumber();
        int num = 231142;
        System.out.println(un.isUgly(num));
    }
    
    public boolean isUgly(int num) {
        if (num != 1) {
            while (num % 2 == 0)
                num /= 2;
            while (num % 3 == 0)
		num /= 3;
	    while (num % 5 == 0)
		num /= 5;
	}
	if (num == 1)
	    return true;
        else
	    return false;
    }
}
