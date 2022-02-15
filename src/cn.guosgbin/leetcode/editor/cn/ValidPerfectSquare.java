package cn.guosgbin.leetcode.editor.cn;

/**
 * @author Dylan Kwok
 * @date 2022-02-15 22:59:18
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        System.out.println(solution.isPerfectSquare(16));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 折半查找
         */
//        public boolean isPerfectSquare(int num) {
//            int left = 1;
//            int right = num;
//            while (left <= right) {
//                int mid = left + (right - left) / 2;
//                double temp = num * 1.0 / mid;
//                if (mid == temp) {
//                    return true;
//                } else if (mid > temp) {
//                    right = mid - 1;
//                } else if (mid < temp) {
//                    left = mid + 1;
//                }
//            }
//            return false;
//        }

        /**
         * 牛顿迭代
         */
        public boolean isPerfectSquare(int num) {
            double ESP = 1e-7;
            double x0 = num;
            while (true) {
                double next = (x0 + num / x0) / 2;
                if (x0 - next < ESP) {
                    break;
                }
                x0 = next;
            }
            int x = (int) x0;
            return x * x == num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}