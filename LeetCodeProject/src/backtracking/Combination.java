package backtracking;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author fangqiao.jfq
 * 问题描述：
 * 给定两个整数 n, k, 其中 n >= k, 
 * 返回1,..., n中 k 个数的所有组合.
 * 
 * 方法1： 递归的方式
 * 方法2：用栈模拟递归。
 */
public class Combination {
	private List<List<Integer>> result;
	
	public static void main(String[] args) {
		Combination c = new Combination();
		c.combine(4, 3);
		System.out.println(c.result);
	}
	
	public List<List<Integer>> combine(int n, int k) {
		result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		combineRecursive(n, k, list, 1);
		return result;
	}
	
	public void combineRecursive(int n, int k, List<Integer> list, int curPos) {

		if (list.size() == k) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		if (curPos <= n) {
	    //有当前元素的组合
		list.add(curPos);
		combineRecursive(n, k, list, curPos + 1);
		//没有当前元素的组合
		list.remove(new Integer(curPos));
		combineRecursive(n, k, list, curPos + 1);
		}
	}
}