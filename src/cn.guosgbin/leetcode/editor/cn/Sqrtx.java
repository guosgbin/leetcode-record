package cn.guosgbin.leetcode.editor.cn;
 /**
 * @author Dylan Kwok
 * @date 2022-02-15 00:21:12
 */
public class Sqrtx{
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();

        System.out.println(solution.mySqrt(2147395599));

        long a = 2147395599 /2;
        System.out.println(a * a);
    }
   
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square == x) {
                return mid;
            } else if (square > x) {
                // 当前数的平方大于x，指针需要左移
                right = mid - 1;
            } else if (square < x) {
                // 当前数的平方小于x，指针需要右移
                left = mid + 1;
            }
        }
        // 没有找到整数的平方根，找到小于且最接近的
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}