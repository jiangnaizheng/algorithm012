/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

 /*
 *思路：贪心算法：当顾客给了20块的时候，有两种找零的方法，一种是全部找还5块，
 *还有一种是优先找还10块和5块，这种是优于第一种的，因为手里5块多是容易后面进行处理的
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0; int ten = 0;
        for (int bill : bills) {
            if (bill == 5) five ++;
            else if (bill == 10) {
                if (five == 0) return false; 
                    five --;
                    ten ++;
            } else {
                if (five > 0 && ten > 0) {
                    ten --;
                    five --;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

class SolutionOne {
    public boolean lemonadeChange(int[] bills) {
        int five = 0; int ten = 0;
        for (int bill : bills) {
            if (bill == 5) five ++;
            else if  (bill == 10) {five --;ten ++;}
            else if (ten > 0) {ten --; five --;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
}


