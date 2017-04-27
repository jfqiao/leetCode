package code;

/**
 * Created by hgf on 2017/1/6.
 */
public class FirstMissingPositive {
    public static void main(String[] args) {

    }

    public static int firstMissingPositive(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i])
                max = nums[i];
        }
        byte[] arr = new byte[max + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                arr[nums[i]] = 1;
        }
        int pos = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}
