/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 
 示例:
 
 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 
 链接：https://leetcode-cn.com/problems/permutations
 */
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums){
    let res = [];
    permuteItem(res,nums,0);
    return res;
    
}
var permuteItem = function (res,nums, start = 0){
    if(start === nums.length-1){
        res.push(nums.map(item=>item))
    }
    for (let i = start; i < nums.length; i++){
        swap(nums,i,start);
        permuteItem(res,nums,start+1)
        swap(nums,i,start);
    }
    function swap(nums,i,j){
        let temp = "";
        temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

};
