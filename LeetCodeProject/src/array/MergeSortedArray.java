package array;

public class MergeSortedArray {

	public static void main(String[] args) {
		MergeSortedArray msa = new MergeSortedArray();
		int[] nums1 = {1, 0};
		int[] nums2 = {2};
		msa.merge(nums1, 1, nums2, 1);
		for (Integer i : nums1)
			System.out.print(i + " ");
	}
	
	//nums1's size is greater or equal to m + n
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int end = m + n - 1;
		int p = m - 1;
		int q = n - 1;
		while (end > -1) {
			if (p < 0 || q < 0)
				break;
			if (nums1[p] > nums2[q]) {
				nums1[end] = nums1[p];
				p--;
			}
			else {
				nums1[end] = nums2[q];
				q--;
			}
			end--;
		}
		if (p < 0) {
			while (q > -1) {
				nums1[end] = nums2[q];
				q--;
				end--;
			}
		}
	}

}
