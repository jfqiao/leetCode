package string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
/**
 * Problem description:
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * For example, given:
 * <code><br>
 * s: "barfoothefoobarman"<br>
 * words: ["foo", "bar"] </br>
 *</code>
 * You should return the indices: <code>[0,9]</code>.
 * (order does not matter).
 * 
 * @author fangqiao.jfq
 *
 */
public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords sw = new SubstringWithConcatenationOfAllWords();
		String[] words = {"a", "a", "a", "a"};
		String str = "";
		System.out.println(sw.findSubstring(str, words));

	}
	
	//注意，按照题目意思，words中所有的单词长度都相同。
    public List<Integer> findSubstring(String s, String[] words) {
    	List<Integer> list = new ArrayList<Integer>();
    	int wordLen = words[0].length();
    	int totalLen = wordLen * words.length;
        char[] chs = s.toCharArray();
        Map<String, Word> map = new HashMap<String, Word>();
        for (int i = 0; i < words.length; i++) {
        	Word count = map.get(words[i]);
        	if (count == null) {
        		map.put(words[i], new Word(1, 1));
        	}
        	else
        		count.increment();
        }
        int curPos = 0, visitPos;
        while (curPos < chs.length) {
        	visitPos = curPos;
        	while (visitPos + wordLen <= chs.length) {
        		String str = s.substring(visitPos, visitPos + wordLen);
        		Word count = map.get(str);
        		if (count == null || count.countNow <= 0 || visitPos - curPos == totalLen) {
        			break;
        		}
        		count.decrement();
        		visitPos += wordLen;
        	}
        	if (visitPos - curPos == totalLen) {
        		list.add(curPos);
        	}
        	curPos++;
        	Set<String> keys = map.keySet();
        	for (String key : keys) {
        		map.get(key).reset();
        	}
        }
    	return list;
    }
    
}


class Word {
	int countNow;
	int countOri;
	
	public Word(int countNow, int countOri) {
		this.countNow = countNow;
		this.countOri = countOri;
	}
	
	public void increment() {
		this.countNow++;
		this.countOri++;
	}
	
	public void decrement() {
		this.countNow--;
	}
	
	public void reset() {
		this.countNow = this.countOri;
	}
}