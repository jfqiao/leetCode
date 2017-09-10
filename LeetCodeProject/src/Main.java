
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(f(7, 2));
	}
	
	public static int f(int n, int m) {
		int mul = 1;
		for (int i = m; i > 0; i--)
			mul *= i;
		int di = 1;
		for (int i = n;i > n - m; i--)
			di *= i;
		return di / mul;
	}

}
