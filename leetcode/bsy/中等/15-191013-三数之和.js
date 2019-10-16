// 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

// 注意：答案中不可以包含重复的三元组。

// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

// 满足要求的三元组集合为：
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    let res = []
    const len = nums.length
    if(nums == null || len < 3) return res
    nums.sort((a,b) => a - b)
    for(let i = 0; i < len; i++){
      if(nums[i] > 0) break
      if(i > 0 && nums[i] == nums[i-1]) continue
      let L = i+1
      let R = len-1
      while(L < R){
        const result = nums[i]+nums[L]+nums[R]
        if(result == 0){
          res.push([nums[i],nums[L],nums[R]])
          while (L<R && nums[L] == nums[L+1]) L++
          while (L<R && nums[R] == nums[R-1]) R--
          L++
          R--
        }
        else if(result < 0) L++
        else if(result > 0) R--
      }
    }
    return res
  };