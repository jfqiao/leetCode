package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hgf on 2016/12/10.
 */
public class CombinationSum {
    private int[] nums;
    private List<List<Integer>> ans;

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        cs.combinationSum(new int[]{1, 1, 2, 3, 6, 7}, 7);
        List<List<Integer>> resultList = cs.backInOnce(7, 0);
        System.out.println(resultList.size());
        for (List<Integer> list : resultList) {
            for (Integer i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    /**
     * @param nums   array of integer without duplicate numbers.
     * @param target the sum.
     * @return all combination of nums sums to target.
     * We can use every element in nums unlimited.
     */
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        this.nums = nums;
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSumRecursive(list, target, 0);
        return ans;
    }

    public void combinationSumRecursive(List<Integer> cur, int target, int from) {
        if (target == 0) {
            //使用tmp重新new一个list，因为ans中添加的是引用。
            List<Integer> tmp = new ArrayList<>(cur);
            ans.add(tmp);
        } else {
            for (int i = from; i < nums.length && target > 0; i++) {
                cur.add(nums[i]);
                combinationSumRecursive(cur, target - nums[i], i);
                cur.remove(new Integer(nums[i]));
//                while (i < nums.length - 1 && nums[i] == nums[i + 1])
//                    i++;
            }
        }
    }

    public List<List<Integer>> backTracing(int[] nums, int target, int from) {
        if (target == 0) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            result.add(list);
            return result;
        } else {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = from; i < nums.length && target > 0; i++) {
                List<List<Integer>> list = backTracing(nums, target - nums[i], i);
                for (List<Integer> tmp : list) {
                    tmp.add(nums[i]);
                }
                result.addAll(list);
                //deal with duplicate number
//                while (i < nums.length - 1 && nums[i] == nums[i + 1])
//                    i++;
            }
            return result;
        }
    }

    /**
     * 每个数字只能用一次，并且所有的的可能值不能相同。
     * @param target 目前的目标值
     * @param from  当前位置
     * @return 结果
     */
    public List<List<Integer>> backInOnce(int target, int from) {
        if (target == 0) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            result.add(list);
            return result;
        } else {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = from; i < nums.length && target > 0; i++) {
                List<List<Integer>> list = backInOnce(target - nums[i], i + 1);
                for (List<Integer> tmp : list) {
                    tmp.add(nums[i]);
                }
                result.addAll(list);
                //deal with duplicate number
                while (i < nums.length - 1 && nums[i] == nums[i + 1])
                    i++;
            }
            return result;
        }
    }

}


