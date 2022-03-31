package cn.guosgbin.leetcode.editor.cn;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 * <p>
 * 题目的需求是
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 * <p>
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * @author Dylan Kwok
 * @date 2022-03-10 23:01:29
 */
public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 因为 s 和 t 只包含小写字母
         * 小写字母的 ascii 码的范围是 97-122，那么可以将字符存到一个数组中
         */
        public boolean isAnagram(String s, String t) {
            int[] arr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                arr[c - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                arr[c - 'a']--;
            }

            for (int i : arr) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}