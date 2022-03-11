package cn.guosgbin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Dylan Kwok
 * @date 2022-03-11 23:00:27
 */
public class IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
   }
   
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                set2.add(i);
            }
        }
        return set2.stream().mapToInt(o -> o).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}