package algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hgf on 2016/12/18.
 */
public class SubstringConcatenationAllWords {

     public List<Integer> findSubstring(String s, String[] words) {
         List<Integer> list = new ArrayList<>();
         Pattern pattern = Pattern.compile(words[0]);
         Matcher matcher = pattern.matcher(s);
         while (matcher.find()) {
             int start = matcher.start();
             if (start == 0) {

             }
             else {

             }
         }
         return null;
     }


}
