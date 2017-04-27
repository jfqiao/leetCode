package code;

import java.util.*;

/**
 * Created by hgf on 2016/12/28.
 * 有重复数字的数组版本�? 在Permutation中已经改良了，可以处理有重复的�??
 * 本类中的改良方法不佳�?
 */
public class PermutationWithDuplicate {
    public static void main(String[] args) {
        int[] nums = {3, 3, 1, 2, 3, 2, 3, 1};;
        List<List<Integer>> lists = permute(nums);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }



    public static List<List<Integer>> permute(int[] nums) {
//        Arrays.sort(nums);
        List<List<Integer>> list = Permutation.permute(nums);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < list.get(i).size(); j++) {
                    sb.append(list.get(i).get(j));
                    sb.append(" ");
            }
            set.add(sb.toString());
        }
        list = new ArrayList<>();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String[] strs = iterator.next().split(" ");
            List<Integer> tmp = new ArrayList<>();
            for (String s : strs) {
                tmp.add(Integer.valueOf(s));
            }
            list.add(tmp);
        }
        return list;
    }

}
