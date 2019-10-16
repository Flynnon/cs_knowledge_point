// 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

// 字符          数值
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
// 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function (num) {
    let str = ''
    let a = 0
    a = parseInt(num / 1000)
    str += a == 3 ? 'MMM' : a == 2 ? 'MM' : a == 1 ? 'M' : ''
    a = parseInt(num % 1000 / 100)
    str += a == 9 ? 'CM' : ''
    if (a != 9) {
        a = parseInt(num % 1000 / 500)
        str += a == 1 ? 'D' : ''
        a = parseInt(num % 500 / 100)
        str += a == 4 ? 'CD' : a == 3 ? 'CCC' : a == 2 ? 'CC' : a == 1 ? 'C' : ''
    }
    a = parseInt(num % 100 / 10)
    str += a == 9 ? 'XC' : ''
    if (a != 9) {
        a = parseInt(num % 100 / 50)
        str += a == 1 ? 'L' : ''
        a = parseInt(num % 50 / 10)
        str += a == 4 ? 'XL' : a == 3 ? 'XXX' : a == 2 ? 'XX' : a == 1 ? 'X' : ''
    }
    a = parseInt(num % 10 / 1)
    str += a == 9 ? 'IX' : ''
    if (a != 9) {
        a = parseInt(num % 10 / 5)
        str += a == 1 ? 'V' : ''
        a = num % 5;
        str += a == 4 ? 'IV' : a == 3 ? 'III' : a == 2 ? 'II' : a == 1 ? 'I' : ''
    }
    return str;
}
