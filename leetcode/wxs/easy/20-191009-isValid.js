/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 
 有效字符串需满足：
 
 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。
 
 示例 1:
 
 输入: "()"
 输出: true
 示例 2:
 
 输入: "()[]{}"
 输出: true
 示例 3:
 
 输入: "(]"
 输出: false
 示例 4:
 
 输入: "([)]"
 输出: false
 示例 5:
 
 输入: "{[]}"
 输出: true
 
 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let len = s.length;
    if(len%2 !== 0) return false;
    let leftStack = [],left = ["(","[","{"],obj ={"}":"{","]":"[",")":"("};
    for(let i = 0;i < len;i++){
        // console.log(s[i]);
        if(left.includes(s[i])){
            leftStack.push(s[i])
        }else{
            let temp = leftStack.pop();
            // console.log(temp)
            if(temp !== obj[s[i]]){
                return false;
            }
        }
    }
    
    return leftStack.length===0;
};
console.log(isValid("([)]"))