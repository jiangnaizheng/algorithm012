import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

 /*
 *思路：1.将字符串重新排序，如果排序后字符串相等，那么二者就是有效异位词，时间复杂度O(nlogn)
 * 2.使用哈希表来进行处理，
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if  (s.length() != t.length()) {
            return false;
        }
    
        char[] char1 = s.toCharArray();   //将字符串转化为数组
        char[] char2 = t.toCharArray();
        Arrays.sort(char1);                      //将数组重新排序
        Arrays.sort(char2);
        return Arrays.equals(char1, char2);
    }
}
// @lc code=end

class SolutionOne {
    public boolean isAnagram(String s, String t) {
        if  (s.length() != t.length()) {
            return false;
        }
 
        int[] alphats = new int[26];             
        for (int i = 0; i < s.length();i++) {
            alphats[s.charAt(i) - 'a'] ++;             //s字符串出现的字母在相应位置上加1，t出现的在相应位置上减1
            alphats[t.charAt(i) - 'a'] --;               //最后统计数组中是否有非0数完成计数
        }

        for (int alphat : alphats) {
            if (alphat != 0) {
                return false;
            }
        }
        return true;
    }
}

