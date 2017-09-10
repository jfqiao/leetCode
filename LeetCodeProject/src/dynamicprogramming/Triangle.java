package dynamicprogramming;

import java.util.List;
import java.util.ArrayList;
/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

利用迪杰特斯拉算法可以解决。但是空间复杂度可能过大。O(n^2)
 * @author jfqiao
 *
 */
public class Triangle {
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> iList = new ArrayList<Integer>();
		iList.add(2);list.add(iList);
		iList = new ArrayList<Integer>();
		iList.add(3);iList.add(4);list.add(iList);
		iList = new ArrayList<Integer>();
		iList.add(6);iList.add(5);iList.add(7);list.add(iList);
		iList = new ArrayList<Integer>();
		iList.add(4);iList.add(1);iList.add(8);iList.add(3);list.add(iList);
		Triangle t = new Triangle();
		t.triangle = list;
		t.minimumTotal(t.triangle);
	}
	private List<List<Integer>> triangle;
	private int[] sum;
	public int minimumTotal(List<List<Integer>> triangle) {
		this.triangle = triangle;
		sum = new int[triangle.size()];
		minimumSum(sum.length);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < sum.length; i++) {
			if (min > sum[i])
				min = sum[i];
		}
		return min;
    }
	
	/*
	 * idea: level表示当前层，sum表示已经得到的最短路径。
	 * 递归思想：假设第n - 1层的结果已经得到，即sum[0: n -2]表示最短路径，
	 * 然后由这个结果求出第n层的结果，即sum[0 : n - 1]的结果。
	 * 从路径上看，sum[0] = 上一层sum[0] + 当前０号节点值
	 * sum[n - 1] ＝　上一层sum[n - 2] + 第n　- 1号节点
	 * 位于０到n - 1中间的节点的最短路径为：由于可以有两条路到当前节点，因此
	 * 只需要保证从两条路中选出最短路径即可，加上当前节点即可。
	 */
	public void minimumSum(int level) {
		if (level == 1) {
			sum[0] = triangle.get(0).get(0);
			return;
		}
		minimumSum(level - 1);
		List<Integer> levelList = triangle.get(level - 1);
		//注意从当前层最后一个节点开始，这样利用前面的值时没有改变。
		for (int i = levelList.size() - 1; i > -1; i--) {
			if (i == 0) {
				sum[i] += levelList.get(i);
				continue;
			}
			if (i == levelList.size() - 1) {
				sum[i] = sum[i - 1] + levelList.get(i);
				continue;
			}
			int min = Math.min(sum[i - 1], sum[i]);
			sum[i] = min + levelList.get(i);
		}
	}
}
