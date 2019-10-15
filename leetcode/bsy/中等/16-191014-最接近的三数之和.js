// 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

// 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {
    let min = 0
    const len = nums.length
    nums.sort((a,b) => a - b)
    let a = true
    for(let i = 0; i < len; i++){
      let L = i+1
      let R = len-1
      while(L<R){
        let num = nums[i] + nums[L] + nums[R] - target
        if(a) min = num
        a = false
        if(num > 0) {
          R--
        }
        else if(num<0) L++
        else return target
        if (Math.abs(num) < Math.abs(min)){
            min = num
        }
      }
    }
  return min+target
};