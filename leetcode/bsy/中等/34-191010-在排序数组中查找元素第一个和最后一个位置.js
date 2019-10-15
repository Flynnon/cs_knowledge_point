// 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

// 你的算法时间复杂度必须是 O(log n) 级别。

// 如果数组中不存在目标值，返回 [-1, -1]。

// 示例 1:

// 输入: nums = [5,7,7,8,8,10], target = 8
// 输出: [3,4]
// 示例 2:

// 输入: nums = [5,7,7,8,8,10], target = 6
// 输出: [-1,-1]
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
  let num = [-1,-1]
  let a = 0
  for(let i in nums){
    if(nums[i] === target){
    if(a === 0){
      num[0] = i
      num[1] = i
      a++
    }else{
      num[1] = i
    }
    }
  }
  return num
};

//二分法查找
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
  var first = null,
  last = null,
  flag1 = true
  flag2 = true
  for(var i = 0,j = nums.length-1;i <nums.length,j >= 0;i++,j--) {
    if(flag1) {
      if(nums[i] === target){
        first = i;
        flag1 = false
      }
    }
    if(flag2) {
      if(nums[j] === target) {
        last = j
        flag2 = false
      }
    }
    if(flag1 === false &&flag2 === false) return [first,last];
  }
  return [-1,-1]
}
