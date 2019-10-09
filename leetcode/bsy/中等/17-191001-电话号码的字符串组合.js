// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    const num2letter = {
        '2':['a','b','c'],
        '3':['d','e','f'],
        '4':['g','h','i'],
        '5':['j','k','l'],
        '6':['m','n','o'],
        '7':['p','q','r','s'],
        '8':['t','u','v'],
        '9':['w','x','y','z']
    }
    //处理length<2的情况
    if(digits.length === 0) return [];
    if(digits.length === 1) return num2letter[digits]

    //数字对应字母数组
    let lettersArr = [];
    for(let item of digits){
        lettersArr.push(num2letter[item])
    }
    //组合两个旧数组成为一个新数组，然后用这个新数组再去和下一个组合  reduce
    let res = lettersArr.reduce((pre,cur)=>{
        let temp = [];
        pre.map(item=>{
            cur.map(item1=>{
                temp.push(item+item1)
            })
        })
        return temp;
    })
    return res;
};
