package array;

public class LargestRectangleInHistogram {
	public static void main(String[] args) {
        LargestRectangleInHistogram lrih = new LargestRectangleInHistogram();
        int[] nums = {3, 2, 5, 6, 3, 2};
        System.out.println(lrih.largestRectangelArea(nums));
	}
	
	public int largestRectangelArea(int[] nums) {
		//从头向后找，找到第一个比自己小的数，则计算该值得面积。
		//然后继续向后，高度换位较小的数的高度。
		int[] area = new int[nums.length];
		for (int i = 0; i < area.length; i++) {
			area[i] = -1;
		}
		
		for (int i = 0; i < area.length; i++) {
			if (area[i] > 0)
				continue;
			int j = i;
			int height = nums[i];
			int pos = i;
			while (j < nums.length) {
				if (nums[j] < nums[i]) {
					area[pos] = height * (j - pos);
					pos = j;
					height = nums[j];
				}
					j++;
			}
			area[pos] = height * (j - pos);
		}
		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < area.length; i++) {
			if (maxArea < area[i])
				maxArea = area[i];
		}
		return maxArea;
	}
}
