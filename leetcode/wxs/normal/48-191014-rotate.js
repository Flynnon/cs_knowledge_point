/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 
 将图像顺时针旋转 90 度。
 
 说明：
 
 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 
 示例 1:
 
 给定 matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],
 z`
 原地旋转输入矩阵，使其变为:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]
 示例 2:
 
 给定 matrix =
 [
 [ 5, 1, 9,11],
 [ 2, 4, 8,10],
 [13, 3, 6, 7],
 [15,14,12,16]
 ],
 
 原地旋转输入矩阵，使其变为:
 [
 [15,13, 2, 5],
 [14, 3, 4, 1],
 [12, 6, 8, 9],
 [16, 7,10,11]
 ]
 
 链接：https://leetcode-cn.com/problems/rotate-image
 */

/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
function rotate(matrix){
    let len = matrix.length;
    for (let i = 0; i < len; i++){
        let k = 0;
        for (let j = i; j < len; j++){
            if (i !== j) swap1(matrix, i, j);
        }
        while(k<len/2){
            swap2(matrix[i],k,len-1-k,)
            k++;
        }
    }
    
    function swap2(arr,i,j){
        let temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    function swap1(nums,i,j){
        let temp = nums[i][j];
        nums[i][j] = nums[j][i];
        nums[j][i] = temp;
    }
    return matrix;
};
console.log(rotate([
    [5, 1, 9, 11],
    [2, 4, 8, 10],
    [13, 3, 6, 7],
    [15, 14, 12, 16]
]));