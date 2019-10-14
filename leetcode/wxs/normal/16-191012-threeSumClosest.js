/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 
 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 
 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 
 链接：https://leetcode-cn.com/problems/3sum-closest
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function (nums, target){
    nums = nums.sort((a, b) => a - b);
    let res = [], closest = 1000, len = nums.length,gap = 0;
    for (let i = 0; i < len; i++){
        for (let j = i + 1, k = len - 1; j < k;){
            gap = nums[i] + nums[j] + nums[k] - target;
            if (gap <0){
                j++;
            } else if(gap > 0){
                k--;
            }else{
                return gap + target;
            }
            if (Math.abs(gap) < Math.abs(closest)){
                closest = gap;
                res = gap + target;
            }
        }
    }
    return res;
};
console.log(threeSumClosest([1, 1, -1, -1, 3], -1));