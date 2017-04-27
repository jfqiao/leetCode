package code;

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
            //浣跨敤tmp閲嶆柊new涓�涓猯ist锛屽洜涓篴ns涓坊鍔犵殑鏄紩鐢ㄣ��?
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
     * 姣忎釜鏁板瓧鍙兘鐢ㄤ竴娆★紝骞朵笖鎵�鏈夌殑鐨勫彲鑳藉�间笉鑳界浉鍚屻��
     * @param target 鐩墠鐨勭洰鏍囧��
     * @param from  褰撳墠浣嶇疆
     * @return 缁撴�?
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


