/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 
 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 
 L   C   I   R
 E T O E S I I G
 E   D   H   N
 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 
 请你实现这个将字符串进行指定行数变换的函数：
 
 string convert(string s, int numRows);
 示例 1:
 
 输入: s = "LEETCODEISHIRING", numRows = 3
 输出: "LCIRETOESIIGEDHN"
 示例 2:
 
 输入: s = "LEETCODEISHIRING", numRows = 4
 输出: "LDREOEIIECIHNTSG"
 解释:
 
 L     D     R
 E   O E   I I
 E C   I H   N
 T     S     G
 
 */
/**
 * covert 的思路都是用笔和纸画出来的，就能够发现，可以按照（numRows-1）*2 分成一个周期  譬如 LEETCODE numRows 的行数是4 那么  第一个周期就是LEETCO 六个字母
 * 一个周期的字母数量 (numRows-1)*2
 * 然后每个字母的位置 ：
 * 前numRows字母的位置是竖着向下排列的，剩下的字母是斜向排列的，那么可以推导出，
 * 前numRows字母的 坐标为:（列数，行数） （第几个周期*(numRows-1)，周期中第几个元素)
 * 其余字母的坐标为：（列数，行数）（第几个元素-（总行数*（第几个周期）），（周期字母数量-该周期中第几个元素））
 *
 * 使用一个二维数组来存储字母的行位置信息和列位置信息，最后按照行顺序输出。
 *
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function (s, numRows){
    if(numRows === 1) return s;
    let res = [];
    let rows = numRows - 1;
    let r = 0;
    let count = 0;
    for (let i = 0; i < s.length; i++){
        // r = i===0?0:i % (rows * 2);
        // count=i===0?0:Math.floor(i / (rows * 2));
        if(i===0){r = 0;count = 0}
        else{
            r = i%(rows * 2);
            count = Math.floor(i / (rows * 2))
        }
        if (r <= rows){
            if(!res[r]) res[r] = [];
            res[r][count*rows] = s[i];
        } else{
            res[rows*2-r][i - rows * (count+1)] = s[i]
        }
    }
    return res.join("")
};
var convert1 = function convert(s, numRows){
    if(numRows === 1) return s;
    let res = [],rows = numRows - 1, r = 0,count = 0,drows=rows*2,len=s.length;
    for (let i = 0; i < len ; i++){
        r = i===0?0:i % drows;
        count=i===0?0:Math.floor(i /drows);
        if (r <= rows){
            if(!res[r]) res[r] = "";
            res[r]+=s[i];
        } else{
            res[drows-r]+=s[i];
        }
    }
    return res.join("")
};
