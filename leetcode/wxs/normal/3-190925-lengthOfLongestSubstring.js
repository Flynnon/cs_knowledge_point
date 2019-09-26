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
    //存放当下最后一个不重复子序列
    let res = [];
    let len = strArr.length;
    //记录最长子序列的最大长度
    let max = 0;
    //遍历输入字符串
    for (let i = 0; i < len; i++){
        //遍历最后一个不重复字序列，如果出现重复的字母，只保留第一个该字母之后的子序列
        for (let j = 0; j < res.length; j++){
            //如果出现重复字母
            if (res[j] === strArr[i]){
                //记录最大长度
                max = res.length > max ? res.length : max;
                //截取数组
                res = res.slice(j + 1);
            }
        }
        //将当前字母push到数组中
        res.push(strArr[i]);
    }
    return max > res.length ? max : res.length;
};
/**
 * 该算法思想同上，只是将数组改成了字符串
 * @param s
 * @return {number}
 */
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