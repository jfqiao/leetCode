package array;

import java.util.Stack;

/**
 * Problem description: Given n non-negative integers representing the
 * histogram's bar height where the width of each bar is 1, find the area of
 * largest rectangle in the histogram. For example, there is an array: {2, 1, 5,
 * 6, 2, 3} The largest rectangle histogram is 2 * 5 = 10; Combined with column
 * 3 (value 5 ) and column 4 (value 6).
 * 
 * There are two ways: recursive and non-recursive. Recursive: the minimum value
 * in the array split the array into two parts. Then there are three histogram:
 * 1. the left maximum, 2, the right maximum, 3. minimum value * the length of
 * array. Do this step recursive and find the maximum histogram.
 * 
 * Non-recursive: make an array to record every column the histogram size, then
 * get the maximum from the new array.
 * 
 * @author hgf
 *
 */
public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		LargestRectangleInHistogram lrih = new LargestRectangleInHistogram();
		int[] nums = new int[100000];
		for (int i = 0; i < 100000; i++) {
			nums[i] = i;
		}
		long t1 = System.currentTimeMillis();
		System.out.println(lrih.largestRectangelArea(nums));
		long t2 = System.currentTimeMillis();
		System.out.println(lrih.largestRectangelAreaWithStack(nums));
		long t3 = System.currentTimeMillis();
		System.out.println(t2 - t1);
		System.out.println(t3 - t2);
	}

	public int largestRectangelArea(int[] heights) {
		if (heights.length == 0)
			return 0;
		int[] area = new int[heights.length];
		for (int i = 0; i < area.length; i++) {
			area[i] = -1;
		}
		
		for (int i = 0; i < area.length; i++) {
			if (area[i] > 0)
				continue;
			int j = i;
			int height = heights[i];
			int pos = i;
			while (j < area.length) {
				if (heights[j] <= height) {
					// 有可能会是位置pos被反复赋值，因此我们只选择最大的。
					// 例如： { 3, 6, 5, 4} 位置4会被两次赋值，
					int tmp = height * (j - i);
					if (area[pos] < tmp)
						area[pos] = tmp;
					pos = j;
					height = heights[j];
				}
				j++;
			}
			int tmp = height * (j - i);
			if (area[pos] < tmp)
				area[pos] = tmp;
		}
		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < area.length; i++) {
			if (maxArea < area[i])
				maxArea = area[i];
		}
		return maxArea;
	}

	// 算法AC了。 
	public int largestRectangelAreaWithStack(int[] heights) {
		//idea：从做往右扫描，如果栈不空，则将当前访问元素与栈顶元素比较，
		//如果栈顶元素较大，则可以计算以栈顶元素为高的长方形面积。
		//弹出栈顶元素继续比较，否则将当前元素压入栈中。
		Stack<Position> stack = new Stack<Position>();
		int area = 0;
		int tmpResult = 0;
		for (int i = 0; i < heights.length; i++) {
			int leftPos = i;
			while (!stack.empty() && heights[stack.peek().pos] > heights[i]) {
				Position left = stack.pop();
				tmpResult = heights[left.pos] * (i - left.leftPos);
				if (area < tmpResult)
					area = tmpResult;
				leftPos = left.leftPos;
			}
			stack.push(new Position(i, leftPos));
		}
		
		//经过一次扫描后，栈中剩余的元素按照从小到大排列
		//如此只需要从栈顶开始弹出元素计算面积即可。
		Position margin = null;
		if (!stack.empty()) {
			margin = stack.peek();
		}
		while (stack.size() > 1) {
			Position pos = stack.pop();
			tmpResult = heights[pos.pos] * (margin.pos - pos.leftPos + 1);
			if (tmpResult > area)
				area = tmpResult;
		}
		if (!stack.empty()) {
			tmpResult = heights[stack.peek().pos] * heights.length;
			if (tmpResult > area)
				area = tmpResult;
		}
		return area;
	}
	
	//通过观察别人的算法，可以不利用栈，并且算法更简洁。
	public int largestRectangelArea2(int[] heights) {
		
		return 0;
	}
}

class Position {
	int leftPos;
	int pos;
	
	public Position(int pos, int leftPos) {
		this.pos = pos;
		this.leftPos = leftPos;
	}
}
