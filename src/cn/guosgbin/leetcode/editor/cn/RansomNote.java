package cn.guosgbin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/ransom-note/
 *
 * @author Dylan Kwok
 * @date 2022-03-13 23:36:21
 */
public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
        System.out.println(solution.canConstruct("a", "b"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 判断 ransomNote 能不能由 magazine 里面的字符构成。
//         * magazine 中的每个字符只能在 ransomNote 中使用一次。
//         *
//         * hashmap
//         *
//         * @param ransomNote
//         * @param magazine
//         * @return
//         */
//        public boolean canConstruct(String ransomNote, String magazine) {
//            if (magazine.length() < ransomNote.length()) {
//                return false;
//            }
//            HashMap<Character, Integer> map = new HashMap<>();
//            // 找出 magazine 的所有字符
//            for (int i = 0; i < magazine.length(); i++) {
//                char c = magazine.charAt(i);
//                // key是字符，value是字符出现的个数
//                map.put(c, map.getOrDefault(c, 0) + 1);
//            }
//
//            for (int i = 0; i < ransomNote.length(); i++) {
//                char c = ransomNote.charAt(i);
//                if (map.containsKey(c)) {
//                    Integer count = map.get(c);
//                    if (count == 1) {
//                        map.remove(c);
//                    } else {
//                        map.put(c, count - 1);
//                    }
//                } else {
//                    return false;
//                }
//            }m
//            return true;
//        }

        /**
         * 判断 ransomNote 能不能由 magazine 里面的字符构成。
         * magazine 中的每个字符只能在 ransomNote 中使用一次。
         *
         * 因为只有小写字母，所以用数组做哈希表
         *
         * @param ransomNote
         * @param magazine
         * @return
         */
        public boolean canConstruct(String ransomNote, String magazine) {
            if (magazine.length() < ransomNote.length()) {
                return false;
            }
            int[] map = new int[26];
            for (char c : magazine.toCharArray()) {
                map[c - 'a']++;
            }
            for (char c : ransomNote.toCharArray()) {
                int count = --map[c - 'a'];
                if (count < 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}