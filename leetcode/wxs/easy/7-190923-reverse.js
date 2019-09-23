/**给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 
 示例 1:
 
 输入: 123
 输出: 321
  示例 2:
 
 输入: -123
 输出: -321
 示例 3:
 
 输入: 120
 输出: 21
 注意:
 
 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 */

/**
 * @param {number} x
 * @return {number}
 */
var reverse = function (x){
    let str = x >= 0 ? x.toString() : x.toString().slice(1, x.toString().length);
    let len = str.length;
    let sum = 0;
    while (len--){
        sum += parseInt(str.charAt(len)) * Math.pow(10, len);
    }
    sum = x >= 0 ? sum : sum * -1;
    return sum > Math.pow(2, 31) - 1 || sum < Math.pow(2, 31) * -1 ? 0 : sum;
    
};
