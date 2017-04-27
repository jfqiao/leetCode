package code;

/**
 * Created by hgf on 2017/1/6.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        int[] heights = {2, 0, 2};
        System.out.println(trw.trap(heights));
    }

    public int trap(int[] heights) {
        int len = heights.length;
        if (len == 0)
            return 0;
        int maxPos = findMax(heights, 0, len);
        int leftMaxPos, rightMaxPos;
        int leftWater = 0, rightWater = 0;
        int tmpMax = maxPos;
        while (true) {
            leftMaxPos = findMax(heights, 0, maxPos);
            leftWater += getRainVolumn(heights, maxPos, leftMaxPos);
            maxPos = leftMaxPos;
            if (maxPos == 0)
                break;
        }
        maxPos = tmpMax;
        while (true) {
            rightMaxPos = findMax(heights, maxPos + 1, len);
            rightWater += getRainVolumn(heights, maxPos, rightMaxPos);
            maxPos = rightMaxPos;
            if (maxPos == len - 1)
                break;
        }
        return leftWater + rightWater;
    }

    /**
     * 找出数组中特定下标序列中国的�?大�?��??
     *
     * @param heights 目标数组
     * @param start   �?始下标（包含�?
     * @param end     结束下标（不包含�?
     * @return �?大�?�所在的位置�?
     */
    private int findMax(int[] heights, int start, int end) {
        if (start == end) {
            if (start == 0)
                return 0;
            else
                return start - 1;
        }
        int pos = 0;
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (heights[i] > max) {
                max = heights[i];
                pos = i;
            }
        }
        return pos;
    }

    //规定start位置的高度较大，end位置的高度较�?
    private int getRainVolumn(int[] heights, int start, int end) {
        if (start == end)
            return 0;
        int maxPos = end, minPos = start;
        if (start > end) {
            maxPos = start;
            minPos = end;
        }
        if (maxPos == minPos + 1)
            return 0;
        int maxWater = heights[end] * (maxPos - minPos - 1);
        int sum = 0;
        for (int i = minPos + 1; i < maxPos; i++) {
            sum += heights[i];
        }
        return maxWater - sum;
    }
}
