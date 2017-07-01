package math;

/**
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5". 
 * Given numerator = 2,denominator = 1, return "2". 
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 * @author hgf
 *
 */
public class FractionToRecurringDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double i = 1999999999;
		double j = 1;
		System.out.println(j / i);
		
	}

	/**
	 * 
	 * @param numerator
	 *            分子
	 * @param denominator
	 *            分母
	 * @return 字符串格式的循环小数（如果是循环小数),有限位直接显示出来。
	 */
	public String fractionToDecimal(int numerator, int denominator) {
		// 分子可以整除分母
		if (numerator % denominator == 0)
			return String.valueOf(numerator / denominator);
		
		int mod = numerator % denominator;
		double s = numerator / denominator;
		// mod 除以分母得到有限位小数
		int tmp = denominator;
		while (tmp % 2 == 0)
			tmp  /= 2;
		while (tmp % 5 == 0)
			tmp /= 5;
		if (tmp == 1) {
			double fractor = (double)mod / (double)denominator;
			return String.valueOf(s + fractor);
		}
		// mod除以分母得到无限循环小数
		
		return null;
	}
}
