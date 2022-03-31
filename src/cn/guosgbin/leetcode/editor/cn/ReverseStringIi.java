package cn.guosgbin.leetcode.editor.cn;

/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 *
 * @author Dylan Kwok
 * @date 2022-03-16 22:12:59
 */
public class ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        System.out.println(solution.reverseStr("abcd", 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            char[] sc = s.toCharArray();

            for (int i = 0; i < sc.length; i += 2 * k) {
                int right;
                if (sc.length - i < k) {
                    // 剩下的元素少于k个，全部反转
                    right = sc.length - 1;
                } else {
                    right = i + k - 1;
                }
                reverse(i, right, sc);
            }
            return new String(sc);
        }

        private void reverse(int left, int right, char[] sc) {
            while (left < right) {
                char temp = sc[left];
                sc[left] = sc[right];
                sc[right] = temp;
                left++;
                right--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}