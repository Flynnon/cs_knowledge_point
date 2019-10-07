"""
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: 3
Output: "III"
Example 2:

Input: 4
Output: "IV"
Example 3:

Input: 9
Output: "IX"
Example 4:

Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

链接：https://leetcode-cn.com/problems/integer-to-roman
"""

import math


class Solution:
    def intToRoman(self, num: int) -> str:
        """
            感觉这个是一个比较特殊的进制转化问题
            只需要分别进位就可以，每一位是一个不定长的字符串
        """
        special_nums = (
            ('M', 1000),
            ('CM', 900),
            ('D', 500),
            ('CD', 400),
            ('C', 100),
            ('XC', 90),
            ('L', 50),
            ('XL', 40),
            ('X', 10),
            ('IX', 9),
            ('V', 5),
            ('IV', 4),
            ('I', 1),
        )
        # 此处使用 ''.join 而不是 字符串拼接，理论上可以减少内存使用
        # 但是leetcode上的内存消耗相同......
        results = []
        for sp_alphabet, the_num in special_nums:
            # 简单的做一个过滤，减少无效操作
            if num < the_num:
                continue
            count, num = divmod(num, the_num)
            for _ in range(count):
                results.append(sp_alphabet)
        return ''.join(results)


class Solution2:
    def intToRoman(self, num: int) -> str:
        """
            暴力解法
            因为输入最大为 3999 ，因此也可以直接算出每一位的数字及其对应的值，然后拼接(看到了别人的解法..)
        """
        possibles = [
            ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"],
            ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"],
            ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"],
            ["", "M", "MM", "MMM"]
        ]

        results = []
        results.append(possibles[3][num // 1000 % 10])
        results.append(possibles[2][num // 100 % 10])
        results.append(possibles[1][num // 10 % 10])
        results.append(possibles[0][num % 10])

        return ''.join(results)

