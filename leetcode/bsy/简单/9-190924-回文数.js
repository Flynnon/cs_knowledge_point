// 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

// 示例 1:

// 输入: 121
// 输出: true
// 示例 2:

// 输入: -121
// 输出: false
// 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 示例 3:

// 输入: 10
// 输出: false
// 解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 进阶:

// 你能不将整数转为字符串来解决这个问题吗？

/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    if(x >= 0){
       if((x+'') === (x+'').split('').reverse().join('')){
           return true
       } else {
           return false
       }
    } else {
        return false
    }
};


//进阶
var isPalindrome = function (x) {
    if (x < 0) return false;
    var arr = [];
    var i = 0;
    while (parseInt(x / 10)) {//123->12
        var a = parseInt(x / 10)
        arr[i] = x - 10 * a;
        x = a;
        i++;
    }
    var l = i;
    arr[i] = x;
    for (; i >= l / 2; i--) {
        if (arr[i] != arr[l - i]) return false;
    }
    return true;
};