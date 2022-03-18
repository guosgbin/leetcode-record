package cn.guosgbin.leetcode.editor.cn;

/**
 * @author Dylan Kwok
 * @date 2022-03-18 22:18:49
 */
public class ZuoXuanZhuanZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
        System.out.println(solution.reverseLeftWords("abcdefg", 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 双指针
//         */
//        public String reverseLeftWords(String s, int n) {
//            char[] sc = s.toCharArray();
//            int fast = n;
//            int slow = 0;
//            char[] temp = new char[n];
//            for (int i = 0; i < n; i++) {
//                temp[i] = sc[i];
//            }
//            while (fast < sc.length) {
//                // 用fast的数据替换slow位置的数据
//                sc[slow] = sc[fast];
//                // 指针后移
//                fast++;
//                slow++;
//            }
//            for (int i = slow; i < sc.length; i++) {
//                sc[i] = temp[i - slow];
//            }
//            return new String(sc);
//        }

        /**
         * 取反字符串
         */
        public String reverseLeftWords(String s, int n) {
            char[] sc = s.toCharArray();
            // 整个字符串取反
            for (int i = 0; i < sc.length / 2; i++) {
                swap(sc, i, sc.length - i - 1);
            }
            // 分别将 n 位置前后分别取反
            int left = 0;
            int right = sc.length - n - 1;
            while (left < right) {
                swap(sc, left,right);
                left++;
                right--;
            }
            left = sc.length -n;
            right = sc.length -1;
            while (left < right) {
                swap(sc, left,right);
                left++;
                right--;
            }
            return new String(sc);
        }

        private void swap(char[] sc, int left, int right) {
            char temp = sc[left];
            sc[left] = sc[right];
            sc[right] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}