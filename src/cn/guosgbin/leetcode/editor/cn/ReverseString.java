package cn.guosgbin.leetcode.editor.cn;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 *
 * @author Dylan Kwok
 * @date 2022-03-16 22:01:06
 */
public class ReverseString {
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int mid = s.length / 2;
            for (int i = 0; i < mid; i++) {
                char temp = s[i];
                s[i] = s[s.length - 1 - i];
                s[s.length - 1 - i] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}