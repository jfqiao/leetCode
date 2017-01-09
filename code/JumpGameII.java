package algorithm.leetcode;

/**
 * 给定数组nums， 从数组的第一个数开始跳，最远可以跳当前位置的大小
 * 注意可能存在回溯：
 * 如：
 * 3， 7， 1， 2， 0， 0， 5；
 * 如按贪心算法，每次尽量调最远，则可能需要回溯。
 * （另外，是否可以考虑不用贪心算法，每次跳一步，回溯是不断跳更远。
 * 貌似复杂度更大）
 * Created by hgf on 2017/1/7.
 */
public class JumpGameII {
    public static void main(String[] args) {
        JumpGameII jm = new JumpGameII();
        int[] nums = {8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5};
//        nums[10] = 1;
//        nums[11] = 0;
//        nums[12] = 0;
//        for (int i = 0; i < 10; i++) {
//            nums[i] = 10 - i;
//        }
//        int[] nums = {3, 7, 2, 1, 2, 0, 0, 5};
        System.out.println(jm.jump(nums));
    }

    private boolean isJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int[] preSteps = new int[nums.length];
        int[] curSteps = new int[nums.length];
        int curPos = 0;
        if (nums[curPos] == 0)
            return false;
        curSteps[curPos] = nums[curPos];
        return isJump(nums, preSteps, curSteps, curPos, true);
    }

    //当前位置nums[curPos] != 0
    private boolean isJump(int[] nums, int[] preSteps, int[] curSteps, int curPos, boolean forward) {
        //从前往后跳
        if (forward) {
            //计算下一个跳跃位置
            int nextPos = curPos + nums[curPos];
            //如果已经越过数组末尾
            if (nextPos >= nums.length - 1)
                return true;
                //如果下一个跳跃位置值为0，则需要回溯
            else if (nums[nextPos] == 0) {
                //找到上一个跳跃位置并回溯
                nextPos = curPos - preSteps[curPos];
                return isJump(nums, preSteps, curSteps, nextPos, false);
            }
            //下一个跳跃位置值不为0，按贪心算法跳跃最大距离
            preSteps[nextPos] = nums[curPos];
            curSteps[curPos] = nums[curPos];
            return isJump(nums, preSteps, curSteps, nextPos, forward);
        }
        //从后返回
        else {
            //当前位置调了一步导致回溯，则继续回溯。
            int nextPos;
            if (curSteps[curPos] == 1) {
                if (curPos == 0)
                    return false;
                nextPos = curPos - preSteps[curPos];
                return isJump(nums, preSteps, curSteps, nextPos, forward);
            }
            //当前位置跳跃了不止一步，则减少一步继续向前跳跃。
            nextPos = curPos + --curSteps[curPos];
            preSteps[nextPos] = curSteps[curPos];
            return isJump(nums, preSteps, curSteps, nextPos, true);
        }
    }

    //从前向后跳
    private int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int result = 0;
        int[] preSteps = new int[nums.length];
        int[] curSteps = new int[nums.length];
        int curPos = 0;
