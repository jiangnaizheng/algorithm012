import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

 /*
 *思路：1.暴力求解法 a + b = target  时间复杂度O(n^2)
 *2.使用哈希表 时间复杂度O(n)
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0;i <nums.length - 1;++i) {
            for (int j = i + 1;j < nums.length;++j) {
                if (nums[i] + nums [j] == target) {
                    return new int[] {i,j};
                }
            }
        }
       return null;    
    }
}
// @lc code=end

//两遍哈希表
class SolutionOne {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0 ; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {  
                return new int[] {i,map.get(complement)};   //该问题要求返回的是下标
            }
        }
        return null;   
    }
}

//一遍哈希表
class SolutionTwo {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement))  {
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i], i);
        }
        return null;  
    }
}
