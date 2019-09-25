// 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

// 示例 1:

// 输入: 123
// 输出: 321
//  示例 2:

// 输入: -123
// 输出: -321
// 示例 3:

// 输入: 120
// 输出: 21
// 注意:

// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

/**
 * @param {number} x
 * @return {number}
 */
// 执行用时 :
// 88 ms, 在所有 JavaScript 提交中击败了98.28%的用户
// 内存消耗 :
// 35.7 MB, 在所有 JavaScript 提交中击败了55.24%的用户

//用main储存x的绝对值sign储存x的正负值num是反转main的值用sign转换数字判断是否超出范围超出的输出0否则输出反转值sum
var reverse = function(x) {
    const main = Math.abs(x)
    let sign = 0
    if (x !== 0){
        sign = x/main
    }
    let num = (main+"").split("").reverse().join("")
    let sum = num*sign
    if (sum<-Math.pow(2,31) || sum>Math.pow(2,31)){
        return 0
    }
    return sum
};

// 执行用时 :
// 92 ms, 在所有 JavaScript 提交中击败了95.61%的用户
// 内存消耗 :
// 36.2 MB, 在所有 JavaScript 提交中击败了10.44%的用户

//while循环每位反转
var reverse = function (x) {
    var re = 0;
    while (parseInt(x / 10)) {
        re = 10 * re + x - 10 * parseInt(x / 10);
        x = parseInt(x / 10);
    }
    if (re > 214748364 || re < -214748364) return 0;
    if ((re == 214748364 && x > 7) || (re == 214748364 && x < -8)) return 0;
    re = 10 * re + x;
    return re
};