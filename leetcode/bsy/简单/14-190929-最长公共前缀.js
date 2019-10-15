// 编写一个函数来查找字符串数组中的最长公共前缀。

// 如果不存在公共前缀，返回空字符串 ""。

// 示例 1:

// 输入: ["flower","flow","flight"]
// 输出: "fl"
// 示例 2:

// 输入: ["dog","racecar","car"]
// 输出: ""
// 解释: 输入不存在公共前缀。
// 说明:

// 所有输入只包含小写字母 a-z 。

//弱智方法
/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    let i = 1
    let item = ''
    if(strs.length == 0) return item
    if(strs.length>0){
        let len = strs[0].length
        let strlen = strs.length
        if(strs.length === 1){
            return strs[0]
        }else if(len === 1){
            for(let j = 1; j < strlen; j++){
                if (strs[j].search(strs[0]) !== 0) {
                    return item = ''
                }else {
                    item = strs[0]
                }
            }
        }else {
            for(i;i<=len;i++){
                let main = strs[0].substr(0,i)
                for(let j = 1; j < strlen; j++){
                    if (strs[j].search(main) !== 0) {
                        return item.substr(0,i-1)
                    }else {
                        item = main
                    }
                }
            }
        }
    }
    return item
};


/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    let i = 1
    let item = ''
    if(strs.length>0){
        if(strs.length === 1){
            return strs[0]
        }else if(strs[0].split('').length === 1){
            for(let j = 1; j < strs.length; j++){
                if (strs[j].search(strs[0].substr(0,i)) !== 0) {
                    return item = ''
                }else {
                    item = strs[0]
                }
            }
        }else {
            for(i;i<=strs[0].split('').length;i++){
                for(let j = 1; j < strs.length; j++){
                    if (strs[j].search(strs[0].substr(0,i)) !== 0) {
                        return item.substr(0,i-1)
                    }else {
                        item = strs[0].substr(0,i)
                    }
                }
            }
        }
    }
    return item
};