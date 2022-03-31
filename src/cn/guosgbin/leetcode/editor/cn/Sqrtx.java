package cn.guosgbin.leetcode.editor.cn;
 /**
 * @author Dylan Kwok
 * @date 2022-02-15 00:21:12
 */
public class Sqrtx{
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();

        System.out.println(solution.mySqrt(24));

        long a = 2147395599 /2;
        System.out.println(a * a);
    }
   
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int mySqrt(int x) {
//        int left = 1;
//        int right = x;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            long square = (long) mid * mid;
//            if (square == x) {
//                return mid;
//            } else if (square > x) {
//                // 当前数的平方大于x，指针需要左移
//                right = mid - 1;
//            } else if (square < x) {
//                // 当前数的平方小于x，指针需要右移
//                left = mid + 1;
//            }
//        }
//        // 没有找到整数的平方根，找到小于且最接近的
//        return right;
//    }

    /**
     * 除法防止溢出
     */
//    public int mySqrt(int x) {
//        int left = 1;
//        int right = x;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (mid == x / mid) {
//                return mid;
//            } else if (mid > x / mid) {
//                // 当前数的平方大于x，指针需要左移
//                right = mid - 1;
//            } else if (mid < x / mid) {
//                // 当前数的平方小于x，指针需要右移
//                left = mid + 1;
//            }
//        }
//        // 没有找到整数的平方根，找到小于且最接近的
//        return right;
//    }

    /**
     * 牛顿迭代
     * f(x) = x^2 - C;
     *
     * x = (x + c/x) / 2
     */
    public int mySqrt(int x) {
        if (x == 1 || x == 0)
            return x;
        double ESP = 1e-7;
        double x0 = x;
        while (true) {
            double next = (x0 + x / x0) / 2;
            if (x0 - next < ESP) {
                return (int)x0;
            }
            x0 = next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}