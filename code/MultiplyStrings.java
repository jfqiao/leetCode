package code;

/**
 * Created by hgf on 2017/1/6.
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println(ms.multiply("11123111111111", "21333333333333333333333333333"));
    }
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] intNum1 = new int[len1];
        int[] intNum2 = new int[len2];
        for (int i = len1 - 1; i > -1; i--) {
            intNum1[i] = num1.charAt(len1 - 1 - i) - 48;
        }
        for (int i = len2 - 1; i > -1; i--) {
            intNum2[i] = num2.charAt(len2 - 1 - i) - 48;
        }
        if (len1 > len2) {
            int tmp = len1;
            len1 = len2;
            len2 = tmp;
            int[] tmpArr = intNum1;
            intNum1 = intNum2;
            intNum2 = tmpArr;
        }
        //注意，用intNum2的每�?个数去乘以intNum1
        int[][] tmpResult = new int[9][len1 + 1];
        int[] result = new int[len1 + len2];
        boolean[] isCaculated = new boolean[9];
        for (int i = 0; i < len2; i++) {
            if (intNum2[i] == 0)
                continue;
            if (!isCaculated[intNum2[i] - 1]) {
                isCaculated[intNum2[i] - 1] = true;
                multiply(intNum1, intNum2[i], tmpResult[intNum2[i] - 1]);
            }
            add(result, tmpResult[intNum2[i] - 1], i);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = result.length - 1; i > -1; i--) {
            if (sb.length() == 0 && result[i] == 0)
                continue;
            sb.append(result[i]);
        }
        if (sb.length() == 0)
            sb.append(0);
        return sb.toString();
    }

    //数组表示数字时，数字的高位在数组的下标较大的位置�?
    private void add(int[] result, int [] tmpResult, int offset) {
        int carryBit = 0;
        for (int i = 0; i < tmpResult.length; i++) {
            int tmp = result[i + offset] + tmpResult[i] + carryBit;
            result[i + offset] = tmp % 10;
            carryBit = tmp / 10;
        }
        int j = tmpResult.length;
        while (carryBit != 0) {
            int tmp = result[offset + j] + carryBit;
            result[offset + j] = tmp % 10;
            carryBit = tmp / 10;
            j++;
        }
    }
    // �?个数乘以数组中的每个数�?�nums中，高位数字在下标大的位置�??
    private void multiply(int[] nums, int mul, int[] result) {
        int carryBit = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp = carryBit + nums[i] * mul;
            result[i] = tmp % 10;
            carryBit = tmp / 10;
        }
        if (carryBit != 0)
            result[nums.length] = carryBit;
    }

}
