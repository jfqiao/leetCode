package algorithm;

public class UglyNumber {
	public static void main(String[] args) {
		UglyNumber un = new UglyNumber();
		System.out.println(un.getNthUglyNumberWithPointer(20));
	}
	
	public int getNthUglyNumber(int n) {
		int result = 0;
		int count = 0;
		int tmp;
		while (count < n) {
			result++;
			tmp = result;
			while (tmp % 2 == 0)
				tmp /= 2;
			while (tmp % 3 == 0)
				tmp /= 3;
			while (tmp % 5 == 0)
				tmp /= 5;
			if (tmp == 1)
				count++;
		}
		return result;
	}
	
	public int getNthUglyNumberWithPointer(int n) {
		int[] uglys = new int[n];
		uglys[0] = 1;
	    int i = 0, j = 0, k = 0;
	    for (int index = 1; index < n; index++) {
//	    	System.out.println(String.format("i = %d, j = %d, k = %d", i, j, k));
	        uglys[index] = Math.min(Math.min(uglys[i] * 2, uglys[j] * 3), uglys[k] * 5);
	        if (uglys[index] / uglys[i] == 2)
	            i++;
	        if (uglys[index] / uglys[j] == 3)
	            j++;
	        if (uglys[index] / uglys[k] == 5)
	            k++;
	    }
	    print(uglys);
	    return uglys[n - 1];
	}
	
	public void print(int[] numbers) {
		for (Integer i : numbers)
			System.out.print(i + "\t");
		System.out.println();
	}
}
