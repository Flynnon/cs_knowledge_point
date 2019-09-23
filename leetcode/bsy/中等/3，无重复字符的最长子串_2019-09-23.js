// 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

// 示例 1:

// 输入: "abcabcbb"
// 输出: 3 
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 示例 2:

// 输入: "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 示例 3:

// 输入: "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

//一.for循环方式
// 执行用时 :
// 340 ms, 在所有 JavaScript 提交中击败了24.13%的用户
// 内存消耗 :
// 64.5 MB, 在所有 JavaScript 提交中击败了5.38%的用户
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let num = 0
    let src = []
    for(let i = 0; i < s.length; i++){
        if(src.indexOf(s[i]) === -1){
            src.push(s[i])
        }else{
            src.shift()
            i = i-1
        }
        num = Math.max(num,src.length)
    }
    return num
};

//二.while循环方式
// 执行用时 :
// 100 ms, 在所有 JavaScript 提交中击败了97.43%的用户
// 内存消耗 :
// 36.8 MB, 在所有 JavaScript 提交中击败了97.25%的用户
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let num = 0, i = 0 
    let src = []
    while(i < s.length){
        if(src.indexOf(s[i]) === -1){
            src.push(s[i])
        }else{
            src.shift()
            continue
        }
        num = Math.max(num,src.length)
        i++
    }
    return num
};

// 三.累加方式
// 执行用时 :
// 92 ms, 在所有 JavaScript 提交中击败了99.45%的用户
// 内存消耗 :
// 37.7 MB, 在所有 JavaScript 提交中击败了86.38%的用户
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    var i=0, res=0, n=0;
    for (var j = 0; j < s.length; j++){
        n = s.slice(i,j).indexOf(s[j])
        if (n == -1){
            res = Math.max(res,j+1-i);
        }else{
            i += n+1;
        }
    }
    return res;
};

// 四.哈希法
// 执行用时 :
// 88 ms, 在所有 JavaScript 提交中击败了99.81%的用户
// 内存消耗 :
// 38.2 MB, 在所有 JavaScript 提交中击败了80.38%的用户
var lengthOfLongestSubstring = function (s) {
    let n = s.length;
    let hashMap = new Map();
    let ans = 0;
    for (let i = 0, j = 0; i < n; i++) {
        if (hashMap.has(s[i])) {
        j = Math.max(hashMap.get(s[i]), j)
        }
        ans = Math.max(ans, i - j + 1);
        hashMap.set(s[i], i + 1)
    }
    return ans;
};
