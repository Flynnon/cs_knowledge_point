/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 
 示例 1:
 
 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:
 
 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:
 
 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s){
    let strArr = s.split("");
    let res = [];
    let len = strArr.length;
    let max = 0;
    for (let i = 0; i < len; i++){
        for (let j = 0; j < res.length; j++){
            if (res[j] === strArr[i]){
                max = res.length > max ? res.length : max;
                res = res.slice(j + 1);
            }
        }
        res.push(strArr[i]);
    }
    return max > res.length ? max : res.length;
};
var lengthOfLongestSubstring1 = function (s){
    let res = "";
    let len = s.length;
    let max = 0;
    for (let i = 0; i < len; i++){
        for (let j = 0; j < res.length; j++){
            if (res[j] === s[i]){
                max = res.length > max ? res.length : max;
                res = res.substring(j + 1);
            }
        }
        res += s[i];
    }
    return max > res.length ? max : res.length;
};