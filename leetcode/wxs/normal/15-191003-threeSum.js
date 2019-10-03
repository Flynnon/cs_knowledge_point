/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 
 注意：答案中不可以包含重复的三元组。
 
 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 
 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 
 */
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function (nums){
    nums = nums.sort((a, b) => a - b);
    let res = [],sum,len=nums.length;
    for (let i = 0; i < len;){
        for (let j = i + 1, k = len-1; j < k;){
            sum = nums[i] + nums[j] + nums[k];
            if (sum > 0){
                do{k--;}
                while(nums[k] === nums[k+1]);
            } else if (sum < 0){
                do{
                    j++
                }
                while(nums[j] === nums[j-1]);
            } else{
                res.push([nums[i], nums[j], nums[k]]);
                j++;
                k--;
                while(nums[k] === nums[k+1])k--;
                while(nums[j] === nums[j-1])j++;
            }
        }
        do{ i++}while(nums[i]===nums[i-1]);
    }
    return res;
};
console.log(threeSum([-1, 0, 1, 2, -1, -4]));