//        保证可以到达末尾
//        if (nums[curPos] == 0)
//            return false;
        curSteps[curPos] = nums[curPos];
        boolean forward = true;
        int nextPos;
        outter:
        while (true) {
            //从前往后跳
            if (forward) {
                //如果当前跳跃位置为0， 则立刻回溯
                if (nums[curPos] == 0) {
                    nextPos = curPos - preSteps[curPos];
                    curPos = nextPos;
                    forward = false;
                    result--;
                    continue;
                }
                nextPos = curPos + nums[curPos];
//                //计算下一个跳跃位置,从最大开始试
//                if (curSteps[curPos] == 0)
//                    nextPos = curPos + nums[curPos];
                //如果已经越过数组末尾
                if (nextPos >= nums.length - 1)
                    return ++result;
                while (nums[nextPos] == 0) {
                    if (nextPos == curPos + 1) {
                        nextPos = curPos - preSteps[curPos];
                        forward = false;
                        curPos = nextPos;
                        result--;
                        continue outter;
                    }
                    nextPos--;
                }
                int jumpPos = nextPos - 1;
                while (jumpPos > curPos) {
                    if (nums[jumpPos] + jumpPos >= nextPos + nums[nextPos]
                            && nums[jumpPos] != 0 && canJump(nums, jumpPos)) {
                        nextPos = jumpPos;
                    }
                    jumpPos--;
                }
                int step = nextPos - curPos;
                curSteps[curPos] = step;
                preSteps[nextPos] = step;
                result++;
                //如果下一个跳跃位置值为0，则减少一步再跳一直到跳了一步还是0则回溯
//                if (nums[nextPos] == 0) {
//                    //找到上一个跳跃位置并回溯
//                    if (curSteps[curPos] == 1) {
//                        nextPos = curPos - preSteps[curPos];
//                        forward = false;
//                    }
//                    --curSteps[curPos];
//                    nextPos = curPos + curSteps[curPos];
//                    preSteps[nextPos] = curSteps[curPos];
////                    return isJump(nums, preSteps, curSteps, nextPos, false);
//                }
//                else {
//                    //下一个跳跃位置值不为0，按贪心算法跳跃最大距离
//                    preSteps[nextPos] = nums[curPos];
//                    curSteps[curPos] = nums[curPos];
//                }
//                return isJump(nums, preSteps, curSteps, nextPos, forward);
            }
            //从后返回
            else {
                //当前位置调了一步导致回溯，则继续回溯。
                if (curSteps[curPos] == 1) {
//                    if (curPos == 0)
//                        return false;
                    nextPos = curPos - preSteps[curPos];
                    result--;
//                    return isJump(nums, preSteps, curSteps, nextPos, forward);
                }
                //当前位置跳跃了不止一步，则减少一步继续向前跳跃,此处也要试调一直到向前跳不为0。
                else {
                    nextPos = curPos + --curSteps[curPos];
                    preSteps[nextPos] = curSteps[curPos];
                    forward = true;
                    result++;
//                    return isJump(nums, preSteps, curSteps, nextPos, true);
                }
            }
            curPos = nextPos;
        }
    }

    private boolean canJump(int[] nums, int start) {
        int zeroPosStart = getZeroPos(nums, start);
        if (zeroPosStart == -1 || zeroPosStart >= nums.length - 1)
            return true;
        int zerosPosEnd = zeroPosStart;
        while (zerosPosEnd < nums.length - 1 && nums[zerosPosEnd + 1] == 0)
            zerosPosEnd++;
        //找到可以跳过的最近的距离。
        int backStart = start;
        int maxStep = Integer.MIN_VALUE;
        while (start < zeroPosStart) {
            //跳跃最远不是零的位置并且跨过zeroPosEnd.
            int tmp = nums[start] + start;
            if (tmp >= nums.length - 1)
                return true;
            while (tmp > maxStep && tmp > zerosPosEnd) {
                if (nums[tmp] != 0) {
                    maxStep = tmp;
                    break;
                }
                tmp--;
            }

            start++;
        }
        int maxStepBack = Integer.MIN_VALUE;
        while (backStart > 0 && nums[backStart] != 0) {
            int tmp = nums[backStart] + backStart;
            if (tmp >= nums.length - 1)
                return true;
            while (tmp > maxStepBack && tmp > zerosPosEnd) {
                if (nums[tmp] != 0) {
                    maxStepBack = tmp;
                    break;
                }
                tmp--;
            }
//                return canJump(nums, zerosPosEnd + 1);
            backStart--;
        }
        if (maxStep > 0 || maxStepBack > 0) {
            if (maxStep > maxStepBack)
                return canJump(nums, maxStep);
            else
                return canJump(nums, maxStepBack);
        }
        return false;
    }

    /**
     * @param nums  the target array
     * @param start the start position
     * @return zero position.
     */
    private int getZeroPos(int[] nums, int start) {
        while (start < nums.length) {
            if (nums[start] == 0)
                return start;
            start++;
        }
        return -1;
    }

}
