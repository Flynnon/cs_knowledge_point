/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 
 你的算法时间复杂度必须是 O(log n) 级别。
 
 如果数组中不存在目标值，返回 [-1, -1]。
 
 示例 1:
 
 输入: nums = [5,7,7,8,8,10], target = 8
 输出: [3,4]
 示例 2:
 
 输入: nums = [5,7,7,8,8,10], target = 6
 输出: [-1,-1]
 
 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    
    let len = nums.length,mid=-1,midNum,start = 0,end = len-1,res = [-1,-1];
    while(start<=end){
        mid = Math.floor((start+end) /2);
        midNum = nums[mid];
        if(midNum < target){
            start = mid+1;
        }else if(midNum > target){
            end = mid-1;
        }else{
            while(nums[start]!==target){start++}
            while(nums[end]!==target){end--}
            res[0] = start;res[1] = end;
            return res;
        }
    }
    return res
    
    
    

};
console.log(searchRange([5,7,7,8,8,10],5))
console.log(searchRange([5,7,7,8,8,10],10))
console.log(searchRange([5,7,7,8,8,10],11))
console.log(searchRange([5,7,7,8,8,10],4))