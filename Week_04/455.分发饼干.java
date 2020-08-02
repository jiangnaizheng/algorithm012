import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

 /*
 *思路：贪心算法，先对数组进行排序，优先满足胃口小的小孩子
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if  (g == null && s == null)  return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int sj = 0,gi = 0;
        while (gi < g.length && sj < s.length) {
            if (g[gi] <= s[sj]) {
                gi ++;
            }
            sj++;
        }
        return gi;
    }
}
// @lc code=end

