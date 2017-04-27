package code;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hgf on 2016/12/27.
 */
public class Permutation {
    public static void main(String[] args) {
        int[] nums = {3, 3, 1, 2, 3, 2, 3, 1};
        List<List<Integer>> lists = permute(nums);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; lists.get(i) != null && j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        //default initialize as all false
        boolean[] isValid = new boolean[nums.length];
        return insertRecursive(nums, isValid);
//        for (int i = 0; i < isValid.length; i++) {
//            isValid[i] = true;
//        }
    }

    public static List<List<Integer>> insertRecursive(int[] nums, boolean[] isValid) {
        int count = 0;
        int pos = -1;
        for (int i = 0; i < isValid.length; i++) {
            if (!isValid[i]) {
                count++;
                pos = i;
            }
        }
        if (count == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[pos]);
            List<List<Integer>> result = new ArrayList<>();
            result.add(list);
            return result;
        } else {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < isValid.length; i++) {
                if (!isValid[i]) {
                    isValid[i] = true;
                    List<List<Integer>> list = insertRecursive(nums, isValid);
                    for (int j = 0; j < list.size(); j++) {
                        list.get(j).add(nums[i]);
                    }
                    result.addAll(list);
                    isValid[i] = false;
                    // delete duplicate numbers
                    while (i < isValid.length - 1 && nums[i] == nums[i + 1])
                        i++;
                }
            }
            return result;
        }
    }
}
