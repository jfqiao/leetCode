package backtracking;

import java.util.Map;
import java.util.HashMap;

/**
 * Problem description: Given two words (beginWord and endWord), and a
 * dictionary's word list, find the length of shortest transformation sequence
 * from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time. Each transformed word must exist in
 * the word list. Note that beginWord is not a transformed word. For example,
 * 
 * Given: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log","cog"] As one shortest transformation is
 * "hit"-> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * 
 * Note: Return 0 if there is no such transformation sequence. All words have
 * the same length. All words contain only lower case alphabetic characters. You
 * may assume no duplicates in the word list. You may assume beginWord and
 * endWord are non-empty and are not the same.
 *
 * 
 * @author jfq
 *
 */
public class WordLadder {
	private boolean[] isUsed;
	private Map<String, Integer> map;

	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		String[] wordList = {};
		System.out.println(wl.ladderLength("sand", "acne", wordList));
	}

	public int ladderLength(String beginWord, String endWord, String[] wordList) {
		isUsed = new boolean[wordList.length];
		map = new HashMap<String, Integer>();
		int len = find(beginWord, endWord, wordList);
		return len > 0 ? len : 0;
	}

	public int find(String beginWord, String endWord, String[] wordList) {
		if (beginWord.equals(endWord))
			return 1;
		// 直接返回有一定的问题,因为以beginWord开始变换到endWord时,isUsed中的值会不同,由此造成了结果有差别.
		Integer result = map.get(beginWord);
		if (result != null)
			return result;
		int len = Integer.MAX_VALUE;
		for (int i = 0; i < wordList.length; i++) {
			if (!isUsed[i] && isDifferInOneChar(beginWord, wordList[i])) {

				isUsed[i] = true;
				int tmp = find(wordList[i], endWord, wordList);
				isUsed[i] = false;

				Integer tmpLen = map.get(wordList[i]);
				if (tmpLen == null)
					map.put(wordList[i], tmp);

				if (tmp > 0 && len > tmp + 1)
					len = tmp + 1;
			}
		}
		if (len == Integer.MAX_VALUE)
			return -1;
		return len;
	}

	// note: you may assume that the string ori and cmp are the same length.
	private boolean isDifferInOneChar(String ori, String cmp) {
		int count = 0;
		for (int i = 0; i < ori.length(); i++) {
			if (ori.charAt(i) != cmp.charAt(i)) {
				count++;
			}
		}
		// 如果两个字符串相差超过一个字符,返回false
		if (count > 1)
			return false;
		return true;

		// 此处是如果两个字符串有且仅有一个字符不同.
		// if (count == 1)
		// return true;
		// else
		// return false;
	}

}
