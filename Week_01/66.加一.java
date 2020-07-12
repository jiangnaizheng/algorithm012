
/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

 /*
 *思路：1.暴力方法，遍历整个数组，然后取出所有值
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >=0; i --) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
         digits = new int[len + 1];
         digits[0] = 1;
         return digits;
    }
}
// @lc code=end

class SolutionOne {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        
        return newNumber;
    }
}