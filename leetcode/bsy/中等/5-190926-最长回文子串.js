// 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

// 示例 1：

// 输入: "babad"
// 输出: "bab"
// 注意: "aba" 也是一个有效答案。
// 示例 2：

// 输入: "cbbd"
// 输出: "bb"



// 这产生了一个直观的动态规划解法，我们首先初始化一字母和二字母的回文，然后找到所有三字母回文，并依此类推…
// 递增 k 值, 依次遍历出 一字母, 二字母, 三字母 等等

var longestPalindrome3 = function(s) {
    let dp = [];
    for (let i = 0; i < s.length; i ++) {
        dp[i] = [];
    };

    let max = -1;
    let str = ''
    //这样可以遍历出所有子串, 以不同子串的开头为基准, 遍历所有子串
    for (let k = 0; k < s.length; k ++) {
        //采用不同的间隔依次遍历
        //这里i 是子串的开始索引, j是 子串的结束索引, k + 1其实就是 子串的长度
        for (let i = 0; i + k < s.length ; i ++) {
            let j = i + k;
            if ( k == 0 ) {
                dp[i][j] = true;
            } else if ( k <= 2 ) {
                if ( s[i] == s[j] ) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            } else {
                //比较少两位的子串是否为回文串   再判断前后是否相等
                dp[i][j] = ( dp[i + 1][j - 1] && s[i] == s[j] ) ? true : false;
            }
            if ( j - i > max && dp[i][j]) {
                max = j - i;
                str = s.substring(i, j + 1);
            }
        };
    };
    return str;
}
