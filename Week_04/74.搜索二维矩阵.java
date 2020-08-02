/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

 /*
 *思路：二分查找：将该二维数组转化为一维数组，然后进行二分查找
 *一维数组和二维数组的下标转化，一维数组下标为mid  二维数字对应的元素
 *为a[mid / n][mid % n]
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
    
        int left = 0;
        int right = m*n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int  value = matrix[mid / n][mid % n];
            if (target == value) {
                return true;
            } else if (target < value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
// @lc code=end

